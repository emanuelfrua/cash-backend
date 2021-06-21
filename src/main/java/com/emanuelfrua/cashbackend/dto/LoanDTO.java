package com.emanuelfrua.cashbackend.dto;


import com.emanuelfrua.cashbackend.model.Loan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class LoanDTO {

    private long id;
    private double total;
    private long userId;

    public LoanDTO(Loan loan) {
        setId(loan.getId());
        setTotal(loan.getTotal());
        setUserId(loan.getCash_user().getId());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
