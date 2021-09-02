package br.com.mesttra.budget.controller;

import br.com.mesttra.budget.model.Budget;
import br.com.mesttra.budget.service.BudgetService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/budgets")
public class BudgetController {

    BudgetService budgetService;

    public BudgetController(BudgetService budgetService) { this.budgetService = budgetService; }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Budget addBudget(@Valid @RequestBody Budget budget) { return budgetService.addBudget(budget); }

    @GetMapping
    public List<Budget> listBudgets() { return budgetService.listBudgets(); }

}
