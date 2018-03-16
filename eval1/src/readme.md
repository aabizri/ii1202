#TP Noté

#### Eytan Azria et Alexandre Bizri

## Exercice 1: Fonction Factorielle

### Question 1: Que fait cette fonction ?

La fonction présentée ici (3.1.1) calcule la factorielle de `n` en itérant de `2 à n` et en multipliant chaque valeur avec le résultat de étape précédente.

Mathématiquement, `n! = n*(n-1)*(n-2)* ... * 2`

### Question 2: Proposez une version récursive de ce code.

Voir Factorial

## Exercice 2: PGCD

Voir GCD



## Exercice 3: Soustraction en croix

Voir `CrossSubstraction`

## Exercice 4: Sélection récursive

### Question 1: Expliquez ce que fait le code récursif précédent lorsque la fonction wasSafe est appelée. 
wasSafe prend trois paramètres: la tableau des températures à comparer, la température maximale et appelle wasSafeR avec le curseur positionné au dernier élément du tableau

wasSafeR prend trois paramètres: la tableau des températures à comparer, la température maximale et la position du curseur dans ce tableau.

wasSafeR vérifie que la température dans le tableau à l'index indiqué par le curseur ne dépasse pas la valeur maximale.

Si la température dépasse, wasSafeR (et donc wasSafe) retourne True, sinon wasSafeR s'appelle avec le curseur décrémenté, et retourne cette valeur.

Une fois que le curseur est arrivé à 0, wasSafeR retourne False (si et seulement si elle n'aurait pas retourné True selon la logique précédente)

## Question 2: Proposez une fonction non-récursive faisant la même chose et testez la avec les mêmes paramètres

Voir `WasSafe`

## Exercice 5: Diagonale de Cantor

### Question 1: Écrivez une fonction récursive Cantor qui prend en paramètres 2 entiers et renvoie le numéro de Cantor correspondant

Voir `Cantor`

### Question 2: Proposez une version non récursive de cette fonction

Voir `Cantor`

## Exercice 6:

### Version naïve

#### Question 1

Voir `Fibonnaci`

#### Question 2

Voir `Fibonnaci` pour le code.

L'éxécution de la fonction est lente avec i grand, car la valeur de Fi-2 n'est pas sauvegardée lors du calcul,
ce qui fait qu'elle est recalculée en tant que Fi-1 à l'appel suivant.

#### Question 3

La complexité de la version naïve est exponentielle, c'est même `O(phi^(n+1))`, phi étant le nombre d'or


### Version avec mémoire

#### Question 1

Voir `Fibonnaci`

#### Question 2

Le code est bien plus efficace

#### Question 3

Dans Fibonnaci, bien que la récursivité soit simple à mettre en place naïvement, elle nécéssite plus de travail pour approcher l'éfficacité d'une approche itérative, et bien plus de mémoire.
