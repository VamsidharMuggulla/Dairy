<?php
$connection = mysqli_connect("mysql.hostinger.in", "u958710114_root", "vamsidhar","u958710114_rest") or die ("Unable to connect!");

$parentName=$_REQUEST['tName'];
$subject=$_REQUEST['subject'];
$classss=$_REQUEST['classss'];
$phone=$_REQUEST['phone'];
$password=$_REQUEST['password'];


$querry="insert into users(password,admin,parentname,studentname,class,phone) values('$password','yes','$parentName','$studentName','$classss','$phone')";
$result=mysqli_query($connection,$querry);

//echo $result;
print(json_encode($result));

mysqli_close($connection);
?>

