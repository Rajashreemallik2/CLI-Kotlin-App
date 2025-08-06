# Loan Application Engine – CLI Kotlin Project

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

  ## Assumptions
- Offers are randomly generated with interest rates between 9% and 18%.
- Negotiable offers are discounted between 0.5% to 1.5%.
- Input validation is minimal for brevity.
