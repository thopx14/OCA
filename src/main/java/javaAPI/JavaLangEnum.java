package main.java.javaAPI;

import java.util.ArrayList;

public class JavaLangEnum {
    public static void main( String[] args ) {
        Cars c1 = Cars.PORSCHE;
        Cars c2 = Cars.MERCEDES;
        Cars c3 = Cars.TESLA;
        System.out.println( c1 ); // toString überschrieben im Enum (siehe unten).
        System.out.println( c1.name() );
        System.out.println( c1.ordinal() );
        System.out.println( c1.getDeclaringClass() );
        System.out.println( c1.compareTo( c2 ) ); // -1 (<0) da von der Ordinalzahl kleiner.
        System.out.println( c3.compareTo( c2 ) ); // 1 (>0) da von der Ordinalzahl kleiner.
        System.out.println( Cars.VOLKSWAGEN.getPS() );
        System.out.println( Cars.PORSCHE.getPS() );
        System.out.println( Cars.MERCEDES.getPS() );
        System.out.println( Cars.TESLA.getPS() );
        System.out.println( Cars.TESLA.getLowerCaseName() );
        System.out.printf( "Cars.valueOf('VOLKSWAGEN'): %s%n", Cars.valueOf( "VOLKSWAGEN" ) );
        // IllegalArgumentException!
//        System.out.printf( "Cars.valueOf('VOLKSWAGEn'): %s%n", Cars.valueOf( "VOLKSWAGEn" ) );

        ArrayList<Cars> garage = new ArrayList<>();
        garage.add( c1 );
        garage.add( c2 );
        garage.add( c3 );

        for ( Cars cars : garage ) {
            if ( cars.isRaceCar() ) {
                System.out.printf( "%s ist ein Rennwagen!%n", cars );
            }
        }

        // Eine andere Möglichkeit alle Elemente aus dem enum Cars zu erhalten
        for ( Cars value : Cars.values() ) {
            System.out.println( value );
        }

    }
}

/*

Generierte Klasse des Compilers (dekompiliert mit http://www.javadecompilers.com/):
===========================================

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3)
// Source File Name:   JavaLangEnum.java

package main.java.javaAPI;


final class Cars extends Enum
{

    public static Cars[] values()
    {
        return (Cars[])$VALUES.clone();
    }

    public static Cars valueOf(String name)
    {
        return (Cars)Enum.valueOf(Cars.class, name);
    }

    private Cars(String s, int i)
    {
        super(s, i);
    }


private static Cars[] $values()
        {
        return (new Cars[] {
        VOLKSWAGEN, PORSCHE, MERCEDES, TESLA
        });
        }

 // Das sind die privaten Attribute. Jeweils eins pro Enumeration:
 // =================================================================
public static final Cars VOLKSWAGEN = new Cars("VOLKSWAGEN", 0); // Hinten steht jeweils die Ordinalzahl.
public static final Cars PORSCHE = new Cars("PORSCHE", 1);
public static final Cars MERCEDES = new Cars("MERCEDES", 2);
public static final Cars TESLA = new Cars("TESLA", 3);
private static final Cars $VALUES[] = $values();

 }
 */

interface RaceCar {
    default boolean isRaceCar() {
        return false;
    }
}


/*
Ein enum kann sogar ein Interface implementieren.
 */
enum Cars implements RaceCar {
    VOLKSWAGEN( "VW" ),
    /* Hier wird dann eine Art anonyme innere Klasse aufgebaut und die Methode aus RaceCar direkt überschrieben.
       Da Porsche nur ein Rennwagen sein soll, wird hier true geliefert, ansonsten false (default im Interface).
     */
    PORSCHE( "PORSCH" ) {
        @Override
        public boolean isRaceCar() {
            return true;
        }
    },
    MERCEDES( "MERC" ),
    TESLA( "TSL" );

    private final String shortName;

    /*
    Konstruktor. Ist automatisch 'private' da es eine finale Klasse ist!
     */
    /* private */ Cars( String shortName ) {
        this.shortName = shortName;
    }
    /*
        Es ist sogar möglich die toString() Methode aus Objekt zu überschreiben.
         */

    @Override
    public String toString() {
        return this.shortName + ": " + this.name();
    }

    /*
    Es ist möglich Instanz methoden in enums zu erstellen.
    This zeigt ja auf das aktuelle Element (siehe oben).
     */
    public int getPS() {
        return switch ( this ) {
            case VOLKSWAGEN -> 100;
            case PORSCHE -> 255;
            case MERCEDES -> 180;
            case TESLA -> 400;
        };
    }

    public String getLowerCaseName() {
        return this.name().toLowerCase();
    }
}
