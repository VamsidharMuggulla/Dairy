package com.dairy;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class GetHolidays extends Activity {
TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_get_holidays);

		tv=(TextView)findViewById(R.id.holidays);
		InputStream is=null;
		
		/*Alerts alerts=new Alerts();
		boolean b=n.testNetwork();
		if(!b)
		{
			alerts.networkError(context);
			return false;
		}*/
		 try {
			 HttpClient httpclient = new DefaultHttpClient();
			 HttpPost httppost = new HttpPost("http://vamsidhar.esy.es/getholidays.php");
			 HttpResponse response = httpclient.execute(httppost);
			 HttpEntity entity = response.getEntity();
			 is = entity.getContent();
			
			 Log.e("log_tag", "getholidays.php success");
			
			  } catch (Exception e) {
				  Log.e("log_tag", "getholidays.php failure" + e.toString());
				   					 
			  }
		//convert response to string
		  try {
		   BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"));
		  StringBuilder sb = new StringBuilder();
		 String line = null;
		  while ((line = reader.readLine()) != null) {
		  sb.append(line + "\n");
		  // Toast.makeText(getApplicationContext(), “Input Reading pass”, Toast.LENGTH_SHORT).show();
		  }
		  is.close();
		 
		 String result = sb.toString();
		  JSONArray jArray=new JSONArray(result);
		  
		  
			String[] workk=new String[jArray.length()];
			
		  
		  for(int i=0;i<jArray.length();i++)
		  {
			  JSONObject json_data = jArray.getJSONObject(i);
			  workk[i]=json_data.getString("date")+" : "+json_data.getString("reason")+"\n";
			  
		  //tv.setText(workk[i]);
			  tv.append(workk[i]);
			  
		  }
		  reader.close();
		  
		
		  //tv.setText(result);
		  } catch (Exception e) {
			  
		  Log.e("log_tag", "Error converting result" + e.toString());
		  				 
		  }	 
		
		}

	}
