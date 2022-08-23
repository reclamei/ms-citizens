package br.com.reclamei.citizens.entrypoint.api.controller;

import br.com.reclamei.citizens.entrypoint.api.dto.CitizenCreateRequest;
import br.com.reclamei.citizens.entrypoint.api.dto.CitizenResponse;

import java.util.UUID;

public interface CitizenController {

    // TODO add swagger documentation
    void createCitizen(final CitizenCreateRequest request);

    // TODO add swagger documentation
    CitizenResponse findCitizenById(final UUID citizenId);

    // TODO add swagger documentation
    void deleteCitizenById(final UUID citizenId);

}
