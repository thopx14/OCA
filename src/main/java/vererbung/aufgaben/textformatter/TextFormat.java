package main.java.vererbung.aufgaben.textformatter;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public abstract class TextFormat {

    protected String text;
    private static final ArrayList<TextFormat> registeredFormatters = new ArrayList<>();

    public TextFormat( String text ) {
        this.text = text;
        registeredFormatters.add( this );
    }

    public abstract String fett();

    public void setText( String text ) {
        this.text = text;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ", Text: " + this.text;
    }

    public static ArrayList<TextFormat> getAllRegisteredFormatters() {
        return registeredFormatters;
    }

    public static boolean hasHtmlFormatter() {
        for ( TextFormat registeredFormatter : registeredFormatters ) {
            if ( registeredFormatter instanceof HtmlTextFormat )
                return true;
        }
        return false;
    }
}
