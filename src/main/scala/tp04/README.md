# TP 04 – Développement d'une Application de Jeu de Logique

## Objectif  
Cette séance a pour but le développement d'une application permettant de produire la meilleure solution en réponse à un petit jeu de logique.  

Pour découvrir le jeu, passez les trois premiers niveaux via le lien suivant :  
[http://www.jeuxclic.com/jeux.php?id=15917](http://www.jeuxclic.com/jeux.php?id=15917)  

**Remarque** : Inutile de lire les règles du jeu. Il est très intuitif et les quatre touches fléchées de votre clavier suffisent.  
**Attention** : Le jeu est addictif ! N'oubliez pas de revenir au TP.  

## Contraintes  
En avançant dans le jeu, de nombreux gadgets supplémentaires apparaissent. Nous ne nous y intéresserons pas et nous limiterons au mécanisme de base :  

- Un plateau de jeu  
- Une position de départ  
- Une position d'arrivée  

Pour trouver la solution, c'est-à-dire une suite de mouvements (**haut, bas, droite, gauche**), nous construirons (de manière implicite) l’arbre de toutes les suites de mouvements possibles.  

Cependant, un tel arbre peut être très grand selon la taille du terrain (voire infini). Il faut donc tester ses nœuds en réalisant un **parcours en largeur** de l’arbre. Cela permet de tester les suites de mouvements de taille **1**, puis **2**, puis **3**, ... jusqu’à atteindre la position d’arrivée.  

## Instructions  

1. Dans le répertoire `src/test/scala`, créé lors de la première séance, décompresser `tp04tests.zip`.  
2. Dans le répertoire `src/main/scala`, créé lors de la première séance, décompresser `tp04sources.zip`.  
3. Compléter les deux fichiers sources en suivant les indications données en commentaires.  

### Exploration des Tests  
Profitez aussi de l’occasion pour consulter les tests, où un élégant mécanisme de **"parsing"** permet de générer des plateaux de jeu à partir d’une simple description textuelle.  

Vous pouvez :  
- Décrire votre propre plateau de jeu.  
- Lancer la recherche de solution une fois le codage terminé.  
