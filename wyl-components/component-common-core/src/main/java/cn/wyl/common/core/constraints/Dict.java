package cn.wyl.common.core.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {DictValidatorForCharSequence.class}
)
public @interface Dict {
    String message() default "{com.wyl.constraints.Dict.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String type() default "";
}
