<?php
    $searchTerm = $_GET['search_term'];
    $sql = "SELECT * FROM Game WHERE name LIKE '%$searchTerm%' OR description LIKE '%$searchTerm%'";
    $result = mysqli_query($GLOBALS['connecte'], $sql);
    while ($row = mysqli_fetch_assoc($result)) {
        echo "<div class='game'>";
        echo "<img src='" . $row['image'] . "' alt='" . $row['name'] . "'>";
        echo "<h1>" . $row['name'] . "</h1>";
        echo "<p>" . $row['description'] . "</p>";
        echo "</div>";
    }
?>
