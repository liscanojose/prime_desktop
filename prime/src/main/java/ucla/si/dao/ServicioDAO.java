package ucla.si.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ucla.si.modelo.Servicio;

@Repository
public class ServicioDAO {

	@PersistenceContext
	private EntityManager em;

	@Transactional(readOnly = true)
	public Servicio buscarServicio(String codigo) {
		Servicio servicio = null;
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myapp");
			em = entityManagerFactory.createEntityManager();

			System.out.println("em " + em);

			Query query = em.createQuery("SELECT u FROM Servicio s " + " where s.codigo = ?1 ");
			query.setParameter(1, codigo).setMaxResults(1);
			servicio = query.getResultList().size() > 0 ? (Servicio) query.getResultList().get(0) : null;
			System.out.println("espacio de memoria usuario " + servicio);

			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return servicio;
	}

	// @Transactional(readOnly = true)
	// public List<Servicio> queryAll() {
	// Query query = em.createQuery("SELECT s FROM Servicio s");
	// List<Servicio> result = query.getResultList();
	// return result;
	// }

	@Transactional(readOnly = true)
	public Servicio get(Long id) {
		return em.find(Servicio.class, id);
	}

	@Transactional
	public Servicio save(Servicio servicio) {
		em.persist(servicio);
		em.flush();
		return servicio;
	}

	@Transactional
	public void delete(Servicio servicio) {
		Servicio r = get(servicio.getId());
		if (r != null) {
			em.remove(r);
		}
	}

}
