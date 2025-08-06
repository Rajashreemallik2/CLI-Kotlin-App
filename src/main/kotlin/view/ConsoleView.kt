package org.example.view

import org.example.models.BankOffer
import org.example.models.LoanApplication

class ConsoleView {
    fun getLoanApplication(): LoanApplication? {
        println("=== Welcome to Loan Application Engine ===")

        print("Enter your name: ")
        val name = readLine() ?: return null

        print("Enter loan amount: ")
        val amount = readLine()?.toDoubleOrNull()
        if (amount == null || amount <= 0) {
            println("❌ Invalid loan amount.")
            return null
        }

        print("Enter duration in months: ")
        val duration = readLine()?.toIntOrNull()
        if (duration == null || duration <= 0) {
            println("❌ Invalid duration.")
            return null
        }

        print("Enter loan purpose: ")
        val purpose = readLine() ?: return null

        return LoanApplication(name, amount, duration, purpose)
    }

    fun displayOffers(title: String, offers: List<BankOffer>) {
        println("\n$title")
        offers.forEach { println(it) }
    }

    fun displayBestOffer(bestOffer: BankOffer?) {
        println("\n🌟 Best Offer:")
        println(bestOffer)
    }

    fun confirmOfferAcceptance(): Boolean {
        println("\nDo you want to accept this offer? (yes/no)")
        return readLine()?.lowercase() == "yes"
    }

    fun showFinalMessage(accepted: Boolean, offer: BankOffer?) {
        if (accepted) {
            println("🎉 You accepted the offer from ${offer?.bankName} at ${"%.2f".format(offer?.interestRate)}% interest.")
        } else {
            println("❌ Offer not accepted. Application closed.")
        }
        println("\n=== Thank You for Using Loan Application Engine ===")
    }
}