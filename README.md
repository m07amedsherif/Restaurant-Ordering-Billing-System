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

### Test Cases

Here are manual test cases to verify the system's functionality.

#### Test Case 1: Vegetarian Pizza with Discount (Dine-In)
**Objective:** Verify ordering a pizza, adding toppings, applying a category discount, and paying with a credit card.

| Step | Input | Action | Expected Output |
| :--- | :--- | :--- | :--- |
| 1 | `1` | Select **Vegetarian** Menu | Displays Vegetarian Menu items. |
| 2 | `2` | Select **Italian Pizza** ($9.50) | Shows "Italian Pizza" selected. |
| 3 | `1` | Add **Extra Cheese** (+$0.75) | Item updates to "Italian Pizza + Extra Cheese". |
| 4 | `6` | Finish adding add-ons | Proceed to discount selection. |
| 5 | `2` | Select **10% off Pizza** | Discount strategy selected. |
| 6 | `1` | Select **Dine-In** | Order type set to Dine-In. |
| 7 | `2` | Select **Credit Card** | Prompt for card number. |
| 8 | `1234` | Enter Card Number | Payment processed. |

**Expected Receipt Output:**
*   **Item:** Italian Pizza + Extra Cheese
*   **Subtotal:** $10.25 ($9.50 + $0.75)
*   **Discount:** -$0.95 (10% of $9.50 base pizza price) *Note: Discount logic depends on implementation details, usually applies to base item price if category matches.*
*   **Tax:** +$1.44 (14% of subtotal)
*   **Total:** Final calculation based on subtotal - discount + tax.
*   **Notifications:** Console shows Kitchen receiving order and Waiter assigned.

#### Test Case 2: Kids Meal Takeaway (No Discount)
**Objective:** Verify ordering a kids meal, no add-ons, no discount, takeaway packaging, and cash payment.

| Step | Input | Action | Expected Output |
| :--- | :--- | :--- | :--- |
| 1 | `3` | Select **Kids** Menu | Displays Kids Menu items. |
| 2 | `1` | Select **Kids Nuggets** ($4.00) | Shows "Kids Nuggets" selected. |
| 3 | `6` | No add-ons | Proceed to discount selection. |
| 4 | `1` | Select **No Discount** | No discount applied. |
| 5 | `3` | Select **Takeaway** | Order type set to Takeaway. |
| 6 | `1` | Select **Cash** | Payment processed. |

**Expected Receipt Output:**
*   **Item:** Kids Nuggets
*   **Subtotal:** $4.00
*   **Discount:** $0.00
*   **Tax:** +$0.56 (14% of $4.00)
*   **Total:** $4.56
*   **Special Handling:** Console shows "Packaging order... for takeaway".

---

### Discount Scenarios

The system uses the **Strategy Pattern** to apply discounts. Currently implemented strategies include:

1.  **No Discount:**
    *   **Logic:** Returns a discount amount of $0.00.
    *   **Use Case:** Standard orders with no promotions.

2.  **Item Category Discount (e.g., 10% off Pizza):**
    *   **Logic:** Iterates through ordered items. If an item's category matches "Pizza", 10% of that item's price is added to the total discount.
    *   **Example:**
        *   Order: Italian Pizza ($9.50) + Burger ($7.00).
        *   Discount Strategy: 10% off Pizza.
        *   Calculation: 10% of $9.50 = $0.95. Burger is ignored.
        *   Total Discount: $0.95.

*Note: The system is designed to easily add new strategies (e.g., "Flat $5 off", "Free Drink with Burger") by implementing the `DiscountStrategy` interface.*

## UML Diagrams

*   **Menu System UML:** [View on Lucidchart](https://lucid.app/lucidchart/39cbdda2-25a4-4ee2-919a-4cc08959a061/edit?viewport_loc=578%2C400%2C2679%2C1257%2CHWEp-vi-RSFO&invitationId=inv_73f2e44e-9f9f-41ba-a969-71b89c80702c) - Includes the Menu and MenuItem interfaces, BaseMenuItem, AddOn, concrete menu item classes, the three Menu types, and the MenuFactory with its concrete factories.
*   **Full Project UML:** [View on Mermaid Chart](https://www.mermaidchart.com/d/b98fda79-ab07-4676-9e26-58dfc3335d00) - Comprehensive diagram covering all implemented patterns and classes.



