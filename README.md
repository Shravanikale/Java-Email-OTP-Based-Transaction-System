# 💳 Java Email OTP-Based Transaction System

A secure transaction system built in Java, demonstrating core Object-Oriented Programming (OOP) principles, multithreading, and email-based OTP verification. This project simulates real-time transaction validation using an OTP sent to the user’s email before completing any financial transfer.

---

## 🚀 Features

- 🔐 Email-based OTP authentication before each transaction
- 🧱 Uses core OOP pillars: Inheritance, Encapsulation, Abstraction, Polymorphism
- 🧵 Multithreading to handle OTP generation and sending
- 📩 Sends OTP using SMTP protocol (JavaMail API)
- 💰 Displays transaction details including:
  - Amount transacted
  - Remaining balance
  - Recipient name
  - OTP validation

---

## 🛠️ Technologies Used

- Java (JDK 8+)
- JavaMail API (javax.mail)
- Eclipse IDE
- SMTP (Gmail recommended)
- Maven (for dependency management, optional)

---

## 🧾 How It Works

1. **User initiates a transaction**
2. **System generates and sends a 6-digit OTP to the user's email**
3. **User enters the OTP received**
4. **OTP is verified**
   - ✅ If valid → Transaction proceeds
   - ❌ If invalid → Transaction denied
5. **Transaction details are displayed**

---

## 📂 Project Structure

```bash
src/
├── Main.java
├── BankAccount.java
├── Transaction.java
├── OTPService.java
├── EmailSender.java
```
## 🧠 OOP Concepts Used

This project effectively demonstrates the four pillars of Object-Oriented Programming (OOP):

### 🔒 Encapsulation
- Sensitive account data such as balance and account holder details are encapsulated within the `BankAccount.java` class.
- Access is controlled through getters and setters, preventing unauthorized modification.

### 🧼 Abstraction
- The process of generating and sending OTP is abstracted away into the `OTPService.java` class.
- This separates the core logic of authentication from the rest of the transaction flow.

### 🧬 Inheritance
- The design allows base functionality (e.g., user validation or account operations) to be extended in future versions.
- Encourages reuse and modularity for scaling or enhancements.

### 🎭 Polymorphism
- Overridden methods can be introduced to modify or extend behaviors (e.g., custom transaction types or logging).
- Enables flexibility while maintaining a common interface across components.


