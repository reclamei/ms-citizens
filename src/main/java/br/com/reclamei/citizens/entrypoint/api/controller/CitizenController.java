package br.com.reclamei.citizens.entrypoint.api.controller;

import br.com.reclamei.citizens.entrypoint.api.dto.CitizenCreateRequest;
import br.com.reclamei.citizens.entrypoint.api.dto.CitizenResponse;
import br.com.reclamei.citizens.entrypoint.api.facade.CitizenFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

@RestController("/citizens")
@RequiredArgsConstructor
public class CitizenController implements CitizensApi {

    private final CitizenFacade citizenFacade;

    @Override
    @PostMapping
    public ResponseEntity<Void> createCitizen(@Valid @RequestBody final CitizenCreateRequest request) {
        citizenFacade.createCitizen(request);
        return ResponseEntity.status(CREATED).build();
    }

    @Override
    @DeleteMapping("/{citizenId}")
    public ResponseEntity<Void> deleteCitizenById(@PathVariable final String citizenId) {
        citizenFacade.deleteCitizenById(citizenId);
        return ResponseEntity.status(NO_CONTENT).build();
    }

    @Override
    @GetMapping("/{citizenId}")
    public ResponseEntity<CitizenResponse> findCitizenById(@PathVariable final String citizenId) {
        return ResponseEntity.status(OK).body(citizenFacade.findCitizenById(citizenId));
    }

}
