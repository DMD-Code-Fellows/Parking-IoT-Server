# Parking-IoT
Our team name: DMD-Code-Fellows

Javadoc: https://dmd-code-fellows.github.io/Parking-IoT-Server/


## Problem Domain
Create an Internet-of-Things (IoT) application, that automates parking space availability in a parking lot, so that drivers can
quickly locate the nearest available space, in order to save time and fuel, and that also helps parking lot owners and attendants, 
monitor and manage their lots.

## Background
Inspired back the movement started in South Korea of using balloons to indicate unoccupied stalls (See article: https://popupcity.net/parking-balloons-help-drivers-save-gas/)

Nothing is more frustrating when time is spent grid-locked looking for an open parking stall at a busy mall's parking lot during the holiday seasons. Based off a month-long study conducted in South Korea, a major oil company S-Oil estimated an average Seoul driver spends 9.3 miles per car a month looking for parking. With a study using balloons those commuters were able to reduce their consumption by more than 65%!

Instead of using a balloons which is naturally imperfect as it requires constant refiling and use of a non-renewable gas. We will be implementing the same concenpt with a Raspberry Pi device that would require less maintenance while providing each user a real-time update of a mapped out parking lot to show where they should head to to find an empty stall.

https://github.com/DMD-Code-Fellows/Parking-IOT

## Features

It's a hardware/software product that will allow users to discover available parking spaces in a parking lot, thereby saving time, and fuel. Sensors in each parking space automatically mark spaces as available, or unavailable, as drivers take, or leave them.

The hardware part of this product will utilize Raspberry Pi micro computers, programmed to detect a sensor being triggered, and respond by contacting our new API.

The software part of the product consists of our new API, an underlying database to store current parking lot information, and a parking lot attendant monitor.

The API will allow drivers to get information about available parking spaces, and respond to Raspberry Pi sensor state changes, in order to update the database.

The attendants monitor will display an up to date status of the parking lot's spaces, together with parking space transactions.


## Setting Up The Environment

### Technology

#### Software

- Java
- Spring Boot
- Spring Statemachine: https://projects.spring.io/spring-statemachine/
- PostGre SQL

#### Hardware
- Raspberry Pi

### Getting started with local development
Spring boot apps require a database in order to run. If you are a developer, and want to work on this application, you'll need to
setup a local database in order to run.
See also: application.properties.


###### Current Phase:
In Development

###### For Contribution Only Purposes:
- Only applicable to current members of the organization, git clone the project repository into a local directory.
- All work must be done on a unique branch that indicates the contributor and the feature.
- All merges from local branches can only be into the test branch. Approval from organization member is required prior to merging to master for publication 


### Product Idea White Board Write-Up:

[Mockup White Board Images](docs)
