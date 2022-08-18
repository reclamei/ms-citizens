package br.com.reclamei.citizens.core.usecase;

import br.com.reclamei.citizens.core.domain.CitizenDomain;
import br.com.reclamei.citizens.core.gateway.CitizenGateway;
import lombok.extern.slf4j.Slf4j;

import static java.util.UUID.randomUUID;

@Slf4j
public record CitizenUseCase(CitizenGateway citizenGateway) {

    public void create(final CitizenDomain citizenDomain) {
        log.info("Creating new citizen. {}", citizenDomain);
        citizenDomain.setId(randomUUID().toString());
        citizenGateway.save(citizenDomain);
    }

    public CitizenDomain findById(final String citizenId) {
        return citizenGateway.findById(citizenId).orElseThrow();
    }

    public void deleteCitizenById(final String citizenId) {
        citizenGateway.deleteById(citizenId);
    }

}
