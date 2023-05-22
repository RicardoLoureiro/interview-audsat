package com.audsat.interview.service;

import com.audsat.interview.dto.BudgetDto;
import com.audsat.interview.dto.BudgetFormDto;
import com.audsat.interview.model.Budget;
import com.audsat.interview.model.Car;
import com.audsat.interview.model.Costumer;
import com.audsat.interview.model.Driver;
import com.audsat.interview.repository.BudgetRepository;
import com.audsat.interview.repository.CarRepository;
import com.audsat.interview.repository.CostumerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

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

        // Get budget value
        budget.setValue_budget(calculateBudgetValue(car.getFipe_value(), costumer.getDriver(), dto));

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

    private float calculateBudgetValue(float fipeValue, Driver driver, BudgetFormDto dto) {
        try {
            int baseValue = 6;
            int costumerAge = getAgeFromBirthdate(driver.getBirthdate());

            if ( costumerAge > 18 && costumerAge < 25 ) baseValue += 2;
            if ( dto.isCar_sinister() ) baseValue += 2;
            if ( dto.isDriver_sinister() ) baseValue += 2;

            return fipeValue/100 * baseValue;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private int getAgeFromBirthdate(Date birthdate) {
        Calendar dob = Calendar.getInstance();
        dob.setTime(birthdate);

        Calendar today = Calendar.getInstance();

        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        if (today.get(Calendar.MONTH) < dob.get(Calendar.MONTH)
                || (today.get(Calendar.MONTH) == dob.get(Calendar.MONTH)
                && today.get(Calendar.DAY_OF_MONTH) < dob.get(Calendar.DAY_OF_MONTH))) {
            age--;
        }

        return age;
    }
}
