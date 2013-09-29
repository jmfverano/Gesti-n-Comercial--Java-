/**
 * 
 */
package es.gestion.comercial.modelo.interfaz;

import es.gestion.comercial.modelo.dto.Persona;

/**
 * Interfaz que representa
 *
 * @author José Manuel Fernández.
 * @version 1.0
 * */
public interface PersonaDAO {

	/**
	 * 
	 * 
	 * @param identificador
	 * @return
	 */
	Persona findById(final Long identificador);
	
	/**
	 * 
	 * 
	 * @param persona
	 * @return
	 */
	Long insert(final Persona persona);
	
	/**
	 * 
	 * 
	 * @param persona
	 */
	void update(final Persona persona);
	
	/**
	 * 
	 * 
	 * @param identificador
	 */
	void delete(final Long identificador);
	
}
