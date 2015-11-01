package ar.edu.unrn.bdii.reclamos.dto;

import ar.edu.unrn.bdii.reclamos.model.Direccion;

public class DireccionDTO extends GenericDTO<Direccion>{
	
	private String calle;
	private String numero;
	
	protected DireccionDTO() {
		this(null, null);
	}
	
	public DireccionDTO(String calle, String numero) {
		this.calle = calle;
		this.numero = numero;
	}
	public DireccionDTO(Direccion direccion){
		setModel(direccion);
	}
	@Override
	protected void setModel(Direccion direccion) {
		super.setModel(direccion);
		calle = direccion.getCalle();
		numero = direccion.getNumero();		
	}
	public String getCalle() {
		return calle;
	}
	public String getNumero() {
		return numero;
	}
	@Override
	public String toString() {
		return "DireccionDTO [id="+ id + ", calle=" + calle + ", numero=" + numero + "]";
	}	
}
