package mvc_todo.model;

import java.util.ArrayList;
import java.util.List;

public class TodoModel {
    private List<TodoItem> items = new ArrayList<>();

    public void addItem(String task) {
        if (task != null && !task.trim().isEmpty()) {
            items.add(new TodoItem(task.trim()));
        }
    }

    public void removeItem(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
        }
    }

    public void toggleItem(int index) {
        if (index >= 0 && index < items.size()) {
            TodoItem item = items.get(index);
            item.setCompleted(!item.isCompleted());
        }
    }

    public List<TodoItem> getAllItems() {
        return new ArrayList<>(items);
    }

    public int getTotalCount() {
        return items.size();
    }

    public int getCompletedCount() {
        return (int) items.stream().filter(TodoItem::isCompleted).count();
    }
}