package org.example.services

import org.example.models.BankOffer
import kotlin.random.Random

class BankService {

    fun simulateBankOffers() : List<BankOffer>{
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

    // Negotiation logic
    fun negotiateOffers(offers: List<BankOffer>) : List<BankOffer> {
        return offers.map { offer ->
            if (offer.isNegotiable) {
                val discount = Random.nextDouble(0.5, 1.5)
                offer.copy(interestRate = (offer.interestRate - discount).coerceAtLeast(1.0))
            } else offer
        }
    }

    fun findBestOffer(offers: List<BankOffer>): BankOffer? {
        return offers.minByOrNull { it.interestRate }
    }
}