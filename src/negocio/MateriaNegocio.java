package negocio;

import java.util.List;

import dominio.Materia;

public interface MateriaNegocio {

	public boolean insert(Materia materia);

	public boolean delete(Materia materia_a_eliminar);

	public List<Materia> readall();

	public boolean update(Materia materia_a_modificar);

}
