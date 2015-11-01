package ar.edu.unrn.bdii.reclamos.test;

import ar.edu.unrn.bdii.reclamos.dto.CategoriaDTO;
import ar.edu.unrn.bdii.reclamos.facade.Fachada;
import ar.edu.unrn.bdii.reclamos.facade.FachadaJPA;

public class TestFachada {
	
	public static void main(String[] args) {
		Fachada sistema = new FachadaJPA();
		try {
			CategoriaDTO categoria = new CategoriaDTO("General", 20);
			sistema.nuevaCategoria(categoria);
			sistema.bajaCategoria(categoria.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
