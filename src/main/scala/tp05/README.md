# Consignes TP 05

Lors de cette séance, nous développons notre premier interpréteur. Il porte sur le langage des expressions conditionnelles et arithmétiques présenté en cours. Vous aurez besoin des transparents 19, 20, 27 et 28 du cours.

## Étapes à suivre

1. **Installation des fichiers**  
   - Dans le répertoire `src/test/scala`, créé lors de la première séance, décompresser `tp05tests.zip`.
   - Dans le répertoire `src/main/scala`, créé lors de la première séance, décompresser `tp05sources.zip`.
   - Compléter les cinq fichiers sources en suivant les indications ci-après et les commentaires fournis dans les fichiers.

2. **Point d'entrée de l'application**  
   - La méthode `main` se trouve dans le fichier `Interpretor`.
   - Cette méthode crée un interpréteur et lance sa méthode `interpret` sur un flux en lecture.
   - La méthode `interpret` est à développer :  
     - Elle réalise une analyse du flux de texte pour repérer les termes qu'il contient.
     - Elle évalue ces termes.  
   - Avant d'implémenter `interpret`, vous devriez d'abord vous intéresser aux autres fichiers.

3. **Les fichiers à compléter**  
   - **`Types`**  
     Définit les différents termes de notre langage. Vous devez le compléter à l’aide des transparents 140 et 148 du cours.  
   - **`Parser`**  
     Définit l’analyseur syntaxique. Scala offre une approche élégante pour construire un analyseur descendant.  
     - Introduction : [Scala Parser Combinators - Getting Started](https://github.com/scala/scala-parser-combinators/blob/1.1.x/docs/Getting_Started.md)
     - Pour une description plus approfondie (nécessaire pour les prochains TPs), consultez le chapitre **"Combinator Parsing"** dans le livre d'Odersky :  
       - [Programming in Scala - Chapitre 31](https://pllab.github.io/cs162-spring17/scala/Programming-in-Scala.pdf)  
     - Vous devez fournir les règles syntaxiques manquantes.  
   - **`Evaluator`**  
     Contient la définition de la méthode `evaluate`, qui permet de réaliser un pas d’évaluation à partir d’un terme.  
     - Complétez cette méthode en suivant les règles définies sur les transparents 20 et 28.  
   - **`Util`**  
     Implémentez deux petites fonctions outils nécessaires à l’évaluation.

4. **Tests et validation**  
   - En plus des fichiers de tests unitaires, un fichier d’exemples et un autre fichier indiquant les résultats attendus vous sont fournis pour tester votre interpréteur.
