package main.java.vererbung.aufgaben;

public class Defrag extends Service {

    @Override
    public String doSomething() {
        return "Ich defragmentiere ...";
    }

    public Defrag() {
        super( "Defragmentierung" );
    }
}
