package com.neoris.turnosrotativos.services;
import com.neoris.turnosrotativos.entities.Empleado;
import com.neoris.turnosrotativos.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class EmpleadoService {
  @Autowired
  EmpleadoRepository empleadoRepo;

  public Empleado save(Empleado empleado){
    empleado.setFechaCreacion(LocalDate.now());
    return empleadoRepo.save(empleado);
  }

  public Empleado findByEmail(String email){
    return empleadoRepo.findByEmail(email);
  }

  public Empleado findByNroDocumento(Integer nroDocumento){
    return empleadoRepo.findByNroDocumento(nroDocumento);
  }

  public List<Empleado> getAll(){
    return empleadoRepo.findAll();
  }


}
