package ucla.si.controlador.gc.cliente;

import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import ucla.si.controlador.app.ControladorInicio;
import ucla.si.modelo.Persona;
import ucla.si.modelo.Usuario;
import ucla.si.servicio.ServicioUsuario;

public class ControladorCliente extends ControladorInicio {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@WireVariable
	private ServicioUsuario servicioUsuario;
	
	@Wire
	Textbox txt_nombre, txt_apellido, txt_cedula, txt_url_foto, txt_direccion, txt_telefono, 
	txt_correo, txt_contrasenna, txt_pregunta_secreta,txt_respuesta_secreta;
	@Wire
	Combobox cmb_sexo;
	@Wire
	Datebox dtb_fecha_nac;

	public ControladorCliente() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void inicializar() {
		// TODO Auto-generated method stub

	}
	
	@Listen("onClick =#btn_registrar")
	public void registrar(){
		if(txt_nombre.getValue().trim() == "" || txt_apellido.getValue().trim() =="" ||
			txt_cedula.getValue().trim() =="" || txt_direccion.getValue().trim() =="" || 
			txt_correo.getValue().trim() =="" || txt_contrasenna.getValue().trim() =="" ||
			txt_pregunta_secreta.getValue().trim() =="" || txt_respuesta_secreta.getValue().trim() =="" ||
			cmb_sexo.getSelectedItem().getValue() =="" || dtb_fecha_nac.getValue() == null){
			Messagebox.show("Debe llenar todos los campos", "Error", Messagebox.OK, Messagebox.ERROR);
		}
		else{
			String nombre = txt_nombre.getValue().trim();
			String apellido = txt_apellido.getValue().trim();
			String cedula = txt_cedula.getValue().trim();
			String url_foto = txt_url_foto.getValue().trim();
			String sexo = cmb_sexo.getValue().trim();
			String direccion = txt_direccion.getValue().trim();
			String telefono = txt_telefono.getValue().trim();
			Date fecha_nacimiento = dtb_fecha_nac.getValue();
			String estatus = "Activo";
			Persona persona = new Persona(nombre, apellido, cedula, url_foto, 
				sexo, direccion, telefono, fecha_nacimiento, estatus, new Date(), null);
			String correo = txt_correo.getValue().trim().toLowerCase();
			String contrasenna = DigestUtils.md5Hex(txt_contrasenna.getValue().trim());
			String pregunta = txt_pregunta_secreta.getValue().trim();
			String respuesta = txt_respuesta_secreta.getValue().trim();
			Usuario usuario = new Usuario(correo, contrasenna, pregunta, respuesta, estatus, 
				new Date(), null);
			if(servicioUsuario.registrarCliente(persona, usuario)){
				Messagebox.show("Registro exitoso", "Información", Messagebox.OK, Messagebox.INFORMATION);
				Executions.sendRedirect("/");
			}
			else{
				Messagebox.show("Error al guardar", "Error", Messagebox.OK, Messagebox.ERROR);
			}
		}
	}

}
