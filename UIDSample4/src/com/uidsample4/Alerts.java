package com.uidsample4;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView.FindListener;
import android.widget.TextView;



public class Alerts
{

	public void networkError(Context context)
	{
		LayoutInflater li = LayoutInflater.from(context);
		View promptsView = li.inflate(R.layout.networkerror, null);
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

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
	
	public void invalidEmailOrPassword(Context context)
	{
		LayoutInflater li = LayoutInflater.from(context);
		View promptsView = li.inflate(R.layout.invalidemailorpassword, null);
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

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




	
	public void invalidDetails(Context context,String alert)
	{
		LayoutInflater li = LayoutInflater.from(context);
		View promptsView = li.inflate(R.layout.collegeregisteralert,null);
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
		// set prompts.xml to alertdialog builder
		alertDialogBuilder.setView(promptsView);
   		// set dialog message
		alertDialogBuilder
				.setCancelable(false)
				.setTitle("Check The Following Data")
				.setMessage("")
				.setMessage(alert)
				.setPositiveButton("OK",new DialogInterface.OnClickListener() 
				 {
							public void onClick(DialogInterface dialo,int id) 
							{
								// get user input and set it to result
								// edit text
								//t1.setText(e1.getText().toString());
								
								dialo.dismiss();
							}
						});
						
						// create alert dialog
		AlertDialog alertDialog = alertDialogBuilder.create();

		// show it
		alertDialog.show();

	}
	


}
