<?php
include 'conexion.php';
//$usu_usuario=$_POST['usuario'];
//$usu_password=$_POST['password'];

$usu_usuario="email";
$usu_password="1234";

$sentencia=$conexion->prepare("SELECT * FROM usersandroid WHERE email=? AND password=?");
$sentencia->bind_param('ss',$usu_usuario,$usu_password);
$sentencia->execute();

$resultado = $sentencia->get_result();
if ($fila = $resultado->fetch_assoc()) {
         //echo json_encode($fila,JSON_UNESCAPED_UNICODE);     
echo "ingresaste";
}else{
    echo "ERROR"; 
}
$sentencia->close();
$conexion->close();
?>