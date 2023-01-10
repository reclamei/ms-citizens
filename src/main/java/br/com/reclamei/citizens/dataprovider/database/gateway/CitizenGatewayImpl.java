package br.com.reclamei.citizens.dataprovider.database.gateway;

import br.com.reclamei.citizens.core.domain.CitizenDomain;
import br.com.reclamei.citizens.core.exception.NotFoundException;
import br.com.reclamei.citizens.core.gateway.CitizenGateway;
import br.com.reclamei.citizens.dataprovider.database.mapper.CitizenDatabaseMapper;
import br.com.reclamei.citizens.dataprovider.database.repository.CitizenRepository;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
public record CitizenGatewayImpl(CitizenDatabaseMapper citizenDatabaseMapper, CitizenRepository citizenRepository) implements CitizenGateway {

    @Override
    public void save(final CitizenDomain citizenDomain) {
        var citizenEntity = citizenDatabaseMapper.toEntity(citizenDomain);
        citizenRepository.save(citizenEntity);
    }

    @Override
    public CitizenDomain findById(final String citizenId) {
        return citizenRepository.findById(citizenId)
            .map(citizenDatabaseMapper::toDomain)
            .orElseThrow(() -> new NotFoundException(format("[CitizenGatewayImpl] :: findById :: Citizen with id %s not found", citizenId)));
    }

    @Override
    public void deleteById(final String citizenId) {
        if (!citizenRepository.existsById(citizenId)) {
            throw new NotFoundException(format("[CitizenGatewayImpl] :: deleteById :: Citizen with id %s not found", citizenId));
        }
        citizenRepository.deleteById(citizenId);
    }

    @Override
    public boolean existsByCpf(final String cpf) {
        return citizenRepository.existsByCpf(cpf);
    }

    @Override
    public boolean existsByEmail(final String email) {
        return citizenRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByPhone(final String phone) {
        return citizenRepository.existsByPhone(phone);
    }

}
