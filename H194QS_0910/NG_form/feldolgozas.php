<?php
	function validate_nev ($nev) {
	$nevek = explode(' ',$nev);
	if ((count($nevek) == 2)) {
	if (!preg_match("/^[a-zA-Zöüóőúéáűäş&#537;ţ&#539;îâŞ&#536;Ţ&#538;ÎÂÖÜÓŐÚÉÁŰ\-]{2,30}$/i",$nevek[0])){
			print("A név nem megfelelő formátumu.");
	}
	elseif (!preg_match("/^[a-zA-Zöüóőúéáűäş&#537;ţ&#539;îâŞ&#536;Ţ&#538;ÎÂÖÜÓŐÚÉÁŰ]{2,30}$/",$nevek[1])) {
			print("A név nem megfelelő formátumu.");
	}
	else {
		return true;
	}
	}	
	elseif ((count($nevek) == 3)) {
	if (!preg_match("/^[a-zA-Zöüóőúéáűäş&#537;ţ&#539;îâŞ&#536;Ţ&#538;ÎÂÖÜÓŐÚÉÁŰ\-]{2,30}$/",$nevek[0])){
			print("A név nem megfelelő formátumu.");
	}
	elseif (!preg_match("/^[a-zA-Zöüóőúéáűäş&#537;ţ&#539;îâŞ&#536;Ţ&#538;ÎÂÖÜÓŐÚÉÁŰ]{2,30}$/",$nevek[1])) {
			print("A név nem megfelelő formátumu.");
	}
	else if (!preg_match("/^[a-zA-Zöüóőúéáűäş&#537;ţ&#539;îâŞ&#536;Ţ&#538;ÎÂÖÜÓŐÚÉÁŰ]{2,30}$/",$nevek[2])) {
			print("A név nem megfelelő formátumu.");
	}
	else {
		return true;
	}
	}
	else {
		print("A név nem megfelelő formátumu.");
	}
	}
	
	function validate_gyumolcs( $gyumolcs ) {  
		$match = '/^[a-zA-Zöüóőúéáűäş&#537;ţ&#539;îâŞ&#536;Ţ&#538;ÎÂÖÜÓŐÚÉÁŰ]{2,30}$/'; 
	if ( preg_match( $match, $gyumolcs ) ) {  
		return true;  
	} else {  
		print("A gyümölcs csak betüt tartalmazhat."); 
	};  
}  	

	function validate_pswd( $pswd ) {  
		$match = '/^[a-zA-Z0-9]+$/'; 
	if ( preg_match( $match, $pswd ) ) {  
		return true;  
	} else {  
		print("A jelszó csak számot és angol betüt tartalmazhat"); 
	}; 
	
}
	function validate_eletkor( $eletkor ) {  
		
	if ("17"<$eletkor && "121">$eletkor ) {  
		return true;  
	} else {  
		print("Az életkor nem 18-120 között van."); 
	}; 
}
	function validate_labmeret($labmeret ) {  
		 
	if ( "0"<$labmeret && "61">$labmeret ) {  
		return true;  
	} else {  
		print("A lábméret nem 1-60 között van."); 
	}; 
}

if (isset($_GET['elkuld'])) {
if(validate_nev($_GET['nev']) && validate_pswd( $_GET['pinkod'] )&& validate_gyumolcs($_GET['kedvencgyumolcs']) && validate_eletkor($_GET['eletkor']) && validate_labmeret($_GET['labmeret'])) {  
	echo "Név: ".$_GET['nev']."<br>";
	echo "PIN kód: ".$_GET['pinkod']."<br>";
	echo "Kedvenc gyümölcs: ".$_GET['kedvencgyumolcs']."<br>";
	echo "Életkor: ".$_GET['eletkor']."<br>";
	echo "Lábméret: ".$_GET['labmeret']."<br>";
	echo "Önbizalom: ".$_GET['onbizalom']."<br>"; }
  else {  
    return false;  
}  
}

if (isset($_GET['elelkuld'])) {
	
	echo "Név: ".$_GET['nev']."<br>";
	echo "PIN kód: ".$_GET['pinkod']."<br>";
	echo "Kedvenc gyümölcs: ".$_GET['kedvencgyumolcs']."<br>";
	echo "Életkor: ".$_GET['eletkor']."<br>";
	echo "Lábméret: ".$_GET['labmeret']."<br>";
	echo "Önbizalom: ".$_GET['onbizalom']."<br>";
	
	}
	
	
?>

<html>

<head>
	<title>Feldolgozo</title>
	
	
</head>

<body>
	<br>
	<a href="NG_from.html"><button type="button">Vissza</button></a>
</body>

</html>
