# j2eSubmodules - Entities

# Vue d'ensemble
 Cet composant fait partie du projet `projet-isa-devops-20-team-d-20 ` nommé `Drone Delivery`. Il représente toute la partie **modèle de donnée** du système et contient donc ainsi tous les `objets métiers` que le système utilise.
 Il embarque avec lui : 
 * _Java Persistence API_ (JPA, OpenJPA) pour supporter la peristence des objets
 * _HyperSQL Database_ (HSQLDB) pour stocker les données
 * _Arquillian_, un frameworkde test pour les sytèmes J2e
 * _Maven_ embarquer toute ces technologie ensemble _"plus facilement"_.

## Informations sur le dépôt
  * La branche `master` ( branche par défaut ) repésente la dernière version de `Entities`.
  
 
  ## Code information
*  Le code utilise `JPA Persistence` pour appliquer la persistence à la plupart de des classes. Il utlise deux bases de données `HyperSQL Database (HSQLDB)`. Une pour les **`tests`** et une pour la **`production`**.
Il suit le concept de `DataSource` qui permet de faire la liaison entre les `objets métiers`
du sytème et de la base de données.

  ## Perspectives
  - [ ] Lancer Sonar dans le projet 
  - [ ] Approfondir la peristence avec **CASCADE** ou **LAZY**  
  
  
