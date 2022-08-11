package br.com.reclamei.citizens.dataprovider.database.gateway;

import br.com.reclamei.citizens.core.domain.CitizenDomain;
import br.com.reclamei.citizens.core.gateway.CitizenGateway;
import br.com.reclamei.citizens.dataprovider.database.entity.CitizenEntity;
import br.com.reclamei.citizens.dataprovider.database.mapper.CitizenDatabaseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CitizenGatewayImpl implements CitizenGateway {

    private final CitizenDatabaseMapper citizenDatabaseMapper;

    @Override
    public void save(final CitizenDomain citizenDomain) {
        citizenDatabaseMapper.toEntity(citizenDomain);
        // TODO repository
    }

    @Override
    public Optional<CitizenDomain> findById(final String citizenId) {
        // TODO repository
        return Optional.of(citizenDatabaseMapper.toDomain(new CitizenEntity()));
    }

    @Override
    public void deleteById(final String citizenId) {
        // TODO repository
    }

}
