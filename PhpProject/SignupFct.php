<?php
/*
 * Function that confirms that the password confirmation worked
 */
function passwordVerif($userPwd, $userPwdConfirm){
    
    $validPassword = true;
    
    if ($userPwd != $userPwdConfirm){
        $validPassword = false;
    }
    
    return $validPassword;
}
/*
 * Function that verifies if no data has been left empty in a form
 */
function completeVerif(Array $userdata){
    $complete = true;
    
    for ($i=0; $i < count($userdata); $i++) {
        if ($userdata[$i] == '' || $userdata[$i] == '0'){
            $complete = false;
        }
    }
    
    return $complete;
}


/*
 * Function that verifies that the email doesn't already exist on sign up
 */
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

/*
 * Function that verifies that the username doesn't already exist on sign up
 */
function usernameUnique($testedUsername){
    
    $usernameUnique =true;
    $usernameBDD = $GLOBALS['allogame'] -> query('SELECT pseudo from User');
    
    while ($usedUsername = $usernameBDD -> fetch()){
        if ($testedUsername == $usedUsername['pseudo']){
            $usernameUnique = false;
        }
    }
    
    return $usernameUnique;
}

?>