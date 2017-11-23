package ucla.si.controlador.gc.grupo;

import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;

import ucla.si.controlador.app.ControladorInicio;
import ucla.si.modelo.Grupo;
import ucla.si.servicio.ServicioGrupo;

public class ControladorGrupoListar extends ControladorInicio{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@WireVariable
	private ServicioGrupo servicioGrupo;
	
	@Wire
	Listbox listGrupos;

	@Override
	protected void inicializar() {
		ListModelList<Grupo> modeloGrupos = new ListModelList<Grupo>(servicioGrupo.listarGrupos());
		modeloGrupos.setMultiple(false);
		listGrupos.setModel(modeloGrupos);
		listGrupos.setMultiple(false);
		listGrupos.setCheckmark(true);
	}
	
	@Listen("onClick =#mItemRegistrar")
	public void mItemRegistrar() {
		String dir = "gc/grupo/frm-grupo-registro.zul";
		clearDivApp(dir);
		// Clients.evalJavaScript("document.title = 'ServiAldanas'; ");
	}

}
