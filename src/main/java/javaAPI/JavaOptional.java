package main.java.javaAPI;

import java.util.Objects;
import java.util.Optional;

public class JavaOptional {
    public static void main( String[] args ) {
        Cop hutch = new Cop( "Hutch" );
        System.out.println( hutch.getPartner() );
        hutch.setPartner( new Cop( "Starsky" ) );
        // Mit isPresent() kann das Optional dann schließlich abgeprüft werden, ob in ihm ein Wert
        // enthalten ist.
        if ( hutch.getPartner().isPresent() ) {
            System.out.println( "Hutch hat einen Partner!" );
        }
    }
}

class Cop {
    private Cop partner;
    private final String name;

    public Cop( String name ) {
        this.name = Objects.requireNonNull( name );
    }

    public void setPartner( Cop partner ) {
        this.partner = Objects.requireNonNullElse( partner, new Cop( "Starsky" ) );
    }

    public Optional<Cop> getPartner() {
        return Optional.ofNullable( partner ); // Im Fehlerfall wird 'Optional.empty' zurück geliefert.
    }
}
