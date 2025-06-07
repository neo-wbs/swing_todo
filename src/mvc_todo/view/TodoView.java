package mvc_todo.view;

import mvc_todo.model.TodoItem;

import javax.swing.*;
import java.awt.*;

public class TodoView extends JFrame {
    private DefaultListModel<TodoItem> listModel;
    private JList<TodoItem> todoList;
    private JTextField inputField;
    private JButton addButton;
    private JButton removeButton;
    private JButton toggleButton;
    private JLabel statusLabel;

    public TodoView() {
        initComponents();
        setupLayout();
        setupWindow();
    }

    private void initComponents() {
        listModel = new DefaultListModel<>();
        todoList = new JList<>(listModel);
        todoList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        todoList.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));

        inputField = new JTextField(20);
        addButton = new JButton("Hinzufügen");
        removeButton = new JButton("Entfernen");
        toggleButton = new JButton("Erledigt/Offen");
        statusLabel = new JLabel("Aufgaben: 0 | Erledigt: 0");
    }

    private void setupLayout() {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(new JLabel("Neue Aufgabe:"));
        inputPanel.add(inputField);
        inputPanel.add(addButton);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(toggleButton);
        buttonPanel.add(removeButton);

        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.add(buttonPanel, BorderLayout.CENTER);
        southPanel.add(statusLabel, BorderLayout.SOUTH);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(todoList), BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    private void setupWindow() {
        setTitle("Mini MVC Todo App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        pack();
    }

    // Getter für controller
    public String getInputText() { return inputField.getText(); }
    public int getSelectedIndex() { return todoList.getSelectedIndex(); }
    public JButton getAddButton() { return addButton; }
    public JButton getRemoveButton() { return removeButton; }
    public JButton getToggleButton() { return toggleButton; }
    public JTextField getInputField() { return inputField; }

    // Update durch controller
    public void clearInput() {
        inputField.setText("");
        inputField.requestFocus();
    }

    public void refreshList(java.util.List<TodoItem> items) {
        listModel.clear();
        for (TodoItem item : items) {
            listModel.addElement(item);
        }
    }

    public void updateStatus(int total, int completed) {
        statusLabel.setText("Aufgaben: " + total + " | Erledigt: " + completed);
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Fehler", JOptionPane.ERROR_MESSAGE);
    }
}