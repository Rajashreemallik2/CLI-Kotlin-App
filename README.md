# Loan Application Engine – CLI Kotlin Project

# Objective

To build a command-line based Loan Application Engine using Kotlin, where users can:

Submit a loan application

View bank offers with interest rates

Negotiate offers if applicable

Accept or reject the best available offer

# Features
Takes user input: name, loan amount, duration, and purpose

Simulates multiple bank offers (random interest rates and negotiability)

Applies negotiation if the bank allows it

Picks the best offer based on lowest interest rate

Displays full offer details and allows the user to accept or reject

Uses Kotlin's data classes, object-oriented principles, and functional collection operations

## Description

This is a console-based Kotlin app that simulates:

- Loan Application submission
- Simulated bank offers from 3 banks
- Negotiation logic to reduce interest if negotiable
- Highlights the best offer
- Allows user to accept the best offer

## Domain Models

- `LoanApplication`: name, amount, duration, purpose, status
- `BankOffer`: bankName, interestRate, isNegotiable, processingTimeInDays

## How to Run
1. Open the project in IntelliJ IDEA.
2. Clone this project
3. Run `Main.kt`.

## Project Structure
- `model/`: Data classes like `LoanApplication`, `BankOffer`
- `service/`: Business logic like bank offer simulation and negotiation
- `view/`: CLI input/output handling
- `controller/`: Flow control
- `Main.kt`: App entry point

# Sample Interaction
=== Welcome to Loan Application Engine === <br>
Enter your name: Rajashree <br>
Enter loan amount (e.g., 50000): 100000 <br>
Enter loan duration in months: 24 <br>
Enter purpose of the loan: Home Renovation

🏦 Initial Bank Offers:
BankOffer(bankName=SBI Bank, interestRate=14.3, isNegotiable=true, processingTimeInDays=2)
...

🤝 Negotiated Bank Offers:
BankOffer(bankName=SBI Bank, interestRate=13.2, isNegotiable=true, processingTimeInDays=2)
...

🌟 Best Offer:
SBI Bank at 13.2%

Do you want to accept this offer? (yes/no)


  ## Assumptions
- Offers are randomly generated with interest rates between 9% and 18%.
- Negotiable offers are discounted between 0.5% to 1.5%.
- Input validation is minimal for brevity.
