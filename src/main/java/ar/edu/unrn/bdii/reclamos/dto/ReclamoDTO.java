package ar.edu.unrn.bdii.reclamos.dto;

import java.util.Date;
import java.util.Set;

import ar.edu.unrn.bdii.reclamos.model.Evento;
import ar.edu.unrn.bdii.reclamos.model.Reclamo;

public class ReclamoDTO extends GenericDTO<Reclamo>{

	private Date fecha;
	private String descripcion;
	private CiudadanoDTO ciudadano;
	private DireccionDTO direccion;
	private CategoriaDTO categoria;
	private Set<EventoDTO> eventos;
	
	protected ReclamoDTO() {
		this(null, null, null, null);
	}

	public ReclamoDTO(String descripcion, CiudadanoDTO ciudadano,
			DireccionDTO direccion, CategoriaDTO categoria) {
		this.descripcion = descripcion;
		this.ciudadano = ciudadano;
		this.direccion = direccion;
		this.categoria = categoria;
	}
	
	public ReclamoDTO(Reclamo reclamo){
		setModel(reclamo);
	}
	
	@Override
	protected void setModel(Reclamo reclamo) {
		super.setModel(reclamo);
		fecha = reclamo.getFecha();
		descripcion = reclamo.getDescripcion();
		ciudadano = new CiudadanoDTO(reclamo.getCiudadano());
		direccion = new DireccionDTO(reclamo.getDireccion());
		categoria = new CategoriaDTO(reclamo.getCategoria());
//		eventos = convert(reclamo.getEventos(), EventoDTO.class);
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public CiudadanoDTO getCiudadano() {
		return ciudadano;
	}
	
	public DireccionDTO getDireccion() {
		return direccion;
	}
	
	public CategoriaDTO getCategoria() {
		return categoria;
	}
	public Set<EventoDTO> getEventos() {
		return eventos;
	}
	
	public void setEventos(Set<Evento> eventos) {
		this.eventos = convert(eventos, EventoDTO.class);
	}
	@Override
	public String toString() {
		return "ReclamoDTO [id=" + id + ", fecha=" + fecha + ", descripcion="
				+ descripcion + ", ciudadano=" + ciudadano + ", direccion="
				+ direccion + ", categoria=" + categoria + ", eventos="
				+ eventos + "]";
	}
}
