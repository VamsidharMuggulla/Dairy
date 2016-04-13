 package com.uidsample4;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class CollegeRegister extends Activity {
	
	ImageButton IBHome;
	Button bGo;
	
	EditText ETCollegeName;
	EditText ETCollegeCode;
	EditText ETCityTown;
	EditText ETPinCode;
	EditText ETDistrict;
	EditText ETPhone;
	EditText ETEmail;
	Spinner SpinnerState;
	
	TextView TVCollegeName;
	TextView TVCollegeCode;
	TextView TVCityTown;
	TextView TVPin;
	TextView TVDistrict;
	TextView TVState;
	TextView TVPhone;
	TextView TVEMail;
	
	String collegeName;
	String collegeCode;
	String cityTown;
	String pinCode;
	String district;
	String phone;
	String email;
	String state;
	
	
	
	
	Context context;
	Alerts alerts;
	
	
	
	TextView tv2; //Register User
	TextView tv3; //Sign In

Button register;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_college_register);
		
		context=this;
		
		alerts=new Alerts();
	
		
		TVCollegeName=(TextView)findViewById(R.id.TVCollegeName);
		TVCollegeCode=(TextView)findViewById(R.id.TVCollegeCode);
		TVCityTown=(TextView)findViewById(R.id.TVCityTown);
		TVPin=(TextView)findViewById(R.id.TVPIN);
		TVDistrict=(TextView)findViewById(R.id.TVDistrict);
		TVState=(TextView)findViewById(R.id.TVState);
		TVPhone=(TextView)findViewById(R.id.TVPhone);
		TVEMail=(TextView)findViewById(R.id.TVEmail);
		
		ETCollegeName=(EditText)findViewById(R.id.ETCollegeName);
		ETCollegeCode=(EditText)findViewById(R.id.ETCollegeCode);
		ETCityTown=(EditText)findViewById(R.id.ETCityTown);
		ETPinCode=(EditText)findViewById(R.id.ETPinCode);
		ETDistrict=(EditText)findViewById(R.id.ETDistrict);
		ETPhone=(EditText)findViewById(R.id.ETPhone);
		ETEmail=(EditText)findViewById(R.id.ETEmail);
		SpinnerState=(Spinner)findViewById(R.id.SpinnerState);
		 
		//COLLEGE REGISTRATION --ENDS--
		
		// HOME IMAGEBUTTON
		IBHome=(ImageButton)findViewById(R.id.IBHome);
		IBHome.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(CollegeRegister.this,MainActivity.class);
				startActivity(it);
			}
		});
		//HOME IMAGEBUTTON
		
		
		  //GO BUTTON
				bGo=(Button)findViewById(R.id.Go);
				bGo.setOnClickListener(new OnClickListener() {			
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Intent it=new Intent(CollegeRegister.this,RegisterCollegeCode.class);
						startActivity(it);
					}
				});
		 //GO BUTTON END
				
				
				//INFO
				  //tv1=(TextView)findViewById(R.id.textView4);
				  tv2=(TextView)findViewById(R.id.textView5);
				  tv3=(TextView)findViewById(R.id.textView6);
				  
				  tv2.setOnClickListener(new OnClickListener() {			
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Intent it=new Intent(CollegeRegister.this,RegisterCollegeCode.class);
						startActivity(it);
					}
				});
				  tv3.setOnClickListener(new OnClickListener() {			
						@Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub
							Intent it=new Intent(CollegeRegister.this,MainActivity.class);
							startActivity(it);
						}
					});
				 //INFO END
				
				  //REGISTER REVIEW
				  register=(Button)findViewById(R.id.Register);
					register.setOnClickListener(new OnClickListener() {
						@Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub`
						//	ETCollegeName.setTextColor(Color.parseColor("#ff3300"));
							
							collegeName=ETCollegeName.getText().toString();
							collegeCode=ETCollegeCode.getText().toString();
							
							cityTown=ETCityTown.getText().toString();
							pinCode=ETPinCode.getText().toString();
							district=ETDistrict.getText().toString();
							phone=ETPhone.getText().toString();
							email=ETEmail.getText().toString();
							state=SpinnerState.getSelectedItem().toString();
							
							CollegeRegisterValidate crv=new CollegeRegisterValidate();
							String alert="";
							Log.e("LOG 1",alert);
							alert=crv.validateColName(context,collegeName,TVCollegeName);
							Log.e("LOG 2",alert);
							alert=crv.validateColCode(context,collegeCode,TVCollegeCode);
							Log.e("LOG 3",alert);
							alert=crv.validateCityTown(context,cityTown,TVCityTown);
							Log.e("LOG 4",alert);
							alert=crv.validatePinCode(context,pinCode,TVPin);
							Log.e("LOG 5",alert);
							alert=crv.validateDistrict(context,district,TVDistrict);
							Log.e("LOG 6",alert);
							alert=crv.validatePhone(context,phone,TVPhone);
							Log.e("LOG 7",alert);
							alert=crv.validateEmail(context,email,TVEMail);
							Log.e("LOG 8",alert);
								
							if(alert.length()<2)
							{
								Intent it=new Intent(CollegeRegister.this,CollegeRegistrationReview.class);
								it.putExtra("collegeName",collegeName);
							it.putExtra("collegeCode",collegeCode);
							it.putExtra("cityTown",cityTown);
							it.putExtra("pinCode",pinCode);
							it.putExtra("district",district);
							it.putExtra("phone",phone);
							it.putExtra("email",email);
							it.putExtra("state",state);
							startActivity(it);
							}
							else
							{
								alerts.invalidDetails(context,alert);
								
							}
						}

					
					});
				//REGISTER REVIEW
	}
	
}
