package com.audsat.interview.service;

import com.audsat.interview.dto.BudgetDto;
import com.audsat.interview.dto.BudgetFormDto;
import com.audsat.interview.model.*;
import com.audsat.interview.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class BudgetService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BudgetRepository budgetRepository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private CarDriverRepository carDriverRepository;

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

        Driver driver = findOrCreateDriver(dto);
        Car car = findOrCreateCar(dto);

        CarDriver carDriver = findOrCreateCarDriver(car, driver, dto);

        budget.setDriver(driver);
        budget.setCar(car);

        // Get budget value
        budget.setValue_budget(calculateBudgetValue(carDriver, dto));

        budgetRepository.save(budget);

        return modelMapper.map(budget, BudgetDto.class);
    }

    public BudgetDto updateBudget(Long id, BudgetFormDto dto) {
        Budget existingBudget = budgetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Budget not found. ID: " + id));

        // Find/create driver in database
        Driver driver = findOrCreateDriver(dto);
        // Find/create Car in database
        Car car = findOrCreateCar(dto);
        CarDriver carDriver = findOrCreateCarDriver(car, driver, dto);

        // Set data to budget
        existingBudget.setDriver(driver);
        existingBudget.setCar(car);

        // Update budget value
        existingBudget.setValue_budget(calculateBudgetValue(carDriver, dto));

        budgetRepository.save(existingBudget);

        return modelMapper.map(existingBudget, BudgetDto.class);
    }

    public void deleteBudget(Long id) {
        Budget existingBudget = budgetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Budget not found. ID: " + id));

        budgetRepository.delete(existingBudget);
    }

    private float calculateBudgetValue(CarDriver carDriver, BudgetFormDto dto) {
        try {
            float fipeValue = carDriver.getCar().getFipe_value();
            String birthdate = carDriver.getDriver().getBirthdate();

            int baseValue = 6;
            int costumerAge = getAgeFromBirthdate(birthdate);

            if ( costumerAge > 18 && costumerAge < 25 ) baseValue += 2;
            if ( carDriver.getClaim_event_date() != null ) baseValue += 2;
            if ( carDriver.is_main_driver() ) baseValue += 2;

            return fipeValue/100 * baseValue;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private int getAgeFromBirthdate(String birthdate) throws ParseException {
        Calendar dob = Calendar.getInstance();

        Date date = new SimpleDateFormat("dd-MM-yyyy").parse(birthdate);
        dob.setTime(date);

        Calendar today = Calendar.getInstance();

        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        if (today.get(Calendar.MONTH) < dob.get(Calendar.MONTH)
                || (today.get(Calendar.MONTH) == dob.get(Calendar.MONTH)
                && today.get(Calendar.DAY_OF_MONTH) < dob.get(Calendar.DAY_OF_MONTH))) {
            age--;
        }

        return age;
    }

    private Driver findOrCreateDriver(BudgetFormDto dto) {
        try {
            Driver driver = driverRepository.findByDocument(dto.getDocument());

            if( driver == null) {
                driver = modelMapper.map(dto, Driver.class);
                driverRepository.save(driver);
            }

            return driver;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Car findOrCreateCar(BudgetFormDto dto) {
        try {
            Car car = carRepository
                    .findByModelAndManufacturerAndYear(dto.getModel(), dto.getManufacturer(), dto.getYear());

            if( car == null) {
                car = modelMapper.map(dto, Car.class);
                carRepository.save(car);
            }

            return car;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private CarDriver findOrCreateCarDriver(Car car, Driver driver, BudgetFormDto dto) {
        try {
            CarDriver carDriver = carDriverRepository.findByCarAndDriver(car.getId(), driver.getId());

            if( carDriver == null) {
                carDriver = modelMapper.map(dto, CarDriver.class);
                carDriverRepository.save(carDriver);
            }

            return carDriver;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }



}
