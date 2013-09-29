/**
 * 
 */
package es.gestion.comercial.modelo.impl;

import java.io.Serializable;

import es.gestion.comercial.modelo.AbstractBaseDAO;
import es.gestion.comercial.modelo.dto.Persona;
import es.gestion.comercial.modelo.interfaz.PersonaDAO;

/**
 * Clase que representa
 *
 * @author José Manuel Fernández.
 * @version 1.0
 * */
public class PersonaDAOImpl extends AbstractBaseDAO implements PersonaDAO, Serializable {

	/** Atributo que representa la propiedad 'serialVersionUID' **/
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see es.gestion.comercial.modelo.interfaz.PersonaDAO#findById(java.lang.Long)
	 */
	@Override
	public Persona findById(Long identificador) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see es.gestion.comercial.modelo.interfaz.PersonaDAO#insert(es.gestion.comercial.modelo.dto.Persona)
	 */
	@Override
	public Long insert(Persona persona) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see es.gestion.comercial.modelo.interfaz.PersonaDAO#update(es.gestion.comercial.modelo.dto.Persona)
	 */
	@Override
	public void update(Persona persona) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see es.gestion.comercial.modelo.interfaz.PersonaDAO#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long identificador) {
		// TODO Auto-generated method stub
		
	}

}
