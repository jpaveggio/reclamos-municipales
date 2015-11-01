package ar.edu.unrn.bdii.reclamos.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Categoria 
implements Identificable<String>, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id; 
	private String nombre;
	private Integer puntos;
	
	public Categoria() {
		this(null, null, null);
	}

	public Categoria(String nombre, Integer puntos) {
		this(null, nombre, puntos);
	}

	public Categoria(String id, String nombre, Integer puntos) {
		this.id = id;
		this.nombre = nombre;
		this.puntos = puntos;
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

	public Integer getPuntos() {
		return puntos;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPuntos(Integer puntos) {
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
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Categoria [nombre=" + nombre + ", puntos=" + puntos + "]";
	}
}