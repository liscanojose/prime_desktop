package ucla.si.controlador.app;

import java.util.Map;

import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.Messagebox;

import ucla.si.modelo.Usuario;

public class ControladorMenu extends ControladorInicio {

	private static final long serialVersionUID = 1L;

	public ControladorMenu() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void inicializar() {
		if (autenticados != null) {
			if (autenticados.containsKey("hola")) {
				Usuario usuario = autenticados.get("hola");
				System.out.println("usuario " + usuario.getCorreo());
			}
		}
		System.out.println("sesion cant: " + Sessions.getCount());
	}

	@Listen("onClick =#dashboard")
	public void aCambiarContrasenna() {
		String dir = "content.zul";
		clearDivApp(dir);
		// Clients.evalJavaScript("document.title = 'ServiAldanas'; ");
	}

	@Listen("onClick =#informacion")
	public void aInformacion() {
		String dir = "gc/frm-servicios.zul";
		clearDivApp(dir);
		// Clients.evalJavaScript("document.title = 'ServiAldanas'; ");
	}
	
	@Listen("onClick =#grupos")
	public void aGrupos() {
		String dir = "gc/grupo/frm-grupo-catalogo.zul";
		clearDivApp(dir);
		// Clients.evalJavaScript("document.title = 'ServiAldanas'; ");
	}
	
	@Listen("onClick =#usuarios")
	public void aUsuarios() {
		String dir = "gc/grupo/frm-grupo.zul";
		clearDivApp(dir);
		// Clients.evalJavaScript("document.title = 'ServiAldanas'; ");
	}

	@Listen("onClick =#msg2")
	public void msg() {
		Messagebox.show("hola");
	}

	public void escribir() {
		Map<String, Usuario> autenticados = getAutenticados();
		Usuario usuario = new Usuario();
		usuario.setCorreo("dreik@gmail.com");
		autenticados.put("hola", usuario);
	}

}
