package main.java.javaAPI;

import java.util.Objects;

public class JavaLangObject {
    public static void main( String[] args ) {
        Smartphone s1 = new Smartphone();
        s1.name = "Samsung";
        System.out.println( s1 );

        Smartphone s2 = new Smartphone();
        s2.name = "Apple";
        System.out.println( s2 );

        Notebook n1 = new Notebook();
        n1.price = 250;
        System.out.println( n1 );

        Notebook n2 = new Notebook();
        n2.price = 250;
        System.out.println( n2 );

        ElectronicDevice e1 = new ElectronicDevice();
        e1.price = 250;
        System.out.println( e1 );

        System.out.println( s1.equals( s2 ) );
        System.out.println( s1.hashCode() );
        System.out.println( s2.hashCode() );

        System.out.println( n1.equals( e1 ) );
        System.out.println( n1.hashCode() );
        System.out.println( e1.hashCode() );

        System.out.println( n1.equals( n2 ) );
        System.out.println( n1.hashCode() );
        System.out.println( n2.hashCode() );

    }
}

class ElectronicDevice {
    String name;
    int price;

    @Override
    public String toString() {
        return "ElectronicDevice{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    /*
    Von IntelliJ generierte Methoden:
     */
    @Override
    public boolean equals( Object o ) {
        // 1. Test, ob this == o, im Falle, dass auf dieselbe Referenz getestet wird.
        if ( this == o )
            return true;
        // 2.+ 3. Sollte o == null sein, wird automatisch 'false' zurückgeliefert. Auch wenn
        // beide Klassen nicht denselben Bauplan haben (getClass()).
        if ( o == null || getClass() != o.getClass() )
            return false;

        // 3. Die Klassen haben denselben Bauplan, also funktioniert ein TypCast hier.
        ElectronicDevice that = ( ElectronicDevice ) o;

        // 4. Anschließend wird verglichen, ob this.price != o.price ist.
        if ( price != that.price )
            return false;

        // 5. Falls immer noch alles ok ist, wird nochmal this.name mittels String.equals(String other) verglichen.
        // Kann mit Objects.equals( name, that.name ) ersetzt werden! Object.equals macht genau das gleiche (name.equals(that.name))
        return Objects.equals( name, that.name );
    }

    /*
    Die hashCode-Methode liefert für jedes Objekt einen spezifischen Hashcode. Dies ist u.A. wichtig für dynamische Datenstrukturen wie z.B.
    HashMap. Wie genau der HashCode berechnet wird, spielt im Endeffekt keine Rolle. Wichtig ist nur, dass er eindeutig ist.
     */
    @Override
    public int hashCode() {
        // Falls name == null ist, so wird einfach 0 dazu gezählt!
        int result = name != null ? name.hashCode() : 0;
        // Recht kryptisch, aber okay ;-)
        result = 31 * result + price;
        return result;
    }
}

class Smartphone extends ElectronicDevice {
    double screenSize;

    @Override
    public String toString() {
        return "Smartphone{" +
                "screenSize=" + screenSize +
                "} " + super.toString();
    }

    @Override
    public boolean equals( Object o ) {
        // 1.
        if ( this == o )
            return true;
        // 2. + 3.
        if ( o == null || getClass() != o.getClass() )
            return false;
        // 4. Hier anders als oben, da geschaut wird, ob in der Oberklasse auch alles in Ordnung ist. Ansonsten sind die Objekte ja nicht gleich.
        if ( ! super.equals( o ) )
            return false;

        // 5.
        Smartphone that = ( Smartphone ) o;

        // 6. Hier wird eben ein double anstelle eines Strings verglichen (siehe oben).
        return Double.compare( that.screenSize, screenSize ) == 0;
    }

    @Override
    public int hashCode() {
        // Es wird zuerst der Hashcode der Oberklasse ermittelt..
        int result = super.hashCode();
        // ..und dann weitere eigene Berechnungen angestellt.
        long temp;
        // Hier wird dann versucht ein Double in einen Integer zu Casten (wie auch immer ;-)).
        temp = Double.doubleToLongBits( screenSize );
        result = 31 * result + ( int ) ( temp ^ ( temp >>> 32 ) );
        // Anschließend wird der Hashcode zurückgeliefert
        return result;
    }
}

class Notebook extends ElectronicDevice {
    double screenSize;
    boolean isExtendable;

    @Override
    public String toString() {
        return "Notebook{" +
                "screenSize=" + screenSize +
                ", isExtendable=" + isExtendable +
                "} " + super.toString();
    }

    /*
    Siehe oben!
     */
    @Override
    public boolean equals( Object o ) {
        //1.
        if ( this == o )
            return true;
        // 2. + 3.
        if ( o == null || getClass() != o.getClass() )
            return false;
        // 4.
        if ( ! super.equals( o ) )
            return false;

        Notebook notebook = ( Notebook ) o;

        // 5.
        if ( Double.compare( notebook.screenSize, screenSize ) != 0 )
            return false;
        // 6.
        return isExtendable == notebook.isExtendable;
    }

    /*
    Siehe oben
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits( screenSize );
        result = 31 * result + ( int ) ( temp ^ ( temp >>> 32 ) );
        // Bei Boolean wird immer 1 oder 0 dazu addiert.
        result = 31 * result + ( isExtendable ? 1 : 0 );
        return result;
    }
}
