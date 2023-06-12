<?php

include 'conexion.php';
$usu_name=$_POST['name'];
$usu_email=$_POST['email'];
$usu_password=$_POST['password'];


$sentencia=$conexion->prepare("INSERT INTO `usersandroid` (`id`, `name`, `email`, `password`, `phone`, `rol`) 
VALUES (NULL, '$usu_name', '$usu_email', '$usu_password', '', 'user');");



$sentencia->bind_param('ss',$usu_name,$usu_email,$usu_password);
$sentencia->execute();

$resultado = $sentencia->get_result();
if ($sentencia > 0) {
    echo "Registrado";
$titulo="Usted se ha registrado correctamente";
$mensaje="Name: ".$usu_name." - Email: ".$usu_email." - password: ".$usu_password." - Puede difrutar de nuestra aplicacion ";
$para=$usu_email;

$cabeceras = 'From: gustavog<gustavog@planidear.com.ar>';
$enviado = mail($para, $titulo, $mensaje,$cabeceras);  

}else{
    echo "ERROR"; 
}
$sentencia->close();
$conexion->close();


?>
