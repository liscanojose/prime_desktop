package ucla.si.controlador.gc.grupo;

import java.util.Date;

import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import ucla.si.controlador.app.ControladorInicio;
import ucla.si.modelo.Grupo;
import ucla.si.servicio.ServicioGrupo;

public class ControladorGrupo extends ControladorInicio{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@WireVariable
	private ServicioGrupo servicioGrupo;
	
	@Wire
	Textbox txtNombre, txtDescripcion;

	@Override
	protected void inicializar() {
		// TODO Auto-generated method stub
	}
	
	@Listen("onClick =#btnRegistrar")
	public void registrar(){
		if(txtNombre.getValue().trim() == "" || txtDescripcion.getValue().trim() ==""){
			Messagebox.show("Debe llenar todos los campos", "Error", Messagebox.OK, Messagebox.ERROR);
		}
		else{
			String nombre = txtNombre.getValue().trim().toUpperCase();
			String descripcion = txtDescripcion.getValue().trim();
			String estatus = "Activo";
			Grupo grupo = new Grupo(nombre, descripcion, estatus, new Date(), null);
			if(servicioGrupo.registrarGrupo(grupo)){
				Messagebox.show("Registro exitoso", "Información", Messagebox.OK, Messagebox.INFORMATION);
				String dir = "gc/grupo/frm-grupo-catalogo.zul";
				clearDivApp(dir);
			}
			else{
				Messagebox.show("Error al guardar", "Error", Messagebox.OK, Messagebox.ERROR);
			}
		}
	}

}
