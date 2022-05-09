package main.java.vererbung.aufgaben;

public class HtmlTextFormat extends TextFormat {

    public HtmlTextFormat( String text ) {
        super( text );
    }

    @Override
    public String fett() {
        return "<b>" + this.text + "</b>";
    }
}
