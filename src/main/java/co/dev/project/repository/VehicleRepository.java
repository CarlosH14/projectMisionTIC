package co.dev.project.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.dev.project.domain.model.Vehiculo;

@Repository
public interface VehicleRepository extends JpaRepository<Vehiculo, String> {
    
}
