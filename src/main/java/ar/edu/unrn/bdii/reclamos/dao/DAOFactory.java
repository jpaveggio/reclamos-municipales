package ar.edu.unrn.bdii.reclamos.dao;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public abstract class DAOFactory {

	public static final String PROPERTIES_FILE = "reclamos_config.properties";
	
//	public static final Class<? extends DAOFactory> JDBC = ar.edu.unrn.bdii.reclamos.dao.jdbc.JDBCDAOFactory.class;
//	public static final Class<? extends DAOFactory> HIBERNATE = ar.edu.unrn.bdii.reclamos.dao.hibernate.HDAOFactory.class;
	public static final Class<? extends DAOFactory> JPA = ar.edu.unrn.bdii.reclamos.dao.jpa.JPADAOFactory.class;

	public abstract CanjeDAO getCanjeDAO() throws Exception;
	public abstract CategoriaDAO getCategoriaDAO() throws Exception;
	public abstract CiudadanoDAO getCiudadanoDAO() throws Exception;
	public abstract EventoDAO getEventoDAO() throws Exception;
	public abstract PremioDAO getPremioDAO() throws Exception;
	public abstract ReclamoDAO getReclamoDAO() throws Exception;
	public abstract void begin() throws Exception;
	public abstract void commit() throws Exception;

	private static DAOFactory factory = null;

	public static DAOFactory instance() {
		if (factory == null) {
			try {
				factory = (DAOFactory) Class.forName(getDAOFactoryClass())
						.newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return factory;
	}	

	private static String getDAOFactoryClass() {

		Properties p = new Properties();
		InputStream is = (InputStream) DAOFactory.class.getClassLoader()
				.getResourceAsStream(PROPERTIES_FILE);

		if (is == null) { // Si no existe el archivo lo creamos.
			OutputStream os = null;
			try {
				os = new FileOutputStream(PROPERTIES_FILE);
				p.setProperty("DAO_FACTORY_CLASS",
						JPA.getName());
				p.store(os, null);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (os != null) {
					try {
						os.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			try {
				p.load(is);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return p.getProperty("DAO_FACTORY_CLASS");
	}
}
