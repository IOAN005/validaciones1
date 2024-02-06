package com.corenetworks.validaciones1.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmpleado;
   @Column(length = 60,nullable = false)
    private String nombreEmpleado;
   @Column(length = 9,nullable = false,unique = true)
    private String dni;
    @Column(nullable = false)
    private double sueldo;
}
