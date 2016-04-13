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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class GiveHoliday extends Activity {

	DatePicker dp;
	EditText res;
	ImageButton back;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_give_holiday);
		
		dp=(DatePicker)findViewById(R.id.datePickerr);	
		res=(EditText)findViewById(R.id.reason);
		
		Button b1=(Button)findViewById(R.id.set);
		b1.setOnClickListener(new OnClickListener() {
			
			
			
			@SuppressLint("NewApi")
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub


		        String date=Integer.toString(dp.getDayOfMonth());
		        date=date+"/"+Integer.toString(dp.getMonth());
		        date=date+"/"+Integer.toString(dp.getYear());        
				
		        String reason=res.getText().toString();
				
				
				
				
				ArrayList<NameValuePair> al=new ArrayList<NameValuePair>();
				al.add(new BasicNameValuePair("date",date));
				al.add(new BasicNameValuePair("reason",reason));
				Log.e("date : ",date); 
				Log.e("reason : ",reason); 


				InputStream is2 = null;
				// TODO Auto-generated method stub
				 try 
				 {
					
					 
					 HttpClient httpclient = new DefaultHttpClient();
					 HttpPost httppost = new HttpPost("http://vamsidhar.esy.es/holiday.php");
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
					 res.setText("");					
					 Log.e("FALSE","RESULT IS FALSE");
					 Toast.makeText(getApplicationContext(),"Update Sent....", Toast.LENGTH_SHORT).show();
				
					 
				 }
					else
					{
						Log.e("FALSE","RESULT IS NOT FALSE");
						Toast.makeText(getApplicationContext(),"", Toast.LENGTH_LONG).show();
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
		back=(ImageButton)findViewById(R.id.imageButton1);
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				//Intent it=new Intent(GiveHoliday.this,Submitted.class);
				finish(); 
				 //startActivity(it);
				 //finishAffinity();
			}
		});
		
	}
}

