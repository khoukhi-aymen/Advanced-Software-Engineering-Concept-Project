# Java Practice for Distributed Application Development
# Introduction

Practice is crucial for acquiring software engineering skills related to requirements specification, design, testing, etc. Copying is considered a serious offense. Both the person copying and the one providing the copied material will be penalized.
# Tools

    1. Java SE Runtime Environment (JRE) Library.
    2. Eclipse IDE for Java Enterprise and Web Developers (J2EE) - version: 2023
    3. WildFly 27.0 Execution Server.
    4. TCP/IP Network.

# Objective

The objective of this work is to implement applications developed and executed over a network using EJB3 technology, TCP, UDP, and RMI sockets.
# Architecture

    1. Five servers (Servi). Each server must manage a group of services (S1, S2... Sn).
    2. Six clients (Clienti). Each client has a reference chain representing service requests.
    3. A central server (Central Server) with a database hosting services.
    4. An intermediary server (Inter) that redirects client requests to the corresponding servers (Servi).

# Process

Services are stored in a database, with each server required to register with the central server before communicating. Each client sends its requests to an intermediary server, which redirects them to the associated server. Each server calls the central server to perform the search and retrieval of services in the database. Information about the requested service must be returned to the respective client.
# License

This project is licensed under the MIT License. See the LICENSE.md file for more details.
# Authors

    -Aymen Khoukhi
