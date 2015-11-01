package ar.edu.unrn.bdii.reclamos.dao;


import ar.edu.unrn.bdii.reclamos.model.Canje;
import ar.edu.unrn.bdii.reclamos.model.Ciudadano;
import ar.edu.unrn.bdii.reclamos.model.Reclamo;

public interface CiudadanoDAO extends GenericDAO<Ciudadano> {
	
	Ciudadano findByReclamo(Reclamo reclamo);
	
	Ciudadano findByCanje(Canje canje);
	
}
