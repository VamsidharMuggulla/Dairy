package com.uidsample4;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class RegisterCollegeCode extends Activity {

	ImageButton IBHome;
	
	Context context;
	Alerts alerts;
	Intent it;
	
	EditText ETCollegeCode;
	EditText ETUID;
	EditText ETFName;
	EditText ETLName;
	EditText ETEmail;
	EditText ETPhone;
	EditText ETPassword;
	EditText ETRPassword;
	Spinner SpinnerBranch;
	
	TextView TVCollegeCode;
	TextView TVUID;
	TextView TVFName;
	TextView TVLName;
	TextView TVBranch;
	TextView TVPhone;
	TextView TVEMail;
	TextView TVPassword;
	TextView TVRPassword;
	
	String collegeCode;
	String alert;
	
	String uID;
	String fName;
	String lName;
	String phone;
	String email;
	String password;
	String rPassword;
	String branch;
	

	
	
	TextView tv1; //Register College
	//TextView tv2; //Register User
	TextView tv3; //Sign In


	Button register;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register_college_code);
		
		context=this;
		alerts=new Alerts();
		alert="";
		it=new Intent(RegisterCollegeCode.this,UserRegisterReview.class);
		
		ETCollegeCode=(EditText)findViewById(R.id.ETCollegeCode);
		ETUID=(EditText)findViewById(R.id.ETUID);
		ETFName=(EditText)findViewById(R.id.ETFname);
		ETLName=(EditText)findViewById(R.id.ETLName);
		ETPassword=(EditText)findViewById(R.id.ETPassword);
		ETRPassword=(EditText)findViewById(R.id.ETRetypePassword);
		ETPhone=(EditText)findViewById(R.id.ETPhone);
		ETEmail=(EditText)findViewById(R.id.ETEmail);
		SpinnerBranch=(Spinner)findViewById(R.id.SpinnerBranch);
		
		TVCollegeCode=(TextView)findViewById(R.id.TVCollegeCode);
		TVBranch=(TextView)findViewById(R.id.TVBranch);
		TVUID=(TextView)findViewById(R.id.TVUserId);
		TVFName=(TextView)findViewById(R.id.TVFirstName);
		TVLName=(TextView)findViewById(R.id.TVLastName);
		TVPassword=(TextView)findViewById(R.id.TVPassword);
		TVRPassword=(TextView)findViewById(R.id.TVRePassword);
		TVPhone=(TextView)findViewById(R.id.TVPhone);
		TVEMail=(TextView)findViewById(R.id.TVEMail);
		
		// HOME IMAGEBUTTON
		IBHome=(ImageButton)findViewById(R.id.IBHome);
		IBHome.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(RegisterCollegeCode.this,MainActivity.class);
				startActivity(it);
			}
		});
		//HOME IMAGEBUTTON
	
		
		//INFO
		  tv1=(TextView)findViewById(R.id.textView4);
		  //tv2=(TextView)findViewById(R.id.textView5);
		  tv3=(TextView)findViewById(R.id.textView6);
		  
		  tv1.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(RegisterCollegeCode.this,CollegeRegister.class);
				startActivity(it);
			}
		});
		  tv3.setOnClickListener(new OnClickListener() {			
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent it=new Intent(RegisterCollegeCode.this,MainActivity.class);
					startActivity(it);
					finishAffinity();
				}
			});
		 //INFO END
	
			register=(Button)findViewById(R.id.Register);
		  register.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) 
			{
				// TODO Auto-generated method stub
				//new Validate().execute();
				
				//ProgressDialog progressDialog = ProgressDialog.show(RegisterCollegeCode.this, "Please Wait", "Verifying Data...");				

				collegeCode=ETCollegeCode.getText().toString();
				branch=SpinnerBranch.getSelectedItem().toString();
				uID=ETUID.getText().toString();
				fName=ETFName.getText().toString();
				lName=ETLName.getText().toString();
				password=ETPassword.getText().toString();
				rPassword=ETRPassword.getText().toString();
				phone=ETPhone.getText().toString();
				email=ETEmail.getText().toString();
				
				

				UserRegisterValidate urv=new UserRegisterValidate(RegisterCollegeCode.this);
				
				Log.e("LOG 1",alert);
				alert=urv.validateColCode(context, collegeCode, TVCollegeCode);
			
				Log.e("LOG 2",alert);
				
				alert=urv.validateUserID(context, uID, TVUID);
				Log.e("LOG 3",alert);
				alert=urv.validateFname(context, fName, TVFName);
				Log.e("LOG 4",alert);
				alert=urv.validateLName(context, lName, TVLName);
				Log.e("LOG 5",alert);
				alert=urv.validatePassword(context, password, TVPassword);
				Log.e("LOG 6",alert);
				alert=urv.validateRPassword(context, rPassword, password, TVRPassword);
				Log.e("LOG 7",alert);
				
				alert=urv.validatePhone(context,phone,TVPhone);
				Log.e("LOG 8",alert);
				alert=urv.validateEmail(context,email,TVEMail);
				Log.e("LOG 9",alert);
				alert=urv.validateBranch(context,branch,TVBranch);
				Log.e("LOG 10",alert);
				

				
				//String colName=urv.getCollegeName();
				//Log.e("College Name"," FUCK "+colName);
				if(alert.length()<2)
				{
					
				//	it.putExtra("collegeName",colName);
					//Log.e("College Name",colName);
					
						it.putExtra("collegeCode",collegeCode);
						it.putExtra("branch",branch);
					it.putExtra("uID",uID);
					it.putExtra("fName",fName);
					it.putExtra("lName",lName);
					it.putExtra("password",password);
					it.putExtra("rPassword",rPassword);
					
					it.putExtra("phone",phone);
					it.putExtra("email",email);
					
					//progressDialog.dismiss();
					startActivity(it);
					}
					else
					{
						//progressDialog.dismiss();
						alerts.invalidDetails(context,alert);
					}
				

			}
			});
	}
	

	/*
	private class Validate extends AsyncTask<Void, Void, Void>
	{

		ProgressDialog progressDialog;
		
		@Override
		protected void onPreExecute()
		{
			// TODO Auto-generated method stub
			super.onPreExecute();
	
		}
		@Override
		protected Void doInBackground(Void... arg0)
		{
			// TODO Auto-generated method stub
							return null;
		}
		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);

				progressDialog.dismiss();
			
		
		}
		
	}
	*/
}


