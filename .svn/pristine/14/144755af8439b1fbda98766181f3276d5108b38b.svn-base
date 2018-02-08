package managed;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ViewScoped
@ManagedBean(name = "loginBean")
public class LoginBean
{
	private String username;

	private String password;

	public String validateUser()
	{

		FacesMessage msg = null;

		boolean isValidUser = false;

		if ( username.equalsIgnoreCase("admin")
				&& password.equalsIgnoreCase("admin") )
		{
			return "/faces/index.xhtml?faces-redirect=true";
		}
		else
		{
			msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Usuário ou senha Inválida", "Credenciais Inválidas");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return null;
		}
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}
}
