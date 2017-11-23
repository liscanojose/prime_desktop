package ucla.si.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ucla.si.modelo.Grupo;

@Repository
public class GrupoDAO {
	
	@PersistenceContext 
	private EntityManager em;
	
	@Transactional
	public Grupo save(Grupo grupo) {
		em.persist(grupo);
		em.flush();
		return grupo;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Grupo> listarGrupos() {
		List<Grupo> grupos = new ArrayList<Grupo>();
		try {
			Query query = em.createQuery("SELECT g FROM Grupo g");
			grupos = (List<Grupo>) query.getResultList();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return grupos;
	}
	

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public boolean registrarGrupo(Grupo grupo){
		boolean guardado = false;
		try {
			if(save(grupo) != null){
				guardado = true;
			}
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
			guardado = false;
		}
		return guardado;
	}

}
