package com.corenetworks.validaciones1.controlador;

import com.corenetworks.validaciones1.dto.EmpleadoDTO;
import com.corenetworks.validaciones1.dto.ResumenDTO;
import com.corenetworks.validaciones1.excepciones.ExcepcionPersonalizadaNoEncontrado;
import com.corenetworks.validaciones1.modelo.Empleado;
import com.corenetworks.validaciones1.service.IEmpleadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoControlador {
    @Autowired
    private IEmpleadoService service;

    @PostMapping
    public ResponseEntity<EmpleadoDTO> crearEmpleado(@Valid @RequestBody EmpleadoDTO e) {
        System.out.println(e.toString());
        Empleado e1 = e.castEmpleado();
        e1 = service.crear(e1);
        return new ResponseEntity<>(e.castEmpleadoDto(e1), HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<EmpleadoDTO> modificarEmpleado(@Valid @RequestBody EmpleadoDTO e) {
        System.out.println(e.toString());
       Empleado e1=service.consultarUno(e.getIdEmpleado());
       if(e1==null){
           throw new ExcepcionPersonalizadaNoEncontrado("Empleado no Encontrado ->" +e.getIdEmpleado());
       }


        e1 = service.modificar(e.castEmpleado());
        return new ResponseEntity<>(e.castEmpleadoDto(e1), HttpStatus.OK);

    }
    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> consultarUno(@PathVariable(name = "id") Integer id){
        Empleado e1=service.consultarUno(id);
        if(e1==null){
            throw new ExcepcionPersonalizadaNoEncontrado("Empleado no Encontrado ->" +id);
        }
        return new ResponseEntity<>(new EmpleadoDTO().castEmpleadoDto(e1),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> eliminar(@PathVariable(name = "id") Integer id){
        Empleado e1=service.consultarUno(id);
        if(e1==null){
            throw new ExcepcionPersonalizadaNoEncontrado("Empleado no Encontrado ->" +id);
        }
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping
    public ResponseEntity<List<EmpleadoDTO>> consultartodos(){
        List<Empleado> empleadosBBDD=service.consultarTodos();
        List<EmpleadoDTO> empleadosDTO=new ArrayList<>();
        for (Empleado elemento:
                //comentario
            empleadosBBDD ) {

            empleadosDTO.add((new EmpleadoDTO()).castEmpleadoDto(elemento));
        }
        return new ResponseEntity<>(empleadosDTO,HttpStatus.OK);
    }
    @GetMapping("/resumenes")
    public ResponseEntity<List<ResumenDTO>> obtenerResumen(){
        return new ResponseEntity<>(service.obtenerResumenes(),HttpStatus.OK);
    }
}