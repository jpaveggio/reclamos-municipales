package ar.edu.unrn.bdii.reclamos.dao;

import java.util.Set;

import ar.edu.unrn.bdii.reclamos.model.Canje;
import ar.edu.unrn.bdii.reclamos.model.Ciudadano;

public interface CanjeDAO extends GenericDAO<Canje> {
	
	Set<Canje> findByCiudadano(Ciudadano ciudadano);
	
	void insert(Canje canje, String ciudadanoId);
	
}
