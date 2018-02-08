package dao.generic;

import java.io.Serializable;

public interface IGenericDAO<T, ID extends Serializable>
{
	public Class<T> getClasse();

	public T inserir(T objeto) throws Exception;

	public T atualizar(T objeto) throws Exception;

	public void excluir(T objeto) throws Exception;

	public T consultarPorId(Long id);

}