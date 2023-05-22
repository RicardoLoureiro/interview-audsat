package com.audsat.interview.controller;


import com.audsat.interview.dto.BudgetDto;
import com.audsat.interview.dto.BudgetFormDto;
import com.audsat.interview.service.BudgetService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/insurance/budgets")
public class BudgetController {

    @Autowired
    private BudgetService service;

    @GetMapping
    public Page<BudgetDto> listar(@PageableDefault(size=10) Pageable paginacao) {
        return service.get(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BudgetDto> detalhar(@PathVariable @NotNull Long id) {
        BudgetDto dto = service.getById(id);

        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<BudgetDto> cadastrar(@RequestBody @Valid BudgetFormDto dto, UriComponentsBuilder uriBuilder) {
        BudgetDto budget = service.createBudget(dto);
        URI newBudget = uriBuilder.path("/insurance/budgets/{id}").buildAndExpand(budget.getId()).toUri();

        return ResponseEntity.created(newBudget).body(budget);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BudgetDto> atualizar(@PathVariable @NotNull Long id, @RequestBody @Valid BudgetDto dto) {
        BudgetDto atualizado = service.updateBudget(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/({id}")
    public ResponseEntity<BudgetDto> remover(@PathVariable @NotNull Long id) {
        service.deleteBudget(id);
        return ResponseEntity.noContent().build();
    }

}
