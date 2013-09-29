/**
 * 
 */
package es.gestion.comercial.controlador.singleton;

import java.io.Serializable;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.gestion.comercial.controlador.interfaz.PersonaBO;

/**
 * Clase que representa
 *
 * @author José Manuel Fernández.
 * @version 1.0
 * */
public class ControladorAplicacion implements Serializable {

	/** Atributo que representa la propiedad 'serialVersionUID' **/
	private static final long serialVersionUID = 1L;
	
	/** Atributo que representa la propiedad 'RUTA_APP_CONTEXT' **/
	private static final String RUTA_APP_CONTEXT = "applicationContext.xml";
	
	/** Atributo que representa la propiedad 'springContext' **/
	private static ApplicationContext springContext;
	
	/** Atributo que representa la propiedad 'personaBO' **/
	private static PersonaBO personaBO;
	
	/**
	 * 
	 * */
	private ControladorAplicacion() {}
	
	/**
	 * Devuelve el valor del atributo 'springContext'.
	 *
	 * @return ApplicationContext - Propiedad 'springContext'.
	 * */
	private synchronized static ApplicationContext getSpringContext() {
		if(springContext == null) {
			springContext = new ClassPathXmlApplicationContext(RUTA_APP_CONTEXT);
		}
		return springContext;
	}
	
	/**
	 * Devuelve el valor del atributo 'personaBO'.
	 *
	 * @return PersonaBO - Propiedad 'personaBO'.
	 * */
	public synchronized static PersonaBO getPersonaBO() {
		if(personaBO == null) {
			personaBO = (PersonaBO) getSpringContext().getBean("");
		}
		return personaBO;
	}

}
