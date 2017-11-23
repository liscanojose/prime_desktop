package ucla.si.controlador.gc;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.apache.poi.ss.usermodel.Textbox;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.CreateEvent;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Intbox;

import antlr.collections.List;
import ucla.si.dao.ServicioDAO;
import ucla.si.modelo.Usuario;
import ucla.si.modelo.Servicio;

public class ControladorServicio extends SelectorComposer<Component> {

	private Servicio servicio =  new Servicio();
	private Button btnGuardar;
	@Wire
	private Button btnModificar, btnEliminarRetencion, btnAgregarRetencion, btnAgregarEspecialidad,
			btnEliminarEspecialidad, btnAgregarTipoPago, btnEliminarTipoPago;

	@Wire
	private Combobox cmbEstatus;

	@Wire
	private Textbox txt_codigo, txt_descripcion;

	@Wire
	private Intbox int_precio;

	@Listen("onClick =#btnGuardar2")
	public void msg() {

		Messagebox.show("hola");

	}

	/*
	 * @Listen("onClick =#btnGuardar") public void aCambiarContrasenna() {
	 * //String dir = "vista/content.zul"; String dir = "vista/content.zul";
	 * 
	 * //Clients.evalJavaScript("document.title = 'ServiAldanas'; "); }
	 */

	@Listen("onClick =#btnGuardar")
	public void guardarServicio() {

		boolean error = false;

		try {

			String codigo;
			String descripcion;
			double precio;
			String estatus;
			

			//estatus = cmbEstatus.getValue().trim();
			//System.out.println(estatus);

			// codigo= txt_codigo.toString();
		
			codigo = txt_codigo.toString();
			System.out.println(codigo);
			precio = int_precio.getValue();
			System.out.println(precio);

			// Datos Generales

			servicio.setCodigo(codigo);
			//servicio.setEstatus(estatus);
			servicio.setEstatus("1");
			servicio.setPrecio(precio);

			ServicioDAO servicioDao = new ServicioDAO();
			servicioDao.save(servicio); // System.out.println("1");

		} catch (org.springframework.transaction.TransactionTimedOutException e) {
			Messagebox.show("¡Tiempo Expirado para la transacción!", "Información", Messagebox.OK, Messagebox.ERROR);
		} catch (org.hibernate.TransactionException e) {
			Messagebox.show("¡Tiempo Expirado para la transacción!", "Información", Messagebox.OK, Messagebox.ERROR);
		} catch (Exception e) {
			e.printStackTrace();
			error = true;
			Messagebox.show("¡Error al guardar el  servicio!", "Error", Messagebox.OK, Messagebox.ERROR);

		}

		Messagebox.show("Servicio registrado exitosamente");

	}

}
