package com.neoris.turnosrotativos.validators;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = LegalAge.LegalAgeValidator.class)
@Documented
public @interface LegalAge {

  String message() default "must be of legal age";
  int value() default 18;


  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  class LegalAgeValidator implements ConstraintValidator<LegalAge, LocalDate> {

    private int legalAge;

    @Override
    public void initialize(LegalAge constraintAnnotation) {
      legalAge = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(LocalDate dateOfBird, ConstraintValidatorContext context) {
      if (dateOfBird == null) {
        return true;
      }
      LocalDate currentDate = LocalDate.now();

      Period age = Period.between(dateOfBird, currentDate);
      return age.getYears() >= legalAge;
    }
  }

}