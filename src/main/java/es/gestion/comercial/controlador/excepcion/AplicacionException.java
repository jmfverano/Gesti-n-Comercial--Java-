/**
 * 
 */
package es.gestion.comercial.controlador.excepcion;

/**
 * Clase que representa
 *
 * @author José Manuel Fernández.
 * @version 1.0
 * */
public class AplicacionException extends Exception {

	/** Atributo que representa la propiedad 'serialVersionUID' **/
	private static final long serialVersionUID = 1L;
	
	public AplicacionException() {
		super();
	}
	
	public AplicacionException(String mensaje) {
		super(mensaje);
	}
	
	public AplicacionException(String mensaje, Throwable error) {
		super(mensaje, error);
	}

}
