<?php

/*include functions*/

?>

<!DOCTYPE html>
<html lang="en" dir="ltr">
    
    <head>
        <meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1">
        <title>AlloGame - Authentication</title>
        <link rel="stylesheet" href="CSS/authentication.css">
    </head>
    
    <body>
    
    	<main>
    
        	<div class="wrapper">
        		
        		<div id="conn" class="left">
        			
            		<h1>Connect to your AlloGame account.</h1>
            		
            		<form class="" action="sendMail.php" method="post">
            		
            			<p>Email: <input type="email" name="emailAddressCo" required pattern="^[a-z0-9._-]+@[a-z0-9._-]{2,}\.[a-z]{2,4}$"></p>
            			<p>---------OR---------</p>
            			<p>Username: <input type="text" name="usernameCo" required minlength="5" maxlength="15"></p>
            			<p>Password: <input type="password" name="passwordCo" required minlength="8" maxlength="15"></p>
            		
            			<input class="button" type="submit" value="Connect to Your Account" name="connectAccount"></input>
            		
            		</form>
            		
            		<p>Forgot your password? Click <a href="">here</a>.</p>
            
           
        		</div>
        		
        		<div class = "vertical"></div>
        		
        		<div id="signup" class="right">
        		
        			<h1>Sign up to AlloGame.</h1>
        		
        			<form class="" action="Homepage.php" method="post">
        			
        				<p>Username: <input type="text" name="username" placeholder="5 to 15 characters" required minlength="5" maxlength="15"></p>
              			<p>Email: <input type="email" name="email" placeholder="example@html.com" required pattern="^[a-z0-9._-]+@[a-z0-9._-]{2,}\.[a-z]{2,4}$"></p>
              			<p>Password: <input type="password" name="password" placeholder="8 to 15 characters" minlength="8" maxlength="15"></p>
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