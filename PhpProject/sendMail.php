<?php

use PHPMailer\PHPMailer\PHPMailer;
use PHPMailer\PHPMailer\Exception;

require_once 'vendor/autoload.php';

$mail = new PHPMailer(true);


$mail->IsSMTP();
$mail->Host = 'smtp.gmail.com';            
$mail->Port = 465;                          
$mail->SMTPAuth = 1;                    

if($mail->SMTPAuth){
    $mail->SMTPSecure = 'ssl';               
    $mail->Username   =  'allogame.eseo@gmail.com';
    $mail->Password   =  'mgqffggdbgkasqjw';   //Mdp 'application' de l'adresse email 
}

$mail->CharSet = 'UTF-8';

$mail->smtpConnect();

$mail->From       =  'allogame.eseo@gmail.com';   
$mail->FromName   = 'AlloGame';

$mail->Subject    =  'Reset password code';  
$mail->WordWrap   = 50; 


$code=code_generator(64, '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ');

$mail->AltBody = 'Your AlloGame password reseting code is:' . $code .'.'; 	      
$mail->IsHTML(false);                                 

$mail->AddAddress('insertemailhere');

if (!$mail->send()) {
    echo $mail->ErrorInfo;
} else{
    echo 'Your password change demand has been noted. Please check your email (including spam) and retrieve the code we have sent you!';
}

?>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>test</h1>

</body>
</html>

<?php 

//adaptée pour PHP7
function code_generator(int $length, string $keyspace): 
    
    string {
        if ($length < 1) {
            throw new \RangeException("Length must be higher than 0");
        }
        $code = [];
        $max = mb_strlen($keyspace, '8bit') - 1;
        for ($i = 0; $i < $length; ++$i) {
            $code []= $keyspace[random_int(0, $max)];
        }
        return implode('', $code);
}

?>