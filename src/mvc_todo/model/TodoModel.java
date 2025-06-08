package mvc_todo.model;

import java.util.ArrayList;
import java.util.List;

public class TodoModel {
    private List<TodoItem> items = new ArrayList<>();

    /**
     *
     * @param task
     */
    public void addItem(String task) {
        if (task != null && !task.trim().isEmpty()) {
            items.add(new TodoItem(task.trim()));
        }
    }

    /**
     *
     * @param index
     */
    public void removeItem(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
        }
    }

    /**
     *
     * @param index
     */
    public void toggleItem(int index) {
        if (index >= 0 && index < items.size()) {
            TodoItem item = items.get(index);
            item.setCompleted(!item.isCompleted());
        }
    }

    /**
     *
     * @return
     */
    public List<TodoItem> getAllItems() {
        return new ArrayList<>(items);
    }

    /**
     *
     * @return
     */
    public int getTotalCount() {
        return items.size();
    }

    /**
     *
     * @return
     */
    public int getCompletedCount() {
        return (int) items.stream().filter(TodoItem::isCompleted).count();
    }
}