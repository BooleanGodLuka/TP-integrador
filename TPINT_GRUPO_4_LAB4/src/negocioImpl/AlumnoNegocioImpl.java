/*package negocioImpl;

import java.util.ArrayList;

import dominio.Alumno;
import negocio.AlumnoNegocio;

public class AlumnoNegocioImpl implements AlumnoNegocio {
	
	@Override
	public boolean agregar_alumno(Alumno alumno) {
		boolean estado=false;
		if(alumno.getNombre().trim().length()>0 && alumno.getApellido().trim().length()>0 && alumno.getDni().trim().length() > 0)
		{
			ArrayList<Alumno> personas =(ArrayList<Alumno>) usdao.leer_todo_alumno();
			if (!alumno.validar_exist(personas)) {
				estado=usdao.agregar_alumno(alumno);	
			}
			
		}
		return estado;
	}
	
	
	public AlumnoNegocioImpl() {
		// TODO Auto-generated constructor stub
	}

}

*/
