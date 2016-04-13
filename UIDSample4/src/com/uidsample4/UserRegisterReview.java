package com.uidsample4;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

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
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class UserRegisterReview extends Activity
{
	
	Context context;
	Button register;
	Button back;
	
	TextView TVColName; String colName;
	TextView TVColCode; String colCode;
	TextView TVBranch; String branch;
	TextView TVUID; String uID;
	TextView TVFName; String fName;
	TextView TVLName; String lName;
	TextView TVEMail; String email;
	TextView TVPhone; String phone;
	String password,rPassword;


	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_register_review);
		
		
		back=(Button)findViewById(R.id.Back);
		register=(Button)findViewById(R.id.Register);
		
		TVColName=(TextView)findViewById(R.id.reviewColName);
		TVColCode=(TextView)findViewById(R.id.reviewColCode);
		TVBranch=(TextView)findViewById(R.id.reviewBranch);
		TVUID=(TextView)findViewById(R.id.reviewUID);
		TVFName=(TextView)findViewById(R.id.reviewFirstName);
		TVLName=(TextView)findViewById(R.id.reviewLastName);
		TVPhone=(TextView)findViewById(R.id.reviewColPhone);
		TVEMail=(TextView)findViewById(R.id.reviewColEmail);
	
		
		
		Intent it=getIntent();
		context=UserRegisterReview.this;
		String x = ""; 
		
		colCode=it.getStringExtra("collegeCode").toString();;
		 TVColCode.setText(colCode);
		 Validate v=new Validate();
		 try {
			x=v.execute(colCode).get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 colName=x;
		 TVColName.setText(colName);
		
		//	colName=it.getStringExtra("collegeName").toString();
			
		 branch=it.getStringExtra("branch").toString();;
		 TVBranch.setText(branch);
		 uID=it.getStringExtra("uID").toString();;
		 TVUID.setText(uID);
		 fName=it.getStringExtra("fName").toString();;
		 TVFName.setText(fName);
		lName=it.getStringExtra("lName").toString();;
		 TVLName.setText(lName);
		
		 password=it.getStringExtra("password").toString();
		 rPassword=it.getStringExtra("rPassword").toString();;
		 
		 phone=it.getStringExtra("phone").toString();;
		 TVPhone.setText(phone);
		 email=it.getStringExtra("email").toString();;
		 TVEMail.setText(email);
		 
		 
		 

			back.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					//NavUtils.navigateUpFromSameTask(getParent());
					finish();
				}
			});
			
		
	}
	
	
	

	private class Validate extends AsyncTask<String, Void, String>
	{

		ProgressDialog progressDialog;
		
		@Override
		protected void onPreExecute()
		{
			// TODO Auto-generated method stub
			super.onPreExecute();
			 progressDialog = ProgressDialog.show(context, "Please Wait", "Verifying Data...");
			 
		}
		
		@Override
		protected String doInBackground(String... params)
		{
			// TODO Auto-generated method stub
			InputStream is=null;
			ArrayList<NameValuePair> al=new ArrayList<NameValuePair>();
			al.add(new BasicNameValuePair("colCode", params[0]));
			
			 try {
				 HttpClient httpclient = new DefaultHttpClient();
				 HttpPost httppost = new HttpPost("http://10.0.2.2/uservalidatecolcode.php");
				 httppost.setEntity(new UrlEncodedFormEntity(al));
				 HttpResponse response = httpclient.execute(httppost);
				 HttpEntity entity = response.getEntity();
				 is = entity.getContent();
				
				 Log.e("log_tag", "connection success");
				 // Toast.makeText(getApplicationContext(), “pass”,Toast.LENGTH_SHORT).show();
				  }
			 	catch (Exception e) {
					  Log.e("log_tag", "Error in http connection in UserRegiisterValidate in Do in background" + e.toString());
					 
				  }
			 
			 
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
				  Log.e("LOG","RESULT :"+result);
				  JSONArray jArray=new JSONArray(result);
				  //JSONArray ar=new JSONArray(ob);
				  for(int i=0;i<jArray.length();i++)
				  {
					  JSONObject json_data = jArray.getJSONObject(i);
					  colName=json_data.getString("colname");
				  }
				  Log.e("LOG","COLLEGE :"+colName);
				
				  
				  //tv.setText(result);
				  } catch (Exception e) {
				  Log.e("log_tag", "Error converting result" + e.toString());
				  //Toast.makeText(getApplicationContext(), "Input reading fail",Toast.LENGTH_SHORT).show();				 
				  }
			 return colName;
			
		}
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);

				progressDialog.dismiss();
				Log.e("College Name POST EXECUTE","  OK  "+colName);
			
		}
		
	}

}
