package com.csis3275.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.csis3275.model.Expense;
//import com.csis3275.respository.ExpenseRespository;
import com.csis3275.model.Users;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

//private final ExpenseRespository expenseRepository;

//    public HomeController(ExpenseRespository expenseRepository) {
//        this.expenseRepository = expenseRepository;
//    }
   
    @GetMapping("/")
    public String home(HttpSession session, Model model) {
        Users user = (Users) session.getAttribute("user"); // Get the user from the session
        if (user == null) {
            return "redirect:/login"; // Redirect to the login page if there's no user in the session
        } else {
            model.addAttribute("user", user); // Add the user to the model
            return "homeView"; // Return the home view
        }
    
    }

    @GetMapping("/converter")
    public String currencyConverter()
    {
        return "currency";
    }

    @GetMapping("/emergency")
    public String emergencyDetails()
    {
        return "emergency";
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
