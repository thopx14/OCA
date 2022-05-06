package main.java.vererbung.aufgaben;

public class EmailsAbrufer extends Service {

    @Override
    public String doSomething() {
        return "Emails senden, Emails empfangen ... ich mache genau mein Ding.";
    }

    public EmailsAbrufer() {
        super( "Emails abrufen" );
    }
}
