package co.dev.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.dev.project.domain.dto.VehiculoDto;
import co.dev.project.services.VehicleService;

@RestController
@RequestMapping("/vehicle")
public class VehiculoController {

    @Autowired
    VehicleService vehicleService;

    @GetMapping
    public ResponseEntity<List<VehiculoDto>> showAllVehicles() {
        return new ResponseEntity<>(vehicleService.showAll(), (HttpStatus.FOUND));
    }

    @PostMapping
    public ResponseEntity<String> saveVehicle(@RequestBody VehiculoDto vehiculoDto) {
        return new ResponseEntity<>(vehicleService.saveVehicle(vehiculoDto), (HttpStatus.CREATED));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVehicle(@PathVariable("id") String id) {
        return new ResponseEntity<>(vehicleService.deleteVehicle(id), (HttpStatus.OK));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehiculoDto> getVehiculoById(@RequestParam("id") String id){
        return new ResponseEntity<>(vehicleService.getVehiculoById(id), (HttpStatus.FOUND));
    }

}
