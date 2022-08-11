package br.com.reclamei.citizens.entrypoint.api.mapper;

import br.com.reclamei.citizens.core.domain.CitizenDomain;
import br.com.reclamei.citizens.entrypoint.api.dto.CitizenCreateRequest;
import br.com.reclamei.citizens.entrypoint.api.dto.CitizenResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CitizenApiMapper {

    CitizenDomain toDomain(CitizenCreateRequest citizenCreateRequest);

    CitizenResponse toResponse(CitizenDomain citizenDomain);

}
