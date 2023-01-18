<?php

    include "ConnexionFct.php";
    $GLOBALS['connecte'] = profileConnected($allogameBase);
    
    if ($GLOBALS['connecte']) {
        
      $Homepage = 'Homepage.php';
      header("Location: $Homepage");
      exit();
    }

?>


<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>AlloGame - Connexion</title>
    <link rel="stylesheet" href="CSS/connexion.css">
  </head>
  <body>

    <main>
    
      <h1>Connect to your AlloGame Account.</h1>

      <form class="" action="profile.php" method="post">
      
        <p>Email Address:<input type="email" name="emailAddress"> </p>
        <p>Password: <input type="password" name="passwordCo"> </p>

        <input type="submit" value="Connect to Your Account" name="connectAccount"></input>
        
      </form>

      <section id = "signup">
      
        <p>Don't have an account yet? Sign up <a href = "signup.php"> here</a>.</p>
        
      </section>

      <form class="" action="Homepage.php" method="post">

        <input type="submit" value="Return to Main Menu" name="returnMain"></input>
        
      </form>

    </main>


  </body>
</html>