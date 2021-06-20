package com.emanuelfrua.cashbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "loan")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "total", precision = 10, scale = 2)
    private double total;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cash_user_id")
    private User cash_user;

    public Loan() {
    }

    public Loan(double total, User cash_user) {
        this.total = total;
        this.cash_user = cash_user;
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

    public User getCash_user() {
        return cash_user;
    }

    public void setCash_user(User cash_user) {
        this.cash_user = cash_user;
    }
}
