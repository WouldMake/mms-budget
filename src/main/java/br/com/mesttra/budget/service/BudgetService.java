package br.com.mesttra.budget.service;

import br.com.mesttra.budget.data.BudgetRepository;
import br.com.mesttra.budget.model.Budget;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class BudgetService {

    BudgetRepository budgetRepository;

    public BudgetService(BudgetRepository budgetRepository) { this.budgetRepository = budgetRepository; }

    public Budget addBudget(Budget budget) { return budgetRepository.save(budget); }

    public List<Budget> listBudgets() { return budgetRepository.findAll(); }

    public List<Budget> listBudgetsByDestination(String destination) { return budgetRepository.findByDestination(destination); }

}
