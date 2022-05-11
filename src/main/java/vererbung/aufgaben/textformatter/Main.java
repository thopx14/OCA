package main.java.vererbung.aufgaben.textformatter;

public class Main {

    public static void main( String[] args ) {
        String text = "Heute ist Dienstag";

        HtmlTextFormat htmlFormat = new HtmlTextFormat( text );
        System.out.println( htmlFormat ); // Html-Formatter, Text: Heute ist Dienstag
        System.out.println( htmlFormat.fett() ); // <b>Heute ist Dienstag</b>

        MarkdownTextFormat mdFormat = new MarkdownTextFormat( text );
        System.out.println( mdFormat ); // Markdown-Formatter, Text: Heute ist Dienstag
        System.out.println( mdFormat.fett() );  // __Heute ist Dienstag__

        mdFormat.setText( "Freitag" );

        System.out.println( mdFormat ); // Markdown-Formatter, Text: Freitag
        System.out.println( mdFormat.fett() );  // __Freitag__

        System.out.println( "All registered Formatters:" );
        for ( TextFormat allRegisteredFormatter : TextFormat.getAllRegisteredFormatters() ) {
            System.out.println( allRegisteredFormatter.getClass().getSimpleName() );
        }

        System.out.println( TextFormat.hasHtmlFormatter() );
    }
}
