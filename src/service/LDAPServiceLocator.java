package service;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class LDAPServiceLocator
{
	protected static LDAPServiceLocator instance;

	private LDAPServiceLocator()
	{
		super();
	}

	public static LDAPServiceLocator getInstance()
	{
		if ( instance == null )
		{
			instance = new LDAPServiceLocator();
		}
		return instance;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DirContext getContext()
	{
		Hashtable env = new Hashtable(5);
		
		env.put(Context.SECURITY_AUTHENTICATION, "simple");

		env.put(Context.INITIAL_CONTEXT_FACTORY, LDAPParametrosConfig.INITIAL_CTX);
		
		env.put(Context.SECURITY_PRINCIPAL, LDAPParametrosConfig.BASE_DN);
		
		env.put(Context.SECURITY_CREDENTIALS, LDAPParametrosConfig.ADMIN_PW);
		
		env.put(Context.PROVIDER_URL, LDAPParametrosConfig.SERVIDOR);

		DirContext ctx = null;
		try
		{
			ctx = new InitialDirContext(env);
		}
		catch (NamingException e)
		{
			System.out.println("Não foi possivel obter um contexto LDAP");
			e.printStackTrace();
		}
		return ctx;
	}
}