package ar.edu.unrn.bdii.reclamos.dto;

import java.util.Set;

import ar.edu.unrn.bdii.reclamos.model.Canje;
import ar.edu.unrn.bdii.reclamos.model.Ciudadano;
import ar.edu.unrn.bdii.reclamos.model.Reclamo;

public class CiudadanoDTO extends GenericDTO<Ciudadano> {

	private String nombre;
	private String apellido;
	private String dni;
	private String email;
	private int puntos;
	private Set<ReclamoDTO> reclamos;
	private Set<CanjeDTO> canjes;
	
	protected CiudadanoDTO() {
		this(null, null, null, null);
	}

	public CiudadanoDTO(String nombre, String apellido, String dni, String email) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.email = email;
	}

	public CiudadanoDTO(Ciudadano ciudadano) {
		setModel(ciudadano);
	}
	
	@Override
	protected void setModel(Ciudadano ciudadano) {
		super.setModel(ciudadano);
		nombre = ciudadano.getNombre();
		apellido = ciudadano.getApellido();
		dni = ciudadano.getDni();
		email = ciudadano.getEmail();
		puntos = ciudadano.getPuntos();
//		reclamos = convert(ciudadano.getReclamos(), ReclamoDTO.class);
//		canjes = convert(ciudadano.getCanjes(), CanjeDTO.class);
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getDni() {
		return dni;
	}

	public String getEmail() {
		return email;
	}

	public int getPuntos() {
		return puntos;
	}

	public Set<ReclamoDTO> getReclamos() {
		return reclamos;
	}
	
	public void setReclamos(Set<Reclamo> reclamos) {
		this.reclamos = convert(reclamos, ReclamoDTO.class);
	}

	public Set<CanjeDTO> getCanjes() {
		return canjes;
	}
	
	public void setCanjes(Set<Canje> canjes) {
		this.canjes = convert(canjes, CanjeDTO.class);
	}
	
	@Override
	public String toString() {
		return "CiudadanoDTO [id=" + id + ", nombre=" + nombre + ", apellido="
				+ apellido + ", dni=" + dni + ", email=" + email + ", puntos="
				+ puntos + "]";
	}
}
