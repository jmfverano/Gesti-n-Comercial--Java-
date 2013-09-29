package es.gestion.comercial.modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import es.gestion.comercial.controlador.excepcion.AplicacionException;

/**
 * Clase que se va a iniciar via Spring para ejecutar el Script inicial de arranque de la Base de Datos.
 * 
 * @author Miguel A. Perez Ruiz
 * @version 1.0
 * */
public class StartDatabase implements Serializable {

    /** Atributo que almacena el valor de 'serialVersionUID' **/
    private static final long serialVersionUID = 8929467773010019847L;
    
    /** Atributo que almacena el valor de 'logger' **/
    private final Log logger = LogFactory.getLog(getClass());
    
    /** Atributo que almacena el valor de 'namedParameterJdbcTemplate' **/
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    /** Atributo que almacena el valor de 'scriptInicio' **/
    private Resource scriptInicio;
    
    /**
     * Constructor de la clase. Se le pasaran por parametros el jdbcTemplate y el script de inicio para poder ejecutar el Script
     * de carga inicial sobre la Base de Datos.
     * 
     * @param scriptInicio - Resource donde esta el script de inicio.
     * @param namedParameterJdbcTemplate - JdbcTemplate para ejecutar las operaciones.
     * */
    public StartDatabase(Resource scriptInicio, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        getLogger().info("Instanciando la clase para iniciar la Base de Datos ...");
        // Establecemos los parametros de clase.
        this.scriptInicio = scriptInicio;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        getLogger().info("Clase para iniciar la Base de Datos instanciada correctamente.");
    }
    
    /**
     * Metodo que va a iniciar la Base de Datos a partir del Script de carga inicial de Datos. Se  ejecutara desde esta clase para que
     * solo se ejecute una vez, ya que cada vez que se realiza una llamada a la url de conexion, al tener la ejecucion del Script, se
     * ejecuta la llamada a la Base de Datos. Asi tambien nos aseguraremos de que cuando la aplicacion arranque, arranque con la Base 
     * de datos ya inicializada.
     * 
     * @throws AplicacionException - Excepcion lanzada si se produce algun error.
     * */
    public void initDatabase() throws AplicacionException {
        // Comprobaciones previas. Si el Script de carga es nulo o no existe ...
        if (getScriptInicio() == null || !getScriptInicio().exists()) {
            // Creamos el mensaje de error.
            final String msgError = "Se ha producido un error al iniciar la Base de Datos. --> El Script SQL " + getScriptInicio() == null ? "no puede ser nulo." : "no existe.";
            getLogger().error(msgError);
            // Elevamos la excepcion.
            throw new AplicacionException(msgError);
        }
        // Si namedParameterJdbcTemplate es nulo ...
        if (getNamedParameterJdbcTemplate() == null) {
            // Creamos el mensaje de error.
            final String msgError = "Se ha producido un error al iniciar la Base de Datos. --> El JDBC Template no puede ser nulo.";
            getLogger().error(msgError);
            // Elevamos la excepcion
            throw new AplicacionException(msgError);
        }
        try {
            getLogger().info("Obteniendo el Script SQL inicial y transformandolo a String ...");
            // Obtenemos el fichero del esquema de datos a partir del resource pasado como parametros.
            final BufferedReader scriptEsquema = new BufferedReader(new InputStreamReader(getScriptInicio().getInputStream()));
            // Creamos la variable donde se va a almacenar el script a lanzar.
            final StringBuilder sql = new StringBuilder();
            // Creamos la variable donde vamos a ir leyendo el script de Base de Datos.
            String line = null;
            // Mientras el fichero tenga lineas ...
            while ((line = scriptEsquema.readLine()) != null) {
                // Anexamos la linea al script
                sql.append(line + "\n");
            }
            // Cerramos el fichero correspondiente al esaquema
            scriptEsquema.close();
            getLogger().info("El Script SQL inicial se ha obtenido correctamente y se ha transformado a String. Ejecutando la carga inicial de datos ...");
            // Una vez tengamos el script almacenado, procedemos a lanzarlo.
            getNamedParameterJdbcTemplate().update(sql.toString(), new HashMap<String, Object>());
            getLogger().info("La carga inicial de datos se ha ejecutado correctamente. Base de Datos iniciada correctamente.");
        } catch (IOException exception) {
            // Creamos el mensaje de error.
            final String msgError = "Se ha producido un error de E/S al leer del Script SQL de carga de datos.";
            getLogger().error(msgError);
            // Elevamos la excepcion.
            throw new AplicacionException(msgError, exception);            
        } catch (DataAccessException exception) {
            // Creamos el mensaje de error
            final String msgError = "Se ha producido un error al ejecutar el Script SQL de carga de datos.";
            getLogger().error(msgError);
            // Elevamos la excepcion
            throw new AplicacionException(msgError, exception);
        }
    }

    /**
     * Metodo que devuelve la propiedad 'namedParameterJdbcTemplate'.
     * 
     * @return NamedParameterJdbcTemplate - propiedad 'namedParameterJdbcTemplate'.
     * */
    private NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
        return namedParameterJdbcTemplate;
    }

    /**
     * Metodo que devuelve la propiedad 'scriptInicio'.
     * 
     * @return Resource - propiedad 'scriptInicio'.
     * */
    private Resource getScriptInicio() {
        return scriptInicio;
    }

    /**
     * Metodo que devuelve la propiedad 'logger'.
     * 
     * @return Log - propiedad 'logger'.
     * */
    private Log getLogger() {
        return logger;
    }
    
}