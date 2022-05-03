package main.java.arrays.aufgaben;

import java.util.Objects;

public class Hafen {

    public static final int MAX_SCHIFFE = 100;
    private final Schiff[] schiffe = new Schiff[MAX_SCHIFFE];
    private String hafenName;

    public Hafen() {
        this.hafenName = "Unbekannter Hafen";
    }

    public Hafen( String hafenName ) {
        this.hafenName = Objects.requireNonNull( hafenName );
    }

    public void addSchiff( Schiff s ) throws HafenVollException {
        addSchiffToHafen( s );
    }

    private void addSchiffToHafen( Schiff s ) throws HafenVollException {
        int schiffeCnt = 0;
        do {
            if ( this.schiffe[schiffeCnt] == null ) {
                this.schiffe[schiffeCnt] = s;
                break;
            }
            schiffeCnt++;
        } while ( schiffeCnt < this.schiffe.length );

        if ( schiffeCnt == this.schiffe.length )
            throw new HafenVollException("Hafen ist voll!");
    }

    public Schiff[] getSchiffe() {
        return this.schiffe;
    }

    public boolean isSchiffImHafen( Schiff s ) {
        for ( Schiff schiff : this.schiffe ) {
            if ( schiff == s ) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        int schiffCnt = 0;
        for ( Schiff value : this.schiffe ) {
            if ( value == null ) {
                break;
            }
            schiffCnt++;
        }
        StringBuilder sb = new StringBuilder();
        sb.append( "Hafen (Schiffe: " )
                .append( schiffCnt )
                .append( ". Freie Plätze: " )
                .append( ( MAX_SCHIFFE - schiffCnt ) )
                .append( ")" )
                .append( "\n" );
        sb.append( "Folgende Schiffe sind zur Zeit im Hafen vor Anker: \n" );

        for ( Schiff schiff : this.schiffe ) {
            if ( schiff != null )
                sb.append( schiff ).append( "\n" );
        }
        return sb.toString();
    }

    public String getHafenName() {
        return hafenName;
    }

    public void setHafenName( String hafenName ) {
        this.hafenName = Objects.requireNonNull( hafenName );
    }
}
