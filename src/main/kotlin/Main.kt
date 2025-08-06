package org.example

import org.example.controller.LoanController
import org.example.services.BankService
import org.example.view.ConsoleView


    fun main() {
        val controller = LoanController(BankService(), ConsoleView())
        controller.startLoanProcess()
    }
