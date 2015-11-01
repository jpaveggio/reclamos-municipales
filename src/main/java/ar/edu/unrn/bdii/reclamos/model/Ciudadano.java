package ar.edu.unrn.bdii.reclamos.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import ar.edu.unrn.bdii.reclamos.model.exceptions.PuntosInsuficientesException;

@Entity
public class Ciudadano 
implements Identificable<String>, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;
	private String nombre;
	private String apellido;
	private String dni;
	private String email;
	private int puntos;
	
	@OneToMany(mappedBy="ciudadano", cascade={CascadeType.ALL})
	private Set<Reclamo> reclamos;
	
	@OneToMany(mappedBy="ciudadano", cascade={CascadeType.ALL})
	private Set<Canje> canjes;

	public Ciudadano() {
		this(null, null, null, null, null, 0, null, null);
	}

	public Ciudadano(String nombre, String apellido, String dni, String email) {
		this(null, nombre, apellido, dni, email, 0, new HashSet<Reclamo>(),
				new HashSet<Canje>());
	}

	public Ciudadano(String id, String nombre, String apellido, String dni,
			String email, int puntos, Set<Reclamo> reclamos, Set<Canje> canjes) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.email = email;
		this.reclamos = reclamos;
		this.canjes = canjes;
		this.puntos = puntos;
	}

	public void crearReclamo(Reclamo reclamo) {
		reclamo.setCiudadano(this);
		reclamos.add(reclamo);
		int incremento = reclamo.getCategoria().getPuntos();
		if (Municipio.instance().isMesDescuento(reclamo.getFecha()))
			incremento *= 2;
		puntos += incremento;
	}

	public Canje canjearPuntos(Premio premio)
			throws PuntosInsuficientesException {
		Canje canje = new Canje(this, premio);
		int costo = premio.getPuntos();
		if (Municipio.instance().isMesDescuento(canje.getFecha()))
			costo = 0;
		if (costo > puntos) {
			canje = null;
			throw new PuntosInsuficientesException();
		} else {
			puntos -= costo;
			getCanjes().add(canje);
		}
		return canje;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Reclamo> getReclamos() {
		return reclamos;
	}

	public void setReclamos(Set<Reclamo> reclamos) {
		this.reclamos = reclamos;
	}

	public Set<Canje> getCanjes() {
		return canjes;
	}

	public void setCanjes(Set<Canje> canjes) {
		this.canjes = canjes;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ciudadano other = (Ciudadano) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ciudadano [nombre=" + nombre + ", apellido=" + apellido
				+ ", dni=" + dni + ", email=" + email + ", puntos=" + puntos
				+ "]";
	}
}