package ar.edu.unrn.bdii.reclamos.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Reclamo 
implements Identificable<String>, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;
	private Date fecha;
	private String descripcion;
	
	@ManyToOne (cascade={CascadeType.ALL})
	private Ciudadano ciudadano;
	@Embedded
	private Direccion direccion;
	@ManyToOne
	private Categoria categoria;
	
	@OneToMany(mappedBy="reclamo", cascade={CascadeType.ALL})
	private Set<Evento> eventos;

	public Reclamo() {
		this(null, null, null, null, null, null, null);
	}

	public Reclamo(String descripcion, Ciudadano ciudadano,
			Direccion direccion, Categoria categoria) {
		this(null, Calendar.getInstance(Locale.getDefault()).getTime(),
				descripcion, ciudadano, direccion, categoria,
				new HashSet<Evento>());
		this.addEvento(new Evento(this.getDescripcion(), this));
	}

	public Reclamo(String id, Date fecha, String descripcion,
			Ciudadano ciudadano, Direccion direccion, Categoria categoria,
			Set<Evento> eventos) {
		this.id = id;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.ciudadano = ciudadano;
		this.direccion = direccion;
		this.categoria = categoria;
		this.eventos = eventos;
	}
	
	public void addEvento(Evento evento) {
		evento.setReclamo(this);
		eventos.add(evento);
	}
	
	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;		
	}

	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public Ciudadano getCiudadano() {
		return ciudadano;
	}
	
	public void setCiudadano(Ciudadano ciudadano) {
		this.ciudadano = ciudadano;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Direccion getDireccion() {
		return direccion;
	}
	
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Set<Evento> getEventos() {
		return eventos;
	}
	
	public void setEventos(Set<Evento> eventos) {
		this.eventos = eventos;
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
		Reclamo other = (Reclamo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reclamo [fecha=" + fecha + ", descripcion=" + descripcion
				+ ", ciudadano=" + ciudadano + ", direccion=" + direccion
				+ ", categoria=" + categoria + "]";
	}
}