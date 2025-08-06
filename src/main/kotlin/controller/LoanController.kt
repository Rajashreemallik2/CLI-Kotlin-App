package org.example.controller

import org.example.models.LoanApplication
import org.example.services.BankService
import org.example.view.ConsoleView

class LoanController (
    private val bankService: BankService,
    private val view: ConsoleView
){
    fun startLoanProcess() {
            val application: LoanApplication = view.getLoanApplication() ?: return
            println("\n✅ Loan Application Submitted:")
            println(application)

            val offers = bankService.simulateBankOffers()
            view.displayOffers("🏦 Initial Bank Offers:", offers)

            val negotiatedOffers = bankService.negotiateOffers(offers)
            view.displayOffers("🤝 Negotiated Bank Offers:", negotiatedOffers)

            val bestOffer = bankService.findBestOffer(negotiatedOffers)
            view.displayBestOffer(bestOffer)

            val accepted = view.confirmOfferAcceptance()
            view.showFinalMessage(accepted, bestOffer)
        }
}