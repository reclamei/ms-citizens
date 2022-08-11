package br.com.reclamei.citizens.entrypoint.api.controller;

import br.com.reclamei.citizens.entrypoint.api.dto.CitizenCreateRequest;
import br.com.reclamei.citizens.entrypoint.api.dto.CitizenResponse;

public interface CitizenController {

    void createCitizen(final CitizenCreateRequest request);

    CitizenResponse findCitizenById(final String citizenId);

    void deleteCitizenById(final String citizenId);

}
