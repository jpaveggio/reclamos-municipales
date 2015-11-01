package ar.edu.unrn.bdii.reclamos.dto;

import java.util.HashSet;
import java.util.Set;

import ar.edu.unrn.bdii.reclamos.model.Identificable;

public abstract class GenericDTO<T extends Identificable<String>> {

	protected String id = null;

	protected void setModel(T t) {
		id = t.getId();
	}

	public String getId() {
		return id;
	}

	public static <M extends Identificable<String>,D extends GenericDTO<M>> Set<D> convert(Set<M> modelSet, Class<D> dtoClass) {
		Set<D> dtoSet = new HashSet<D>();
		for (M m : modelSet) {
			try {
				D d = dtoClass.newInstance();
				d.setModel(m);
				dtoSet.add(d);
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return dtoSet;
	}
}
