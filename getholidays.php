<?php
$connection = mysqli_connect("mysql.hostinger.in", "u958710114_root", "vamsidhar","u958710114_rest") or die ("Unable to connect!");
//mysql_select_db("u958710114_rest") or die ("Unable to select database!");

$querry="select date,reason from holiday";


//echo $querry;

	$result=mysqli_query($connection,$querry);
	while($row=mysqli_fetch_assoc($result))
		$output[]=$row;


print(json_encode($output));

//echo $result;
//echo json_encode($result);




mysqli_close($connection);
?>