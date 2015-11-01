package ar.edu.unrn.bdii.reclamos.dao;

import java.util.Set;

import ar.edu.unrn.bdii.reclamos.model.Evento;
import ar.edu.unrn.bdii.reclamos.model.Reclamo;

public interface EventoDAO extends GenericDAO<Evento> {
	
	Set<Evento> findByReclamo(Reclamo reclamo);
}
