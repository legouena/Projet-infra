<?php
if (isset($_POST['verify'])) {
    // Récupération du code de vérification entré par l'utilisateur
    $verification_code = mysqli_real_escape_string($conn, $_POST['verification_code']);

    // Vérification du code de vérification dans la base de données
    $sql = "SELECT * FROM User WHERE verification_code = '$verification_code'";
    $result = mysqli_query($conn, $sql);
    $count = mysqli_num_rows($result);

    if ($count == 1) {
        // Stockage de l'ID de l'utilisateur pour une utilisation ultérieure
        $row = mysqli_fetch_array($result);
        $user_id = $row['id'];

        // Suppression du code de vérification de la base de données
        $sql = "UPDATE User SET verification_code = '' WHERE id = '$user_id'";
        mysqli_query($conn, $sql);

        // Redirection vers la page de création de mot de passe
        header("location: reset-password.php?user_id=$user_id");
    } else {
        echo "Invalid verification code";
    }
}
?>
<form method="post" action="">
    <label for="verification_code">Verification Code:</label>
    <input type="text" id="verification_code" name="verification_code" required>
    <br>
    <input type="submit" name="verify" value="Verify">
</form>