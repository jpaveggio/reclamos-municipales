package ar.edu.unrn.bdii.reclamos.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import ar.edu.unrn.bdii.reclamos.dao.CategoriaDAO;
import ar.edu.unrn.bdii.reclamos.dao.CiudadanoDAO;
import ar.edu.unrn.bdii.reclamos.dao.DAOFactory;
import ar.edu.unrn.bdii.reclamos.dao.PremioDAO;
import ar.edu.unrn.bdii.reclamos.dto.CanjeDTO;
import ar.edu.unrn.bdii.reclamos.dto.CategoriaDTO;
import ar.edu.unrn.bdii.reclamos.dto.CiudadanoDTO;
import ar.edu.unrn.bdii.reclamos.dto.EventoDTO;
import ar.edu.unrn.bdii.reclamos.dto.GenericDTO;
import ar.edu.unrn.bdii.reclamos.dto.PremioDTO;
import ar.edu.unrn.bdii.reclamos.dto.ReclamoDTO;
import ar.edu.unrn.bdii.reclamos.model.Categoria;
import ar.edu.unrn.bdii.reclamos.model.Ciudadano;
import ar.edu.unrn.bdii.reclamos.model.Direccion;
import ar.edu.unrn.bdii.reclamos.model.Evento;
import ar.edu.unrn.bdii.reclamos.model.Premio;
import ar.edu.unrn.bdii.reclamos.model.Reclamo;

public class FachadaHibernate implements Fachada {

	@Override
	public CategoriaDTO nuevaCategoria(CategoriaDTO categoria) throws Exception {
		DAOFactory.instance().begin();
		Categoria c = new Categoria(categoria.getNombre(), categoria.getPuntos());
		DAOFactory.instance().getCategoriaDAO().insert(c);
		DAOFactory.instance().commit();
		return new CategoriaDTO(c);
	}

	@Override
	public CategoriaDTO bajaCategoria(String id) throws Exception {
		DAOFactory.instance().begin();
		CategoriaDAO dao = DAOFactory.instance().getCategoriaDAO();
		Categoria c = dao.findById(id);
		dao.delete(c);
		DAOFactory.instance().commit();
		return new CategoriaDTO(c);
	}

	@Override
	public CategoriaDTO modificarCategoria(String id, CategoriaDTO categoria)
			throws Exception {
		DAOFactory.instance().begin();
		Categoria c = DAOFactory.instance().getCategoriaDAO().findById(id);
		c.setNombre(categoria.getNombre());
		c.setPuntos(categoria.getPuntos());
		DAOFactory.instance().commit();
		return new CategoriaDTO(c);
	}

	@Override
	public List<CategoriaDTO> listarCategorias() throws Exception {
		DAOFactory.instance().begin();
		CategoriaDAO dao = DAOFactory.instance().getCategoriaDAO();
		Set<CategoriaDTO> cdto = GenericDTO.convert(dao.findAll(),
				CategoriaDTO.class);
		DAOFactory.instance().commit();
		return new ArrayList<CategoriaDTO>(cdto);
	}

	@Override
	public PremioDTO nuevoPremio(PremioDTO premio) throws Exception {
		DAOFactory.instance().begin();
		Premio p = new Premio(premio.getNombre(), premio.getPuntos());
		DAOFactory.instance().getPremioDAO().insert(p);
		DAOFactory.instance().commit();
		return new PremioDTO(p);
	}

	@Override
	public PremioDTO bajaPremio(String id) throws Exception {
		DAOFactory.instance().begin();
		PremioDAO dao = DAOFactory.instance().getPremioDAO();
		Premio p = dao.findById(id);
		dao.delete(p);
		DAOFactory.instance().commit();
		return new PremioDTO(p);
	}

	@Override
	public PremioDTO modificarPremio(String id, PremioDTO premio) throws Exception {
		DAOFactory.instance().begin();
		Premio p = DAOFactory.instance().getPremioDAO().findById(id);
		p.setNombre(premio.getNombre());
		p.setPuntos(premio.getPuntos());
		DAOFactory.instance().commit();
		return new PremioDTO(p);
	}

	@Override
	public List<PremioDTO> listarPremios() throws Exception {
		DAOFactory.instance().begin();
		Set<PremioDTO> dtoSet = GenericDTO.convert(DAOFactory.instance()
				.getPremioDAO().findAll(), PremioDTO.class);
		DAOFactory.instance().commit();
		return new ArrayList<PremioDTO>(dtoSet);
	}

	@Override
	public CiudadanoDTO nuevoCiudadano(CiudadanoDTO ciudadano) throws Exception {
		DAOFactory.instance().begin();
		Ciudadano c = new Ciudadano(ciudadano.getNombre(),
				ciudadano.getApellido(), ciudadano.getDni(),
				ciudadano.getEmail());
		ciudadano = new CiudadanoDTO(c);
		DAOFactory.instance().getCiudadanoDAO().insert(c);
		DAOFactory.instance().commit();
		return new CiudadanoDTO(c);
	}

