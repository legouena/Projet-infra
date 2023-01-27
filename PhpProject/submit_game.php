<?php
   // Connexion à la base de données
   $host = "localhost";
   $username = "test";
   $password = "test";
   $dbname = "allogame";
   $conn = mysqli_connect($host, $username, $password, $dbname);
  
  if (isset($_POST["name"]) && isset($_POST["image"])) {
    $name = $_POST["name"];
    $image = $_POST["image"];
    $game = array("name" => $name, "image" => $image);
    $games = file_get_contents("games.txt");
    $games = json_decode($games, true);
    $games[] = $game;
    file_put_contents("games.txt", json_encode($games));
    header("location: homepage.php");


  }
?>
