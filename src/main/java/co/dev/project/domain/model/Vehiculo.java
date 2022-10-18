package co.dev.project.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="vehiculo")
public class Vehiculo {

    @Id
    @Column(unique = true, nullable = false)
    String id;
    @Column(name = "color", nullable = false)
    String color;
    @Column(name = "marca", nullable = false)
    String marca;
    @Column(name = "modelo", nullable = false)
    String modelo;
    @Column(name = "usado", nullable = false)
    Boolean usado;
    
}