	@Override
	public CiudadanoDTO bajaCiudadano(String id) throws Exception {
		DAOFactory.instance().begin();
		CiudadanoDAO dao = DAOFactory.instance().getCiudadanoDAO();
		Ciudadano c = dao.findById(id); 
		dao.delete(c);
		DAOFactory.instance().commit();
		return new CiudadanoDTO(c);		
	}

	@Override
	public CiudadanoDTO modificarCiudadano(String id, CiudadanoDTO ciudadano)
			throws Exception {
		DAOFactory.instance().begin();
		Ciudadano c = DAOFactory.instance().getCiudadanoDAO().findById(id);
		c.setNombre(ciudadano.getNombre());
		c.setApellido(ciudadano.getApellido());
		c.setDni(ciudadano.getDni());
		c.setEmail(ciudadano.getEmail());
		return new CiudadanoDTO(c);
	}

	@Override
	public List<CiudadanoDTO> listarCiudadanos() throws Exception {
		DAOFactory.instance().begin();
		Set<CiudadanoDTO> dtoSet = GenericDTO.convert(DAOFactory.instance()
				.getCiudadanoDAO().findAll(), CiudadanoDTO.class);
		DAOFactory.instance().commit();
		return new ArrayList<CiudadanoDTO>(dtoSet);
	}
	
	@Override
	public CiudadanoDTO traerCiudadanoFull(String idCiudadano)
			throws Exception {
		DAOFactory.instance().begin();
		Ciudadano c = DAOFactory.instance().getCiudadanoDAO().findById(idCiudadano);
		CiudadanoDTO ciudadano = new CiudadanoDTO(c);
		ciudadano.setReclamos(c.getReclamos());
		ciudadano.setCanjes(c.getCanjes());
		DAOFactory.instance().commit();
		return ciudadano;
	}

	@Override
	public ReclamoDTO nuevoReclamo(ReclamoDTO reclamo) throws Exception {
		DAOFactory.instance().begin();
		Ciudadano ciudadano = DAOFactory.instance().getCiudadanoDAO()
				.findById(reclamo.getCiudadano().getId());
		Direccion direccion = new Direccion(reclamo.getDireccion().getCalle(),
				reclamo.getDireccion().getNumero());
		Categoria categoria = DAOFactory.instance().getCategoriaDAO()
				.findById(reclamo.getCategoria().getId());
		Reclamo r = new Reclamo(reclamo.getDescripcion(), ciudadano, direccion,
				categoria);
		ciudadano.crearReclamo(r);
		DAOFactory.instance().getReclamoDAO().insert(r);
		DAOFactory.instance().commit();
		return new ReclamoDTO(r);
	}

	@Override
	public List<ReclamoDTO> listarReclamos() throws Exception {
		DAOFactory.instance().begin();
		Set<ReclamoDTO> reclamos = GenericDTO.convert(DAOFactory.instance()
				.getReclamoDAO().findAll(), ReclamoDTO.class);
		DAOFactory.instance().commit();
		return new ArrayList<ReclamoDTO>(reclamos);
	}

	@Override
	public ReclamoDTO traerReclamo(String idReclamo) throws Exception {
		DAOFactory.instance().begin();
		Reclamo reclamo = DAOFactory.instance().getReclamoDAO()
				.findById(idReclamo);
		DAOFactory.instance().commit();
		return new ReclamoDTO(reclamo);
	}

	@Override
	public ReclamoDTO traerReclamoYEventos(String idReclamo) throws Exception {
		DAOFactory.instance().begin();
		Reclamo r = DAOFactory.instance().getReclamoDAO()
				.findById(idReclamo);
		ReclamoDTO reclamo = new ReclamoDTO(r);
		reclamo.setEventos(r.getEventos());
		DAOFactory.instance().commit();
		return reclamo;
	}

	@Override
	public EventoDTO agregarEvento(String idReclamo, EventoDTO evento)
			throws Exception {
		DAOFactory.instance().begin();
		Reclamo reclamo = DAOFactory.instance().getReclamoDAO()
				.findById(idReclamo);
		Evento e = new Evento(evento.getDescripcion(), reclamo);
		reclamo.addEvento(e);
		evento = new EventoDTO(e); 
		DAOFactory.instance().commit();
		return evento;
	}

	@Override
	public CanjeDTO canjear(String idCiudadano, String idPremio) throws Exception {
		DAOFactory.instance().begin();
		Ciudadano ciudadano = DAOFactory.instance()
				.getCiudadanoDAO().findById(idCiudadano);
		Premio premio = DAOFactory.instance().getPremioDAO().findById(idPremio);
		CanjeDTO canje = new CanjeDTO(ciudadano.canjearPuntos(premio));
		DAOFactory.instance().commit();
		return canje;
	}
}
