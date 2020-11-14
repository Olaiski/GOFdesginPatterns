package no.olai.html;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Test {

    private static final String FILE_NAME = "todo.html";

    public static void main(String[] args) {


        // Main list
        ArrayList<TodoComponent> todos = new ArrayList<>();
        todos.add(new TodoLeaf("Main Todo 1"));



        // Subproject 1 / 2
        ArrayList<TodoComponent> subprojectTodos = new ArrayList<>();
        subprojectTodos.add(new TodoLeaf("Subproject 1 - Todo 1"));
        subprojectTodos.add(new TodoLeaf("Subproject 1 - Todo 2"));

        ArrayList<TodoComponent> subprojectTodos2 = new ArrayList<>();
        subprojectTodos2.add(new TodoLeaf("Subproject 2 - Todo 1"));
        subprojectTodos2.add(new TodoLeaf("Subproject 2 - Todo 2"));

        subprojectTodos.add(new TodoComposite("SubProject (2)", subprojectTodos2));

        TodoComposite subproject1 = new TodoComposite("SubProject (1)", subprojectTodos);
        todos.add(subproject1);

        // Main list 2
        todos.add(new TodoLeaf("Main Todo 2"));


        // Subproject 3
        subprojectTodos = new ArrayList<>();
        subprojectTodos.add(new TodoLeaf("Subproject 3 - Todo 1"));
        subprojectTodos.add(new TodoLeaf("Subproject 3 - Todo 2"));

        todos.add(new TodoComposite("Subproject (3)",subprojectTodos));

        // Main list 3
        todos.add(new TodoLeaf("Main Todo 3"));

        TodoComposite mainTodoComposite = new TodoComposite("Todos", todos);


        System.out.println(mainTodoComposite.getHtml());



        try {
            File f = new File(FILE_NAME);

            System.out.println("File created " + f.getName());

            BufferedWriter writer = new BufferedWriter(new FileWriter(f));
            writer.write(mainTodoComposite.getHtml());

            writer.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
