package com.uidsample4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class Registered extends Activity 
{

	ImageButton IBHome;
	Button home,signup;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registered);
		
		home=(Button)findViewById(R.id.home);
		home.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(Registered.this,MainActivity.class);
				startActivity(it);
				finishAffinity();
				
			}
		});
		signup=(Button)findViewById(R.id.signup);
		signup.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(Registered.this,RegisterCollegeCode.class);
				startActivity(it);
				finishAffinity();
				
			}
		});
		
		// HOME IMAGEBUTTON
		IBHome=(ImageButton)findViewById(R.id.IBHome);
		IBHome.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(Registered.this,MainActivity.class);
				startActivity(it);
				finishAffinity();
			}
		});
		//HOME IMAGEBUTTON
		
		
	
	}
}
