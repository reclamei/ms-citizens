package br.com.reclamei.citizens.entrypoint.api.controller.impl;

import br.com.reclamei.citizens.entrypoint.api.controller.CitizenController;
import br.com.reclamei.citizens.entrypoint.api.dto.CitizenCreateRequest;
import br.com.reclamei.citizens.entrypoint.api.dto.CitizenResponse;
import br.com.reclamei.citizens.entrypoint.api.facade.CitizenFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/citizens")
@RequiredArgsConstructor
public class CitizenControllerImpl implements CitizenController {

    private final CitizenFacade citizenFacade;

    @Override
    @PostMapping
    public void createCitizen(final CitizenCreateRequest request) {
        citizenFacade.createCitizen(request);
    }

    @Override
    @GetMapping("/{citizenId}")
    public CitizenResponse findCitizenById(@PathVariable final String citizenId) {
        return citizenFacade.findCitizenById(citizenId);
    }

    @Override
    @DeleteMapping("/{citizenId}")
    public void deleteCitizenById(@PathVariable final String citizenId) {
        citizenFacade.deleteCitizenById(citizenId);
    }

}
