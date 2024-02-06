package com.corenetworks.validaciones1.service;

import com.corenetworks.validaciones1.dto.ResumenDTO;
import com.corenetworks.validaciones1.modelo.Empleado;

import java.util.List;

public interface IEmpleadoService extends ICRUD<Empleado,Integer>{
    public List<ResumenDTO> obtenerResumenes();
}
