package com.emanuelfrua.cashbackend.controller;

import com.emanuelfrua.cashbackend.dto.LoanDTO;
import com.emanuelfrua.cashbackend.exception.ResourceNotFoundException;
import com.emanuelfrua.cashbackend.model.Loan;
import com.emanuelfrua.cashbackend.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class LoanController {

    @Autowired
    private LoanRepository loanRepository;

    // get loans by page and size, user_id is optional
    @GetMapping("/loans")
    public Page<LoanDTO> getLoansByPageAndSize(
            @RequestParam(required = true, value = "page") int page,
            @RequestParam(required = true, value = "size") int size,
            @RequestParam(required = false, value = "user_id") Long userId
    ) {
        Page<LoanDTO> loanDTOPage = null;
        Pageable pageable = PageRequest.of(page, size);

        if (userId != null) {
            loanDTOPage = this.loanRepository.findByUserId(userId, pageable).map(LoanDTO::new);
        } else {
            loanDTOPage = this.loanRepository.findAll(pageable).map(LoanDTO::new);
        }
//        return new LoanResponseDTO(loanDTOPage.getContent(), pageable);
        return loanDTOPage;
    }

    // save Loan
    @PostMapping("loans")
    public Loan createLoan(@Valid @RequestBody Loan loan) {
        return this.loanRepository.save(loan);
    }

    // update Loan
    @PutMapping("loans/{id}")
    public ResponseEntity<Loan> updateLoan(@PathVariable(value = "id") Long loanId, @Valid @RequestBody Loan loanDetails) throws ResourceNotFoundException {
        Loan loan = loanRepository.findById(loanId).orElseThrow(() -> new ResourceNotFoundException("Loan not found for this id: " + loanId));
        loan.setTotal(loanDetails.getTotal());
        final Loan loanUpdated = loanRepository.save(loan);
        return ResponseEntity.ok(loanUpdated);
    }

    // delete loan
    @DeleteMapping("loans/{id}")
    public Map<String, Boolean> deleteLoan(@PathVariable(value = "id") Long loanId) throws ResourceNotFoundException {
        Loan loan = loanRepository.findById(loanId).orElseThrow(() -> new ResourceNotFoundException("Loan not found for this id: " + loanId));
        this.loanRepository.delete(loan);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
