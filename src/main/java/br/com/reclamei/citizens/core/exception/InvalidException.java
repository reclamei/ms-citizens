package br.com.reclamei.citizens.core.exception;

import br.com.reclamei.citizens.core.validator.Validator;

import static java.lang.String.format;

public class InvalidException extends RuntimeException {

    public InvalidException(final Validator validator) {
        super(format("[%s] :: isValid :: %s is invalid for %s",
            validator.getClass().getSimpleName(),
            validator.getValidatedAttribute(),
            validator.getValidationType()));
    }

}
