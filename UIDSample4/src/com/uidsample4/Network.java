package com.uidsample4;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.StrictMode;
import android.util.Log;

public class Network
{
	
	public Network() 
	{ 
		// TODO Auto-generated constructor stub
		if(android.os.Build.VERSION.SDK_INT>9)
		{
			StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
			StrictMode.setThreadPolicy(policy);
			
		}
	}

	public boolean testNetwork()
	{
		InputStream is=null;
		 try {
			 HttpClient httpclient = new DefaultHttpClient();
			 HttpPost httppost = new HttpPost("http://10.0.2.2/test.php");
			 HttpResponse response = httpclient.execute(httppost);
			 HttpEntity entity = response.getEntity();
			 is = entity.getContent();
			 
			  BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"));
			   String x=reader.readLine().toString();
			   if(x.equals("true"))
			   {
				   Log.e("log_tag",x+"  CONNECTION SUCCESS");
				   return true;
				     
			   }
			   else
			   {
				   Log.e("log_tag",x+"   CONNECTION ERROR");
					 return false;
			   }
			 // Toast.makeText(getApplicationContext(), “pass”,Toast.LENGTH_SHORT).show();
			  } catch (Exception e) {
				  Log.e("log_tag", "Error in http connection" + e.toString());
				  return false;					 
				  }
		 	}
}
