
<?php
$connection = mysqli_connect("mysql.hostinger.in", "u958710114_root", "vamsidhar","u958710114_rest") or die ("Unable to connect!");


$work=$_REQUEST['work'];


$querry="insert into work(work) values('$work')";
$result=mysqli_query($connection,$querry);

//echo $result;
print(json_encode($result));

mysqli_close($connection);
?>


