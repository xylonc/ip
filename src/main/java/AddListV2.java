import java.util.Scanner;
import java.util.ArrayList;
public class AddListV2 {
    public static ArrayList<Task> tasks = new ArrayList<>();
    public static void AddlistV2() throws Exception{
        String input;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            input = scanner.nextLine();
            String[] inputs = input.split(" ", 2);//limit 2 means only split at the first " "
            //ensure only 2 parts jic got another spacing dont want to split again
            String command = inputs[0];
            String arguments = inputs.length > 1 ? inputs[1] : "";

            switch (command) {
            case "todo":
                addTask(arguments);
                break;
            case "list":
                listTask();
                break;
            case "mark":
                markTask(arguments);
                break;
            case "unmark":
                unmarkTask(arguments);
                break;
            case "event":
                addEvent(arguments);
                break;
            case "deadline":
                addDeadline(arguments);
                break;
            case "bye":
                sayBye();
                return;
            case "delete":
                deleteTask(arguments);
                return;
            default:
                throw new UnknownInputException();
            }
        }
    }

    public static void listTask() {
        if(tasks.isEmpty()) {
            System.out.println("Shiok ah no tasks!");
        }
        System.out.println("-".repeat(30));
        System.out.println("Here are your tasks bro:");
        for(int i = 0; i < tasks.size(); i++){
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
        System.out.println("-".repeat(30));
    }
    public static void addTask(String description) throws Exception {
        if(description.isEmpty()) throw new EmptyStringException();
        Task task = new Task(description);
        tasks.add(task);
        System.out.println("-".repeat(30));
        System.out.println("ok added the following task bro:");
        System.out.println(tasks.get(tasks.size()-1));
        System.out.println("now you got "+ tasks.size() + " tasks in your list.");
        System.out.println("-".repeat(30));
    }
    public static void markTask(String args ) {
        int index = Integer.parseInt(args.trim()) - 1;
        //trim incase user have extra spaces
        //- 1 as indexed 0
        Task task = tasks.get(index);
        task.markDone();
        System.out.println("-".repeat(30));
        System.out.println("Nice la , I have marked it as done!");
        System.out.println(" " + task);
        System.out.println("-".repeat(30));
    }
    public static void unmarkTask (String args ) {
        int index = Integer.parseInt(args.trim()) - 1;
        Task task = tasks.get(index);
        task.markUndone();
        System.out.println("-".repeat(30));
        System.out.println("Shag , I have marked it as undone!");
        System.out.println(" " + task);
        System.out.println("-".repeat(30));
    }
    public static void addDeadline(String args ) {
        int byIndex = args.indexOf("/by");
        String description = args.substring(0, byIndex).trim();
        String by = args.substring(byIndex + 3).trim();
        Task task =  new Deadline(description, by);
        tasks.add(task);
        System.out.println("-".repeat(30));
        System.out.println("okies brother. I added this deadline!");
        System.out.println(tasks.get(tasks.size()-1));
        System.out.println("now you got: " + tasks.size() + " tasks");
        System.out.println(" ");
        System.out.println("-".repeat(30));
    }
    private static void addEvent(String args) {
        int indexFrom = args.indexOf("from");
        int indexTo = args.indexOf("to");
        int indexSlash = args.indexOf("/");
        String From = args.substring(indexFrom + 4 ,indexTo - 1 ).trim(); //takes timing between "from" and "to"
        String To = args.substring(indexTo + 3).trim();//takes the to timing
        String description = args.substring(0, indexSlash).trim();//description
        Task task = new Events(description, From, To);
        tasks.add(task);
        System.out.println("okies brother. I added this event!");
        System.out.println(tasks.get(tasks.size()-1));
        System.out.println("now you got: " + tasks.size() + " tasks");
        System.out.println(" ");
        System.out.println("-".repeat(30));
    }
    private static void sayBye(){
        System.out.println("\n" + "-".repeat(30));
        System.out.println("Bye.Hope to see you again soon!\n");
        System.out.println("-".repeat(30));
    }
    private static void deleteTask(String input) {
        int index = Integer.parseInt(input.trim());
        Task task = tasks.remove(index - 1);
        System.out.println("-".repeat(30));
        System.out.println("thy task have been vanquished!");
        System.out.println(task);
        System.out.println("now you only left with " + tasks.size() + " tasks!");
        System.out.println("-".repeat(30));
        System.out.println(" ".repeat(30));
    }
}