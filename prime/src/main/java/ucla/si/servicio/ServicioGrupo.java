package ucla.si.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import ucla.si.dao.GrupoDAO;
import ucla.si.modelo.Grupo;

@Service("servicioGrupo")
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ServicioGrupo {
	
	@Autowired
	private GrupoDAO grupoDAO;
	
	public boolean registrarGrupo(Grupo grupo){
		boolean guardado = false;
		try {
			guardado = grupoDAO.registrarGrupo(grupo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return guardado;
	}
	
	public List<Grupo> listarGrupos(){
		List<Grupo> grupos = new ArrayList<Grupo>();
		try {
			grupos = grupoDAO.listarGrupos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return grupos;
	}

}
