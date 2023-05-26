<?php

if($_SERVER['REQUEST_METHOD'] == 'POST'){
    require_once("db.php");
    $name=$_POST['name'];	
    $email=$_POST['email'];
    $password=$_POST['password'];	
    $phone=$_POST['phone'];

    $insertarusersandroid = "INSERT INTO `usersandroid` (`id`, `name`, `email`, `password`, `phone`) VALUES (NULL, '$name', '$email', '$password', '$phone');";
    $result=mysqli_query($mysqli,$insertarusersandroid );
		
    if($result === true){
        echo "El usuario fue credo existosamente";

    }else{
        echo "Error";
    }
		
    mysqli_close($mysqli);	
}


		
?>