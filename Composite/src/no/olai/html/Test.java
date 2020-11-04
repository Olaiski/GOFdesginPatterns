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
        ArrayList<TodoList> todos = new ArrayList<>();
        todos.add(new Todo("Main Todo 1"));



        // Subproject 1 / 2
        ArrayList<TodoList> subprojectTodos = new ArrayList<>();
        subprojectTodos.add(new Todo("Subproject 1 - Todo 1"));
        subprojectTodos.add(new Todo("Subproject 1 - Todo 2"));

        ArrayList<TodoList> subprojectTodos2 = new ArrayList<>();
        subprojectTodos2.add(new Todo("Subproject 2 - Todo 1"));
        subprojectTodos2.add(new Todo("Subproject 2 - Todo 2"));

        subprojectTodos.add(new Project("SubProject (2)", subprojectTodos2));

        Project subproject1 = new Project("SubProject (1)", subprojectTodos);
        todos.add(subproject1);

        // Main list 2
        todos.add(new Todo("Main Todo 2"));


        // Subproject 3
        subprojectTodos = new ArrayList<>();
        subprojectTodos.add(new Todo("Subproject 3 - Todo 1"));
        subprojectTodos.add(new Todo("Subproject 3 - Todo 2"));

        todos.add(new Project("Subproject (3)",subprojectTodos));

        // Main list 3
        todos.add(new Todo("Main Todo 3"));

        Project mainProject = new Project("Todos", todos);


//        System.out.println(mainProject.getHtml());


        try {
            File f = new File(FILE_NAME);

            System.out.println("File created " + f.getName());

            BufferedWriter writer = new BufferedWriter(new FileWriter(f));
            writer.write(mainProject.getHtml());

            writer.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
