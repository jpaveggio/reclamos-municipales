package ar.edu.unrn.bdii.reclamos.model.exceptions;

public class PuntosInsuficientesException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "No tiene puntos suficientes para este premio";
	}
}
