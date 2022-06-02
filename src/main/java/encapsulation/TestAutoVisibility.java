package main.java.encapsulation;

public class TestAutoVisibility {
    public static void main( String[] args ) {
        Auto a1 = new Auto();
//        System.out.println( a1.manufacturer ); //cf: prviate!
        System.out.println( a1.shortName );
        System.out.println( a1.model );         // Okay, da im selben Paket (siehe Klasse Rennwagen)
        System.out.println( a1.dateOfManufacturing );
    }
}
