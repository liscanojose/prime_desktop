package ucla.si.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ucla.si.modelo.Persona;
import ucla.si.modelo.Usuario;


@Repository
public class UsuarioDAO {

	@PersistenceContext 
	private EntityManager em;
	
	@Transactional(readOnly = true)
	public Usuario buscarUsuario(String correo, String contrasenna) {
		Usuario usuario = null;
		try {
			/*EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myapp");
			em = entityManagerFactory.createEntityManager();*/

			System.out.println("em "+em);
			
			Query query = em.createQuery("SELECT u FROM Usuario u "
					+ " where u.correo = ?1 "
					+ " and u.contrasenna = ?2 ");
			query.setParameter(1, correo).setParameter(2, contrasenna).setMaxResults(1);
			usuario = query.getResultList().size() > 0 ? (Usuario) query.getResultList().get(0) : null;
			System.out.println("espacio de memoria usuario "+usuario);
			if(usuario != null){
				Hibernate.initialize(usuario.getPersona());
			}
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}

//	@Transactional(readOnly = true)
//	public List<Usuario> queryAll() {
//		Query query = em.createQuery("SELECT u FROM Usuario u");
//		List<Usuario> result = query.getResultList();
//		return result;
//	}

	@Transactional(readOnly = true)
	public Usuario get(Long id) {
		return em.find(Usuario.class, id);
	}

	@Transactional
	public Usuario save(Usuario usuario) {
		em.persist(usuario);
		em.flush();
		return usuario;
	}
	
	@Transactional
	public Persona save(Persona persona) {
		em.persist(persona);
		em.flush();
		return persona;
	}
	
	/*Registrar Cliente*/
	/* esta anotacion permite que si ocurre un error la bd no tenga cambios 
	 * (propagation=Propagation.REQUIRED, rollbackFor=Exception.class) */
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public boolean registrarCliente(Persona persona, Usuario usuario){
		boolean guardado = false;
		try {
			/*Guardamos primero el objeto que sera padre
			 * en este caso persona*/
			Persona p = save(persona);
			/*validamos si al guardar devuelve un objeto persona*/
			if(p != null){
				System.out.println("entro");
				/*Si se guarda correctamente le asignamos a usuario el objeto persona
				 * ya que el usuario depende de persona*/
				usuario.setPersona(p);
				Usuario u = save(usuario);
				/*Si usuario es diferente de null entonces el proceso guardo correctamente 2 
				 * objetos relacionados */
				if(u != null){
					guardado = true;
				}
				else{
					guardado = false;
				}
			}
			em.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return guardado;
	}

	@Transactional
	public void delete(Usuario usuario) {
		Usuario r = get(usuario.getId());
		if(r != null) {
			em.remove(r);
		}
	}

}
