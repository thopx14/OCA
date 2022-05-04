package main.java.arrays.aufgaben;

import java.util.Arrays;

public class IntMatrix {

    private final int[][] matrix;
    private final StringBuilder sb = new StringBuilder();


    public IntMatrix( int x, int y ) {
        this.matrix = new int[x][y];
    }

    public IntMatrix( int x, int y, int defValue ) {
        this.matrix = new int[x][y];
        for ( int[] ints : this.matrix ) {
            Arrays.fill( ints, defValue );
        }
    }

    public IntMatrix( int[][] arr ) {
        this.matrix = arr;
    }

    private IntMatrix( int x, int y, int from, int to ) {
        this.matrix = new int[x][y];
        for ( int[] ints : this.matrix ) {
            for ( int i = 0; i < ints.length; i++ ) {
                ints[i] = ( int ) ( from + Math.round( Math.random() * ( to - from ) ) );
            }
        }
    }

    /**
     * Creates a random matrix with dimensions {@param x} and {@param x} with pseudo random values from
     * [0 ... randomSeed]
     *
     * @param x          dimX
     * @param y          dimY
     * @param randomSeed value range from [0 ... randomSeed]
     * @return a new InMatrix object.
     */
    public static IntMatrix getRandomMatrix( int x, int y, int randomSeed ) {
        return new IntMatrix( x, y, 0, randomSeed );
    }

    public int get( int x, int y ) {
        return this.matrix[x][y];
    }

    public int getRowCount() {
        return this.matrix.length;
    }

    public int getColumnCount() {
        int sumCols = 0;
        for ( int[] ints : this.matrix ) {
            sumCols++;
        }
        return sumCols;
    }

    /**
     * Adding two matrices.
     */
    public IntMatrix add( IntMatrix other ) throws RuntimeException {
        // Check if this and other are of some size.
        if ( getColumnCount() != other.getColumnCount() || getRowCount() != other.getRowCount() )
            throw new RuntimeException( "Both matrices needs to be of same size!" );


        // Cloning old array to get the actual size for the new array.
        int[][] newMatrix = this.matrix.clone();
        for ( int i = 0; i < getRowCount(); i++ ) {
            for ( int j = 0; j < getColumnCount(); j++ ) {
                newMatrix[i][j] = get( i, j ) + other.get( i, j );
            }
        }

        return new IntMatrix( newMatrix );
    }


    @Override
    public String toString() {
        // First of all remove all characters present in StringBuilder.
        sb.delete( 0, sb.length() );
        // Then start filling it freshly.
        for ( int i = 0; i < getRowCount(); i++ ) {
            for ( int j = 0; j < getColumnCount(); j++ ) {
                if ( j != ( getColumnCount() - 1 ) ) {
                    sb.append( get( i, j ) ).append( ", " );
                } else {
                    sb.append( get( i, j ) );
                }
            }
            // Do not add newline if it's the end of the array.
            if ( i != getRowCount() - 1 ) {
                sb.append( "\n" );
            }
        }
        return sb.toString();
    }

    public boolean equals( IntMatrix other ) {
        // First check if the rows and columns are of same size.
        if ( getRowCount() != other.getRowCount() || getColumnCount() != other.getColumnCount() ) {
            return false;
        }

        for ( int i = 0; i < getRowCount(); i++ ) {
            for ( int j = 0; j < getColumnCount(); j++ ) {
                if ( get( i, j ) != other.get( i, j ) )
                    return false;
            }
        }
        return true;
    }
}

