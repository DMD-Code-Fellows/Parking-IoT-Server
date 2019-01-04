<p align="center">
   <a href="https://http://parking.my-dog-spot.com"> <img width="500" height="auto" src="libs/img/logo-banner.png" alt="DMD Banner">
   </a>
</p>


# Parking-IoT

#### A Code Fellows 401 Java Team Project.

![car balloon](libs\img\car-balloon-1.jpg)

Photo Credit: [Freakonmics](http://freakonomics.com/2013/08/16/how-to-save-time-hunting-for-a-parking-spot-south-korea-edition/)


An Internet-of-Things (IoT) application, that automates parking space availability in a parking lot, so that drivers can quickly locate the nearest available space, in order to save time and fuel, and that also helps parking lot owners and attendants, monitor and manage their lots.

* [Background](#background)
* [Approach](#our-approach)
* [Architecture](#architecture-design)
* [Technology](#technology)
* [Software](#software)
* [Hardware](#hardware)
* [Installation](#local-installation)
* [Organiztion](#organization)
* [License](#license)




#### Documentation:
[Javadoc](https://dmd-code-fellows.github.io/Parking-IoT-Server/)




## Background
Inspired by the movement started in South Korea of using balloons to indicate unoccupied stalls (See article: https://popupcity.net/parking-balloons-help-drivers-save-gas/)

![car balloon](libs\img\car-balloon-3.jpg)

Photo Credit: [Spring Wise](https://www.springwise.com/south-korea-vacant-parking-lots-automatically-alert-drivers-balloons-string/)

Nothing is more frustrating when time is spent grid-locked looking for an open parking stall at a busy mall's parking lot during the holiday seasons. Based off a month-long study conducted in South Korea, a major oil company S-Oil estimated an average Seoul driver spends 9.3 miles per car a month looking for parking. With a study using balloons those commuters were able to reduce their consumption by more than 65%!

## Our Approach

It's a hardware/software based solution that will allow users to discover nearby available parking spaces in a parking lot, thereby saving time, and fuel. Sensors in each parking space automatically mark spaces as available, or unavailable, as drivers occupy or vacate them.

The hardware part of this product will utilize Raspberry Pi micro computers, programmed to detect a sensor being triggered when drivers occupy and vacate parking spaces, and respond by contacting the server API about the event.

The software part of this solution is a cloud based application that maintains parking lot information in real time, based on the events occuring in the parking lot, detected by the hardware components.

Additionally, parking lot operations can be managed in real time, by attendants, and owners, using an Atendant application, to view current status, and monitor transactions.

## Architecture and Design
Whiteboard High Level:
![alt text](https://github.com/DMD-Code-Fellows/Parking-IoT-Server/blob/master/docs/ParkingSpaceStateModel.jpg "State Transition Diagram")

The only change to our original architecture write up, is that we elected to go with a browser based Attendant application, instead
of a Java Swing application. It uses Java and Spring WebSockets.

Domain Model:
![alt text](https://github.com/DMD-Code-Fellows/Parking-IoT-Server/blob/master/docs/parking_iot_main.jpg "Domain Model")

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
- Wiringpi
- Raspian OS
- Pi4J

### Hardware
- Raspberry Pi
See the client repository for more information: [Physical-IoT](https://dmd-code-fellows.github.io/Parking-IoT-Physical/)

## Local Installation
Spring boot apps that use JPA, like this one, require a database in order to run. If you are a developer, and want to work on this application, you'll need to
setup a local database in order to run.

#### Installation

###### Clone
* got the directory in which you want to install Physical application
* Clone this repository for code to run

###### Create Local Database

To run locally on localhost:8080

* Create and connect `parking_app` database in PostgreSQL
* Configure your editor environment variable
```
--DATABASE_URL="postgresql://localhost/parking_app"

--SPRING_DATASOURCE_USERNAME="yourusername"

--SPRING_DATASOURCE_PASSWORD="yourpassword"
```

###### Physical Device Setup

Navigate to [Physical-IoT](https://dmd-code-fellows.github.io/Parking-IoT-Physical/) to follow instructions on how to setup the device.

#### Current Phase:
- 1 - Official concept Release

#### For Contribution Only Purposes:
- Only applicable to current members of the organization, git clone the project repository into a local directory.
- All work must be done on a unique branch that indicates the contributor and the feature.
- All merges from local branches can only be into the test branch. Approval from organization member is required prior to merging to master for publication 

## Organization
- [Parking-IoT-Server](https://dmd-code-fellows.github.io/Parking-IoT-Server/)
- [Parking-IoT-Common](https://dmd-code-fellows.github.io/Parking-IoT-Common/)
- Parking-IoT-Attendant: TODO 
- [Parking-IoT-Physical](https://dmd-code-fellows.github.io/Parking-IoT-Physical/)


## License

Parking-IoT-Server is licensed under the APache License, Version 2.0 [Apache License](http://www.apache.org/licenses/LICENSE-2.0)