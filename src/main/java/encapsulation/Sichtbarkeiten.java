/**
 * @see Kursmaterialien_Patrin/Projekte/PackagesImportsVisibilities/src/regeln/Sichtbarkeiten.java
 * @see Kursmaterialien_Patrin/Projekte/PackagesImportsVisibilities/src/regeln/SichtbarkeitenUndUeberschreiben.java
 */
package main.java.encapsulation;

class Tier {
    void laufen() {
    }

    protected void springen() {
    }
}

class Hund extends Tier {
    /*
        Geht beides, da die Sichtbarkeiten nicht verändert wurden!
     */
    void laufen() {
    }

    protected void springen() {
    }
}

class Maus extends Tier {

    protected void laufen() {
    } // Sichtbarkeit erhöht. Problemlos möglich!

    public void springen() {
    } // Sichtbarkeit erhöht, Problemlos möglich!
}

class Kaenguru extends Tier {
//    private void laufen() {}  // cf: Sichtbarkeit darf nicht weniger sein als in der ursprünglichen Klasse!
//    void springen() {}        // cf: Sichtbarkeit darf nicht weniger sein als in der ursprünglichen Klasse!
}


public class Sichtbarkeiten {
    public static void main( String[] args ) {
        
    }
}
