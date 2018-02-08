package anotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import auxiliares.EnumTelaBci;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CasoDeTeste
{
	String id() default "";

	String complemento() default "";

	String nome() default "";

	EnumTelaBci tela() default EnumTelaBci.CADASTRO;

	boolean fecharDriver() default false;

	String identificador() default "";

}
