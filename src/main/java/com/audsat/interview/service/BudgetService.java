package com.audsat.interview.service;

import com.audsat.interview.dto.BudgetDto;
import com.audsat.interview.repository.BudgetRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class BudgetService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BudgetRepository budgetRepository;

    public Page<BudgetDto> obterTodos(Pageable paginacao) {
        return budgetRepository
                .findAll(paginacao)
                .map(p -> modelMapper.map(p, BudgetDto.class));
    }
}
