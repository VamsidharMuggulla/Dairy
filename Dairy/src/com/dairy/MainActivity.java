package com.dairy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends Activity {

	
	EditText et1; //uname
	EditText et2; //password
	 // signin
	String b2;//return of validate
	
	Spinner sp;
	Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
		context=this;
		//Log.e("email", "message");
		
		Button bt1,bt2;
		//alerts=new Alerts();
		//this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		//NETWORK TEST AND ALERRT
		
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

		StrictMode.setThreadPolicy(policy); 
		//Intent it=getIntent();
		//final boolean b=it.getBooleanExtra("test", isChild());
		//if(!b)
		//{
		//	alerts.networkError(context);
		//}
		
		//NETWORK TEST AND ALERT ENDS
		
		
		// HANDLE LOGIN
		et1=(EditText)findViewById(R.id.ETEmail);
		et2=(EditText)findViewById(R.id.ETPassword);
		bt1=(Button)findViewById(R.id.BSignIn);  //now see it will
		
		//Log.e("OUT",et1.getText().toString());
		bt1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				 
				 String aadmin="admin";
				 String noadmin="noadmin";
				// TODO Auto-generated method stub
				String email=et1.getText().toString();
				Log.e("email", "message");
				String password=et2.getText().toString();
				Log.e("PASS", "message");
				if(!email.isEmpty())
				{
					
					Logon l=new Logon();
					b2=l.validate(context,email,password); 
				}
				else
				{
					//alerts.invalidEmailOrPassword(context);
					et1.setText("");
					et2.setText("");
				}
				
				if(b2.equals(aadmin)){
					Toast.makeText(context, "Welcome Admin", Toast.LENGTH_SHORT).show();
					Intent it=new Intent(MainActivity.this,HomeActivity.class);
					it.putExtra("Username", email);
					startActivity(it);
					//finishAffinity();		
					
				}
				else if(b2.equals(noadmin)){
					Toast.makeText(context, "Welcome "+email, Toast.LENGTH_SHORT).show();
					Intent it=new Intent(MainActivity.this,UserHome.class);
					it.putExtra("username", email);
					
					startActivity(it);
					//finishAffinity();		
					
				}
				else
					Toast.makeText(context, "Unable to Login", Toast.LENGTH_SHORT).show();	
					//alerts.invalidEmailOrPassword(context);	
			}
		});
		
		sp=(Spinner)findViewById(R.id.Signup);
		sp.setSelection(0);
		
		
		sp.setOnItemSelectedListener(new OnItemSelectedListener() {
			
			

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				
			
				if(sp.getSelectedItem().toString().equals("Signup as Teacher"))
				{
					Intent it=new Intent(MainActivity.this,TSignup.class);
					
					startActivity(it);
					
				}
				if(sp.getSelectedItem().toString().equals("Signup as Parent"))
				{
					Intent it=new Intent(MainActivity.this,PSignUp.class);
					startActivity(it);
				}
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
			}
	
}
