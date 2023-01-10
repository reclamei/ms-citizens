package br.com.reclamei.citizens.core.validator;

import br.com.reclamei.citizens.core.domain.CitizenDomain;

public interface Validator {

    boolean isValid(CitizenDomain citizenDomain);

    String getValidatedAttribute();

    String getValidationType();

}
