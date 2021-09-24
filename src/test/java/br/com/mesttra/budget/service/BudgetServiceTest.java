package br.com.mesttra.budget.service;

import br.com.mesttra.budget.data.BudgetRepository;
import br.com.mesttra.budget.enums.Origin;
import br.com.mesttra.budget.exception.BusinessException;
import br.com.mesttra.budget.model.Budget;
import br.com.mesttra.budget.request.DebitExpenseRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BudgetServiceTest {

    private final BudgetRepository budgetRepository = mock(BudgetRepository.class);
    private BudgetService budgetService = new BudgetService(budgetRepository);

    @Test
    public void addBudgetTest()
    {
        Budget budget = new Budget(Long.valueOf(0), Double.valueOf(1000), Double.valueOf(100), "HEALTH", Origin.STATE);
        budgetService.addBudget(budget);
        verify(budgetRepository, times(1)).save(budget);
    }

}