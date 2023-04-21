Rapport de projet “Desert interdit” - POGL avril 2023

Membres: Lisa CERESOLA, Elisa CIOCARLAN (LDD2 IM2)


1- Parties du sujets traitées

Nous avons traité toutes les parties obligatoires de ce sujet, ainsi que la partie bonus qui concerne les rôles spéciaux.


2- Choix d’Architecture

Nos choix d’architecture pour ce projet sont traduits par le diagramme des classes ci-joint.

Plateau
Nous avons décidé de modéliser le plateau par un ensemble de 25 cases caractérisées par une position (x,y).

Case
Une case représente une tuile, et ne présente pas les mêmes informations à l’affichage selon le cas où elle a déjà été
explorée ou non. Pour mettre à jour l’affichage de l’interface graphique, nous avons relié la classe “Case” au contrôleur “ControleCase”’.

Joueur et personnages
Nous avons décidé de modéliser les joueurs avec un rôle par des sous-classes qui héritent d’une classe mère “Joueur”
. Ce choix d’architecture est très utile puisqu’il nous permet d’implémenter toutes les méthodes pour chacun des
personnages en une fois, mais aussi de redéfinir certaines méthodes si nécessaire en fonction des caractéristiques des rôles.

Pièces et indices
Pour modéliser les pièces et les indices pour les trouver sur le plateau, nous avons créé une classe fille “IndicePiece”
à la classe “Case”. Ce choix d’architecture nous permet d’utiliser le “ControleCase” pour afficher l’indice sur une tuile
lorsqu’elle est explorée. Les pièces sont par ailleurs modélisées par un type enum dans la classe “IndicePiece”.


3- Problèmes dans le code



4- Morceaux de codes empruntés ailleurs

Nous n’avons pas fait appel à une aide extérieure au cours de ce projet.


5- Répartition des tâches
