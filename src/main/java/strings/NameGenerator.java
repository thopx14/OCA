package main.java.strings;

import java.util.Random;

public class NameGenerator implements CharSequence {

    private final String syllables2 = "pro|gi|ha|nar|bam|lim|hug|ref|klo|ger|hol|grau|nom|juh|kli|zru|lol|pop|zuh|muh";

    @Override
    public int length() {
        return syllables2.length();
    }


    @Override
    public char charAt( int index ) {
        return syllables2.charAt( index );
    }

    @Override
    public CharSequence subSequence( int start, int end ) {
        return syllables2.subSequence( start, end );
    }

    @Override
    public String toString() {
        return "NameGenerator{" +
                "syllables2='" + syllables2 + '\'' +
                '}';
    }

    public CharSequence generateName( int len ) {
        if ( syllables2.length() < len ) {
            String out = "len must be less than: " + syllables2.length();
            throw new IllegalArgumentException( out );
        }
        String[] arr = syllables2.split( "\\|" );
        StringBuilder sb = new StringBuilder( arr.length );
        for ( int i = 0; i < len; i++ ) {
            sb.append( arr[new Random().nextInt( arr.length - 1 )] );
            sb.replace( 0, 1, String.valueOf( sb.charAt( 0 ) ).toUpperCase() );
        }
        return sb.toString();
    }
}
