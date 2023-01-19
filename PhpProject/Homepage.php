<div class="game-container">
    <?php
        include "ConnexionFct.php";
        
        $sql = "SELECT * FROM Review";
        $result = mysqli_query($GLOBALS['connecte'], $sql);
        while ($row = mysqli_fetch_assoc($result)) {
            echo "<div class='Review'>";
            echo "<img src='" . $row['image'] . "' alt='" . $row['game'] . "'>";
            echo "<h1>" . $row['game'] . "</h1>";
            echo "<p>" . $row['description'] . "</p>";
            echo "</div>";
        }
    ?>


<!DOCTYPE html>
<html lang="en" dir="ltr">

    <form action="" method="get">
        <input type="text" id="search-input" name="search-term">
        <input type="submit" value="Search">
    </form>

</html>

$(document).ready(function() {
    $('form').submit(function(event) {
        event.preventDefault();
        var searchTerm = $('#search-input').val();
        $.get('SearchGames.php', { search_term: searchTerm }, function(data) {
            $('.game-container').html(data);
        });
    });
});

</div>