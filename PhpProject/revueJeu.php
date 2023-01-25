<?php
    $nombre = 0;
    
    if (isset($_POST['plus'])){
        $nombre++;
    }
    if(isset($_POST['moins'])){
        $nombre--;
    }
?>

<!DOCTYPE html>
<html lang="fr">
	
	<head>
        <title>Page Revue de jeu</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="CSS/revue.css">
    </head>
    
    <body>
        <header>
        	<div class="navigation_button">
        		<p>&nbsp;</p>
            	<p>GameRev</p>
            	<button>Liste Jeux</button>
            	<input class="textfield" type="text" placeholder="Recherche">
            </div>
        </header>
        
         <section>
         	<div class="cadre_img">
         		<img src="photos/Halo3.jpg" class="image_jeu">
         		<div class ="description">
         			<object data="listeCommentairesRevues/descriptionJeu.txt" width="450" height="300"></object>
         		</div>
         		<iframe width="450" height="300" src="https://www.youtube.com/embed/T9Ezd2FqxAU" title="Halo 3 - First Announcement Trailer  [HD] - E3 2006" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
         	</div>
         </section>
         
         <section>
         	<div class="cadre_commentaire">
         	
         		<div class="commentaire">
         			<h1> Excellent jeu</h1>
         			<p>par Jean-Eudes</p>
         			<object data="listeCommentairesRevues/revueCommentaires.txt"></object>
         			<div class="thumbs_up_down_revue">
         				<button type=submit><img src="photos/thumbs_up.png" class="thumbs"></button>
         				<p>0</p>
         				<button type=submit><img src="photos/thumbs_down.png" class="thumbs"></button>
         			</div>
         		</div>
         		
         		<div class="commentaire">
         			<h1> Je m'attendais à mieux...</h1>
         			<p>par Catalina</p>
         			<object data="listeCommentairesRevues/commentaire2.txt"></object>
         			<div class="thumbs_up_down_revue">
         				<button type=submit name="plus" value="Plus"><img src="photos/thumbs_up.png" class="thumbs"></button>
         				<p>0</p>
         				<button type=submit name="moins" value="Moins"><img src="photos/thumbs_down.png" class="thumbs"></button>
         			</div>
         		</div>
         		
         	</div>
         </section>
         
         <section>
         	<div class="nouveau_commentaire">
         		<textarea class="titre_nouveau_commentaire" type="text" placeholder="Titre de votre revue" name="titre_nouveau_commentaire"></textarea>
				<textarea class="redaction_nouveau_commentaire" type="text" placeholder="Commentaire du jeu...." name="redaction_nouveau_commentaire"></textarea>
				<button class="sumbit_button" type="submit" value="1" name="sumbit_button">Envoyer</button>
         	</div>
         </section>
         
    </body>
</html>
