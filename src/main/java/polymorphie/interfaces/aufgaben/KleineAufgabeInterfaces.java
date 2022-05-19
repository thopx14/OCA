package main.java.polymorphie.interfaces.aufgaben;

interface Preisable {
    int getPreis();
}

abstract class Ding {
    String name;

    Ding( String name ) {
        this.name = name;
    }

    abstract String getName();
}

class Blume extends Ding implements Preisable {
    int preis;

    public Blume( String name, int preis ) {
        super( name );
        this.preis = preis;
    }

    @Override
    String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Blume{" +
                "name='" + name + '\'' +
                ", preis=" + preis +
                '}';
    }

    public int getPreis() {
        return preis;
    }
}

class Notebook extends Ding implements Preisable {
    int preis;

    public Notebook( String name, int preis ) {
        super( name );
        this.preis = preis;
    }

    public int getPreis() {
        return preis;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "name='" + name + '\'' +
                ", preis=" + preis +
                '}';
    }

    @Override
    String getName() {
        return this.name;
    }
}

public class KleineAufgabeInterfaces {

    public static void main( String[] args ) {

        Blume b1 = new Blume( "Nelke", 70 );
        Blume b2 = new Blume( "Rose", 180 );
        Blume b3 = new Blume( "Narzisse", 10 );
        Blume b4 = new Blume( "Tulpe", 150 );

        System.out.println( b1 );
        System.out.println( b2 );
        System.out.println( b3 );
        System.out.println( b4 );

        int max = maxPreis( b1, b2, b3, b4 );
        System.out.printf( "Max preis: %d%n", max );

        Notebook n1 = new Notebook( "Acer", 450 );
        Notebook n2 = new Notebook( "Macbook", 2500 );

        System.out.println( n1 );
        System.out.println( n2 );

        int max2 = maxPreis( n1, n2 );
        System.out.printf( "Max preis: %d%n", max2 );

        System.out.printf( "Max Preis: %s%n", maxPreis2( b1, b2, b3, n2, n1 ) );
    }

    private static int maxPreis( Preisable... p ) {
        int max = 0;
        for ( int i = 0; i < p.length; i++ ) {
            if ( ( i + 1 ) < p.length ) {
                int m = Math.max( p[i].getPreis(), p[i + 1].getPreis() );
                max = Math.max( m, max );
            }
        }
        return max;
    }

    private static Preisable maxPreis2( Preisable... p ) {
        int max = 0;
        Preisable temp = null;
        for ( int i = 0; i < p.length; i++ ) {
            if ( ( i + 1 ) < p.length ) {
                int m = Math.max( p[i].getPreis(), p[i + 1].getPreis() );
                max = Math.max( m, max );
                temp = p[i].getPreis() == max ? p[i] : p[i + 1];
            }
        }
        return temp;
    }
}
