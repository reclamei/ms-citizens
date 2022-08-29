package br.com.reclamei.citizens.core.validator.impl;

import br.com.reclamei.citizens.core.domain.CitizenDomain;
import br.com.reclamei.citizens.core.gateway.CitizenGateway;
import br.com.reclamei.citizens.core.validator.CitizenValidator;

import static br.com.reclamei.citizens.core.type.ValidationType.DUPLICATION;

public record CpfDuplicationCitizenValidatorImpl(CitizenGateway citizenGateway) implements CitizenValidator {

    @Override
    public boolean isValid(final CitizenDomain citizenDomain) {
        return !citizenGateway.existsByCpf(citizenDomain.getCpf());
    }

    @Override
    public String getValidatedAttribute() {
        return "CPF";
    }

    @Override
    public String getValidationType() {
        return DUPLICATION.getType();
    }

}
