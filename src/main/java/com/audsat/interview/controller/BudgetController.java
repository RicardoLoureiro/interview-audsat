package com.audsat.interview.controller;


import com.audsat.interview.dto.BudgetDto;
import com.audsat.interview.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/insurance/budgets")
public class BudgetController {

    @Autowired
    private BudgetService service;

    @GetMapping
    public Page<BudgetDto> listar(@PageableDefault(size=10) Pageable paginacao) {
        return service.obterTodos(paginacao);
    }

}
