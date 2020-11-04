package no.olai.html;

import java.util.ArrayList;

// Composite
public class Project implements TodoList {

    private String title;
    private ArrayList<TodoList> todos;


    public Project(String title, ArrayList<TodoList> todos) {
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
        for (TodoList t : todos) {
            html.append("\n <li>    ");
            html.append(t.getHtml());
            html.append("   </li>");
        }
        html.append("\n</ul>\n");

        return html.toString();
    }


}
