package no.olai.html;

import java.util.Iterator;

// Leaf
public class Todo implements TodoList {

    private String text;

    public Todo(String text) {
        this.text = text;
    }

    @Override
    public String getHtml() {
        return  this.text + "<input type=\"checkbox\">";
    }

}
