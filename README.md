# GEN_Labo_03
GEN Labo 03

## intégration continue

### partie 1 - intégration continue mise en place de maven

procédure effectuée:

1. utilisation de `https://travis-ci.com/` (signup with github)
2. installation de la "github app" de travis-ci pour le repository du laboratoire
3. ajout du `.travis.yml` 
4. ajout d'un projet vide maven en ayant adapté le pom.xml pour avoir les dependances de test
5. ajout d'une classe d'example pour verifier le bon fonctionnement du build qui se lance apres avoir push
6. nous pouvons egalement voir que les notifications de mail arrivent par e-mail


### note concernant le fichier `.travys.yml` :

on doit selectionner le language a compiler avec : `language: java`
```yml
cache:
  directories:
  - $HOME/.m2
```
sert à accelerer le build

`script: "mvn ..."` pour lancer nos scripts maven
dans notre cas: `mvn clean test`

### partie 2 - protection avec les status de Travis CI

1. etablissement de la regle permettant de verifier status travis avant de merge dans l'onglet `Braches` des parametre du repo

## Labo 3 - Exécution en parallèle - Threads

### Introduction – Intégration continue avec Travis 

## banque & thread

faire une classe transfert 
faire une classe de test pour transfert

état inconsistent recréer dans `dev1`

dans `dev2` on  résouds le problème au moyen de bloc `synchronized`
