package org.example.models

data class LoanApplication(
    val name: String,
    val amount: Double,
    val durationInMonths: Int,
    val purpose: String,
    var status: String = "Submitted"
)
