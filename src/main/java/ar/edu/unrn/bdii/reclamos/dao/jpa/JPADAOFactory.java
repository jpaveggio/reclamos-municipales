package ar.edu.unrn.bdii.reclamos.dao.jpa;

import ar.edu.unrn.bdii.reclamos.dao.CanjeDAO;
import ar.edu.unrn.bdii.reclamos.dao.CategoriaDAO;
import ar.edu.unrn.bdii.reclamos.dao.CiudadanoDAO;
import ar.edu.unrn.bdii.reclamos.dao.DAOFactory;
import ar.edu.unrn.bdii.reclamos.dao.EventoDAO;
import ar.edu.unrn.bdii.reclamos.dao.PremioDAO;
import ar.edu.unrn.bdii.reclamos.dao.ReclamoDAO;

public abstract class JPADAOFactory extends DAOFactory {
	
	public JPADAOFactory() {}

	@Override
	public abstract CanjeDAO getCanjeDAO() throws Exception;

	@Override
	public abstract CategoriaDAO getCategoriaDAO() throws Exception;

	@Override
	public abstract CiudadanoDAO getCiudadanoDAO() throws Exception;

	@Override
	public abstract EventoDAO getEventoDAO() throws Exception;

	@Override
	public abstract PremioDAO getPremioDAO() throws Exception;

	@Override
	public abstract ReclamoDAO getReclamoDAO() throws Exception;

	@Override
	public void begin() throws Exception {
		JPAUtil.getEntityManagerFactory().createEntityManager().getTransaction().begin();
	}

	@Override
	public void commit() throws Exception {
		JPAUtil.getEntityManagerFactory().createEntityManager().getTransaction().commit();
	}
}
