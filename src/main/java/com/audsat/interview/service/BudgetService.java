package com.audsat.interview.service;

import com.audsat.interview.dto.BudgetDto;
import com.audsat.interview.dto.BudgetFormDto;
import com.audsat.interview.model.Budget;
import com.audsat.interview.model.Car;
import com.audsat.interview.model.Costumer;
import com.audsat.interview.repository.BudgetRepository;
import com.audsat.interview.repository.CarRepository;
import com.audsat.interview.repository.CostumerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BudgetService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BudgetRepository budgetRepository;
    @Autowired
    private CostumerRepository costumerRepository;
    @Autowired
    private CarRepository carRepository;

    public Page<BudgetDto> get(Pageable paginacao) {
        return budgetRepository
                .findAll(paginacao)
                .map(p -> modelMapper.map(p, BudgetDto.class));
    }

    public BudgetDto getById(Long id) {
        Budget budget = budgetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Budget not found. ID: " + id));

        return modelMapper.map(budget, BudgetDto.class);
    }

    public BudgetDto createBudget(BudgetFormDto dto) {
        Budget budget = modelMapper.map(dto, Budget.class);

        Costumer costumer = costumerRepository.findById(dto.getCostumer_id())
                .orElseThrow(() -> new RuntimeException("Costumer not found. ID: " + dto.getCostumer_id()));

        Car car = carRepository.findById(dto.getCar_id())
                .orElseThrow(() -> new RuntimeException("Car not found. ID: " + dto.getCar_id()));

        budget.setCostumer(costumer);
        budget.setCar(car);

        budgetRepository.save(budget);

        return modelMapper.map(budget, BudgetDto.class);
    }

    public BudgetDto updateBudget(Long id, BudgetFormDto dto) {
        Budget existingBudget = budgetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Budget not found. ID: " + id));

        modelMapper.map(dto, existingBudget);

        // Find costumer in database
        Costumer costumer = costumerRepository.findById(dto.getCostumer_id())
                .orElseThrow(() -> new RuntimeException("Costumer not found. ID: " + dto.getCostumer_id()));

        // Find Car in database
        Car car = carRepository.findById(dto.getCar_id())
                .orElseThrow(() -> new RuntimeException("Car not found. ID: " + dto.getCar_id()));

        existingBudget.setCostumer(costumer);
        existingBudget.setCar(car);

        Budget updatedBudget = budgetRepository.save(existingBudget);

        return modelMapper.map(updatedBudget, BudgetDto.class);
    }

    public void deleteBudget(Long id) {
        Budget existingBudget = budgetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Budget not found. ID: " + id));

        budgetRepository.delete(existingBudget);
    }
}
