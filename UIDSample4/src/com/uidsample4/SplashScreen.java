package com.uidsample4;



import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class SplashScreen extends Activity {
	 boolean test;
	//public static int SPLASH_TIME=8000;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		
		super.onCreate(savedInstanceState);

      	this.requestWindowFeature(Window.FEATURE_NO_TITLE);	// Removes title bar
      	this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);	// Removes notification bar
    	setContentView(R.layout.activity_splash_screen);
      	
   	new Splash().execute();  
    	 
	}
	private class Splash extends AsyncTask<Void, Void, Void>
	{
		Intent i;
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
			  
			    		i = new Intent(SplashScreen.this, MainActivity.class);    		
			    		Network n=new Network();
			    		test=n.testNetwork();
			
			    		i.putExtra("test", test);
		      return null;
		}
		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			startActivity(i);
			// close this activity
			finish();
	
		}
	}
	}