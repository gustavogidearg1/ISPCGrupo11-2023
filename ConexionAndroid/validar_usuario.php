<?php
include 'conexion.php';
$email=$_POST['email'];
$password=$_POST['password'];

$ListUsuario=mysqli_query($mysqli ,"SELECT * FROM `usersandroid`");
$vec=[];
while($reg=mysqli_fetch_array($ListUsuario)){
    $vec[]=$reg;
    $varReg = $reg;
}

 if( $varReg > 1){
echo "ingresaste";
       
    }else{
        echo "ERROR"; 
    }


?>