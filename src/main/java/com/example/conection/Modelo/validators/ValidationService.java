package com.example.conection.Modelo.validators;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ValidationService<T> {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();


    public <T> Set<String> validate(T object) {
        Set<ConstraintViolation<T>> violations = validator.validate(object);

        if(!violations.isEmpty()){
            return violations.stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.toSet());

        }
       return Collections.emptySet();
    }

}

