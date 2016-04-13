<?php
$connection = mysqli_connect("mysql.hostinger.in", "u958710114_root", "vamsidhar","u958710114_rest") or die ("Unable to connect!");

$query = "SELECT email,pass,admin FROM users";
$result = mysqli_query($connection,$query);

//tutorial code
while($row=mysqli_fetch_assoc($result))
	$output[]=$row;
print(json_encode($output));

mysqli_close($connection);
?>