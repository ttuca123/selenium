package br.com.cagece.prax.bci;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Exemplo
{

	public static void main(String[] args) throws ClassNotFoundException
	{
		Class cls = Class.forName("br.com.cagece.prax.bci.TelaCadastroBCITest");
		Method[] methods = cls.getDeclaredMethods();
		System.out.println("METODOS DA CLASSE");
		for (int i = 0; i < methods.length; i++)
		{
			Method m = methods[i];
			System.out.println(m);
			System.out.println("NOME DO MÉTODO ------> " + m.getName());
			System.out.println("PACOTE (Classe) ------> " + m.getDeclaringClass());
			System.out.println("MODIFICADOR ------> "
					+ Modifier.toString(m.getModifiers()));
			Class pvec[] = m.getParameterTypes();
			for (int j = 0; j < pvec.length; j++)
				System.out.println("PARÂMETRO #" + j + " " + pvec[j]);
			Class evec[] = m.getExceptionTypes();
			for (int j = 0; j < evec.length; j++)
				System.out.println("EXCEÇÃO #" + j + " " + evec[j]);
			System.out.println("TIPO DE RETORNO ------> " + m.getReturnType());
			System.out.println("-----");
		}
	}
}
