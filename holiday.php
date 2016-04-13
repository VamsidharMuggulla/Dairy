<?php
$connection = mysqli_connect("mysql.hostinger.in", "u958710114_root", "vamsidhar","u958710114_rest") or die ("Unable to connect!");


$date=$_REQUEST['date'];
$reason=$_REQUEST['reason'];


$querry="insert into holiday(date,reason) values('$date','$reason')";

$result=mysqli_query($connection,$querry);

//echo $result;
print(json_encode($result));

mysqli_close($connection);
?>
