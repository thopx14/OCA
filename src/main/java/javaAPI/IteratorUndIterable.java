package main.java.javaAPI;

import java.util.*;

public class IteratorUndIterable {
    public static void main( String[] args ) {

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add( "Hallo" );
        stringList.add( "Welt" );
        System.out.println( stringList );

        // Erweiterte for-Schleife...
        for ( String s : stringList ) {
            System.out.println( s );
        }

        //... wird eigentlich so umgewandelt vom Compiler
        for ( Iterator<String> i = stringList.iterator(); i.hasNext(); ) {
            System.out.println( i.next() );
            i.remove(); // hierdurch ist es möglich die Liste über den übergebenen Iterator zu löschen!
        }

        // Die Liste ist jetzt leer.
        System.out.println( stringList );

        Auto vw = new Auto( "Volkswagen", 120 );
        Auto porsche = new Auto( "Porsche", 700 );
        Auto tesla = new Auto( "Tesla", 300 );

        Garage garage = new Garage();
        garage.addAuto( vw );
        garage.addAuto( porsche );
        garage.addAuto( tesla );

        for ( Auto auto : garage ) {
            System.out.println( auto );
        }

        for ( Iterator<Auto> iterator = garage.iterator(); iterator.hasNext(); ) {
            Auto auto = iterator.next();
            System.out.println( auto );
//            iterator.remove(); // Hier schlägt remove() fehl, da die Operation nicht supported wird! Siehe unten
        }

        // Hier kommt true raus. Es gibt noch Elemente. iterator.remove() schlug fehl (siehe oben!)
        System.out.println( garage.iterator().hasNext() );

    }
}

record Auto(String fabrikat, int ps) {
}

class Garage implements Iterable<Auto> {
    private final ArrayList<Auto> autos;

    public Garage() {
        this.autos = new ArrayList<>();
    }

    // Hier wird die ArrayList zurückgegeben. Diese kann auch verändert werden - Achtung!
//    public ArrayList<Auto> getAutos() {
//        return autos;
//    }

    public void addAuto( Auto a ) {
        autos.add( Objects.requireNonNull( a ) );
    }

    @Override
    public Iterator<Auto> iterator() {
    /*  return autos.iterator(); // So könnte mxn einfach den Iterator der Klasse ArrayList nutzen, oder:
        Lokale Klasse - ähnlich einer lokalen Variablen.
     */
        class GarageIterator implements Iterator<Auto> {

            /*
            Hier wird ein neuer Iterator<Auto> erzeugt und sofort zurückgegeben. Um mit einer ArrayList<Auto> zu arbeiten,
            muss man zuerst den Iterator der Klasse ArrayList mithilfe von autos.iterator() erfragen. Dann kann man mithilfe von
            hasNext() und next() darüber iterieren. Ansonsten müsste man die Klasse Garage eine verkettete Liste, oder ein Array enthalten,
            damit man sauber darüber iterieren kann.

             */
            private final Iterator<Auto> autoIt;

            private GarageIterator() {
                autoIt = autos.iterator();
            }

            @Override
            public boolean hasNext() {
                return autoIt.hasNext();
            }

            @Override
            public Auto next() {
                if ( ! hasNext() ) {
                    throw new NoSuchElementException( "Kein Auto mehr vorhanden!" );
                }
                return autoIt.next();
            }
        }
        return new GarageIterator();
    }
}





