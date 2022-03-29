package com.wposs.alfa.utilities;

import java.io.File;
import java.io.PrintStream;

import com.wposs.core.log.AppLogger;
import com.wposs.core.spring.BaseSpringApplication;

public class AlfaUtils {
	
	public static void main( String[] args ) throws Exception { //NOSONAR: Esto es para ejecutar por linea de comandos
		AppLogger.stdout("Procesando "+args[0]);
		System.setProperty("test", "true");
		if( args.length>0 && args[0].equals("crypt") ){
			BaseSpringApplication.crypt( args );
		}
		if( args.length>0 && args[0].equals("cryptfile") ){
			BaseSpringApplication.cryptfile( args );
		}
		if( args.length>0 && args[0].equals("encode") ){
			BaseSpringApplication.encode( args );
		}
		if( args.length>0 && args[0].equals("resource") ){
			resource( args );
		}
		if( args.length>0 && args[0].equals("resources") ){
			resources();
		}
		if( args.length>0 && args[0].equals("json") ){
			json( args );
		}
	}
	
	public static void resource( String[] args ) throws Exception {
    	/*MiSeguridadHelper helper = new MiSeguridadHelper();
    	int app = Integer.parseInt( args[1] );
    	String recurso = args[2];
    	AppLogger.stdout( "código:"+helper.convertURLToInt( app, recurso, false, true ) );
    	if( app == 1 ){
	    	AppLogger.stdout( "código miseguridad:"+helper.convertURLToInt( app, "/miseguridad"+recurso, false, true ) );
	    	AppLogger.stdout( "código midocumento:"+helper.convertURLToInt( app, "/midocumento"+recurso, false, true ) );
	    	AppLogger.stdout( "código misms:"+helper.convertURLToInt( app, "/misms"+recurso, false, true ) );
	    	AppLogger.stdout( "código miemail:"+helper.convertURLToInt( app, "/miemail"+recurso, false, true ) );
    	}*/
	}
    
    public static void resources() throws Exception {    	
    	/*int app = 1;
    	PrintStream fout = null;
    	File fileOut = new File( "/proyectos/prisma2/apis/prisma-security-api/docs/resources/miseguridad.sql" ); //NOSONAR
		try {
			fout = new PrintStream( fileOut );
			
	
			procesarRecursos( fout, app, 47, "raspita", "Administrador Raspita" );
			
			AppLogger.stdout("fin");

		} finally {
			try { if( fout!=null ) fout.close(); } catch( Exception ee ){ }
		}		*/	
    }
    
    private static void procesarRecursos( PrintStream fout, int app, int appAdmin, String appAdminName, String rolAdminName ) throws Exception {
    	/*File file = new File( "/proyectos/prisma2/apis/prisma-security-api/docs/resources/miseguridad.txt" ); //NOSONAR
		FileInputStream fin = null;
		BufferedReader reader = null;
		try {
			fin = new FileInputStream( file );		
			reader = new BufferedReader( new InputStreamReader( fin ) );
			String line = reader.readLine();
			while( line!=null ){
				procesarRecurso( fout, app, appAdmin, appAdminName, rolAdminName, line );
				line = reader.readLine();
			}
			fout.println( "" );
		} finally {
			try { if( fin!=null ) fin.close(); } catch( Exception ee ){ /NO HACE NADA/ }
			try { if( reader!=null ) reader.close(); } catch( Exception ee ){ /NO HACE NADA/ }
		}	 */   	
    }

	private static void procesarRecurso( PrintStream fout, int app, int appAdmin, String appAdminName, String rolAdminName, String line ) {
		/*tringTokenizer st = new StringTokenizer( line, "|" );
		String recurso = st.nextToken().trim();
		if( ( recurso.startsWith("/documents/") && appAdmin==0 ) || ( !recurso.startsWith("/documents/") && appAdmin!=0 ) ){				
			if( !StringUtils.isNull( appAdminName ) ){
				recurso = "/"+appAdminName+recurso;
			}
			String name = st.nextToken().trim();
			String descripcion = st.nextToken().trim();
			MiSeguridadHelper helper = new MiSeguridadHelper();
			int code = helper.convertURLToInt( app, recurso, false, true );
			String sql = "INSERT INTO miseguridad.SERVICIOS ( ID_SERVICIO, ID_APLICACION, URL, NOMBRE, DESCRIPCION, ID_APLICACION_ADMIN ) VALUES ( "+
					code+", "+app+", '"+recurso+"', '"+name+"', '"+descripcion+"', "+(appAdmin!=0?appAdmin:"NULL")+" );";
			fout.println( sql );
			sql = "INSERT INTO miseguridad.ROLES_X_SERVICIOS ( ID_ROL, ID_APLICACION, ID_SERVICIO ) VALUES ( 1, "+app+", "+code+" );";
			fout.println( sql );
			if( rolAdminName != null ){
				sql = "INSERT INTO miseguridad.ROLES_X_SERVICIOS ( ID_ROL, ID_APLICACION, ID_SERVICIO ) VALUES ( ( SELECT ID_ROL FROM miseguridad.ROLES WHERE ID_APLICACION=1 AND NOMBRE='"+rolAdminName+"' ), "+app+", "+code+" );";
				fout.println( sql );
			}
		}*/
	}
	
	public static void main2() throws Exception {
		json( new String[]{ "", "2", "8", "c:\\proyectos_git\\eclipse\\Prisma2\\migiro\\migiro-api\\src\\main\\resources\\www\\reports\\detalladoImposicionGiros.json" } );
	}
	
    private static void json(String[] args) throws Exception {
    	/*int tipo = Integer.parseInt( args[1] );
    	int app = Integer.parseInt( args[2] );
    	String archivo = args[3];
    	File f = new File( archivo );
    	String name = f.getName().substring( 0, f.getName().indexOf('.') );
    	String json = readFile( f );
    	String encrypted = CipherUtils.cryptBasic(new String(Base64.getEncoder().encode(json.getBytes(StandardCharsets.UTF_8))));
    	String sql = "DELETE FROM RECURSOS_JSON WHERE TIPO="+tipo+" AND ID_APLICACION="+app+" AND NOMBRE='"+name+"';";
    	sql += "\nINSERT INTO RECURSOS_JSON VALUES ( "+tipo+", "+app+", '"+name+"', '"+encrypted+"' );";
    	String s = new String(Base64.getDecoder().decode(CipherUtils.decryptBasic(encrypted).getBytes()),StandardCharsets.UTF_8);
    	if( !s.equals(json) ){
    		throw new InformationException("ENCRIPCIÓN NO CONFIABLE");
    	}
    	StringSelection stringSelection = new StringSelection(sql);
    	Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    	clipboard.setContents(stringSelection, null);
    	AppLogger.stdout( "El resultado quedó almacenado en el clipboard" );*/
	}

}
