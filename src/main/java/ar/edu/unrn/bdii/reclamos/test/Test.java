package ar.edu.unrn.bdii.reclamos.test;

import javax.persistence.EntityManager;

import ar.edu.unrn.bdii.reclamos.dao.jpa.JPAUtil;
import ar.edu.unrn.bdii.reclamos.model.Canje;
import ar.edu.unrn.bdii.reclamos.model.Categoria;
import ar.edu.unrn.bdii.reclamos.model.Ciudadano;
import ar.edu.unrn.bdii.reclamos.model.Direccion;
import ar.edu.unrn.bdii.reclamos.model.Evento;
import ar.edu.unrn.bdii.reclamos.model.Premio;
import ar.edu.unrn.bdii.reclamos.model.Reclamo;

public class Test {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Categoria categoria = new Categoria("General", 20);
			em.persist(categoria);
			Premio premio = new Premio("Canasto de basura", 30);
			em.persist(premio);
			Ciudadano ciudadano = new Ciudadano("Juan Pablo", "Aveggio", "33416794", "jpaveggio@unrn.edu.ar");
			em.persist(ciudadano);
			Reclamo reclamo1 = new Reclamo("Se me cayo un arbol en la cabeza", ciudadano, new Direccion("Caseros", "1150"), categoria);
			ciudadano.crearReclamo(reclamo1);
			//em.persist(reclamo1);
			Evento evento = new Evento("Se constato el hecho", reclamo1);
			reclamo1.addEvento(evento);
			//em.persist(evento);
			Reclamo reclamo2 = new Reclamo("Reventó el contenedor de la esquina", ciudadano, new Direccion("Belgrano", "200"), categoria);
			ciudadano.crearReclamo(reclamo2);
			//em.persist(reclamo2);
			Canje canje = ciudadano.canjearPuntos(premio);
			//em.persist(canje);
			em.getTransaction().commit();
		} catch(Exception e) {
			em.getTransaction().rollback();
			System.err.println("Ha ocurrido un error");
			throw new RuntimeException(e);
			
		} finally {
			em.close();
		}
	}
}
