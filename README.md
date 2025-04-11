# ProjectTickets - Ticket Management System

The **ProjectTickets** project is a backend application for managing tickets for events. The application allows for creating events, adding tickets, managing users, and purchasing tickets. It is built using the **Spring Boot** framework and follows a RESTful API architecture.

## Features

- **Event Management**:
  - Create new events
  - Delete events
  - View list of events
  
- **Ticket Management**:
  - Add tickets to events
  - Generate QR codes for tickets
  - Purchase tickets by users
  - Delete tickets

- **User Management**:
  - Register users
  - Delete users
  - Users can only purchase tickets if registered

- **Authorization and Roles**:
  - Roles: `ADMIN` and `USER`
  - Only `ADMIN` users can manage events, tickets, and users
  - `USER` users can only purchase tickets

## Technologies

- **Java**: 17
- **Spring Boot**
- **Spring Security**: for authorization and authentication
- **JPA/Hibernate**: for database interaction
- **H2 Database**: used as the project database
- **QR Code Generator**: generates QR codes for tickets
- **Maven**: for dependency management

## Project Structure

- `controller`: Contains the REST API controllers that handle HTTP requests.
- `model`: Contains the data entities, such as `Event`, `Ticket`, and `User`.
- `repository`: Contains JPA repositories for interacting with the database.
- `service`: Contains the business logic of the application.
- `enums`: Contains enums such as `TicketType` and `TicketStatus`.

## Installation

To run the application locally, follow these steps:

1. **Clone the repository**

   Clone the repository to your local machine:

   ```bash
   git clone https://github.com/Pyonaaa/ProjectTickets.git
   cd ProjectTickets
2. **Build the project**
   ```bash
   mvn clean install

3. **Run the application**
 ```bash
   mvn spring-boot:run
```

## API Endpoints

### 1. **Events**

- **GET** `/event`  
  Get a list of all events.

- **POST** `/event/save`  
  Create a new event (accessible by ADMIN only).

- **DELETE** `/event/{eventId}`  
  Delete an event (accessible by ADMIN only).

### 2. **Tickets**

- **GET** `/ticket`  
  Get a list of all tickets.

- **POST** `/ticket/save`  
  Add tickets to an event (accessible by ADMIN only).

- **GET** `/ticket/{ticketId}/qr`  
  Get the QR code for a ticket.

- **DELETE** `/ticket/{ticketId}`  
  Delete a ticket (accessible by ADMIN only).

- **POST** `/ticket/buy`  
  Buy a ticket (accessible by USER only).

### 3. **Users**

- **GET** `/user`  
  Get a list of all users (accessible by ADMIN only).

- **POST** `/user/save`  
  Register a new user.

- **DELETE** `/user/{userId}`  
  Delete a user (accessible by ADMIN only).


