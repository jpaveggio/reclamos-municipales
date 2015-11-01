package ar.edu.unrn.bdii.reclamos.model;

import java.io.Serializable;

public interface Identificable<T extends Serializable> {
	
	public T getId();
	public void setId(T id);
}
