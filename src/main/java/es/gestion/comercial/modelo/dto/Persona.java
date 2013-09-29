package es.gestion.comercial.modelo.dto;

import java.io.Serializable;

/**
 * Clase que representa
 *
 * @author José Manuel Fernández.
 * @version 1.0
 * */
public class Persona implements Serializable {

	/** Atributo que representa la propiedad 'serialVersionUID' **/
	private static final long serialVersionUID = 1L;
	
	/** Atributo que representa la propiedad 'identificador' **/
	private Long identificador;
	
	/** Atributo que representa la propiedad 'nombre' **/
	private String nombre;
	
	/** Atributo que representa la propiedad 'apellidos' **/
	private String apellidos;

	/**
	 * Devuelve el valor del atributo 'identificador'.
	 *
	 * @return Long - Propiedad 'identificador'.
	 * */
	public Long getIdentificador() {
		return identificador;
	}

	/**
	 * Establece el nuevo valor para el atributo 'identificador'.
	 *
	 * @param identificador - Nuevo valor a establecer.
	 * */
	public void setIdentificador(Long identificador) {
		this.identificador = identificador;
	}

	/**
	 * Devuelve el valor del atributo 'nombre'.
	 *
	 * @return String - Propiedad 'nombre'.
	 * */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nuevo valor para el atributo 'nombre'.
	 *
	 * @param nombre - Nuevo valor a establecer.
	 * */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve el valor del atributo 'apellidos'.
	 *
	 * @return String - Propiedad 'apellidos'.
	 * */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Establece el nuevo valor para el atributo 'apellidos'.
	 *
	 * @param apellidos - Nuevo valor a establecer.
	 * */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
}
