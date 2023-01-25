<div class="game-container">



<!DOCTYPE html>
<html lang="en" dir="ltr">
	<h1>
        <title>AlloGame</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="CSS/homepage.css">
    </h1>
	<header>
      <nav>
        <ul>
          <li><a href="index.php">Accueil</a></li>
          <?php if(isset($_SESSION['user_id'])) { ?>
            <li><a href="profile.php">Profil</a></li>
          <?php } ?>
        </ul>
      </nav>
	</header>
    <form action="" method="get">
        <input type="text" id="search-input" name="search-term">
        <input type="submit" value="Search">
    </form>

</html>
</div>
    <?php
        include "ConnexionFct.php";
        
        $sql = "SELECT * FROM Game";
        $result = mysqli_query($GLOBALS['connecte'], $sql);
        while ($row = mysqli_fetch_assoc($result)) {
            echo "<div class='Review'>";
            echo "<img src='" . $row['image'] . "' alt='" . $row['name'] . "'>";
            echo "<h1>" . $row['name'] . "</h1>";
            echo "<p>" . $row['description'] . "</p>";
            echo "</div>";
        }
    ?>
$(document).ready(function() {
    $('form').submit(function(event) {
        event.preventDefault();
        var searchTerm = $('#search-input').val();
        $.get('SearchGames.php', { search_term: searchTerm }, function(data) {
            $('.game-container').html(data);
        });
    });
});

