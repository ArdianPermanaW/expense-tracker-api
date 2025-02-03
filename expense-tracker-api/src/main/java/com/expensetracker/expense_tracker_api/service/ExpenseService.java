package com.expensetracker.expense_tracker_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expensetracker.expense_tracker_api.model.Expense;
import com.expensetracker.expense_tracker_api.repository.ExpenseRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public List<Expense> getExpenses(String category, LocalDate startDate, LocalDate endDate) {
        if (category != null && startDate != null && endDate != null) {
            return expenseRepository.findByCategoryAndDateBetween(category, startDate, endDate);
        } else if (startDate != null && endDate != null) {
            return expenseRepository.findByDateBetween(startDate, endDate);
        } else if (category != null) {
            return expenseRepository.findByCategory(category);
        } else {
            return expenseRepository.findAll();
        }
    }

    public Expense addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public Expense updateExpense(String id, Expense expense) {
        expense.setId(id);
        return expenseRepository.save(expense);
    }

    public void deleteExpense(String id) {
        expenseRepository.deleteById(id);
    }
}
