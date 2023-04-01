package com.neoris.turnosrotativos.controllers;
import com.neoris.turnosrotativos.entities.Empleado;
import com.neoris.turnosrotativos.exceptions.ApiExceptionResponse;
import com.neoris.turnosrotativos.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/empleado")
public class ControllerEmpleado {

  @Autowired
  private EmpleadoService empleadoSvc;


  @PostMapping
  public ResponseEntity<?> saveEmpleado(@Valid @RequestBody Empleado empleado){

    Map<String, String> errors = new HashMap<>();

    if(empleadoSvc.findByEmail(empleado.getEmail()) != null ){
      errors.put("Email", "Ya existe un empleado con el email ingresado.");
    }

    if(empleadoSvc.findByNroDocumento(empleado.getNroDocumento()) != null){
      errors.put("NroDocumento", "Ya existe un empleado con el documento ingresado.");
    }

    if(!errors.isEmpty()){
      return  new ResponseEntity<>(new ApiExceptionResponse(errors, HttpStatus.CONFLICT), HttpStatus.CONFLICT);
    }

    return  new ResponseEntity<>(empleadoSvc.save(empleado), HttpStatus.CREATED);
  }

  @GetMapping
  public List<Empleado> getAll(){
    return  empleadoSvc.getAll();
  }
}
