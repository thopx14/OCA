package main.java.lambda.aufgaben.javatipp;

import java.util.ArrayList;
import java.util.List;

public class JavaTipp {
    private final String text;
    private final ArrayList<Topic> topic = new ArrayList<>();
    private static final byte MAX_TOPIC_COUNT = 3;


    public JavaTipp( String text, Topic... topic ) {
        this.text = text;
        if ( topic.length > MAX_TOPIC_COUNT )
            throw new IllegalArgumentException( "Too many topics!" );

        this.topic.addAll( List.of( topic ) );

    }

    public String getText() {
        return text;
    }

    public ArrayList<Topic> getTopic() {
        return topic;
    }

    @Override
    public String toString() {
        return "Text: " + text +
                "Themen=" + topic;
    }
}