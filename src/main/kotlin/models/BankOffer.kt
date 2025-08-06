package org.example.models

data class BankOffer(
    val bankName: String,
    var interestRate: Double,
    val isNegotiable: Boolean,
    val processingTimeInDays: Int
)
