package com.expensetracker.expense_tracker_api.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "Expenses")
public class Expense {
    @Id
    private String id;
    private String userId;
    private String category; // Groceries, Leisure, Electronics, etc.
    private double amount;
    private String description;
    private LocalDate date;
}
