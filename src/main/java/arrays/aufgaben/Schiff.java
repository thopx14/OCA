package main.java.arrays.aufgaben;

import java.util.Objects;

public class Schiff {

    private Hafen aktuellerHafen;
    private String name;

    public Schiff() {
        this.name = "Unbekanntes Schiff";
        this.aktuellerHafen = new Hafen("Unbekannter Hafen");
    }

    public Schiff( String name ) {
        this.name = name == null ? "Unbekanntes Schiff" : name;
    }

    public Schiff( String name, Hafen h ) {
        this.name = name == null ? "Unbekanntes Schiff" : name;
        this.aktuellerHafen = Objects.requireNonNull( h );
    }

    public Schiff( Hafen h ) {
        this.aktuellerHafen = Objects.requireNonNull( h );
        this.name = "Unbekanntes Schiff";
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name == null ? "Unbekanntes Schiff" : name;
    }

    @Override
    public String toString() {
        return "Schiff: " + this.name + " aktuell im Hafen: " + this.aktuellerHafen.getHafenName();
    }
}
