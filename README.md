# GEN_Labo_03
GEN Labo 03


## partie 1 - intégration continue

procédure effectuée:

1. utilisation de `https://travis-ci.com/` (signup with github)
2. installation de la "github app" de travis-ci pour le repository du laboratoire
3. ajout du `.travis.yml` 

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