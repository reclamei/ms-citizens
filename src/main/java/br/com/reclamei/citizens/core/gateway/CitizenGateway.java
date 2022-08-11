package br.com.reclamei.citizens.core.gateway;

import br.com.reclamei.citizens.core.domain.CitizenDomain;

import java.util.Optional;

public interface CitizenGateway {

    void save(CitizenDomain citizenDomain);

    Optional<CitizenDomain> findById(String citizenId);

    void deleteById(String citizenId);

}
