<?php
	$username = $_POST["username"];
	$passoword = $_POST["password"];
	
	if(($username == "huacnlee") && ($password == "123123")){
		echo("{success:1}");
	}
	else
	{
		echo("{success:0}")	;
	}
	
	
?>
