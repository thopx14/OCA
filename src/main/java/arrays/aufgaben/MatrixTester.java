package main.java.arrays.aufgaben;

public class MatrixTester {
    public static void main( String[] args ) {

        IntMatrix m1 = new IntMatrix( 2, 3 );
        IntMatrix m2 = new IntMatrix( 5, 3, 100 );
        System.out.println( m1 );
        System.out.println( m1.get( 1, 2 ) );
        IntMatrix m3 = IntMatrix.getRandomMatrix( 4, 6, 200 );
        System.out.println( m3 );

        System.out.println();
        System.out.printf( "m1.equals(m2) == %s%n", m1.equals( m2 ) );
        IntMatrix m4 = new IntMatrix( 5, 5, 5 );
        IntMatrix m5 = new IntMatrix( 5, 5, 5 );
        System.out.printf( "m4.equals(m5) == %s%n", m4.equals( m5 ) );
        IntMatrix m6 = new IntMatrix( 7, 5, 10 );
        IntMatrix m7 = new IntMatrix( 7, 5 );
        System.out.printf( "m6.equals(m7) == %s%n", m6.equals( m7 ) );
        IntMatrix m8 = new IntMatrix( 2, 6 );
        IntMatrix m9 = new IntMatrix( 7, 5 );
        System.out.printf( "m8.equals(m9) == %s%n", m8.equals( m9 ) );

        IntMatrix m10 = m4.add( m5 );
        System.out.println( m10 );

        IntMatrix m11 = IntMatrix.getRandomMatrix( 2, 2, 4 );
        System.out.println( "========== M11 ============" );
        System.out.println( m11 );
        IntMatrix m12 = IntMatrix.getRandomMatrix( 2, 2, 4 );
        System.out.println( "========== M12 ============" );
        System.out.println( m12 );
        IntMatrix m13 = m11.add( m12 );
        System.out.println( "========== M13 ============" );
        System.out.println( m13 );


    }
}
