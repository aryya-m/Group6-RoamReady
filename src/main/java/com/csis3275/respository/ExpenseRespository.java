package com.csis3275.respository;
import com.csis3275.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ExpenseRespository extends JpaRepository<Expense, Long> {

}
