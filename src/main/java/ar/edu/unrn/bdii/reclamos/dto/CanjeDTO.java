package ar.edu.unrn.bdii.reclamos.dto;

import java.util.Date;

import ar.edu.unrn.bdii.reclamos.model.Canje;

public class CanjeDTO extends GenericDTO<Canje>{
	
	private Date fecha;
    private PremioDTO premio;
    private CiudadanoDTO ciudadano;
    
    protected CanjeDTO() {
    	this(null, null, null);
    }

	public CanjeDTO(Date fecha, PremioDTO premio,
			CiudadanoDTO ciudadano) {
		this.fecha = fecha;
		this.premio = premio;
		this.ciudadano = ciudadano;
	}

	public CanjeDTO(Canje canje) {
		setModel(canje);	
	}

	@Override
	protected void setModel(Canje t) {
		super.setModel(t);
		fecha = t.getFecha();
		premio = new PremioDTO(t.getPremio());
		ciudadano = new CiudadanoDTO(t.getCiudadano());
	}
	 

	public Date getFecha() {
		return fecha;
	}

	public PremioDTO getPremio() {
		return premio;
	}

	public CiudadanoDTO getCiudadano() {
		return ciudadano;
	}

	@Override
	public String toString() {
		return "CanjeDTO [id=" + getId() + ", fecha=" + fecha + ", premio=" + premio
				+ ", ciudadano=" + ciudadano + "]";
	}

}
			
