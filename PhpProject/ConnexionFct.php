<?php

if(!isset($functionsconnexionInclude)){
    
    $functionsconnexionInclude = true;
    
    session_start();
    try {
        $alloBase = new PDO('mysql:host=localhost;dbname=allogame;charset=utf8','root','');
    }
    catch(Exception $e) {
        die('Erreur : ' .$e -> getMessage());
    }
    
    $GLOBALS["allogame"] = $alloBase;
    
    function verifEmail($alloBase){
        $emailAll = $alloBase -> query('SELECT mail from User');
        $emailValide = false;
        
        if(isset($_SESSION["sessionEmail"])){
            while ($emails = $emailAll -> fetch()){
                if ($emails["mail"] == $_SESSION["sessionEmail"]){
                    $emailValide = true;
                }
            }
        }
        
        return $emailValide;
    }
    
    function verifPseudo($alloBase){
        $pseudoAll = $alloBase -> query('SELECT pseudo from User');
        $pseudoValide = false;
        
        if(isset($_SESSION["sessionPseudo"])){
            while ($pseudos = $pseudoAll -> fetch()){
                if ($pseudos["pseudo"] == $_SESSION["sessionPseudo"]){
                    $pseudoValide = true;
                }
            }
        }
        
        return $emailValide;
    }
    
    function verifPassword($alloBase){
        
        $passwordValide = false;
        
        if (verifEmail($alloBase)){
            $userPassword = $alloBase -> query("SELECT password from User WHERE mail = '".$_SESSION["sessionEmail"]."';");
            while($mdp = $userPassword->fetch()){
                if ($_SESSION["sessionPassword"] == $mdp['password']) {
                    $passwordValide = true;
                }
            }
        } else if(verifPseudo($alloBase)){
            $userPassword = $alloBase -> query("SELECT password from User WHERE pseudo = '".$_SESSION["sessionPseudo"]."';");
            while($mdp = $userPassword->fetch()){
                if ($_SESSION["sessionPassword"] == $mdp['password']) {
                    $passwordValide = true;
                }
            }
        }
        return $passwordValide;
    }
    
    function profile($alloBase){
        
        $connected = false;
        if(verifPassword($alloBase)){
            $connected = true;
        }
        
        return $connected;
    }
    
    
    function valid($donnee_a_valider){
        
        $donnee_a_valider = stripcslashes($donnee_a_valider);
        $donnee_a_valider = htmlspecialchars($donnee_a_valider);
        
        return $donnee_a_valider;
    }
}

?>
