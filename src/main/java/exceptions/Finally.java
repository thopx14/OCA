package main.java.exceptions;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class Finally {


    /*
     * Hier wird die Ausnahme dann wieder weitergeleitet und es wird nichts zurückgegeben!
     *
     */
    static int foo3() {
        try {
            return 0;
        } finally {
            System.out.println( 1 / 0 );
            return - 1;
        }
    }

    /*
     *
     * Gefährlich! Hier wird die ArithmeticException geschluckt und es wird -1 zurück gegeben!
     * Die ArithmeticException kommt quasi nicht vor.
     */
    static int foo2() {
        try {
            System.out.println( 1 / 0 );

            return 0;
        } finally {
            return - 1;
        }
    }

    static int foo() {
        try {
            return 0;
        } finally {
            // Hier wird auf jeden Fall -1 zurückgeliefert, da finally immer als letzte Anweisung
            // ausgeführt wird!
            return - 1;
        }

    }

    public static void main( String[] args ) {

        System.out.println( foo() );
        System.out.println( foo2() );
        System.out.println( foo3() );

        try {
            writeXmlFile();

        } catch ( XMLStreamException e ) {
            throw new RuntimeException( e );
        }

    }


    /**
     * Die Methode behandelt nur die IOException und leitet die XMLStreamException an den
     * Aufrufer weiter. Dies ist schöner, da der Code lesbarer bleibt.
     *
     * @throws XMLStreamException
     */
    private static void writeXmlFile() throws XMLStreamException {

        XMLStreamWriter xmlStreamWriter = null;

        try {
            PrintWriter printWriter = new PrintWriter( "persons.xml", StandardCharsets.UTF_8 );
            xmlStreamWriter = XMLOutputFactory.newInstance().createXMLStreamWriter( printWriter );
            xmlStreamWriter.writeStartDocument();
            xmlStreamWriter.writeStartElement( "persons" );
            xmlStreamWriter.writeCharacters( "Thomas" );
            xmlStreamWriter.writeEndElement();


        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
            // Muss unbedingt geschlossen werden, sonst wird nix geschrieben
            if ( xmlStreamWriter != null ) {
                xmlStreamWriter.close();
            }
        }
    }
}
