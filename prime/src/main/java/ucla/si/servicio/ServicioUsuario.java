package ucla.si.servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import ucla.si.dao.UsuarioDAO;
import ucla.si.modelo.Persona;
import ucla.si.modelo.Usuario;

@Service("servicioUsuario")
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ServicioUsuario{
	@Autowired
	private UsuarioDAO usuarioDAO;

	public Usuario buscarUsuario(String correo, String contrasenna) {
		Usuario usuario = null;
		try {
			usuario = usuarioDAO.buscarUsuario(correo, contrasenna);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}
	
	public boolean registrarCliente(Persona persona, Usuario usuario){
		boolean guardado = false;
		try {
			guardado = usuarioDAO.registrarCliente(persona, usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return guardado;
	}

}
