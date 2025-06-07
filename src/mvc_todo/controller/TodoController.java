package mvc_todo.controller;

import mvc_todo.model.TodoModel;
import mvc_todo.view.TodoView;

import java.awt.event.ActionListener;

public class TodoController {
    private TodoModel model;
    private TodoView view;

    public TodoController(TodoModel model, TodoView view) {
        this.model = model;
        this.view = view;

        setupEventHandlers();
        refreshView();
    }

    private void setupEventHandlers() {
        ActionListener addAction = e -> handleAddItem();
        view.getAddButton().addActionListener(addAction);
        view.getInputField().addActionListener(addAction);
        view.getRemoveButton().addActionListener(e -> handleRemoveItem());
        view.getToggleButton().addActionListener(e -> handleToggleItem());
    }

    private void handleAddItem() {
        String task = view.getInputText();
        if (task.trim().isEmpty()) {
            view.showError("Bitte geben Sie eine Aufgabe ein!");
            return;
        }

        model.addItem(task);
        view.clearInput();
        refreshView();
    }

    private void handleRemoveItem() {
        int selectedIndex = view.getSelectedIndex();
        if (selectedIndex == -1) {
            view.showError("Bitte wählen Sie eine Aufgabe zum Entfernen aus!");
            return;
        }

        model.removeItem(selectedIndex);
        refreshView();
    }

    private void handleToggleItem() {
        int selectedIndex = view.getSelectedIndex();
        if (selectedIndex == -1) {
            view.showError("Bitte wählen Sie eine Aufgabe aus!");
            return;
        }

        model.toggleItem(selectedIndex);
        refreshView();
    }

    private void refreshView() {
        view.refreshList(model.getAllItems());
        view.updateStatus(model.getTotalCount(), model.getCompletedCount());
    }
}