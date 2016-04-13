package com.uidsample4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.TextView;

public class CollegeRegisterValidate 
{
    String alert="";
   
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
	public String validateColName(Context context,String collegeName,TextView TVCollegeName)
	{
		if(collegeName.isEmpty()||collegeName.length()<20)
		{
			TVCollegeName.setTextColor(Color.parseColor("#ff0000"));
			alert=alert+"College Name\n";
			return alert;
		}
		TVCollegeName.setTextColor(Color.parseColor("#ffffff"));
		return alert;
	}
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
	public String validateCityTown(Context context,String cityTown,TextView TVCityTown)
	{
		Pattern pattern = Pattern.compile("[A-Y]{1}[a-z]+");
		Matcher matcher=pattern.matcher(cityTown);
		if(!(matcher.matches())||cityTown.equals(null)||cityTown.length()<4||cityTown.length()>20)
		{
			TVCityTown.setTextColor(Color.parseColor("#ff0000"));
			alert=alert+"City/Town\n";
			return alert;
		}
		TVCityTown.setTextColor(Color.parseColor("#ffffff"));
		return alert;
	}
	public String validatePinCode(Context context,String pinCode,TextView TVPinCode)
	{
		Pattern pattern = Pattern.compile("[5]{1}[0-9]{5}");
		Matcher matcher=pattern.matcher(pinCode);
		if(!(matcher.matches())||pinCode.isEmpty()||pinCode.length()!=6)
		{
			TVPinCode.setTextColor(Color.parseColor("#ff0000"));
			alert=alert+"PinCode\n";
			return alert;
		}
		TVPinCode.setTextColor(Color.parseColor("#ffffff"));
		return alert;
	}
	public String validateDistrict(Context context,String district,TextView TVDistrict)
	{
		if(district.isEmpty()||district.length()<5)
		{
			TVDistrict.setTextColor(Color.parseColor("#ff0000"));
			alert=alert+"District\n";
			return alert;
		}
		TVDistrict.setTextColor(Color.parseColor("#ffffff"));
		return alert;
	}
	public String validatePhone(Context context,String phone,TextView TVPhone)
	{

		Pattern pattern = Pattern.compile("[2-9]{1}[0-9]{5}");
		Matcher matcher=pattern.matcher(phone);
	
		if(!(matcher.matches())||phone.isEmpty()||phone.length()!=6)
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