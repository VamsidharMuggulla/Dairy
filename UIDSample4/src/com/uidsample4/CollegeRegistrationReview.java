package com.uidsample4;

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

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CollegeRegistrationReview extends Activity {
	//ProgressDialog progressDialog;
	Context context;
	Button register;
	Button back;
	
	TextView colName; String colName2;
	TextView colCode; String colCode2;
	TextView cityTown; String cityTown2;
	TextView pinCode; String pinCode2;
	TextView district; String district2;
	TextView phone; String phone2;
	TextView email; String email2;
	TextView state; String state2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_college_registration_review);
		
		register=(Button)findViewById(R.id.Register);
		
	 	colName=(TextView)findViewById(R.id.reviewColName);
		colCode=(TextView)findViewById(R.id.reviewColCode);
		cityTown=(TextView)findViewById(R.id.reviewColTown);
		pinCode=(TextView)findViewById(R.id.reviewColPin);
		district=(TextView)findViewById(R.id.reviewColDistrict);
		phone=(TextView)findViewById(R.id.reviewColPhone);
		email=(TextView)findViewById(R.id.reviewColEmail);
		state=(TextView)findViewById(R.id.reviewColState);
	
		Intent it=getIntent();
		context=getApplicationContext();
		 
			colName2=it.getStringExtra("collegeName").toString();
			colName.setText(colName2);
		colCode2=it.getStringExtra("collegeCode").toString();;
		 colCode.setText(colCode2);
		 cityTown2=it.getStringExtra("cityTown").toString();;
		 cityTown.setText(cityTown2);
		 pinCode2=it.getStringExtra("pinCode").toString();;
		 pinCode.setText(pinCode2);
		 district2=it.getStringExtra("district").toString();;
		 district.setText(district2);
		
		 phone2=it.getStringExtra("phone").toString();;
		 phone.setText(phone2);
		 email2=it.getStringExtra("email").toString();;
		 email.setText(email2);
		 state2=it.getStringExtra("state").toString();;
		 state.setText(state2);
		
		
		back=(Button)findViewById(R.id.Back);
		back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//NavUtils.navigateUpFromSameTask(getParent());
				finish();
			}
		});
		
		register.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				ArrayList<NameValuePair> al=new ArrayList<NameValuePair>();
				al.add(new BasicNameValuePair("collegename", colName2));
				al.add(new BasicNameValuePair("collegecode", colCode2));
				al.add(new BasicNameValuePair("citytown", cityTown2));
				al.add(new BasicNameValuePair("pincode", pinCode2));
				al.add(new BasicNameValuePair("district", district2));
				al.add(new BasicNameValuePair("phone", phone2));
				al.add(new BasicNameValuePair("email", email2));
				al.add(new BasicNameValuePair("state", state2));
				 Log.e("log_tag", "ONE");
				 Network m=new Network();
				 if(m.testNetwork())
				 {
				new CollegeRegisterFinal(getApplicationContext(),al).execute();
				 }
				 else
				 {

						LayoutInflater li = LayoutInflater.from(CollegeRegistrationReview.this);
						View promptsView = li.inflate(R.layout.networkerror, null);
						AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(CollegeRegistrationReview.this);

						// set prompts.xml to alertdialog builder
						alertDialogBuilder.setView(promptsView);
				   		// set dialog message
						alertDialogBuilder
								.setCancelable(false)
								.setPositiveButton("OK",new DialogInterface.OnClickListener() 
								 {
											public void onClick(DialogInterface dialo,int id) 
											{
												// get user input and set it to result
												// edit text
												//t1.setText(e1.getText().toString());
												dialo.cancel();
											}
										});
										// create alert dialog
						AlertDialog alertDialog = alertDialogBuilder.create();

						// show it
						alertDialog.show();

		 }
				Log.e("log_tag", "TWO");
			}
		});
		
	}
	
	
	
	private class CollegeRegisterFinal extends AsyncTask<String, Void, Void> 
	{
		//ProgressDialog progressDialog;
		AlertDialog alertDialog;
		Context context;
		Network n;
		String x="true";
		ArrayList<NameValuePair> al;
		CollegeRegisterFinal(Context context,ArrayList<NameValuePair> al)
		{
			//progressDialog=new ProgressDialog(context);
			this.context=context;
			this.al=al;
			Log.e("log_tag", "THREE");
			 n=new Network();
		}
		
		
		@Override
		protected void onPreExecute() 
		{
		super.onPreExecute();
		//progressDialog = ProgressDialog.show(context, "Wait", "Uploading...");
		//progressDialog = new ProgressDialog(context);
		//progressDialog = ProgressDialog.show(CollegeRegisterFinal.this, "Wait", "Downloading...");
		//ProgressDialog.show(context, "Please Wait","Data Uploading...");
		//progressDialog.isIndeterminate();
		
	
		 if(n.testNetwork())
		 {
		LayoutInflater li = LayoutInflater.from(CollegeRegistrationReview.this);
		View promptsView = li.inflate(R.layout.connecting, null);
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(CollegeRegistrationReview.this);

		// set prompts.xml to alertdialog builder
		alertDialogBuilder.setView(promptsView);
   		// set dialog message
		alertDialogBuilder
				.setCancelable(false)
				.setTitle("Please Wait");
						// create alert dialog
		alertDialog = alertDialogBuilder.create();

		// show it
		alertDialog.show();
		 }
		 else
		 {
			x="false1";
		}
				
 
		}
		

		@Override
		protected Void doInBackground(String... arg0)
		{
			InputStream is2 = null;
			// TODO Auto-generated method stub
			 try 
			 {
				
				 
				 HttpClient httpclient = new DefaultHttpClient();
				 HttpPost httppost = new HttpPost("http://10.0.2.2/collegeregisterfinal.php");
				 httppost.setEntity(new UrlEncodedFormEntity(al));
				 HttpResponse response = httpclient.execute(httppost);
				 HttpEntity entity = response.getEntity();
				  is2 = entity.getContent();
				 
				// Toast.makeText(getApplicationContext(), "Connection Success Inserted",Toast.LENGTH_SHORT).show();					 
				 
				 Log.e("log_tag", " in doinbackground connection success");
								
				 // Toast.makeText(getApplicationContext(), “pass”,Toast.LENGTH_SHORT).show();
				  } catch (Exception e) 
				  {
					  x="false";
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
				Log.e("LOG", result2);
				
				 //Toast.makeText(getApplicationContext(),result2, Toast.LENGTH_SHORT).show();
			 }
			 catch(Exception e) 
			 {
				 x="false2";
				 Log.e("log_tag","Error  in insert "+e.toString());
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			
			if(x=="false1")
			{
				Toast.makeText(getApplicationContext(), "NO NETWORK CONNECTION", Toast.LENGTH_SHORT).show();
				
			}
			else if(x=="false2")
			{
				Toast.makeText(getApplicationContext(), "SERVER ERROR TRY LATER", Toast.LENGTH_SHORT).show();
				
			}
			else
			{
				Intent it=new Intent(CollegeRegistrationReview.this,Registered.class);
				it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				alertDialog.dismiss();
				startActivity(it);
				finishAffinity();
			}
				

			}
			
			//finish();
			
			
		}

	}
