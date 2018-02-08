package service;

import java.util.Hashtable;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchResult;

public class TesteLDAP
{
	@SuppressWarnings("rawtypes")
	public static void main(String[] args)
	{
		String login = "208396";
		String senha = "Mecb73640128*";

		DirContext ctx = LDAPServiceLocator.getInstance().getContext();
		Attributes matchAttrs = new BasicAttributes(false);

		String[] atributosRetorno = new String[] { LDAPParametrosConfig.UID_FIELD };

		matchAttrs.put(new BasicAttribute(LDAPParametrosConfig.UID_FIELD, login));
		matchAttrs.put(new BasicAttribute("userPassword", senha));
		System.out.println("Buscando...");
		try
		{
			TesteLDAP.login(login,senha);

			NamingEnumeration resultado = ctx.search(LDAPParametrosConfig.SEARCHBASE,
					matchAttrs, atributosRetorno);

			while (resultado.hasMore())
			{
				SearchResult sr = (SearchResult) resultado.next();
				// Obtem os atributos
				Attributes atributos = sr.getAttributes();
				for (NamingEnumeration todosAtributos = atributos.getAll(); todosAtributos
						.hasMore();)
				{
					Attribute attrib = (Attribute) todosAtributos.next();
					String nomeAtributo = attrib.getID();
					System.out.println("Atributo:" + nomeAtributo);
					// Exibe todos os valores do atributo
					for (NamingEnumeration e = attrib.getAll(); e.hasMore();)
					{
						System.out.println("\tvalor:" + e.next());
					}
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("Busca finalizada.");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void login(String usuario, String senha)
	{
		Hashtable authEnv = new Hashtable(11);
		authEnv.put(Context.INITIAL_CONTEXT_FACTORY,
				"com.sun.jndi.ldap.LdapCtxFactory");
		authEnv.put(Context.PROVIDER_URL, LDAPParametrosConfig.SERVIDOR);
		authEnv.put(Context.SECURITY_AUTHENTICATION, "simple");
		authEnv.put(Context.SECURITY_PRINCIPAL, usuario + "@int.cagece.com.br");
		authEnv.put(Context.SECURITY_CREDENTIALS, senha);

		try
		{
			DirContext authContext = new InitialDirContext(authEnv);
			System.out.println(authContext.getAttributes(LDAPParametrosConfig.UID_FIELD));

			System.out.println("Autenticado!");
		}
		catch (AuthenticationException authEx)
		{

			System.out.println("Erro na autenticação! ");
			authEx.getCause().printStackTrace();
		}
		catch (NamingException namEx)
		{
			System.out.println("Problemas na conexão! ");
			namEx.getCause().printStackTrace();
		}

	}

}