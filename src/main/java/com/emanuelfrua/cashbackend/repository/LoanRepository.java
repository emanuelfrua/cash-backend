package com.emanuelfrua.cashbackend.repository;

import com.emanuelfrua.cashbackend.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
