package no.olai.html;

import java.util.ArrayList;

// Composite
public class TodoComposite implements TodoComponent {

    private String title;
    private ArrayList<TodoComponent> todos;


    public TodoComposite(String title, ArrayList<TodoComponent> todos) {
        this.title = title;
        this.todos = todos;
    }

    @Override
    public String getHtml() {
        StringBuilder html = new StringBuilder();
        html.append("\n<b>");
        html.append(this.title);
        html.append("</b>");
        html.append("\n<ul>");
        for (TodoComponent t : todos) {
            html.append("\n <li>    ");
            html.append(t.getHtml());
            html.append("   </li>");
        }
        html.append("\n</ul>\n");

        return html.toString();
    }


}
