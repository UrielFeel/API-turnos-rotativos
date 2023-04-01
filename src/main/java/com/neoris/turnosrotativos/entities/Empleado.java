package com.neoris.turnosrotativos.entities;

import com.neoris.turnosrotativos.validators.LegalAge;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@Entity
public class Empleado {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true)
  @NotNull(message = "'nro_documento' es obligatorio.")
  private Integer nroDocumento;

  @NotEmpty(message = "'nombre' es obligatorio.")
  @Pattern(regexp = "^[a-zA-Z]+$", message = "Solo se permiten letras en el campo nombre.")
  private String nombre;

  @NotEmpty(message = "'apellido' es obligatorio.")
  @Pattern(regexp = "^[a-zA-Z]+$", message = "Solo se permiten letras en el campo apellido.")
  private String apellido;

  @Column(unique = true)
  @NotEmpty(message = "'email' es obligatorio.")
  @Email(message = "El email ingresado no es correcto.")
  private String email;

  @NotNull(message = "'fecha_nacimiento' es obligatorio.")
  @Past(message = "La fecha de nacimiento no puede ser posterior al día de la fecha.")
  @LegalAge(message = "La edad del empleado no puede ser menor a 18 años.")
  private LocalDate fechaNacimiento;


  @NotNull(message = "'fecha_ingreso' es obligatorio.")
  @Past(message = "La fecha de ingreso no puede ser posterior al día de la fecha.")
  private LocalDate fechaIngreso;

  private LocalDate fechaCreacion;
}
