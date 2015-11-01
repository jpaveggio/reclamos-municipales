package ar.edu.unrn.bdii.reclamos.dto;

import ar.edu.unrn.bdii.reclamos.model.Premio;

public class PremioDTO extends GenericDTO<Premio>{
	
	private String nombre;
	private int puntos;
	
	protected PremioDTO() {
		this(null, 0);
	}
	
	public PremioDTO(String nombre, int puntos) {
		this.nombre = nombre;
		this.puntos = puntos;
	}
	public PremioDTO(Premio premio){
		setModel(premio);
	}
	@Override
	protected void setModel(Premio premio) {
		super.setModel(premio);
		nombre = premio.getNombre();
		puntos = premio.getPuntos();
	}
	public String getNombre() {
		return nombre;
	}
	public int getPuntos() {
		return puntos;
	}
	@Override
	public String toString() {
		return "PremioDTO [id=" + id + ", nombre=" + nombre + ", puntos="
				+ puntos + "]";
	}
}
