<?php

// Connexion à la base de données
$conn = mysqli_connect("host", "username", "password", "database");

// Vérification de la connexion
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}

// Récupération de la requête de recherche
$query = mysqli_real_escape_string($conn, $_GET['query']);

// Exécution de la requête de recherche dans la base de données
$sql = "SELECT * FROM game WHERE name LIKE '%$query%'";
$result = mysqli_query($conn, $sql);

// Vérification des résultats de la requête
if (mysqli_num_rows($result) > 0) {
    // Affichage des résultats de la recherche
    while($row = mysqli_fetch_assoc($result)) {
        echo "<div class='game'>";
        echo "<img src='" . $row['image'] . "' alt='" . $row['name'] . "'>";
        echo "<h2>" . $row['name'] . "</h2>";
        echo "</div>";
    }
} else {
    echo "No result for '" . $query . "'";
}

// Fermeture de la connexion à la base de données
mysqli_close($conn);

?>
