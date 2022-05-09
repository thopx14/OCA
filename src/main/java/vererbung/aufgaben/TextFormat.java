package main.java.vererbung.aufgaben;

public abstract class TextFormat {

    protected String text;

    public TextFormat( String text ) {
        this.text = text;
    }

    public abstract String fett();

    public void setText( String text ) {
        this.text = text;
    }

    @Override
    public String toString() {
        String[] result = this.getClass().toString().split( "\\." );
        return result[result.length - 1] + ", Text: " + this.text;
    }
}
