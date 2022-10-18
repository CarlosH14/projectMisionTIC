package co.dev.project.mapper;

import org.mapstruct.Mapper;

import co.dev.project.domain.dto.VehiculoDto;
import co.dev.project.domain.model.Vehiculo;

@Mapper
public interface VehicleMapper {

    Vehiculo vehiculoDtoToVehiculo(VehiculoDto vehiculoDto);
    
    VehiculoDto vehiculoToVehiculoDto(Vehiculo vehiculo);
}
