package main.java.vererbung.aufgaben;

public class MarkdownTextFormat extends TextFormat {
    public MarkdownTextFormat( String text ) {
        super( text );
    }
    
    @Override
    public String fett() {
        return "__" + this.text + "__";
    }
}
