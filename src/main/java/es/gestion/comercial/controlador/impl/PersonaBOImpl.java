/**
 * 
 */
package es.gestion.comercial.controlador.impl;

import java.io.Serializable;

import es.gestion.comercial.controlador.interfaz.PersonaBO;
import es.gestion.comercial.modelo.dto.Persona;
import es.gestion.comercial.modelo.interfaz.PersonaDAO;

/**
 * Clase que representa
 *
 * @author José Manuel Fernández.
 * @version 1.0
 * */
public class PersonaBOImpl implements PersonaBO, Serializable {

	/** Atributo que representa la propiedad 'serialVersionUID' **/
	private static final long serialVersionUID = 1L;
	
	/** Atributo que representa la propiedad 'personaDAO' **/
	private PersonaDAO personaDAO;

	/* (non-Javadoc)
	 * @see es.gestion.comercial.controlador.interfaz.PersonaBO#obtenerPorId(java.lang.Long)
	 */
	@Override
	public Persona obtenerPorId(Long identificador) {
		
		return getPersonaDAO().findById(identificador);
	}

	/* (non-Javadoc)
	 * @see es.gestion.comercial.controlador.interfaz.PersonaBO#crearPersona(es.gestion.comercial.modelo.dto.Persona)
	 */
	@Override
	public Long crearPersona(Persona persona) {
		
		return getPersonaDAO().insert(persona);
	}

	/* (non-Javadoc)
	 * @see es.gestion.comercial.controlador.interfaz.PersonaBO#actualizarPersona(es.gestion.comercial.modelo.dto.Persona)
	 */
	@Override
	public void actualizarPersona(Persona persona) {
		
		getPersonaDAO().update(persona);
	}

	/* (non-Javadoc)
	 * @see es.gestion.comercial.controlador.interfaz.PersonaBO#eliminarPersona(java.lang.Long)
	 */
	@Override
	public void eliminarPersona(Long identificador) {
		
		getPersonaDAO().delete(identificador);
	}

	/**
	 * Devuelve el valor del atributo 'personaDAO'.
	 *
	 * @return PersonaDAO - Propiedad 'personaDAO'.
	 * */
	private PersonaDAO getPersonaDAO() {
		return personaDAO;
	}

	/**
	 * Establece el nuevo valor para el atributo 'personaDAO'.
	 *
	 * @param personaDAO - Nuevo valor a establecer.
	 * */
	public void setPersonaDAO(PersonaDAO personaDAO) {
		this.personaDAO = personaDAO;
	}

}
