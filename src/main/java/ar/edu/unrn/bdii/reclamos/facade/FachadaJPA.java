package ar.edu.unrn.bdii.reclamos.facade;

import java.util.List;

import ar.edu.unrn.bdii.reclamos.dao.DAOFactory;
import ar.edu.unrn.bdii.reclamos.dto.CanjeDTO;
import ar.edu.unrn.bdii.reclamos.dto.CategoriaDTO;
import ar.edu.unrn.bdii.reclamos.dto.CiudadanoDTO;
import ar.edu.unrn.bdii.reclamos.dto.EventoDTO;
import ar.edu.unrn.bdii.reclamos.dto.PremioDTO;
import ar.edu.unrn.bdii.reclamos.dto.ReclamoDTO;
import ar.edu.unrn.bdii.reclamos.model.Categoria;
import ar.edu.unrn.bdii.reclamos.model.Municipio;

public class FachadaJPA implements Fachada {

	@Override
	public CategoriaDTO nuevaCategoria(CategoriaDTO categoria) throws Exception {
		DAOFactory.instance().begin();
		Categoria c = new Categoria(categoria.getNombre(), categoria.getPuntos());
		Municipio.instance().getCategorias().add(c);
		DAOFactory.instance().commit();
		return new CategoriaDTO(c);
	}

	@Override
	public CategoriaDTO bajaCategoria(String id) throws Exception {
		DAOFactory.instance().begin();
		Categoria categoria = new Categoria(id, null, null);
		Municipio.instance().getCategorias().remove(categoria);
		DAOFactory.instance().commit();
		return new CategoriaDTO(categoria);
	}

	@Override
	public CategoriaDTO modificarCategoria(String id, CategoriaDTO categoria)
			throws Exception {
		
		return null;
	}

	@Override
	public List<CategoriaDTO> listarCategorias() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PremioDTO nuevoPremio(PremioDTO premio) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PremioDTO bajaPremio(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PremioDTO modificarPremio(String id, PremioDTO premio)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PremioDTO> listarPremios() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CiudadanoDTO nuevoCiudadano(CiudadanoDTO ciudadano) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CiudadanoDTO bajaCiudadano(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CiudadanoDTO modificarCiudadano(String id, CiudadanoDTO ciudadano)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CiudadanoDTO> listarCiudadanos() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CiudadanoDTO traerCiudadanoFull(String idCiudadano) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EventoDTO agregarEvento(String idReclamo, EventoDTO evento)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CanjeDTO canjear(String idCiudadano, String idPremio)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReclamoDTO nuevoReclamo(ReclamoDTO reclamo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReclamoDTO> listarReclamos() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReclamoDTO traerReclamo(String idReclamo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReclamoDTO traerReclamoYEventos(String idReclamo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
