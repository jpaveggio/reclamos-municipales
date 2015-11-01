package ar.edu.unrn.bdii.reclamos.dto;

import ar.edu.unrn.bdii.reclamos.model.Categoria;

public class CategoriaDTO extends GenericDTO<Categoria> {

	private String nombre;
	private Integer puntos;
	
	protected CategoriaDTO() {
		this(null, null);
	}
	
	public CategoriaDTO(String nombre, Integer puntos) {
		this.nombre = nombre;
		this.puntos = puntos;
	}
	public CategoriaDTO(Categoria categoria){
		setModel(categoria);
	}
	@Override
	protected void setModel(Categoria categoria) {
		super.setModel(categoria);
		nombre = categoria.getNombre();
		puntos = categoria.getPuntos();
	}
	public String getNombre() {
		return nombre;
	}
	public Integer getPuntos() {
		return puntos;
	}
	@Override
	public String toString() {
		return "CategoriaDTO [id=" + id + ", nombre=" + nombre + ", puntos="
				+ puntos + "]";
	}
}