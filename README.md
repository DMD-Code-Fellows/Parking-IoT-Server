# Parking-IoT

A Code Fellows 401 Java Team Project.

An Internet-of-Things (IoT) application, that automates parking space availability in a parking lot, so that drivers can
quickly locate the nearest available space, in order to save time and fuel, and that also helps parking lot owners and attendants, 
monitor and manage their lots.

## Background
Inspired by the movement started in South Korea of using balloons to indicate unoccupied stalls (See article: https://popupcity.net/parking-balloons-help-drivers-save-gas/)

Nothing is more frustrating when time is spent grid-locked looking for an open parking stall at a busy mall's parking lot during the holiday seasons. Based off a month-long study conducted in South Korea, a major oil company S-Oil estimated an average Seoul driver spends 9.3 miles per car a month looking for parking. With a study using balloons those commuters were able to reduce their consumption by more than 65%!

## Our Approach

It's a hardware/software based solution that will allow users to discover nearby available parking spaces in a parking lot, thereby saving time, and fuel. Sensors in each parking space automatically mark spaces as available, or unavailable, as drivers occupy or vacate them.

The hardware part of this product will utilize Raspberry Pi micro computers, programmed to detect a sensor being triggered when drivers occupy and vacate parking spaces, and respond by contacting the server API about the event.

The software part of this solution is a cloud based application that maintains parking lot information in real time, based on the events occuring in the parking lot, detected by the hardware components.

Additionally, parking lot operations can be managed in real time, by attendants, and owners, using an Atendant application, to view current status, and monitor transactions.

## Architecture and Design
Whiteboard High Level:
![alt text](https://github.com/DMD-Code-Fellows/Parking-IoT-Server/blob/master/docs/Project%20assignments%205-6_wireframe.jpg "Architecture Big Picture")

The only change to our original architecture write up, is that we elected to go with a browser based Attendant application, instead
of a Java Swing application. It uses Java and Spring WebSockets.

Design Models:

Parking Space State Model:
![alt text](https://github.com/DMD-Code-Fellows/Parking-IoT-Server/blob/master/docs/ParkingSpaceStateModel.jpg "State Transition Diagram")

Database Model:
![alt text](https://github.com/DMD-Code-Fellows/Parking-IoT-Server/blob/master/docs/DatabaseERD.jpg "DB Entity Relationship Diagram")

## Technology

### Software
- Java
- Spring Boot
- Spring JPA
- Spring Statemachine: https://projects.spring.io/spring-statemachine/
- HTML/CSS/JavaScript
- Bootstrap
- Thymeleaf
- WebSockets
- PostGre SQL
- Heroku
- Gradle

### Hardware
- Raspberry Pi
See the client repository for more information: https://github.com/DMD-Code-Fellows/Parking-IoT-Physical

### Getting started with local development
Spring boot apps that use JPA, like this one, require a database in order to run. If you are a developer, and want to work on this application, you'll need to
setup a local database in order to run.

#### Current Phase:
In Development

#### For Contribution Only Purposes:
- Only applicable to current members of the organization, git clone the project repository into a local directory.
- All work must be done on a unique branch that indicates the contributor and the feature.
- All merges from local branches can only be into the test branch. Approval from organization member is required prior to merging to master for publication 

## Documentation:
- Parking-IoT-Server: https://dmd-code-fellows.github.io/Parking-IoT-Server/
- Parking-IoT-Common: https://dmd-code-fellows.github.io/Parking-IoT-Common/
- Parking-IoT-Attendant: TODO 
- Parking-IoT-Physical: TODO
