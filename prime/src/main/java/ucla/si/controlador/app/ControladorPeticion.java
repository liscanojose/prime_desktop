package ucla.si.controlador.app;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Messagebox;

import ucla.si.modelo.Usuario;
import ucla.si.servicio.ServicioUsuario;
import ucla.si.dao.*;

/**
 * Servlet implementation class ControladorPeticion
 */
public class ControladorPeticion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServicioUsuario servicioUsuarioImpl = new ServicioUsuario();

	/**
	 * Default constructor.
	 */
	public ControladorPeticion() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		peticionAcceso(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		peticionAcceso(request, response);
	}

	public void getUsuario() {
		try {
			Class generico = Class.forName("panel.Administrador.aplicacion.controlador.componente.ControladorMenu");
			String metodo = "escribir";
			Object obj;
			obj = (ControladorMenu) generico.getConstructor(null).newInstance(null);
			obj.getClass().getMethod(metodo, null).invoke(obj, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void peticionAcceso(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String origen = request.getParameter("origen");
		String correo = request.getParameter("correo");
		String contrasenna = request.getParameter("contrasenna");
		Usuario usuario = servicioUsuarioImpl.buscarUsuario(correo, contrasenna);
		if (usuario != null) {
			getUsuario();
			response.sendRedirect("/Administrador/prime/index.zul");
			System.out.println("persona " + usuario.getPersona().getNombre());
		} else {
			response.sendRedirect("http://www.google.co.ve");
		}
	}

}
