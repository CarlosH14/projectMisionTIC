package co.dev.project.domain.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoDto implements Serializable {
    private String id;
    private String color;
    private String marca;
    private String modelo;
    private Boolean usado;
}
