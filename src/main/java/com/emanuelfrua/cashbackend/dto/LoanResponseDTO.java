package com.emanuelfrua.cashbackend.dto;

import org.springframework.data.domain.Pageable;

import java.util.List;

public class LoanResponseDTO {

    private List<LoanDTO> items;
    private long page;
    private long size;

    public LoanResponseDTO(List<LoanDTO> loanDTOList, Pageable pageable) {
        setItems(loanDTOList);
        setPage(pageable.getPageNumber());
        setSize(pageable.getPageSize());
    }

    public long getPage() {
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public List<LoanDTO> getItems() {
        return items;
    }

    public void setItems(List<LoanDTO> items) {
        this.items = items;
    }
}
