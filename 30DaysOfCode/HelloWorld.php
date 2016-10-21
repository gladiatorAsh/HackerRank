<?php

$fp=fopen("php://stdin","r");

$inputString=fgets($fp);
print("Hello World !");
print($inputString);

fclose($fp);

?>

