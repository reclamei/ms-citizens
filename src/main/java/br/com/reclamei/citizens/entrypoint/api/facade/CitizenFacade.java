package br.com.reclamei.citizens.entrypoint.api.facade;

import br.com.reclamei.citizens.core.usecase.CitizenUseCase;
import br.com.reclamei.citizens.entrypoint.api.dto.CitizenCreateRequest;
import br.com.reclamei.citizens.entrypoint.api.dto.CitizenResponse;
import br.com.reclamei.citizens.entrypoint.api.mapper.CitizenApiMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CitizenFacade {

    private final CitizenApiMapper citizenApiMapper;
    private final CitizenUseCase citizenUseCase;

    public void createCitizen(final CitizenCreateRequest request) {
        var citizenDomain = citizenApiMapper.toDomain(request);
        citizenUseCase.create(citizenDomain);
    }

    public CitizenResponse findCitizenById(final String citizenId) {
        var citizenDomain = citizenUseCase.findById(citizenId);
        return citizenApiMapper.toResponse(citizenDomain);
    }

    public void deleteCitizenById(final String citizenId) {
        citizenUseCase.deleteCitizenById(citizenId);
    }

}
