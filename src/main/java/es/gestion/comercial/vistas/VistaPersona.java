/**
 * 
 */
package es.gestion.comercial.vistas;

import es.gestion.comercial.controlador.singleton.ControladorAplicacion;

/**
 * Clase que representa
 *
 * @author José Manuel Fernández.
 * @version 1.0
 * */
public class VistaPersona {
	
	public void main(String arg1, Long arg2) {
		
		ControladorAplicacion.getPersonaBO().obtenerPorId(1L);
		
	}

}
