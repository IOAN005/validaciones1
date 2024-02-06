package com.corenetworks.validaciones1.service;

import com.corenetworks.validaciones1.dto.ResumenDTO;
import com.corenetworks.validaciones1.modelo.Empleado;
import com.corenetworks.validaciones1.repository.IEmpleadoRepo;
import com.corenetworks.validaciones1.repository.IGenericoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServicioImpl extends CRUDImpl<Empleado,Integer> implements IEmpleadoService{
    @Autowired
    private IEmpleadoRepo repo;
    @Override
    protected IGenericoRepo<Empleado, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<ResumenDTO> obtenerResumenes() {
        return repo.obtenerResumenes();
    }
}
