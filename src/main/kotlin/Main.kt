package org.example

import org.example.models.BankOffer
import org.example.models.LoanApplication
import kotlin.random.Random

fun main() {
    println("=== Welcome to Loan Application Engine ===")

    print("Enter your name: ")
    val name = readLine() ?: ""

    print("Enter loan amount (e.g., 50000): ")
    val amount = readLine()?.toDoubleOrNull()
    if (amount == null || amount <= 0) {
        println("❌ Invalid loan amount.")
        return
    }

    print("Enter loan duration in months: ")
    val duration = readLine()?.toIntOrNull()
    if (duration == null || duration <= 0) {
        println("❌ Invalid duration.")
        return
    }

    print("Enter purpose of the loan: ")
    val purpose = readLine() ?: ""

    val application = LoanApplication(name, amount, duration, purpose)
    println("\n✅ Loan Application Submitted:")
    println(application)

    // Simulate offers
    val offers = simulateBankOffers()
    println("\n🏦 Initial Bank Offers:")
    offers.forEach { println(it) }

    // Negotiation logic
    val negotiatedOffers = offers.map { offer ->
        if (offer.isNegotiable) {
            val discount = Random.nextDouble(0.5, 1.5)
            offer.copy(interestRate = (offer.interestRate - discount).coerceAtLeast(1.0))
        } else offer
    }

    println("\n🤝 Negotiated Bank Offers:")
    negotiatedOffers.forEach { println(it) }

    // Find best offer
    val bestOffer = negotiatedOffers.minByOrNull { it.interestRate }

    println("\n🌟 Best Offer:")
    println(bestOffer)

    println("\nDo you want to accept this offer? (yes/no)")
    val accept = readLine()?.lowercase()
    if (accept == "yes") {
        println("🎉 Congratulations! You accepted the offer from ${bestOffer?.bankName} at ${"%.2f".format(bestOffer?.interestRate)}% interest.")
    } else {
        println("❌ Offer not accepted. Application closed.")
    }

    println("\n=== Thank You for Using Loan Application Engine ===")
}

// Simulate 3 bank offers
fun simulateBankOffers(): List<BankOffer> {
    val banks = listOf("HDFC Bank", "ICICI Bank", "SBI Bank")
    return banks.map {
        BankOffer(
            bankName = it,
            interestRate = Random.nextDouble(9.0, 18.0),
            isNegotiable = Random.nextBoolean(),
            processingTimeInDays = Random.nextInt(1, 4)
        )
    }
}