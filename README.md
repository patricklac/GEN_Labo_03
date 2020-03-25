# GEN_Labo_03
GEN Labo 03


## partie 1 - intégration continue

procédure effectuée:

1. utilisation de `https://travis-ci.com/` (signup with github)
2. installation de la "github app" de travis-ci pour le repository du laboratoire
3. ajout du `.travis.yml` 

note concernant le fichier `.travys.yml` :

```yml
cache:
  directories:
  - $HOME/.m2
```
sert a accelerer le build