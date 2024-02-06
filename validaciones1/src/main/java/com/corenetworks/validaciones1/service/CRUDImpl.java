package com.corenetworks.validaciones1.service;

import com.corenetworks.validaciones1.repository.IGenericoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public abstract class CRUDImpl <T,ID> implements ICRUD<T,ID>{
    @Autowired
    protected abstract IGenericoRepo <T,ID>getRepo();
    @Override
    public T crear(T t) {
        return getRepo().save(t);
    }

    @Override
    public T modificar(T t) {
        return getRepo().save(t);
    }

    @Override
    public void eliminar(ID id) {
        getRepo().deleteById(id);

    }

    @Override
    public T consultarUno(ID id) {
        return getRepo().findById(id).orElse(null);
    }

    @Override
    public List<T> consultarTodos() {
        return getRepo().findAll();
    }
}
