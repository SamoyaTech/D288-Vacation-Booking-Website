# Vacation Booking App - Spring Boot Backend

## Overview

A travel agency's Angular vacation-booking front end was left running on a legacy, undocumented backend with no remaining support. This project rebuilds that backend from scratch on the Spring framework as a minimum viable product, without modifying the provided front end.

The finished application allows a user browse available vacation packages, add a new customer directly from the front end (name, address, postal code, phone, country/division), select a party size and a set of add-on excursions for a trip, and complete checkout with the total price calculated dynamically based on party size and selected excursions. On checkout, the backend persists the customer, cart, cart items, and excursion selections to MySQL, and returns an order confirmation with a unique tracking number.

## Features

- Entity classes and an enum modeled to match a provided UML diagram, mapped to a MySQL database via Spring Data JPA
- Repository interfaces for each entity extending `JpaRepository`, with cross-origin support for the Angular front end
- Service layer including a purchase data class (customer cart and cart items), a purchase response class returning a unique order tracking number, and a checkout service interface/implementation handling order logic
- Dynamic price calculation based on party size and selected excursions, reflected live in the cart summary before checkout
- Input validation enforcing the constraints expected by the Angular front end
- A REST checkout controller exposing a POST endpoint for placing orders, verified error-free via browser network inspection
- Five sample customers seeded programmatically at startup, without overwriting existing data on repeated runs, plus support for adding new customers directly from the front end
- Order data (customer, cart, cart items, excursions) persisted to MySQL via MySQL Workbench after checkout

## Tech Stack

- Java, Spring Boot, Spring Data JPA, Spring Data REST
- MySQL
- Lombok
- Angular (provided front end, not modified)


## Order Flow
An order was placed for a vacation package with two excursions using the unmodified Angular front end. The screenshots below show the completed order generating no network errors, along with the resulting database records in MySQL Workbench confirming the data was saved successfully.

![Vacations](images/vacations.png)

---

![Select Excursion](images/select-excursion.png)

---

![Excursions](images/excursions.png)

---

![Cart Summary](images/cart-summary.PNG)


---

**Verified clean network activity (no errors) on order submission:**


![Network Tab](images/network-tab-no-errors.PNG)



**Database records confirming the order was persisted (MySQL Workbench):**

![Customers Table](images/db-customers.PNG)

---

![Carts Table](images/db-carts.PNG)

---

![Cart Items Table](images/db-cart-items.PNG)

---

![Excursion Cart Items Table](images/db-excursion-cart-item.PNG)

