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
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class TSignup extends Activity {
	
	EditText TName;
	//EditText StudentName;
	EditText password;
	//EditText ETpin;
	EditText Phone;
	Spinner	 Classs;
	Spinner	 Subject;
	
	
	

	String tName;
	String subjectt;
	String studentName;
	//String	pin;
	String phone;
	String passwordd;
	String group;
	String uname;
	String classss;
	

	
	
	
	
	Context context;
	//Alerts alerts;
	
	
	
	

Button sugnup;

	
	
	



	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tsignup);context=this;
		
		//alerts=new Alerts();
	
		
		
		TName=(EditText)findViewById(R.id.Name);
		//StudentName=(EditText)findViewById(R.id.StudentName);
		//ETpin=(EditText)findViewById(R.id.editText1);
		Phone=(EditText)findViewById(R.id.Phone);
		password=(EditText)findViewById(R.id.ETPassword);
		Classs=(Spinner)findViewById(R.id.Class);
		Subject=(Spinner)findViewById(R.id.Subject);
		
		
		
				  sugnup=(Button)findViewById(R.id.BSignIn);
					sugnup.setOnClickListener(new OnClickListener() {
						@SuppressLint("ShowToast") @Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub`
						//	ETCollegeName.setTextColor(Color.parseColor("#ff3300"));
							
							Log.e("1","2");
							
							tName=TName.getText().toString();
							passwordd=password.getText().toString();
							subjectt=Subject.getSelectedItem().toString();
							Log.e("",tName);
							
							//studentName=StudentName.getText().toString();
							
							//pin=ETpin.getText().toString();
							//Log.e("",pin);
							phone=Phone.getText().toString();
							classss=Classs.getSelectedItem().toString();
							Log.e("",classss);
							
										ArrayList<NameValuePair> a1=new ArrayList<NameValuePair>();
							
							a1.add(new BasicNameValuePair("tName", tName));
							//a1.add(new BasicNameValuePair("studentName", studentName));
							a1.add(new BasicNameValuePair("classss", classss));
							a1.add(new BasicNameValuePair("phone", phone));
							a1.add(new BasicNameValuePair("subject", subjectt));
							a1.add(new BasicNameValuePair("password", passwordd));
							
							
							 Log.e("log_tag", "ONE");

							 Log.e("ArrayList", ""+a1.toString());
							

								InputStream is2 = null;
								// TODO Auto-generated method stub
								 try 
								 {
									
									 
									 HttpClient httpclient = new DefaultHttpClient();
									 HttpPost httppost = new HttpPost("http://vamsidhar.esy.es/teachersignup.php");
									 httppost.setEntity(new UrlEncodedFormEntity(a1));
									 HttpResponse response = httpclient.execute(httppost);
									 HttpEntity entity = response.getEntity();
									  is2 = entity.getContent();
									 
									// Toast.makeText(getApplicationContext(), "Connection Success Inserted",Toast.LENGTH_SHORT).show();					 
									 
									 //Log.e("log_tag", " in doinbackground connection success");
													
									 // Toast.makeText(getApplicationContext(), �pass�,Toast.LENGTH_SHORT).show();
									  } catch (Exception e) 
									  {
										//  x="false";
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
									Log.e("LOG INSRT :", result2);
									
									boolean x2=result2 !=null;
									if(x2)
									{
									 
									 TName.setText("");
									 //StudentName.setText("");
									 //ETpin.setText("");
									 Phone.setText("");
									 password.setText("");
									
									 
									 Toast.makeText(getApplicationContext(),"Registarion Sucess", Toast.LENGTH_SHORT).show();
									 
									//Intent it=new Intent(DregActivity.this,TipsActivity.class);
									//startActivity(it);
									//finishAffinity();									 
								 }
									else
									{
										Toast.makeText(getApplicationContext(),"Registarion Failed \n Try Again", Toast.LENGTH_SHORT).show();
									}
								 }
								 catch(Exception e) 
								 {
									 //x="false2";
									 Log.e("log_tag","Error  in insert "+e.toString());
								}
				
							}
						

					
					});
				//REGISTER REVIEW
	}
	
}
