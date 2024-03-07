package com.csis3275.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.csis3275.model.Expense;
//import com.csis3275.respository.ExpenseRespository;

@Controller
public class HomeController {

//private final ExpenseRespository expenseRepository;

//    public HomeController(ExpenseRespository expenseRepository) {
//        this.expenseRepository = expenseRepository;
//    }
   
    @GetMapping("/")
    public String home(Model model) {
        return "homeView";
    }
    
//    @GetMapping("/budget")
//    public String showBudgetPage(Model model) {
//        //List<Expense> expenses = expenseRepository.findAll();
//        //model.addAttribute("expenses", expenses);
//        //model.addAttribute("newExpense", new Expense());
//        return "budget";
//    }
//
//    @PostMapping("/budget/add")
//    public String addExpense(Expense expense) {
//        //expenseRepository.save(expense);
//        return "redirect:/budget";
//    }
}
