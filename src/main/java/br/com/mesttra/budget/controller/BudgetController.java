package br.com.mesttra.budget.controller;

import br.com.mesttra.budget.model.Budget;
import br.com.mesttra.budget.service.BudgetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/budgets")
public class BudgetController {

    BudgetService budgetService;

    public BudgetController(BudgetService budgetService) { this.budgetService = budgetService; }

    @GetMapping
    public List<Budget> listBudgets() { return budgetService.listBudgets(); }

}
