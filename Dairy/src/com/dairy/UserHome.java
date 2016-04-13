package com.dairy;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class UserHome extends Activity {

	
	Button b1,b2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_home);


		b1=(Button)findViewById(R.id.work);
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent it=new Intent(UserHome.this,GetWork.class);
				startActivity(it);
			}
		});
		b2=(Button)findViewById(R.id.holidays);
		b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent it=new Intent(UserHome.this,GetHolidays.class);
				startActivity(it);
			}
		});
		Intent itt=getIntent();
		

		ArrayList<NameValuePair> a1=new ArrayList<NameValuePair>();
		
		a1.add(new BasicNameValuePair("user", itt.getStringExtra("username")));
		
		final TextView remarkkk;
		remarkkk=(TextView)findViewById(R.id.remarks);
		InputStream is=null;
		
		 try {
			 HttpClient httpclient = new DefaultHttpClient();
			 HttpPost httppost = new HttpPost("http://vamsidhar.esy.es/getupdate.php");
			 httppost.setEntity(new UrlEncodedFormEntity(a1));
			 HttpResponse response = httpclient.execute(httppost);
			 HttpEntity entity = response.getEntity();
			 is = entity.getContent();
			
			 Log.e("log_tag", "getUpdate.php success");
			 // Toast.makeText(getApplicationContext(), �pass�,Toast.LENGTH_SHORT).show();
			  } catch (Exception e) {
				  Log.e("log_tag", "getUpdate.php failure" + e.toString());
				  //return false;				 					 
			  }
		//convert response to string
		  try {
		   BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"));
		  StringBuilder sb = new StringBuilder();
		 String line = null;
		  while ((line = reader.readLine()) != null) {
		  sb.append(line + "\n");
		  // Toast.makeText(getApplicationContext(), �Input Reading pass�, Toast.LENGTH_SHORT).show();
		  }
		  is.close();
		 
		 String result = sb.toString();
		  JSONArray jArray=new JSONArray(result);
		  
		  
			String[] update=new String[jArray.length()];
			
		  int i=0;
		  for(i=0;i<jArray.length();i++)
		  {
			  JSONObject json_data = jArray.getJSONObject(i);
			  update[i]=json_data.getString("msg");
			  remarkkk.setText(update[i]);
			  
			  Log.e("1",update[i]);
			  
		  }
		  
		  reader.close();
		  
		
		  //tv.setText(result);
		  } catch (Exception e) {
			  
		  Log.e("log_tag", "Error converting result" + e.toString());
		  				 
		  }	 
		
		}

	}
