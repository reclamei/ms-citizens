package br.com.reclamei.citizens.dataprovider.database.mapper;

import br.com.reclamei.citizens.core.domain.CitizenDomain;
import br.com.reclamei.citizens.dataprovider.database.entity.CitizenEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CitizenDatabaseMapper {

    CitizenDomain toDomain(CitizenEntity citizenEntity);

    CitizenEntity toEntity(CitizenDomain citizenDomain);

}
