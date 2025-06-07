package mvc_todo;

import mvc_todo.controller.TodoController;
import mvc_todo.model.TodoModel;
import mvc_todo.view.TodoView;

import javax.swing.*;

public class TodoApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TodoModel model = new TodoModel();
            TodoView view = new TodoView();
            new TodoController(model, view);
            view.setVisible(true);
        });
    }
}