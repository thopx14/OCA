package main.java.vererbung.aufgaben.textformatter;

public class HtmlTextFormat extends TextFormat {

    public HtmlTextFormat( String text ) {
        super( text );
    }

    @Override
    public String fett() {
        return "<b>" + this.text + "</b>";
    }
}
