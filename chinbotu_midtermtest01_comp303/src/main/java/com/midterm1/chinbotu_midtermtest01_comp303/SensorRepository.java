package com.midterm1.chinbotu_midtermtest01_comp303;
//imports reequired dependencies
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//sets up repository:
@Repository
//declares public interface called sensor repo, extending the Crudrepo function from spring framework API
public interface SensorRepository extends CrudRepository<Sensor, Integer> {
}
