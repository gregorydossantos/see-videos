package com.fiap.gregory.seevideos.domain.useful;

import com.fiap.gregory.seevideos.domain.exception.BadRequestException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

import static com.fiap.gregory.seevideos.domain.useful.CommonsMessages.BAD_REQUEST;

@Component
@AllArgsConstructor
public class ValidatorUseful {

    final Validator validator;

    public <T> void validateRequest(T request) {
        Set<ConstraintViolation<T>> violations = validator.validate(request);
        if (!violations.isEmpty()) {
            throw new BadRequestException(BAD_REQUEST);
        }
    }
}
