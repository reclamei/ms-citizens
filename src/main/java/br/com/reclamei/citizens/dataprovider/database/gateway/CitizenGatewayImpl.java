package br.com.reclamei.citizens.dataprovider.database.gateway;

import br.com.reclamei.citizens.core.domain.CitizenDomain;
import br.com.reclamei.citizens.core.gateway.CitizenGateway;
import br.com.reclamei.citizens.dataprovider.database.mapper.CitizenDatabaseMapper;
import br.com.reclamei.citizens.dataprovider.database.repository.CitizenRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public record CitizenGatewayImpl(CitizenDatabaseMapper citizenDatabaseMapper, CitizenRepository citizenRepository) implements CitizenGateway {

    @Override
    public void save(final CitizenDomain citizenDomain) {
        var citizenEntity = citizenDatabaseMapper.toEntity(citizenDomain);
        citizenRepository.save(citizenEntity);
    }

    @Override
    public Optional<CitizenDomain> findById(final String citizenId) {
        return citizenRepository.findById(citizenId)
            .map(citizenDatabaseMapper::toDomain);
    }

    @Override
    public void deleteById(final String citizenId) {
        citizenRepository.deleteById(citizenId);
    }

}
