package ar.edu.unrn.bdii.reclamos.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Evento 
implements Identificable<String>, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;
	private Date fecha;
	private String descripcion;
	@ManyToOne (cascade={CascadeType.ALL})
	private Reclamo reclamo;
	
	public Evento() {
		this(null, null, null, null);
	}

	public Evento(String descripcion, Reclamo reclamo) {
		this(null, Calendar.getInstance(Locale.getDefault()).getTime(), descripcion, reclamo);
	}

	public Evento(String id, Date fecha, String descripcion, Reclamo reclamo) {
		this.id = id;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.reclamo = reclamo;
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

	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void setReclamo(Reclamo reclamo) {
		this.reclamo = reclamo;
	}
	
	public Reclamo getReclamo() {
		return reclamo;
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
		Evento other = (Evento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Evento [fecha=" + fecha + ", descripcion=" + descripcion
				+ ", reclamo=" + reclamo + "]";
	}
}