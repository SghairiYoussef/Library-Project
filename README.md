# Library Management System

This Java project is a Library Management System that enables users to manage books, users, bookings, suppliers, and a co-working space within a library.

## Overview

The project consists of several Java classes:

- `Library`: Controls the library system including books, users, suppliers, and orders. (sort of act like a local data base, tables similated to ArrayLists)
- `Book`: Represents a book with attributes such as ISBN, name, category, author, and booking details.
- `Booking`: Manages the booking of a book by a user with details like lending date, expected return date, and actual return date. 
- `BookOrder`: Represents an order of a book from a supplier.
- `User`: Manages basic user functionalities within the library.
- `PremiumUser`: Represents a premium user in the library system. Extends the User class.
- `Supplier`: Represents a book supplier for the library.
- `CoWorkingSpace`: Manages access to the library's co-working space for premium users.
- `MainClass`: The main class to run the library management system, where a menu (console application) is implemented.

### Further Details for the Management System
- In this project, an Admin class is considered useless, for the following reason:
 The way I understood the assignment is that the admin himself is the application user in this scenario, where the user is rather a client, in other terms, the person running the program, is the admin, I was counting on adding a login-logout authentification system in which an admin class needs to be implemented but due to the time limit, it was unfortunately impossible or rather hard to do so.

- The Library uses a LoyaltyPoints System in order to keep track of bookings and return Dates to sanction users accordingly. As a matter of fact, each user, depending on his nature(Premium/free) and his tier _concerning Premium Users_ has a limited amount of time to return a certain book, if that time is exceeded, sanctions take place, reducing loyaltyPoints, in which case, if a user reaches a negative number of LoyaltyPoints he gets omitted from the library and therefore has to repay a subscription.

### Usage

To run the Library Management System, execute the `MainClass.java` file. This initiates the system and displays a menu-based interface for interacting with the library.

### Features

The system provides the following features:

- Adding and managing users and books in the library.
- Booking and returning books by users.
- Managing suppliers and book orders.
- Access control to the co-working space for premium users.

#### Exception Handeling

The System only handles exceptions in the mainClass, I struggled to add in exceptions in this project because I had very little info on how to manage them while working on this project (before studying them in class), but they were better dealt with in the final project.

THANK YOU.
