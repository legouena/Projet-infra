<?php
  $video_games = array(
    array("name" => "Super Mario Bros.", "image" => "mario.jpg"),
    array("name" => "The Legend of Zelda", "image" => "zelda.jpg"),
    array("name" => "Minecraft", "image" => "minecraft.jpg")
  );
  




?>

<!DOCTYPE html>
<html lang="en" dir="ltr">

    <head>Home Page</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="CSS/homepage.css">
    </head>

    <header>
        <div class="navigation_button">
        <meta charset="utf-8">
            <nav>
            <a href="/homepage.php">Accueil</a>
            <a href="/profile.php">Profil</a>
            <a href="/revueJeu.php">Page de revue</a>
            </nav>
        </div>
    </header>





    <body>
        <div class="games-list">
            <?php
            $games_json = file_get_contents("games.txt");
            $games = json_decode($games_json, true);
            foreach ($games as $game) {
                echo "<div class='game'>";
                echo "<img src='" . $game["image"] . "' alt='" . $game["name"] . "'>";
                echo "<p>" . $game["name"] . "</p>";
                echo "</div>";
            }
            ?>
        </div>
    </body>

    <form method="post" action="submit_game.php">
        <label for="name">Nom du jeu vidéo :</label>
        <input type="text" id="name" name="name">
        <br>
        <label for="image">URL de l'image :</label>
        <input type="text" id="image" name="image">
        <br>
        <input type="submit" value="Ajouter">
    </form>

</html>