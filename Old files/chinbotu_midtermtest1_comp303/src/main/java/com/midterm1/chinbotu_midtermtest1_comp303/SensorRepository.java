package com.midterm1.chinbotu_midtermtest1_comp303;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends CrudRepository<Sensor, Long> {
}