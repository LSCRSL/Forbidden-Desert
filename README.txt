Rapport de projet “Desert interdit” - POGL avril 2023

Membres: Lisa CERESOLA, Elisa CIOCARLAN (LDD2 IM2)


1- Parties du sujet traitées

Nous avons traité toutes les parties obligatoires de ce sujet, ainsi que la partie bonus qui concerne les tas de cartes
et le rôle des personnages à quelques exceptions près.


2- Choix d’Architecture

Nos choix d’architecture pour ce projet sont traduits par le diagramme des classes ci-joint. Nous nous sommes inspirées
de l’architecture MVC.

A)Le modèle

a)Plateau
Nous avons décidé de modéliser le plateau par un ensemble de 25 cases caractérisées par une position (x,y). La classe
"Plateau" nous sert de modèle, c'est dans cette classe que l'on répertorie les pièces récupérées, les joueurs présents
et le niveau de sable par exemple.

b)Case
Une case représente une tuile, et ne présente pas les mêmes informations à l’affichage selon le cas où elle a déjà été
explorée ou non. Pour mettre à jour l’affichage de l’interface graphique, nous avons relié la classe “Case” au
contrôleur “ControleCase”’.

c)Joueur et personnages
Nous avons décidé de créer une classe joueur et un type énuméré pour les rôles. Le joueur a un attribut Carte.Personnage
 qui nous permet de connaître son rôle. Grâce à des switch et des conditions sur cet attribut, nous avons pu implémenter
  les différentes actions selon le rôle.

d)Pièces et indices
Nous avons décidé de modéliser les pièces et les indices dans la classe "Case". Nous avons au début voulu implémenter
une classe fille "IndicePiece" à la classe mère "Case" or comme notre fonction souffler fonctionne en modifiant les
informations d'une "Case" et non pas en la faisant se déplacer, il a été plus simple pour nous de fusionner ces 2
classes pour ne pas avoir de soucis de type lors de l'implémentation.

e)Tas de Cartes
Le tas de cartes est modélisé dans la classe PaquetCartes qui a deux attributs. Ces attributs sont des LinkedList, une
représentant pioche, l’autre la défausse.

B)  Le controleur

Le contrôleur comporte notamment tous les JButton visibles directement lors de l’ouverture  du jeu, la classe
ControleCase qui nous permet de déclencher certaines actions lorsque le joueur clique sur une case du plateau. Il y a
également la classe Launcher qui permet de créer et relier le jeu et la vue.

C)  La vue

Le dossier Views comporte toutes les classes qui une à une affiche des informations spécifiques. La classe Views
regroupe toutes ces classes et nous permet de créer l’affichage du jeu.

D)  ForbiddenDesert

La classe ForbiddenDesert comporte le main de notre projet.


3- Problèmes dans le code

Nous n’avons pas de problèmes particuliers. Cependant, le rôle de la navigatrice n’a pas été implémenté et celui de
la météorologue simplifié.


4- Morceaux de codes empruntés ailleurs

Nous n’avons pas fait appel à une aide extérieure au cours de ce projet. Nous avons uniquement repris le dossier IG
utilisé en TP notamment pour utiliser IG.Zone Cliquable.


5- Répartition des tâches

De manière générale, nous avons manipulé chacune l’ensemble des notions requises pour ce projet. Lisa s’est occupée des
parties Vue, Controller et a implémenté les bonus. Elisa s’est quant à elle focalisée sur le modèle ainsi que les tests
et a pris soin de déchiffrer les règles du jeu.

