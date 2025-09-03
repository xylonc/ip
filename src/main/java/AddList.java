import java.util.Scanner;
public class AddList {
    public static void main(String[] args) {
        Task[] list = new Task[100];
        int count = 0;
        String task;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            task = scanner.nextLine();
            if (task.equals("list")) { //listing
                System.out.println("-".repeat(30));
                System.out.println("Here are your tasks:");
                for (int i = 0; i < count; i++) {
                    System.out.println((i + 1) + ". " + list[i]);
                }
                System.out.println("\n" + "-".repeat(30));
            } else if (task.startsWith("mark")) { //marking
                int taskNum = Integer.parseInt(task.split(" ")[1]) - 1; //splits to get second indexed input then -1 because is 0 indexed
                list[taskNum].markDone();
                System.out.println("-".repeat(30));
                System.out.println("Nice la , I have marked it as done!");
                System.out.println(" " + list[taskNum]);
                System.out.println("-".repeat(30));
            } else if (task.startsWith("unmark")) { //unmark
                int taskNum = Integer.parseInt(task.split(" ")[1]) - 1;
                list[taskNum].markUndone();
                System.out.println("-".repeat(30));
                System.out.println("Shag , I have marked it as undone!");
                System.out.println(" " + list[taskNum]);
                System.out.println("-".repeat(30));
            }else if(task.startsWith("deadline")) {//adding deadline
                int indexOfby = task.indexOf("by");
                String by = task.substring(indexOfby + 3);//add two cos index is for b
                int indexOfSlash = task.indexOf("/");
                String description = task.substring(0, indexOfSlash);
                list[count] = new Deadline(description, by);
                System.out.println("\n" + "-".repeat(30));
                System.out.println("okies brother. I added this deadline!");
                System.out.println(list[count]);
                System.out.println("now you got: " + (count + 1) + " tasks");
                System.out.println(" ");
                System.out.println("-".repeat(30));
                count++;
            }else if(task.startsWith("event")) {
                int indexFrom = task.indexOf("from");
                int indexTo = task.indexOf("to");
                int indexOfSlash = task.indexOf("/");
                String From = task.substring(indexFrom + 4 ,indexTo - 1 ); //takes timing between "from" and "to"
                String To = task.substring(indexTo + 3);//takes the to timing
                String description = task.substring(0, indexOfSlash);//description
                list[count] = new Events(description, To , From );
                System.out.println("\n" + "-".repeat(30));
                System.out.println("okies brother. I added this event!");
                System.out.println(list[count]);
                System.out.println("now you got: " + (count + 1) + " tasks");
                System.out.println(" ");
                System.out.println("-".repeat(30));
                count++;
            } else if (task.equals("bye")) { //exiting the code
                System.out.println("\n" + "-".repeat(30));
                System.out.println("Bye.Hope to see you again soon!\n");
                System.out.println("-".repeat(30));
                break;
            } else if(task.startsWith("todo")){ //adding task with no deadline
                //System.out.println("\n" + "-".repeat(30));
                list[count] = new Todo(task);
                System.out.println("\n" + "-".repeat(30));
                System.out.println("okies brother. I added this event!");
                System.out.println(list[count]);
                System.out.println("now you got: " + (count + 1) + " tasks");
                System.out.println(" ");
                System.out.println("-".repeat(30));
                count++;
            }
        }
    }
}