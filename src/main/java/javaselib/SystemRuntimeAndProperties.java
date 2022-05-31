package main.java.javaselib;

import java.util.Map;
import java.util.Properties;

public class SystemRuntimeAndProperties {
    public static void main( String[] args ) {
        /*
            Hiermit lässt sich das Environment des angemeldeten Benutzers ausgeben.
         */
        Map<String, String> getenv = System.getenv();
//        System.out.println( getenv );

        getenv.forEach( ( s1, s2 ) -> System.out.println( s1 + " " + s2 ) );

        /*
            So lassen sich gezielt Werte abfragen.
         */
        System.out.println( System.getenv( "HOME" ) );


        /*
            Hiermit lassen sich u.A. Programmschalter erfragen, welche die JVM betreffen.
            Ebenfalls lassen sich Umgebungsvariablen erfragen, wie z.B. den Benutzernamen, oder
            das aktuelle Verzeichnis.
         */
        Properties properties = System.getProperties();
        System.out.println( properties );
        System.out.println( properties.getProperty( "user.home" ) );
        System.out.println( properties.getProperty( "user.dir" ) );
        System.out.println( properties.getProperty( "user.name" ) );
        System.out.println( properties.getProperty( "os.name" ) );
        System.out.println( properties.getProperty( "java.version" ) );
        // ...

        /*
            Man kann auch eigene Properties setzen, mithilfe des Schalters -D beim Aufruf des Programms.
            Der Aufruf sollte so erfolgen (im Ordner target/classes):
            java -DSchalter=22 main.java.javaselib.SystemRuntimeAndProperties
         */
        System.out.println( properties.getProperty( "SCHALTER" ) ); //22, falls -DSCHALTER=22
        System.out.println( properties.getProperty( "SCHALTER" ) ); //"", falls -DSCHALTER
        System.out.println( properties.getProperty( "SCHALTER" ) ); // null, falls -DSCHALTER fehlt.

    }
}
