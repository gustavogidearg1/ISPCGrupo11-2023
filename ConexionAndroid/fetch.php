<?php
//https://planidear.com.ar/ConexionAndroid/fetch.php?id=2

$id=$_GET['id'];	

echo $id;	
require_once("db.php");
		
$query = $mysqli -> query ("SELECT * FROM `usersandroid` WHERE `id` = ".$id.";");
	
$row = mysqli_fetch_assoc($query);

echo json_encode($row);

$query->close();
$mysql->close();

?>