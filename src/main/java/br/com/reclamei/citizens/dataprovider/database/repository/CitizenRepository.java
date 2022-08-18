package br.com.reclamei.citizens.dataprovider.database.repository;

import br.com.reclamei.citizens.dataprovider.database.entity.CitizenEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitizenRepository extends MongoRepository<CitizenEntity, String> {

}
