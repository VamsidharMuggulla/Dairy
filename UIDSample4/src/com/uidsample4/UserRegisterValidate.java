package com.uidsample4;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class UserRegisterValidate 
{
    String alert;
    static String colName="";
    Context cont;
     UserRegisterValidate(Context cont2)
    {
    	 cont=cont2;
    	
    	 alert="";
    }
   /* 	
	    if(alert.equals(null))
		{
        	return true;
		}
        else
        {
          	
        	
        }
		return false;
	}
	*/
     
     public String validateColCode(Context context,String collegeCode,TextView TVCollegeCode)
	{
		
		Pattern pattern = Pattern.compile("[A-Z]{1}[0-9]{1}");
		Matcher matcher=pattern.matcher(collegeCode);
	
		
		if(!(matcher.matches())||collegeCode.isEmpty()||collegeCode.length()!=2)
		{
			TVCollegeCode.setTextColor(Color.parseColor("#ff0000"));
			alert=alert+"College Code\n";
			return alert;
		}
		
		TVCollegeCode.setTextColor(Color.parseColor("#ffffff"));
		return alert;
	}
	public String validateBranch(Context context,String branch,TextView TVBranch)
	{
		//String sele="--select--";
		Pattern pattern = Pattern.compile("CSE|ECE|EEE|MECH");
		Matcher matcher=pattern.matcher(branch);
		if(!(matcher.matches())||branch.length()>4)
		{
			TVBranch.setTextColor(Color.parseColor("#ff0000"));
			alert=alert+"Branch\n";
			return alert;
		}
		TVBranch.setTextColor(Color.parseColor("#ffffff"));
		return alert;
	}
	public String validateUserID(Context context,String userID,TextView TVUserID)
	{
		Pattern pattern = Pattern.compile("[5]{1}[0-9]{4}");
		Matcher matcher=pattern.matcher(userID);
		if(!(matcher.matches())||userID.isEmpty()||userID.length()!=5)
		{
			TVUserID.setTextColor(Color.parseColor("#ff0000"));
			alert=alert+"User ID\n";
			return alert;
		}
		TVUserID.setTextColor(Color.parseColor("#ffffff"));
		return alert;
	}
	public String validateFname(Context context,String fname,TextView TVFname)
	{

		Pattern pattern = Pattern.compile("[A-Za-z]{3}[a-z]+");
		Matcher matcher=pattern.matcher(fname);
	
		if(!(matcher.matches())||fname.isEmpty()||fname.length()<5)
		{
			TVFname.setTextColor(Color.parseColor("#ff0000"));
			alert=alert+"First Name\n";
			return alert;
		}
		TVFname.setTextColor(Color.parseColor("#ffffff"));
		return alert;
	}
	public String validateLName(Context context,String lname,TextView TVLname)
	{Pattern pattern = Pattern.compile("[A-Za-z]{3}[a-z]+");
	Matcher matcher=pattern.matcher(lname);
	
	if(!(matcher.matches())||lname.isEmpty()||lname.length()<5)
		{
			TVLname.setTextColor(Color.parseColor("#ff0000"));
			alert=alert+"Last Name\n";
			return alert;
		}
		TVLname.setTextColor(Color.parseColor("#ffffff"));
		return alert;
	}
	
	public String validatePassword(Context context,String password,TextView TVPassword)
	{
		Pattern pattern = Pattern.compile("[A-Za-z]{6}[a-z]+");
		Matcher matcher=pattern.matcher(password);
	
	if(!(matcher.matches())||password.isEmpty()||password.length()<5)
		{
			TVPassword.setTextColor(Color.parseColor("#ff0000"));
			alert=alert+"Password\n";
			return alert;
		}
		TVPassword.setTextColor(Color.parseColor("#ffffff"));
		return alert;
	}


	public String validateRPassword(Context context,String rpassword,String password,TextView TVRPassword)
	{	
		Pattern pattern = Pattern.compile("[A-Za-z]{6}[a-z]+");
	Matcher matcher=pattern.matcher(rpassword);
	
if(!(matcher.matches())||!(rpassword.equals(password))||rpassword.isEmpty()||rpassword.length()<5)
		{
			TVRPassword.setTextColor(Color.parseColor("#ff0000"));
			alert=alert+"Password\n";
			return alert;
		}
		TVRPassword.setTextColor(Color.parseColor("#ffffff"));
		return alert;
	}
	
	public String validatePhone(Context context,String phone,TextView TVPhone)
	{

		Pattern pattern = Pattern.compile("[2-9]{1}[0-9]{9}");
		Matcher matcher=pattern.matcher(phone);
	
		if(!(matcher.matches())||phone.isEmpty()||phone.length()!=10)
		{
			TVPhone.setTextColor(Color.parseColor("#ff0000"));
			alert=alert+"Phone\n";
			return alert;
		}
		TVPhone.setTextColor(Color.parseColor("#ffffff"));
		return alert;
	}
	public String validateEmail(Context context,String email,TextView TVEmail)
	{
		Pattern pattern = Pattern.compile("[a-z]+[a-z0-9._]+\\@[a-z]+\\.[a-z]{3}");
		Matcher matcher=pattern.matcher(email);
		
		if(!(matcher.matches())||email.isEmpty()||email.length()<11)
		{
			TVEmail.setTextColor(Color.parseColor("#ff0000"));
			alert=alert+"Email\n";
			return alert;
		}
		TVEmail.setTextColor(Color.parseColor("#ffffff"));
		return alert;
	}
	

}