package br.com.mesttra.budget.controller;

import br.com.mesttra.budget.exception.BusinessException;
import br.com.mesttra.budget.model.Budget;
import br.com.mesttra.budget.request.DebitExpenseRequest;
import br.com.mesttra.budget.service.BudgetService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiOperation(value = "Add budget",
            notes = "This method adds a new budget.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Budget added"),
            @ApiResponse(code = 500, message = "Internal Error"),
    })    public Budget addBudget(@Valid @RequestBody Budget budget) { return budgetService.addBudget(budget); }

    @GetMapping
    @ApiOperation(value = "List budgets",
            notes = "This method lists all budgets.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Budgets listed"),
            @ApiResponse(code = 500, message = "Internal Error"),
    })
    public List<Budget> listBudgets(@RequestParam(required = false) String destination) {

        if (destination == null || destination.isEmpty())
            return budgetService.listBudgets();
        else
            return budgetService.listBudgetsByDestination(destination);
    }

    @PatchMapping("/{id}/expense")
    @ApiOperation(value = "Debit an expense from an existing budget",
            notes = "This method finds a budget by its id and debits an expense from it.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Budget changed"),
            @ApiResponse(code = 500, message = "Internal Error"),
    })
    public Budget debitExpense(@PathVariable Long id, @Valid @RequestBody DebitExpenseRequest debitExpenseRequest) throws BusinessException {
        return  budgetService.debitExpense(id, debitExpenseRequest);
    }
}
