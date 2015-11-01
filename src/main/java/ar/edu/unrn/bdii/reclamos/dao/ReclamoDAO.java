package ar.edu.unrn.bdii.reclamos.dao;

import java.sql.SQLException;
import java.util.Set;

import ar.edu.unrn.bdii.reclamos.model.Categoria;
import ar.edu.unrn.bdii.reclamos.model.Ciudadano;
import ar.edu.unrn.bdii.reclamos.model.Evento;
import ar.edu.unrn.bdii.reclamos.model.Reclamo;

public interface ReclamoDAO extends GenericDAO<Reclamo> {
	
	Reclamo findByEvento(Evento e);
	
	Set<Reclamo> findByCiudadano(Ciudadano c);
	
	Set<Reclamo> findByCategoria(Categoria c);
	
	void insert(Reclamo reclamo, String ciudadanoId) throws SQLException;

}
