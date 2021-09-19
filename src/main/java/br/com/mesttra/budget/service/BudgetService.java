package br.com.mesttra.budget.service;

import br.com.mesttra.budget.data.BudgetRepository;
import br.com.mesttra.budget.exception.BusinessException;
import br.com.mesttra.budget.model.Budget;
import br.com.mesttra.budget.request.DebitExpenseRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BudgetService {

    BudgetRepository budgetRepository;

    public BudgetService(BudgetRepository budgetRepository) { this.budgetRepository = budgetRepository; }

    public Budget addBudget(Budget budget) { return budgetRepository.save(budget); }

    public List<Budget> listBudgets() { return budgetRepository.findAll(); }

    public List<Budget> listBudgetsByDestination(String destination) { return budgetRepository.findByDestination(destination); }

    @Transactional
    public Budget debitExpense(Long id, DebitExpenseRequest debitExpenseRequest) throws BusinessException {

        Optional<Budget> budgetOptional = budgetRepository.findById(id);

        if (budgetOptional.isEmpty()) {
            throw new BusinessException("Budget not found.");
        }

        Budget budget = budgetOptional.get();
        String destination = debitExpenseRequest.getFolder().toString();

        if (!budget.getPossibleDestinations().contains(destination))
        {
            throw new BusinessException("Invalid budget destination.");
        }

        // The expense is greater than the available budget
        if (debitExpenseRequest.getAmount() > (budget.getTotalAmount() - budget.getSpentAmount()) )
        {
            throw new BusinessException("Not enough budget.");
        }
        // Debit expense
        else
        {
            budget.setSpentAmount(budget.getSpentAmount() + debitExpenseRequest.getAmount());
            return budgetRepository.save(budget);
        }
    }
}
