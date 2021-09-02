package br.com.mesttra.budget.service;

import br.com.mesttra.budget.data.BudgetRepository;
import br.com.mesttra.budget.model.Budget;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetService {

    BudgetRepository budgetRepository;

    public BudgetService(BudgetRepository budgetRepository) { this.budgetRepository = budgetRepository; }

    public List<Budget> listBudgets() { return budgetRepository.findAll(); }
}
