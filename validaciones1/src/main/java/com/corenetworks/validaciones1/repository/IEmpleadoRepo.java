package com.corenetworks.validaciones1.repository;

import com.corenetworks.validaciones1.dto.ResumenDTO;
import com.corenetworks.validaciones1.modelo.Empleado;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IEmpleadoRepo extends IGenericoRepo<Empleado ,Integer> {
    @Query(value = " select count(id_empleado)as contador,avg (sueldo)as sueldo_promedio from public.empleados;",nativeQuery = true)
    public List<ResumenDTO> obtenerResumenes();
}
