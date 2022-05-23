package main.java.javaAPI;

public class WrapperKlassen {
    public static void main( String[] args ) {

        /*
        The following boxing types exists:
         */
        Byte b;
        Short s;
        Integer i;
        Long l;
        Float f;
        Double d;
        Boolean bol;
        Character c;

        /*
         Automatic Autoboxing.
         */
        Integer i1 = 12;    // Integer i1 = Integer.valueOf(12);
        Integer myInt = Integer.valueOf( "12" );
        int myInt2 = Integer.parseInt( "B", 16 );
        System.out.println( myInt );
        System.out.println( myInt2 );

        Integer myInt3 = myInt2; // Integer.valueOf(myInt2);

        /*
        Automatic AutoUnboxing
         */
        int x = i1;         // int x = i1.intValue();

        /*
        AutoBoxing and AutoUnboxing
         */

        // Integer objects are immutable. The below code will create a new Integer Object (or a cashed one).
        i1++;               // i1 = i1 + 1 ==> i1 = Integer.valueOf(i1.intValue() + 1 );

//        Short i2 = Short.valueOf( 12 ); cf: Int literal, needs cast to short!
        Short i2 = Short.valueOf( ( short ) 12 );
        Short i3 = 12;      // The same as above (autoboxing from compiler)

//        Byte b1 = 1200; // cf: Too big for byte (Byte by = Byte.valueOf((byte) 1200));

        Integer i4 = 12;
        Integer i5 = 22;

        System.out.println( i5.compareTo( i4 ) ); // >0
        System.out.println( i4.compareTo( i5 ) ); // <0
        System.out.println( i4.compareTo( i4 ) ); // =0

        /*
        It's not cheap to use boxing in loops, e.g.:
         */
        for ( int j = 0; j < 1000; j++ ) {
            // It's generated like this
            Object[] arr = new Object[3];
            arr[0] = Integer.valueOf( j );
            arr[1] = Double.valueOf( 2.0 );
            arr[2] = Character.valueOf( 'c' );

            System.out.printf( "", arr );
//            System.out.printf( "", i, 2.0, '3' ); // Object... args
        }

        /*
        Compare references:
         */
        Integer number1 = 1;
        Integer number2 = 1;
        Integer number3 = 1000;
        Integer number4 = 1000;

        System.out.println( number1 == number2 ); // true --> They are equal because of the number caching (See class Integer.IntegerCache)
        System.out.println( number3 == number4 ); // false --> No boxing because compare references.
        System.out.println( number1 <= number4 ); // true -> Boxing takes place here.
        System.out.println( number3 == number4 + 0 ); // true -> Boxing takes place here, because of arithmetic operation (+0)

        /*
        NullPointer
         */
        Byte bNull = null;
//        System.out.println( bNull.byteValue() ); cf: NullPointerException

        switch ( bNull ) { // NullPointerException, but not visible at beginning!

        }
    }
}
