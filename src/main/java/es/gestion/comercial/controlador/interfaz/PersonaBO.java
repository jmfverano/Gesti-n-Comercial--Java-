/**
 * 
 */
package es.gestion.comercial.controlador.interfaz;

import es.gestion.comercial.modelo.dto.Persona;

/**
 * Interfaz que representa
 *
 * @author José Manuel Fernández.
 * @version 1.0
 * */
public interface PersonaBO {

	/**
	 * 
	 * 
	 * @param identificador
	 * @return
	 */
	Persona obtenerPorId(final Long identificador);
	
	/**
	 * 
	 * 
	 * @param persona
	 * @return
	 */
	Long crearPersona(final Persona persona);
	
	/**
	 * 
	 * 
	 * @param persona
	 */
	void actualizarPersona(final Persona persona);
	
	/**
	 * 
	 * 
	 * @param identificador
	 */
	void eliminarPersona(final Long identificador);
	
}
