package main.java.arrays.aufgaben;

import java.util.Arrays;

public class IntMatrix {

    private final int[][] matrix;
    private final StringBuilder sb = new StringBuilder();

    /**
     * Non-arg constructor that sets this.matrix to a 5 x 5 array by default.
     */
    public IntMatrix() {
        this.matrix = new int[5][5];
    }

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

    public int[][] getMatrix() {
        return this.matrix;
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

    /**
     * Adding two matrices.
     */
    public IntMatrix add( IntMatrix other ) throws RuntimeException {
        if ( this.matrix.length != other.getMatrix().length )
            throw new RuntimeException( "Both matrices needs to be of same size!" );

        int[][] otherArr = other.getMatrix();
        // Cloning old array to get the actual size for the new array.
        int[][] newMatrix = this.matrix.clone();
        for ( int i = 0; i < this.matrix.length; i++ ) {
            for ( int j = 0; j < this.matrix[i].length; j++ ) {
                newMatrix[i][j] = this.matrix[i][j] + otherArr[i][j];
            }
        }

        return new IntMatrix( newMatrix );
    }


    @Override
    public String toString() {
        // First of all remove all characters present in StringBuilder.
        sb.delete( 0, sb.length() );
        // Then start filling it freshly.
        for ( int i = 0; i < this.matrix.length; i++ ) {
            for ( int j = 0; j < this.matrix[i].length; j++ ) {
                if ( j != ( this.matrix[i].length - 1 ) ) {
                    sb.append( this.matrix[i][j] ).append( ", " );
                } else {
                    sb.append( this.matrix[i][j] );
                }
            }
            // Do not add newline if it's the end of the array.
            if ( i != this.matrix.length - 1 ) {
                sb.append( "\n" );
            }
        }
        return sb.toString();
    }

    public boolean equals( IntMatrix other ) {
        // First check if the rows are of same size.
        if ( this.matrix.length != other.getMatrix().length ) {
            return false;
        }
        // Second check if the columns are of same size.
        for ( int[] aL : this.matrix ) {
            for ( int[] bL : other.getMatrix() ) {
                if ( aL.length != bL.length ) {
                    return false;
                }
            }
        }
        for ( int i = 0; i < this.matrix.length; i++ ) {
            for ( int j = 0; j < this.matrix[i].length; j++ ) {
                if ( this.matrix[i][j] != other.getMatrix()[i][j] )
                    return false;
            }
        }
        return true;
    }
}

