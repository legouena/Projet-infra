<?php

/*
 *File containing functions pertaining to users' session and connection 
 */

if(!isset($functionsconnexionInclude)) {

    $functionsconnexionInclude = true;

    session_start();
  
    /*
     * Connexion to the database.
     */
    try {
      
        $allogameBase = new PDO('mysql:host=localhost;dbname=testtest;charset=utf8','root','');
  
    } catch(Exception $e) {
    
      die('Erreur : ' .$e -> getMessage());
    }

    /*
     * Defining a global variable.
     */
    $GLOBALS["allogame"] = $allogameBase;

    
    
    /*
     * Function determining if the email address exists in the database.
     */
    function verifEmail($allogameBase) {
      
        $emailAll = $allogameBase -> query('SELECT ... from table');
        $emailValide = false;
    
        if(isset($_SESSION["sessionEmail"])) {
            
          while ($emails = $emailAll -> fetch()) {
              
            if ($emails["Email"] == $_SESSION["sessionEmail"]) {
                
              $emailValide = true;
            }
          }
        }
    
        return $emailValide;
    }

    /*
     * Function determining if the password matches the email.
     */
    function verifPassword($allogameBase) {

        $passwordValide = false;

        if (verifEmail($allogameBase)) {
            
            $userPassword = $allogameBase -> query("SELECT ??? from table WHERE ??? = '".$_SESSION["sessionEmail"]."';");
            
            while($mdp = $userPassword->fetch()) {
                
                if ($_SESSION["sessionPassword"] == $mdp['???']) {
                    
                    $passwordValide = true;
                }
            }
        }
        
        return $passwordValide;
    }

    
    /*
     * Function that verifies if the user's data is correct and offers him the "connected" status
     */
    function profileConnected($allogameBase) {

      $connected = false;
      
      if(verifPassword($allogameBase)) {
          
        $connected = true;
      }

      return $connected;
    }
}

?>