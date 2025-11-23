# Restaurant Ordering & Billing System

This project is a modular and extensible restaurant ordering and billing system designed to demonstrate the application of SOLID principles and various object-oriented design patterns. The system allows customers to browse menus, customize meals, place orders, process payments, and generate bills.

## How to Run the Project

1.  **Compile the Java files:**
    ```bash
    javac src/*.java
    ```
2.  **Run the main application:**
    ```bash
    java src.Main
    ```

The application will then guide you through the ordering process, from selecting a menu to customizing your meal and making a payment.

## Implemented Design Patterns

This project implements the following design patterns to ensure a clean, modular, and extensible architecture:

| Pattern                | Purpose                                                                          | Implemented In                                                              |
| ---------------------- | -------------------------------------------------------------------------------- | --------------------------------------------------------------------------- |
| **Abstract Factory**   | Creates families of related or dependent objects without specifying their concrete classes. | `MenuFactory` and its concrete implementations (`VegetarianFactory`, etc.).       |
| **Decorator**          | Adds new features (add-ons) to objects dynamically without altering their structure. | `AddOn` abstract class and concrete decorators like `ExtraCheese` and `Sauce`.    |
| **Strategy**           | Defines a family of algorithms, encapsulates each one, and makes them interchangeable. | `PaymentStrategy` for payments and `DiscountStrategy` for discounts.            |
| **Observer**           | Notifies multiple objects (observers) about any events that happen to the object they are observing. | `Order` (Subject) notifies `Kitchen` and `Waiter` (Observers) when an order is placed. |
| **Facade**             | Provides a simplified, unified interface to a more complex subsystem.             | `RestaurantFacade` simplifies the interaction with the ordering system.         |
| **Template Method**    | Defines the skeleton of an algorithm in a method, deferring some steps to subclasses. | `OrderProcessor` and its subclasses (`DineInOrderProcessor`, etc.).             |
| **Builder**            | Separates the construction of a complex object from its representation.          | `Order.Builder` class for creating `Order` objects.                         |

---

### Example Scenarios

#### 1. Ordering a Customized Pizza with a Discount

1.  Run the application.
2.  Select the **Non-Vegetarian** menu.
3.  Choose an **Eastern Pizza**.
4.  Add **Extra Cheese** and **Sauce** as add-ons.
5.  Select the **10% off Pizza** discount.
6.  Choose **Dine-In** as the order type.
7.  Select **Credit Card** as the payment method.

The system will process the order, apply the discount, notify the kitchen and waiter, and generate a receipt.

#### 2. Ordering a Kids Meal for Takeaway

1.  Run the application.
2.  Select the **Kids** menu.
3.  Choose a **Kids Burger**.
4.  Select **No Discount**.
5.  Choose **Takeaway** as the order type.
6.  Select **Cash** as the payment method.

The system will process the takeaway order, package it, and generate a receipt.

## UML Diagrams

*   **Menu System UML:** [View on Lucidchart](https://lucid.app/lucidchart/39cbdda2-25a4-4ee2-919a-4cc08959a061/edit?viewport_loc=578%2C400%2C2679%2C1257%2CHWEp-vi-RSFO&invitationId=inv_73f2e44e-9f9f-41ba-a969-71b89c80702c) - Includes the Menu and MenuItem interfaces, BaseMenuItem, AddOn, concrete menu item classes, the three Menu types, and the MenuFactory with its concrete factories.
*   **Full Project UML:** [View on Mermaid Chart](https://www.mermaidchart.com/d/b98fda79-ab07-4676-9e26-58dfc3335d00) - Comprehensive diagram covering all implemented patterns and classes.



