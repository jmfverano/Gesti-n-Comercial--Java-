package es.gestion.comercial.modelo;

import java.io.Serializable;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * Clase que va a implementar los metodos definicos en la interfaz 'AbstractBaseDAO'. Sera una clase abstracta de la cual deberan extender las clases
 * de acceso a datos para el acceso a Base de Datos.
 *
 * @author Miguel A. Perez Ruiz
 * @version 1.0
 * */
public abstract class AbstractBaseDAO implements Serializable {

    /** Atributo que almacena el valor de 'serialVersionUID' **/
    private static final long serialVersionUID = 4176536393324107361L;
    
    /** Atributo que almacena el valor de 'namedParameterJdbcTemplate' **/
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
  
    /**
     * Metodo que devuelve la propiedad 'namedParameterJdbcTemplate'.
     *
     * @return 'NamedParameterJdbcTemplate' - Valor de la propiedad 'namedParameterJdbcTemplate'.
     * */
    protected NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
        return namedParameterJdbcTemplate;
    }
    
    /**
	 * Metodo que establece el valor de la propiedad 'namedParameterJdbcTemplate'.
	 * 
	 * @param namedParameterJdbcTemplate - Valor a establecer.
	 * */
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}


}