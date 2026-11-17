AquaRoute: Priority-Based Water Supply Scheduling System

Project Overview

AquaRoute is a Java-based console application designed to manage and schedule water supply requests in water-scarce areas.

The system allocates water tankers based on request priority, ensuring essential services such as hospitals receive water before schools and residential areas.

Problem Statement

Water scarcity creates difficulties in distributing available water resources fairly and efficiently. AquaRoute aims to improve water distribution through priority-based scheduling and tanker capacity management.

Features

Register water requests with area, required litres, and priority.

Register water tankers with their capacities.

Schedule water distribution based on priority.

Carry forward unserved water requests.

Generate area-wise water supply reports.

Technologies Used

Java

Object-Oriented Programming

ArrayList and Collections

Priority-Based Scheduling

VS Code

Git and GitHub

Priority Levels

Hospital – Highest Priority

School – Medium Priority

Residential – Normal Priority

Project Structure

Aqua-Route/
├── Main.java
├── WaterSource.java
├── Route.java
└── RouteManager.java

How to Run

Compile the Java files:

javac Main.java WaterSource.java Route.java RouteManager.java

Run the application:

java Main

Application Modules

Water Request Registration

Water Tanker Registration

View Water Requests

View Available Tankers

Water Supply Scheduling

Area-wise Report Generation

Future Enhancements

Geographic route optimization.

Database integration.

Daily scheduling and persistent carry-forward records.

Average waiting time calculation.

Project Information

Project Name: AquaRoute
Problem Code: CP-072
Domain: Public Services, Utilities and Smart City
Language: Java
