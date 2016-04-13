package com.uidsample4;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
	
	EditText ETEmail; //email
	EditText ETPassword; //password
	Button BSignIn; // signin
	boolean b2;//return of validate
	
	TextView tv1; //Register College
	TextView tv2; //Register User
//	TextView tv3; //Sign In
    Context context;
	 Button bRegister;
	 Alerts alerts;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context=this;
		alerts=new Alerts();
		//this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		//NETWORK TEST AND ALERRT
		Intent it=getIntent();
		final boolean b=it.getBooleanExtra("test", isChild());
		if(!b)
		{
			alerts.networkError(context);
		}
		
		//NETWORK TEST AND ALERT ENDS
		
		
		// HANDLE LOGIN
		ETEmail=(EditText)findViewById(R.id.ETEmail);
		ETPassword=(EditText)findViewById(R.id.ETPassword);
		BSignIn=(Button)findViewById(R.id.BSignIn);
		BSignIn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String email=ETEmail.getText().toString();
				String password=ETPassword.getText().toString();
				if(!email.isEmpty())
				{
					
					Logon l=new Logon();
					b2=l.validate(context,email,password);
				}
				else
				{
					alerts.invalidEmailOrPassword(context);
					ETEmail.setText("");
					ETPassword.setText("");
				}
				if(b2)
					Toast.makeText(context, "VALID USER", Toast.LENGTH_SHORT).show();				 
				else
					alerts.invalidEmailOrPassword(context);	
			}
		});
		//HANDLE LOGIN --ENDS--
			
		//INFO
		  tv1=(TextView)findViewById(R.id.textView4);
		  tv2=(TextView)findViewById(R.id.textView5);
		  //tv3=(TextView)findViewById(R.id.textView6);
		  
		  tv1.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(MainActivity.this,CollegeRegister.class);
				startActivity(it);
			}
		});
		  tv2.setOnClickListener(new OnClickListener() {			
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent it=new Intent(MainActivity.this,RegisterCollegeCode.class);
					startActivity(it);
				}
			});
		 //INFO END
		
		bRegister =(Button)findViewById(R.id.BRegister);
		
		bRegister.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(MainActivity.this,CollegeRegister.class);
				startActivity(it);
				
			}
		});
	}
	private class LoginValidate extends AsyncTask<Void, Void, Void>
	{

		@Override
		protected Void doInBackground(Void... arg0) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
}
