Used Desing Patterns:

---

### **1. Factory Pattern**

**Location:**

* `MenuFactory` (interface)
* `VegetarianMenuFactory`, `NonVegetarianMenuFactory`, `KidsMenuFactory` (implementations)
  **Usage:**
  When the system needs to display or build a menu, it asks the appropriate factory to create the right `Menu` object.

**Design Principle:** *Open/Closed* — new menus can be added without modifying existing code.

---

### **2. Factory Method Pattern**

**Location:**

* Inside each `Menu` class (`VegetarianMenu`, `NonVegetarianMenu`, `KidsMenu`).
  Each menu class creates its own items dynamically without exposing construction logic.

**Design Principle:** *Single Responsibility* — each menu is responsible for creating its own category items.

---

### **3. Builder Pattern**

**Purpose:** Simplify and control the construction of complex `Order` objects.
**Location:**

* `Order` class → inner static `Builder` class.
  **Usage:**

**Design Principle:** *Encapsulation* — separates object construction from its representation.

---

### **4. Decorator Pattern**

**Purpose:** Dynamically add features (add-ons like sauces, cheese, etc.) to menu items without modifying the base classes.
**Location:**

* `AddOn` (abstract decorator extending `MenuItem`)
* `ExtraCheese`, `Sauce`, `Bacon`, `Jalapenos`, etc. (concrete decorators).
  **Usage:**

**Design Principle:** *Open/Closed* — add-ons can be extended without altering existing code.

---

### **5. Strategy Pattern**

**Purpose:** Define interchangeable discount strategies that can vary independently from the billing logic.
**Location:**

* `DiscountStrategy` (interface)
* `PizzaDiscount`, `BurgerDiscount`, `ChickenDiscount`, etc. (concrete strategies).
  **Usage:**

**Design Principle:** *Dependency Inversion* — high-level billing depends on abstractions, not concrete discount types.

---

### **6. Observer Pattern**

**Purpose:** Notify kitchen and waiter systems automatically when an order is placed.
**Location:**

* `OrderNotifier` (subject interface)
* `KitchenSystem`, `WaiterSystem` (observers)
* `RestaurantOrderManager` (implements notification and observer registration).
  **Usage:**

**Design Principle:** *Loose Coupling* — the order system doesn’t directly depend on kitchen or waiter classes.

---

### **7. Strategy Pattern (Secondary Use — Payment)**

**Purpose:** Support multiple interchangeable payment methods.
**Location:**

* `PaymentStrategy` (interface)
* `CashPayment`, `CreditCardPayment`, `MobileWalletPayment` (concrete strategies).
  **Usage:**

**Design Principle:** *Open/Closed* — new payment methods can be added easily.

---

### **8. Template Method Pattern** *(optional refinement)*

**Purpose:** Define the skeleton of the order processing workflow while allowing customization of steps.
**Location:**

* `OrderProcessor` (abstract class)
* `DineInOrderProcessor`, `DeliveryOrderProcessor`, `TakeawayOrderProcessor` (subclasses).
  **Usage:**
  Each subclass overrides methods like `deliverOrder()` or `assignWaiter()`.
  **Design Principle:** *Liskov Substitution* — each order type follows the same process with its own implementation.

---

✅ **Summary Table**

| Pattern            | Purpose                        | Implemented In                                   |
| ------------------ | ------------------------------ | ------------------------------------------------ |
| Abstract Factory   | Create menu families           | `MenuFactory` + subfactories                     |
| Factory Method     | Create menu items per category | `Menu` subclasses                                |
| Builder            | Build orders step-by-step      | `Order.Builder`                                  |
| Decorator          | Add dynamic add-ons            | `AddOn` + subclasses                             |
| Strategy           | Apply discounts                | `DiscountStrategy` hierarchy                     |
| Observer           | Notify kitchen/waiter          | `OrderNotifier`, `KitchenSystem`, `WaiterSystem` |
| Strategy (Payment) | Multiple payment methods       | `PaymentStrategy` hierarchy                      |
| Template Method    | Workflow sequence (optional)   | `OrderProcessor` subclasses                      |

---

