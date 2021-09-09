package br.com.mesttra.budget.controller;

import br.com.mesttra.budget.exception.BusinessException;
import br.com.mesttra.budget.model.Budget;
import br.com.mesttra.budget.request.DebitExpenseRequest;
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
    public List<Budget> listBudgets(@RequestParam(required = false) String destination) {

        if (destination == null || destination.isEmpty())
            return budgetService.listBudgets();
        else
            return budgetService.listBudgetsByDestination(destination);
    }

    @PatchMapping("/{id}/expense")
    public Budget debitExpense(@PathVariable Long id, @Valid @RequestBody DebitExpenseRequest debitExpenseRequest) throws BusinessException {
        return  budgetService.debitExpense(id, debitExpenseRequest);
    }
}
