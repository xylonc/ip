import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private final ArrayList<Task> tasks = new ArrayList<>();

    public TaskList() {} //can construct empty list
    public TaskList(List<Task> initial) { //constructing list with input
        if (initial != null) tasks.addAll(initial);
    }

    public boolean isEmpty() { return tasks.isEmpty(); }
    public int size() { return tasks.size(); }
    public Task get(int idx) { return tasks.get(idx); }
    public List<Task> asList() { return tasks; }

    public void list(Ui ui) {
        if (isEmpty()) {
            ui.showEmptyList();
        }
        ui.showLine();
        ui.showListHeader();
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
        ui.showLine();
    }

    public void addTodo(String description, Ui ui) throws EmptyStringException {
        if (description.isEmpty()) throw new EmptyStringException();
        Task t = new Task(description);
        tasks.add(t);
        ui.showTaskAdded(t, size());
    }

    public void mark(String args, Ui ui) {
        int index = Integer.parseInt(args.trim()) - 1;
        Task t = tasks.get(index);
        t.markDone();
        ui.showMarked(t, true);
    }

    public void unmark(String args, Ui ui) {
        int index = Integer.parseInt(args.trim()) - 1;
        Task t = tasks.get(index);
        t.markUndone();
        ui.showMarked(t, false);
    }

    public void addDeadline(String args, Ui ui) {
        int byIndex = args.indexOf("/by");
        String description = args.substring(0, byIndex).trim();
        String by = args.substring(byIndex + 3).trim();
        Task t = new Deadline(description, by);
        tasks.add(t);
        ui.showAddedDeadline(t, size());
    }

    public void addEvent(String args, Ui ui) {
        int indexFrom = args.indexOf("from");
        int indexTo = args.indexOf("to");
        int indexSlash = args.indexOf("/");
        String from = args.substring(indexFrom + 4, indexTo).trim();
        String to = args.substring(indexTo + 2).trim();
        String description = args.substring(0, indexSlash).trim();
        Task t = new Events(description, to, from);
        tasks.add(t);
        ui.showAddedEvent(t, size());
    }

    public void delete(String args, Ui ui) {
        int index = Integer.parseInt(args.trim()) - 1;
        Task t = tasks.remove(index);
        ui.showDelete(t, size());
    }

    public void find(String args, Ui ui) throws NothingFoundException, EmptyStringException {
        ArrayList<Task> foundList = new ArrayList<>();
        if (args.isEmpty()) throw new EmptyStringException();
        for (Task t : tasks) {
            String description = t.description;
            if(description.contains(args)) {
                foundList.add(t);
            }
        }
        if (foundList.isEmpty()) throw new NothingFoundException();
        ui.showLine();
        ui.showListHeader();
        for (int i = 0; i < foundList.size(); i++) {
            System.out.println((i + 1) + ". " + foundList.get(i));
        }
        ui.showLine();
    }
}
