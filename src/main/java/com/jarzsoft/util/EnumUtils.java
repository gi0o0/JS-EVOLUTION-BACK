package com.jarzsoft.util;

public class EnumUtils {

	public enum TIPO_TRAZABILIDAD
	{
		ERROR("ERROR"), CRITICO("CRITICO"), INFORMATIVO("INFORMATIVO"), ADVERTENCIA("ADVERTENCIA"),
		USUARIOS("ERROR"), PLATAFORMAS("CRITICO"), TERMINOSYCONDICIONES("INFORMATIVO"),
		ROLES("Roles"), MECANISMOS("Mecanismos"), ADMIN_MECANISMOS("Administración Mecanismos"),
		MACROSECTORES("Macrosectores"), TRAZABILIDAD_CLIENTES("Trazabilidad Clientes"),
		CREAR_USUARIOS_CCB("Crear Usuarios CCB"),ROLES_FUNCIONALIDADES("Roles Funcionalidades"),
		AUTENTICACION("Autenticación"),	REPORTES_MAUC("Reportes Muac"), VINCULOS("Vinculos"), 
		PARAMETROS("Parametros");
		
	    private String nombre;
	    TIPO_TRAZABILIDAD(String nombre) {
	    }	 
	    
	    public String getNombre() {
	        return nombre;
	    }    
	    
	    
	}
	
}
