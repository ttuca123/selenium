package anotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import enumerators.EnumServico;
import enumerators.EnumTipoPagamento;
import enumerators.EnumUsuario;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MetodoDeTeste {

	String nrCaso() default "";

	String caso() default "";

	EnumTipoPagamento tipoPagamento() default EnumTipoPagamento.SEM_CUSTO;

	EnumServico servicoCasado() default EnumServico.NENHUM;

	EnumUsuario usuario() default EnumUsuario.ADMINISTRADOR;

}
