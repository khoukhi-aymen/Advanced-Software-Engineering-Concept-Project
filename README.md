# Pratique Java pour le Développement d'Applications Distribuées

## Introduction

La pratique est cruciale pour acquérir des compétences en génie logiciel liées à la spécification des exigences, à la conception, aux tests, etc. Copier est considéré comme une infraction sérieuse. Tant la personne copiant que celle fournissant le matériel copié seront pénalisées.

## Outils

- Bibliothèque du système JRE [Java SE].
- Eclipse IDE pour les développeurs Java Entreprise et Web (J2EE) - version : 2023
- Serveur d'exécution WildFly 27.0.
- Réseau TCP/IP.

## Objectif

L'objectif de ce travail est de mettre en œuvre des applications développées et exécutées sur un réseau en utilisant la technologie EJB3, les sockets TCP, UDP et RMI.

## Architecture

- Cinq serveurs (Servi). Chaque serveur doit gérer un groupe de services (S1, S2... Sn).
- Six clients (Clienti). Chaque client a une chaîne de références représentant des demandes de service.
- Un serveur central (Central Server) avec une base de données hébergeant des services.
- Un serveur intermédiaire (Inter) qui redirige les demandes des clients vers les serveurs correspondants (Servi).

## Processus

Les services sont stockés dans une base de données, chaque serveur devant s'enregistrer auprès du serveur central avant de communiquer. 
Chaque client envoie ses demandes à un serveur intermédiaire qui les redirige vers le serveur associé. 
Chaque serveur appelle le serveur central pour effectuer la recherche et la récupération des services dans la base de données. 
Les informations sur le service demandé doivent être renvoyées au client concerné.


## Licence

Ce projet est sous licence MIT. Voir le fichier [LICENSE.md](LICENSE.md) pour plus de détails.

## Auteurs

- Aymene Khoukhi
