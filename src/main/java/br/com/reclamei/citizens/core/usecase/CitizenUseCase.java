package br.com.reclamei.citizens.core.usecase;

import br.com.reclamei.citizens.core.domain.CitizenDomain;
import br.com.reclamei.citizens.core.exception.InvalidException;
import br.com.reclamei.citizens.core.gateway.CitizenGateway;
import br.com.reclamei.citizens.core.validator.CitizenValidator;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static java.util.UUID.randomUUID;

@Slf4j
public record CitizenUseCase(CitizenGateway citizenGateway, List<CitizenValidator> citizenValidators) {

    public void create(final CitizenDomain citizenDomain) {
        validateCitizen(citizenDomain);
        log.info("[CitizenUseCase] :: create :: Creating new citizen. {}", citizenDomain);
        citizenGateway.save(citizenDomain);
    }

    private void validateCitizen(final CitizenDomain citizenDomain) {
        citizenValidators.stream()
            .filter(citizenValidator -> !citizenValidator.isValid(citizenDomain))
            .findFirst()
            .ifPresent(citizenValidator -> {throw new InvalidException(citizenValidator);});
    }

    public CitizenDomain findById(final String citizenId) {
        log.info("[CitizenUseCase] :: findById :: Finding citizen with id {}", citizenId);
        return citizenGateway.findById(citizenId);
    }

    public void deleteCitizenById(final String citizenId) {
        log.info("[CitizenUseCase] :: deleteCitizenById :: Deleting citizen with id {}", citizenId);
        citizenGateway.deleteById(citizenId);
    }

}
