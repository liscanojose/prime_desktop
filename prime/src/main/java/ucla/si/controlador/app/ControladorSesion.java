package ucla.si.controlador.app;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import ucla.si.modelo.Usuario;
import ucla.si.servicio.ServicioUsuario;

public class ControladorSesion extends ControladorInicio {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@WireVariable
	private ServicioUsuario servicioUsuario;
	
	@Override
	protected void inicializar() {
		
	}
	
	/*Componentes*/
	@Wire
	Textbox txt_correo, txt_contrasenna;
	
	@Listen("onClick = #btn_entrar")
	public void entrar(){
		if(txt_correo.getValue().trim() =="" || txt_contrasenna.getValue().trim() == ""){
			Messagebox.show("Completar los campos", "Información", Messagebox.OK, Messagebox.INFORMATION);
		}
		else{
			String correo = txt_correo.getValue().trim().toLowerCase();
			String contrasenna = DigestUtils.md5Hex(txt_contrasenna.getValue().trim());
			System.out.println("correo: "+correo);
			System.out.println("contrasenna "+contrasenna);
			Usuario usuario = servicioUsuario.buscarUsuario(correo, contrasenna);
			if(usuario != null){
				Executions.sendRedirect("prime/index.zul");
				System.out.println("persona "+usuario.getPersona().getNombre());
			}
			else{
				Messagebox.show("El correo o contraseña invalido", "Información", Messagebox.OK, Messagebox.INFORMATION);
			}
		}
		
	}

}
