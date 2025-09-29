import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;


public class Storage {
    private final File file;

    public Storage(String path) { //constructor
        this.file = new File(path);
    }

    public void save(List<Task> tasks) {
        try (FileWriter fw = new FileWriter(file.getAbsolutePath(), true)) {
            for (Task task : tasks) {
                fw.write(task.toString() + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getLocalizedMessage());
        }
    }


    public List<Task> load() {
        List<Task> loaded = new ArrayList<>();
        if (!file.exists()) return loaded;
        return loaded;
    }
}
