package mvc_todo.model;

public class TodoItem {
    private static int nextId = 1;
    private int id;
    private String task;
    private boolean completed;

    public TodoItem(String task) {
        this.id = nextId++;
        this.task = task;
        this.completed = false;
    }

    public int getId() { return id; }
    public String getTask() { return task; }
    public void setTask(String task) { this.task = task; }
    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }

    @Override
    public String toString() {
        return (completed ? "✓ " : "○ ") + task;
    }
}
