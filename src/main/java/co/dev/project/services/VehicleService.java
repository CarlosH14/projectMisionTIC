package co.dev.project.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.dev.project.domain.dto.VehiculoDto;
import co.dev.project.domain.model.Vehiculo;
import co.dev.project.mapper.VehicleMapper;
import co.dev.project.repository.VehicleRepository;

@Service
public class VehicleService {
    
    @Autowired
    VehicleRepository vehicleRepository;

    private VehicleMapper vehicleMapper = Mappers.getMapper(VehicleMapper.class);

    public String saveVehicle(VehiculoDto vehiculoDto){
        Vehiculo vehiculo = new Vehiculo();
        vehiculo = vehicleMapper.vehiculoDtoToVehiculo(vehiculoDto);
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        vehiculo.setId(generatedString);
        vehicleRepository.save(vehiculo);
        return "Saved";
    }

    public List<VehiculoDto> showAll(){
        List<Vehiculo> vehicleList= vehicleRepository.findAll();
        List<VehiculoDto> dtoList = new ArrayList<>();
        vehicleList.stream().forEach(v -> dtoList.add(vehicleMapper.vehiculoToVehiculoDto(v)));
        return dtoList;
    }

    public String deleteVehicle(String id){
        Optional<Vehiculo> v = vehicleRepository.findById(id);
        if(v.isPresent()){
            try {
                vehicleRepository.delete(v.get());
                return "Deleted";
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return "Failed to delete";
    }

    public VehiculoDto getVehiculoById(String id){
        Optional<Vehiculo> v = vehicleRepository.findById(id);
        if (v.isPresent()) {
            return vehicleMapper.vehiculoToVehiculoDto(v.get());
        }
        return null;
    }

}
