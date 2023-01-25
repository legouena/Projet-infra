<?php
    session_start();

    // Connexion à la base de données
    $host = "192.168.156.82";
    $username = "allogame_user";
    $password = "network";
    $dbname = "allogame";
    $conn = mysqli_connect($host, $username, $password, $dbname);

    // Vérifiez la connexion
    if (!$conn) {
        die("Connection failed: " . mysqli_connect_error());
    }

    if (isset($_POST['login'])) {
        // Récupération des données de connexion
        $mail = mysqli_real_escape_string($conn, $_POST['mail']);
        $password = mysqli_real_escape_string($conn, $_POST['password']);
    
        // Vérification de l'utilisateur dans la base de données
        $sql = "SELECT * FROM User WHERE mail = '$mail'";
        $result = mysqli_query($conn, $sql);
        $count = mysqli_num_rows($result);
    
        if ($count == 1) {
            // Récupération des données de l'utilisateur
            $row = mysqli_fetch_array($result);
            $password_hashed = $row['password'];
    
            // Vérification du mot de passe
            if (password_verify($password, $password_hashed)) {
                // Stockage des données de session
                $_SESSION['id'] = $row['id'];
                $_SESSION['type'] = $row['type'];
                $_SESSION['pseudo'] = $row['pseudo'];
                $_SESSION['mail'] = $row['mail'];
                // Redirection vers la page d'accueil
                header("location: homepage.php");
            } else {
                echo "Invalid mail or password";
            }
        } else {
            echo "Invalid mail or password";
        }
    }

    if (isset($_POST['register'])) {
        // Récupération des données d'inscription
        $pseudo = mysqli_real_escape_string($conn, $_POST['pseudo']);
        $mail = mysqli_real_escape_string($conn, $_POST['mail']);
        $password = mysqli_real_escape_string($conn, $_POST['password']);
        $creationDate = date("Y-m-d H:i:s");
        $lastConnexion_login = date("Y-m-d H:i:s");
        $notoriety = 0;

        // hash the password before saving in the database
        $password = password_hash($password, PASSWORD_DEFAULT);

        // Insertion des données dans la base de données
        $sql = "INSERT INTO User (pseudo, mail, password, creationDate, lastConnexion, notoriety) VALUES ('$pseudo', '$mail', '$password', '$creationDate', '$lastConnexion_login', '$notoriety')";
        $result = mysqli_query($conn, $sql);
        /*
        if ($result) {
            // Envoi d'un mail de vérification
            $to = $mail;
            $subject = "Verification Code";
            $verification_code = rand(100000, 999999);
            $_SESSION['verification_code'] = $verification_code;
            $message = "Your Verification Code is " . $verification_code;
            $headers = "From: noreply@example.com\r\n";
            mail($to, $subject, $message, $headers);
            header("location: verify.php");
        } else {
            echo "Error: " . $sql . "<br>" . mysqli_error($conn);
        }
        */
        if (mysqli_query($conn, $sql)) {
            echo "Inscription réussie";
        } else {
            echo "Error: " . $sql . "<br>" . mysqli_error($conn);
        }
    }

    if (isset($_POST['forgot'])) {
        // Récupération de l'mail de l'utilisateur
        $mail = mysqli_real_escape_string($conn, $_POST['mail']);

        // Vérification de l'existence de l'mail dans la base de données
        $sql = "SELECT * FROM User WHERE mail = '$mail'";
        $result = mysqli_query($conn, $sql);
        $count = mysqli_num_rows($result);

        if ($count == 1) {
            // Génération d'un code de vérification aléatoire
            $verification_code = rand(100000, 999999);

            // Mise à jour de la base de données avec le code de vérification
            $sql = "UPDATE User SET verification_code = '$verification_code' WHERE mail = '$mail'";
            $result = mysqli_query($conn, $sql);

            // Envoi d'un mail de vérification
            $to = $mail;
            $subject = "Verification Code";
            $message = "Your Verification Code is " . $verification_code;
            $headers = "From: noreply@example.com\r\n";
            mail($to, $subject, $message, $headers);
            header("location: verify.php");
        } else {
            echo "Invalid mail address";
        }
    }
    /*
    * Function that confirms that the password confirmation worked
    /
    function passwordVerif($userPwd, $userPwdConfirm){

        $validPassword = true;

        if ($userPwd != $userPwdConfirm){
            $validPassword = false;
        }

        return $validPassword;
    }
    /
    * Function that verifies if no data has been left empty in a form
    /
    function completeVerif(Array $userdata){
        $complete = true;

        for ($i=0; $i < count($userdata); $i++) {
            if ($userdata[$i] == '' || $userdata[$i] == '0'){
                $complete = false;
            }
        }

        return $complete;
    }


    /
    * Function that verifies that the email doesn't already exist on sign up
    /
    function emailUnique($testedEmail){
        $emailUnique = true;
        $emailBDD = $GLOBALS['allogame'] -> query('SELECT mail from User');

        while ($usedEmail = $emailBDD -> fetch()){
            if ($testedEmail == $usedEmail['mail']){
                $emailUnique = false;
            }
        }
        return $emailUnique;
    }

    /
    * Function that verifies that the username doesn't already exist on sign up
    */
    function usernameUnique($testedUsername){

        $usernameUnique =true;
        $usernameBDD = $GLOBALS['allogame'] -> query('SELECT pseudo from user');

        while ($usedUsername = $usernameBDD -> fetch()){
            if ($testedUsername == $usedUsername['pseudo']){
                $usernameUnique = false;
            }
        }

        return $usernameUnique;
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
    
        <main>

            <div class="wrapper">
                
                <div id="conn" class="left">
                    
                    <h1>Connect to your AlloGame account.</h1>

                        <form method="post" action="">
                            <label for="mail">mail:</label>
                            <input type="mail" id="mail" name="mail" placeholder="example@html.com" required pattern="^[a-z0-9.-]+@[a-z0-9.-]{2,}.[a-z]{2,4}$" required>
                            <br>
                            <label for="password">Password:</label>
                            <input type="password" id="password" name="password" required>
                            <br>
                            <input type="submit" name="login" value="Login">
                            <input type="submit" name="forgot" value="Forgot Password">
                        </form>
                        
        
                </div>
                    
                <div class = "vertical"></div>
                    
                <div id="signup" class="right">
                    
                    <h1>Sign up to AlloGame.</h1>
    
                    <form method="post" action="">

                        <label for="pseudo">Pseudo:</label>
                        <input type="text" id="pseudo" name="pseudo" required>
                        <br>
                        <label for="mail">mail:</label>
                        <input type="mail" id="mail" name="mail" required placeholder="example@html.com" required pattern="^[a-z0-9.-]+@[a-z0-9.-]{2,}.[a-z]{2,4}$">
                        <br>
                        <label for="password">Password:</label>
                        <input type="password" id="password" name="password" required>
                        <br>
                        <input type="submit" name="register" value="Register">
                    </form>
                    
                </div>
    		
    		</div>
    		
    		
    		
    	</main>
        
        <footer>
    	
        <p>ESEO 2023.</p>
    
        </footer>

    </body>


</html>
