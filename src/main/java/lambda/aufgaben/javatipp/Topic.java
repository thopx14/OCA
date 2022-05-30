package main.java.lambda.aufgaben.javatipp;

public class Topic {
    private final String text;

    public Topic( String text ) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return text;
    }
}
