package br.com.zupacademy.ggwadera.casadocodigo.util.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {ExistsIdValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsId {
    String message() default "não existe um recurso com o id especificado";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    Class<?> domainClass();
}
