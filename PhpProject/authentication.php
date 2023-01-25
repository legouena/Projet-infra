<?php

include "ConnexionFct.php";
include "SignupFct.php";
$GLOBALS['connecte'] = profile($alloBase);

if ($GLOBALS['connecte']){
    $profile = 'profile.php';
    header("Location: $profile");
    exit();
}

if (isset($_POST["createAccount"])){
    $userdata = array(valid($_POST['username']), valid($_POST['email']), valid($_POST['password']), valid($_POST['passwordConf']));
    
    if (completeVerif($userdata)){
        if (emailUnique($userdata)){
            if (usernameUnique(valid($_POST['username']))){
                if (passwordVerif($userdata)){
                    $account = $alloBase->prepare('INSERT INTO User (pseudo, mail, password)
                    VALUES (:pseudo, :mail, :password)');
                    
                    $account->execute(array(':pseudo' => valid($_POST['username']), ':mail' => valid($_POST['email']), ':password' => valid($_POST['password'])));
                    
                    $menu_connected = 'Homepage.php';
                    header("Location: $menu_connected");
                    exit();
                    
                }}}}
}

if (isset($_POST["decoButton"])){
    $GLOBALS["connecte"] = false;
    session_destroy();
}

?>

<!DOCTYPE html>
<html lang="en" dir="ltr">
    
    <head>
        <meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1">
        <title>AlloGame - Authentication</title>
        <link rel="stylesheet" href="CSS/authentication.css">
    </head>
    
    <body>
    
    	<header>
    		<b><p style="font-size: 22px">AlloGame - Community Video Game Reviews.</p></b>
    		
    	</header>
    
    	<main>
    
        	<div class="wrapper">
        		
        		<div id="conn" class="left">
        			
            		<b><p style="font-size: 27px">Connect to your AlloGame account.</p></b>
            		
            		<form class="" action="Homepage.php" method="post">
            		
            			<p>Email: <input type="email" name="emailAddress" pattern="^[a-z0-9._-]+@[a-z0-9._-]{2,}\.[a-z]{2,4}$"></p>
            			<p>---------OR---------</p>
            			<p>Username: <input type="text" name="usernameCo" minlength="5" maxlength="15"></p>
            			<p>Password: <input type="password" name="passwordCo" required minlength="8" maxlength="15"></p>
            		
            			<input class="button" type="submit" value="Connect to Your Account" name="connectAccount"></input>
            		
            		</form>
            		
            		<p>Forgot your password? Click <a href="sendMail.php">here</a>.</p>
            
           
        		</div>
        		
        		<div class = "vertical"></div>
        		
        		<div id="signup" class="right">
        		
        			<b><p style="font-size: 27px">Sign up to AlloGame.</p></b>
        		
        			<form class="" action="Homepage.php" method="post">
        			
        				<p>Username: <input type="text" name="username" placeholder="5 to 15 characters" required minlength="5" maxlength="15"></p>
              			<p>Email: <input type="email" name="email" placeholder="example@html.com" required pattern="^[a-z0-9._-]+@[a-z0-9._-]{2,}\.[a-z]{2,4}$"></p>
              			<p>Password: <input type="password" name="password" placeholder="8 to 15 characters" required minlength="8" maxlength="15"></p>
              			<p>Password Confirmation: <input type="password" name="passwordConf" required minlength="8" maxlength="15"></p>
           
    					<input class="button" type="submit" value="Create Your Account" name="createAccount"></input>    			
        			
        			</form>
        			
        		</div>
    		
    		</div>
    		
    		
    		
    	</main>
    
    <footer>
    	
    		<p>ESEO 2023.</p>
    	
    	</footer>
    	
    
    </body>
</html>