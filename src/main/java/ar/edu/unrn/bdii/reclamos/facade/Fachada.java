package ar.edu.unrn.bdii.reclamos.facade;

import java.util.List;

import ar.edu.unrn.bdii.reclamos.dto.CanjeDTO;
import ar.edu.unrn.bdii.reclamos.dto.CategoriaDTO;
import ar.edu.unrn.bdii.reclamos.dto.CiudadanoDTO;
import ar.edu.unrn.bdii.reclamos.dto.EventoDTO;
import ar.edu.unrn.bdii.reclamos.dto.PremioDTO;
import ar.edu.unrn.bdii.reclamos.dto.ReclamoDTO;

public interface Fachada {
	
	CategoriaDTO nuevaCategoria(CategoriaDTO categoria) throws Exception;
	CategoriaDTO bajaCategoria(String id) throws Exception;
	CategoriaDTO modificarCategoria(String id, CategoriaDTO categoria) throws Exception;
	List<CategoriaDTO> listarCategorias() throws Exception;
	
	PremioDTO nuevoPremio(PremioDTO premio) throws Exception;
	PremioDTO bajaPremio(String id) throws Exception;
	PremioDTO modificarPremio(String id, PremioDTO premio) throws Exception;
	List<PremioDTO> listarPremios() throws Exception;
	
	CiudadanoDTO nuevoCiudadano(CiudadanoDTO ciudadano) throws Exception;
	CiudadanoDTO bajaCiudadano(String id) throws Exception;
	CiudadanoDTO modificarCiudadano(String id, CiudadanoDTO ciudadano) throws Exception;
	List<CiudadanoDTO> listarCiudadanos() throws Exception;
	CiudadanoDTO traerCiudadanoFull(String idCiudadano) throws Exception;
	EventoDTO agregarEvento(String idReclamo, EventoDTO evento) throws Exception;
	CanjeDTO canjear(String idCiudadano, String idPremio) throws Exception;
	
	ReclamoDTO nuevoReclamo(ReclamoDTO reclamo) throws Exception;
	List<ReclamoDTO> listarReclamos() throws Exception;
	ReclamoDTO traerReclamo(String idReclamo) throws Exception;
	ReclamoDTO traerReclamoYEventos(String idReclamo) throws Exception;
	
}
