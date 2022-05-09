package main.java.vererbung.aufgaben;

import java.util.Objects;

public class Kurs {

    private static int nummerCounter = 1;
    private final int kursNummer;
    private final String name;
    private final Teilnehmer[] teilnehmer;
    private final Dozent dozent;

    public Kurs( String name, int maxTeilnehmer, Dozent dozent ) {
        this.name = Objects.requireNonNull( name );
        this.dozent = dozent;

        if ( maxTeilnehmer > 0 ) {
            this.teilnehmer = new Teilnehmer[maxTeilnehmer];
        } else {
            this.teilnehmer = new Teilnehmer[10];
        }

        this.kursNummer = nummerCounter++;
    }

    public void addTeilnehmer( Teilnehmer teilnehmer ) throws KursVollException {
        boolean teilnehmerAdded = false;
        for ( int i = 0; i < this.teilnehmer.length; i++ ) {
            if ( this.teilnehmer[i] == null ) {
                this.teilnehmer[i] = teilnehmer;
                teilnehmerAdded = true;
                break;
            }
        }
        if ( ! teilnehmerAdded ) {
            throw new KursVollException( this.kursNummer, this.name );
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append( "Kurs (id " ).append( this.kursNummer ).append( "):\n\t '" ).append( this.name ).append( "'\n" );
        sb.append( "Dozent:\n\t" ).append( this.dozent ).append( "\n" );
        sb.append( "Teilnehmer: " ).append( "\n\t" );
        for ( Teilnehmer tn : this.teilnehmer ) {
            if ( tn != null )
                sb.append( tn ).append( "\n\t" );
        }
        return sb.toString();
    }
}
