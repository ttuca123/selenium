package auxiliares;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import br.com.cagece.prax.automatizacao.srv012.Srv012CortePorInfracao;

public class Execucao
{

	public static void main(String[] args)
	{
		Thread thread = new Thread("Grid 1")
		{
			public void run()
			{

				TestListenerAdapter tla1 = new TestListenerAdapter();
				TestNG testng1 = new TestNG();
				testng1.setTestClasses(new Class[] { Srv012CortePorInfracao.class });
				testng1.addListener(tla1);
				testng1.run();
			}
		};

		thread.start();

	}
}
