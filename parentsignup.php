<?php
$connection = mysqli_connect("mysql.hostinger.in", "u958710114_root", "vamsidhar","u958710114_rest") or die ("Unable to connect!");

$parentName=$_REQUEST['parentName'];
$studentName=$_REQUEST['StudentName'];
$classss=$_REQUEST['classss'];
$phone=$_REQUEST['phone'];


$querry="insert into users(admin,parentname,studentname,class,phone) values('no','$parentName','$StudentName','$classss','$phone')";
$result=mysqli_query($connection,$querry);

//echo $result;
print(json_encode($result));

mysqli_close($connection);
?>


