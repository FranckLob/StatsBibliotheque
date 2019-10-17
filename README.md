BRIEF #2
--------

L'idée de ce brief est de réaliser un programme java en mode console permettant d'analyser des fichiers textes représentant des livres.

Besoin
------
Le programme accepte un nombre quelconque d'arguments qui sont des noms de fichiers. 
Ensuite, il doit présenter le menu suivant :
1. Lister les fichiers 
2. Ajouter un fichier 
3. Supprimer un fichier 
4. Afficher des informations sur un livre 
5. Quitter le programme.

Le choix 4 : affiche la liste des fichiers, propose de choisir d'un de ces fichiers, propose le sous-menu suivant : 1. Afficher le nombre de lignes du fichier, 2. Afficher le nombre de mots différents du fichier

Pendant toute l'exécution du programme, celui-ci maintient une liste des noms de fichiers, initialisée par les arguments du programme, qu'il est possible de consulter et modifier avec les trois premières options.

La version livrée se concentre sur les statistiques d'un livre en particulier.

Informations techniques
-----------------------
Dans ce programme java, on utilise notamment :
* une arraylist pour gérer la liste des fichiers
* des hashmaps pour gérer les statistiques d'un fichier

Les erreurs gérées sont :
* choix utilisateur non numérique ou numérique mais hors valeurs proposées
* liste vide ou non
* nom de fichier existant ou non
* fichier existant ou non

Les fichiers utilisés sont des .txt et ils sont pré-traités.
Le pré-traitement génére un fichier texte ne contenant que les mots (un par ligne) d'un fichier texte origine.
