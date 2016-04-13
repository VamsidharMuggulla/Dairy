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

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Givework extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_givework);
		
		final EditText et=(EditText)findViewById(R.id.work);
				
		Button b1=(Button)findViewById(R.id.assign);
		b1.setOnClickListener(new OnClickListener() {
			
			@SuppressLint("NewApi")
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String workk=et.getText().toString();
				
				
				
				ArrayList<NameValuePair> al=new ArrayList<NameValuePair>();
				al.add(new BasicNameValuePair("work",workk));
				Log.e("Work : ",workk); 


				InputStream is2 = null;
				// TODO Auto-generated method stub
				 try 
				 {
					
					 
					 HttpClient httpclient = new DefaultHttpClient();
					 HttpPost httppost = new HttpPost("http://vamsidhar.esy.es/work.php");
					 httppost.setEntity(new UrlEncodedFormEntity(al));
					 HttpResponse response = httpclient.execute(httppost);
					 HttpEntity entity = response.getEntity();
					  is2 = entity.getContent();
					 } catch (Exception e) 
					  {
					
						  Log.e("log_tag", "Error in http connection" + e.toString());
					  }
				 try 
				 {
					 BufferedReader br=new BufferedReader(new InputStreamReader(is2,"iso-8859-1"));
					 StringBuilder sb=new StringBuilder();
					 String line=null;
					 while((line=br.readLine())!=null)
						 sb.append(line+"\n");
					 is2.close();
					String result2=sb.toString();
					
					
					
					
					String x="true";
					//x=result2; != null;
					
					Log.e("res",""+result2.equals(false));
					
					Log.e("X==",""+x);
					if(result2.contains("false"))
					{
						x="false";
						Log.e("resulllllll",""+result2.equals(false));
						
						
					}
					
					 if(!x.equals("false"))
					 {
					 et.setText("");					
					 Log.e("FALSE","RESULT IS FALSE");
					 Toast.makeText(getApplicationContext(),"Registarion Sucess", Toast.LENGTH_SHORT).show();
					 Intent it=new Intent(Givework.this,Submitted.class);
					 				 
					 startActivity(it);
					 finishAffinity();
					 
				 }
					else
					{
						Log.e("FALSE","RESULT IS NOT FALSE");
						Toast.makeText(getApplicationContext(),"Already Registered,\n" +
								"Please Login..", Toast.LENGTH_LONG).show();
					}
				 }
				 catch(Exception e) 
				 {
					 //x="false2";
					 Log.e("Exception String",e.toString());
					 Log.e("Exception Message",e.getMessage());
					 Log.e("Exception Cause",e.getCause().toString());
					 //Log.e("Exception StackTrace",e.printStackTrace());
					 
					 Log.e("log_tag","Error  in insert "+e.toString());
				}
		}
		
		

	
	});		
	}
}
