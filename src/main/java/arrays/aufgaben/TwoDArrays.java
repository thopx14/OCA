package main.java.arrays.aufgaben;

import java.util.Arrays;

public class TwoDArrays {

    /**
     * Aufgabe:
     * Zwei Arrays erzeugen:
     * 0 1 2
     * 0 1 2
     * <p>
     * und
     * <p>
     * 0 1 2
     * 0 1 2
     */
    public static void main( String[] args ) throws RuntimeException {

        int[][] a1 = new int[2][3];
        a1[0] = new int[]{0, 1, 2};
        a1[1] = new int[]{0, 1, 2};

//        Entweder so...
//        int[][] a2 = new int[2][3];
//        a2[0] = new int[] {0, 1, 2};
//        a2[1] = new int[] {0, 1, 2};
//        oder so ...

        int[][] a2 = {
                {0, 1, 2},
                {0, 1, 5}
        };

        String[][] s1 = {
                {"Mo", "Die", "Mi", "Do"},
                {"Fr", "Sa", "So"}
        };

        System.out.println( "a1.equals(a2) :" );
        System.out.println( a1.equals( a2 ) );                          // false
        System.out.println( "Arrays.deepEquals( a1, a2 ) :" );          // true
        System.out.println( Arrays.deepEquals( a1, a2 ) );              // true

        // Wenn beide Referenzen 'null' sind, dann ist das Ergebnis 'true'!
        System.out.println( "Arrays.deepEquals( null, null ) :" );      // true
        System.out.println( Arrays.deepEquals( null, null ) );          // true
        System.out.println( "Arrays.deepEquals( a1, null ) :" );        // true
        System.out.println( Arrays.deepEquals( a1, null ) );            // false

        System.out.println( "Eigene equals Methode: " );
        System.out.println( equals( a1, a2 ) );

        System.out.println();
        for ( String[] strings : s1 ) {
            for ( String string : strings ) {
                System.out.print( string + " " );
            }
            System.out.println();
        }

        System.out.println( a1.length );

        System.out.println( "============================" );
        System.out.println( "            A1              " );
        System.out.println( "============================" );
        int[][] arrA1 = createArray( 4, 5 );
        System.out.println( "============================" );
        System.out.println( "            A2              " );
        System.out.println( "============================" );
        printArray( arrA1 );
        System.out.println( "============================" );
        System.out.println( "            A3              " );
        System.out.println( "============================" );
        arrA1[1][1] = 5;
        printArray( arrA1 );
        System.out.println( "============================" );
        System.out.println( "            A5              " );
        System.out.println( "============================" );
        printArray( createArray( 4, 5, 2 ) );
        System.out.println( "============================" );
        System.out.println( "            A6              " );
        System.out.println( "============================" );
        printArrayNew( createArray( 4, 5, 2 ) );
        System.out.println( "============================" );
        System.out.println( "            A7              " );
        System.out.println( "============================" );
        printArray( createBorderedArray( 5, 'X' ) );

    }

    /**
     * This method compares two two-dimensional int arrays.
     *
     * @param a Array 1 to compare
     * @param b Array 2 to compare
     * @return Returns true, if both are equal, otherwise false.
     * @throws IllegalArgumentException throws IllegalArgumentException if {@param a} and {@param a} are not of same size.
     */
    public static boolean equals( int[][] a, int[][] b ) throws RuntimeException {
        // First test if the two arrays are of same size.
        if ( a.length != b.length )
            throw new RuntimeException( "Both arrays need to be of same size (row size)" );
        for ( int[] aL : a ) {
            for ( int[] bL : b ) {
                if ( aL.length != bL.length ) {
                    throw new RuntimeException( "Both arrays need to be of same size (column size)" );
                }
            }
        }
        for ( int i = 0; i < a.length; i++ ) {
            for ( int j = 0; j < a[i].length; j++ ) {
                if ( a[i][j] != b[i][j] )
                    return false;
            }
        }
        return true;
    }

    /**
     * ================
     * A1
     * ================
     */
    public static int[][] createArray( int dimX, int dimY ) {
        return new int[dimX][dimY];
    }

    /**
     * ================
     * A2
     * ================
     */
    public static void printArray( int[][] a ) {
        for ( int[] ints : a ) {
            for ( int anInt : ints ) {
                System.out.print( anInt + " " );
            }
            System.out.println();
        }
    }

    /**
     * ================
     * A5
     * ================
     */
    public static int[][] createArray( int dimX, int dimY, int defaultNr ) {
        int[][] arrTmp = new int[dimX][dimY];
        for ( int i = 0; i < arrTmp.length; i++ ) {
            for ( int j = 0; j < arrTmp[i].length; j++ ) {
                arrTmp[i][j] = defaultNr;
            }
        }
        return arrTmp;
    }

    /**
     * ================
     * A6
     * ================
     */
    public static void printArrayNew( int[][] a ) {
        for ( int[] ints : a ) {
            for ( int anInt : ints ) {
                System.out.print( anInt + ", " );
            }
            System.out.println();
        }
    }

    /**
     * ================
     * A7
     * ================
     */
    public static char[][] createBorderedArray( int dim, char cToFill ) {
        char[][] c = new char[dim][dim];
        for ( int i = 0; i < c.length; i++ ) {
            for ( int j = 0; j < c[i].length; j++ ) {
                if ( i == 0 || i == c[i].length - 1 ) {
                    c[i][j] = cToFill;
                } else {
                    if ( j == 0 || j == c[i].length - 1 ) {
                        c[i][j] = cToFill;
                    } else {
                        c[i][j] = ' ';
                    }
                }
            }
        }
        return c;
    }

    public static void printArray( char[][] c ) {
        for ( char[] chars : c ) {
            for ( char aChar : chars ) {
                System.out.print( aChar );
            }
            System.out.println();
        }
    }

}
