package main.java.vererbung.aufgaben;

public class Teilnehmer {

    private static int idCounter = 1;
    private final int id;
    private final String name;

    public Teilnehmer( String name ) {
        this.name = name;
        this.id = idCounter++;
    }

    @Override
    public String toString() {
        return this.name + " (id: " + this.id + ")";
    }
}
