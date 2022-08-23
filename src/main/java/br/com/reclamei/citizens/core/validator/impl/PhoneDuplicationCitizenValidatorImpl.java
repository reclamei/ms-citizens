package br.com.reclamei.citizens.core.validator.impl;

import br.com.reclamei.citizens.core.domain.CitizenDomain;
import br.com.reclamei.citizens.core.gateway.CitizenGateway;
import br.com.reclamei.citizens.core.validator.CitizenValidator;

import static br.com.reclamei.citizens.core.validator.ValidationType.DUPLICATION;

public record PhoneDuplicationCitizenValidatorImpl(CitizenGateway citizenGateway) implements CitizenValidator {

    @Override
    public boolean isValid(final CitizenDomain citizenDomain) {
        return !citizenGateway.existsByPhone(citizenDomain.getPhone());
    }

    @Override
    public String getValidatedAttribute() {
        return "Phone";
    }

    @Override
    public String getValidationType() {
        return DUPLICATION.getType();
    }

}
