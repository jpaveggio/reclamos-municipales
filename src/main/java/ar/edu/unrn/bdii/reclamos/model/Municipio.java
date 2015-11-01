package ar.edu.unrn.bdii.reclamos.model;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import ar.edu.unrn.bdii.reclamos.dao.jpa.JPAUtil;

@Entity
public class Municipio {
	
	@Id
	private int id;
	@OneToMany(mappedBy="Municipio", cascade={CascadeType.ALL})
	private Set<Ciudadano> ciudadanos;
	@OneToMany(mappedBy="Municipio", cascade={CascadeType.ALL})
	private Set<Categoria> categorias;
	@OneToMany(mappedBy="Municipio", cascade={CascadeType.ALL})
	private Set<Premio> premio;
	private int mesPromocion = Calendar.SEPTEMBER;
	
	@Transient
	private static Municipio instance = null;
	
	public static Municipio instance() {
		if(instance == null)
			instance = JPAUtil.getEntityManagerFactory().createEntityManager().find(Municipio.class, 1);
		return instance;
	}
	
	public Municipio() throws Exception {
		ciudadanos = new HashSet<Ciudadano>();
	}
	
	public boolean isMesDescuento(Date fecha) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(fecha);
		int mes = cal.get(Calendar.MONTH);
		return mes == mesPromocion;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Ciudadano> getCiudadanos() {
		return ciudadanos;
	}

	public void setCiudadanos(Set<Ciudadano> ciudadanos) {
		this.ciudadanos = ciudadanos;
	}

	public Set<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(Set<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Set<Premio> getPremio() {
		return premio;
	}

	public void setPremio(Set<Premio> premio) {
		this.premio = premio;
	}

	public int getMesPromocion() {
		return mesPromocion;
	}

	public void setMesPromocion(int mesPromocion) {
		this.mesPromocion = mesPromocion;
	}

}
