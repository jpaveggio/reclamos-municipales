package ar.edu.unrn.bdii.reclamos.dto;

import java.util.Date;

import ar.edu.unrn.bdii.reclamos.model.Evento;

public class EventoDTO extends GenericDTO<Evento>{
	
	private Date fecha;
	private String descripcion;	
	private ReclamoDTO reclamo;
	
	protected EventoDTO() {
		this(null, null);
	}
		
	public EventoDTO(String descripcion, ReclamoDTO reclamo) {
		super();
		this.descripcion = descripcion;
		this.reclamo = reclamo;
	}
	public EventoDTO(Evento evento){
		setModel(evento);
	}
	@Override
	protected void setModel(Evento evento) {
		super.setModel(evento);
		fecha = evento.getFecha();
		descripcion = evento.getDescripcion();
		reclamo = new ReclamoDTO(evento.getReclamo());
	}
	public Date getFecha() {
		return fecha;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public ReclamoDTO getReclamo() {
		return reclamo;
	}
	@Override
	public String toString() {
		return "EventoDTO [id=" + id + ", fecha=" + fecha + ", descripcion="
				+ descripcion + ", reclamo=" + reclamo + "]";
	}
}
