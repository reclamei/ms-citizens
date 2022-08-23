package br.com.reclamei.citizens.core.gateway;

import br.com.reclamei.citizens.core.domain.CitizenDomain;

public interface CitizenGateway {

    void save(CitizenDomain citizenDomain);

    CitizenDomain findById(String citizenId);

    void deleteById(String citizenId);

    boolean existsByCpf(String cpf);

    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);

}
