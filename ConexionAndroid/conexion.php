<?php
$hostname='168.197.48.110';
$database='c2110488_PrIspc';
$username='c2110488_PrIspc';
$password='98movadoDO';


$conexion=new mysqli($hostname,$username,$password,$database);
if($conexion->connect_errno){
    echo "El sitio web está experimentado problemas";
}
?>