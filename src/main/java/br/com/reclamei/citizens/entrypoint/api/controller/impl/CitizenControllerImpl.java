package br.com.reclamei.citizens.entrypoint.api.controller.impl;

import br.com.reclamei.citizens.entrypoint.api.controller.CitizenController;
import br.com.reclamei.citizens.entrypoint.api.dto.CitizenCreateRequest;
import br.com.reclamei.citizens.entrypoint.api.dto.CitizenResponse;
import br.com.reclamei.citizens.entrypoint.api.facade.CitizenFacade;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController("/citizens")
public record CitizenControllerImpl(CitizenFacade citizenFacade) implements CitizenController {

    @Override
    @PostMapping
    public void createCitizen(@Valid @RequestBody final CitizenCreateRequest request) {
        citizenFacade.createCitizen(request);
    }

    @Override
    @GetMapping("/{citizenId}")
    public CitizenResponse findCitizenById(@PathVariable final UUID citizenId) {
        return citizenFacade.findCitizenById(citizenId.toString());
    }

    @Override
    @DeleteMapping("/{citizenId}")
    public void deleteCitizenById(@PathVariable final UUID citizenId) {
        citizenFacade.deleteCitizenById(citizenId.toString());
    }

}
