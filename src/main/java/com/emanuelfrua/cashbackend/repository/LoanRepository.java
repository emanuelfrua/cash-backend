package com.emanuelfrua.cashbackend.repository;

import com.emanuelfrua.cashbackend.model.Loan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    @Query("select l from Loan l where l.cash_user.id in :id")
    Page<Loan> findByUserId(@Param("id") Long cash_user_id, Pageable pageable);
}
