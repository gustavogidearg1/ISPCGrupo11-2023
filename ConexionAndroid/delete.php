<?php
//https://youtu.be/cBfL5-4Ylgs?t=2218

$id=$_GET['id'];	

require_once("db.php");
		
$query = $mysqli -> query ("SELECT * FROM `usersandroid` WHERE `id` = ".$id.";");
	
$row = mysqli_fetch_assoc($query);

echo json_encode($row);

$query->close();
$mysql->close();

?>