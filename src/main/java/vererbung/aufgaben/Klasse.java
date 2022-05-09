package main.java.vererbung.aufgaben;

public class Klasse {

    public static void main( String[] args ) {

        Kurs oca = new JavaKurs( "Oracle Certified Associate",
                5,
                new Dozent( "Klaus Bärbel" ) );

        Kurs ocp = new Kurs( "Oracle Certified Professional",
                10,
                new Dozent( "Hans Dampf" ) );

        try {
            oca.addTeilnehmer( new Teilnehmer( "Albert Einstein" ) );
            oca.addTeilnehmer( new Teilnehmer( "Angela Merkel" ) );
            oca.addTeilnehmer( new Teilnehmer( "Knut Mithut" ) );
            oca.addTeilnehmer( new Teilnehmer( "Franz Allows" ) );
            oca.addTeilnehmer( new Teilnehmer( "Herbert Schulze" ) );
            // Aber hier ist der Kurs voll!
//            oca.addTeilnehmer( new Teilnehmer( "Rudolf MitDerRotenNase" ) );
            ocp.addTeilnehmer( new Teilnehmer( "Rudolf MitDerRotenNase" ) );
            ocp.addTeilnehmer( new Teilnehmer( "Olaf Schubert" ) );
            ocp.addTeilnehmer( new Teilnehmer( "Thorsten Sträter" ) );
            ocp.addTeilnehmer( new Teilnehmer( "Gundula Gause" ) );

        } catch ( KursVollException e ) {
            System.err.println( e.getMessage() );
        }

        System.out.println( oca );
        System.out.println( ocp );
    }
}
