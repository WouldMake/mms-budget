package br.com.mesttra.budget.controller;

import br.com.mesttra.budget.enums.Folder;
import br.com.mesttra.budget.service.BudgetService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class BudgetControllerTest {

    private final BudgetService budgetService = mock(BudgetService.class);
    private BudgetController budgetController = new BudgetController(budgetService);

    @Test
    public void listBudgetsWithNullDestination() {
        budgetController.listBudgets(null);
        verify(budgetService).listBudgets();
    }

    @Test
    public void listBudgetsWithEmptyDestination() {
        budgetController.listBudgets("");
        verify(budgetService).listBudgets();
    }

    @Test
    public void listBudgetsWithValidDestination() {
        final String destination = Folder.HEALTH.toString();
        budgetController.listBudgets(destination);
        verify(budgetService).listBudgetsByDestination(destination);
    }
}