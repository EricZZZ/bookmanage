package com.eric.bookmanage.domain.validation.books;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER,ElementType.TYPE})
@Constraint(validatedBy = BooksValidation.NotConflictBooksValidator.class)
public @interface NotConflictBooks {
    String message() default "标题、作者、出版日期产生重复";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
