package ar.edu.unrn.bdii.reclamos.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Canje 
implements Identificable<String>, Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;
	private Date fecha;
	
	@ManyToOne
    private Premio premio;
    @ManyToOne (cascade={CascadeType.ALL})
	private Ciudadano ciudadano;
    
    public Canje() {
    	this(null, null, null, null);
    }
    
	public Canje(Ciudadano ciudadano, Premio premio) {
		this(null, new Date(), ciudadano, premio);
	}

	public Canje(String id, Date fecha, Ciudadano ciudadano, Premio premio) {
		this.id = id;
		this.fecha = fecha;
		this.ciudadano = ciudadano;
		this.premio = premio;
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

	public Premio getPremio() {
		return premio;
	}

	public void setPremio(Premio premio) {
		this.premio = premio;
	}

	public void setCiudadano(Ciudadano ciudadano) {
		this.ciudadano = ciudadano;
	}

	public Ciudadano getCiudadano() {
		return ciudadano;
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
		Canje other = (Canje) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Canje [premio=" + premio + "]";
	}
}