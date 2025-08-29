import java.util.Scanner;

public class Victoria {
    public static void echo(String[] args){
        String answer;
        Scanner reply = new Scanner(System.in);
        answer = reply.nextLine();
        if(answer.equals("bye")) {
            System.out.println("-".repeat(30));
            System.out.println("Bye.Hope to see you again soon!\n");
            System.out.println("-".repeat(30));
        }
        else {
            System.out.println("-".repeat(30));
            System.out.println(answer + "\n");
            System.out.println("-".repeat(30) + "\n");
            echo(args);
        }
    }

    public static void addList(String[] args){
        Task[] list = new Task[100];
        int count =0;
        String task;
        Scanner scanner = new Scanner(System.in);
        while(true) {
            task = scanner.nextLine();
            if (task.equals("list")) {
                System.out.println("-".repeat(30));
                System.out.println("Here are your tasks:");
                for (int i = 0; i < count; i++) {
                    System.out.println((i + 1) + ". " + list[i]);
                }
                System.out.println("\n" + "-".repeat(30));
            }
            else if(task.startsWith("mark")) {
                int taskNum = Integer.parseInt(task.split(" ")[1]) - 1;
                list[taskNum].markDone();
                System.out.println("-".repeat(30));
                System.out.println("Nice la , I have marked it as done!");
                System.out.println(" " + list[taskNum]);
                System.out.println("-".repeat(30));
            }
            else if(task.startsWith("unmark")) {
                int taskNum = Integer.parseInt(task.split(" ")[1]) - 1;
                list[taskNum].markUndone();
                System.out.println("-".repeat(30));
                System.out.println("Shag , I have marked it as undone!");
                System.out.println(" " + list[taskNum]);
                System.out.println("-".repeat(30));
            }
            else if(task.equals("bye")) {
                System.out.println("\n" + "-".repeat(30));
                System.out.println("Bye.Hope to see you again soon!\n");
                System.out.println("-".repeat(30));
                break;
            }
            else{
                System.out.println("\n" + "-".repeat(30));
                list[count] = new Task(task);
                count++;
                System.out.println("added:" + task + "\n");
                System.out.println("-".repeat(30) + "\n");
            }
        }
    }
    public static class Task {
        protected String description;
        protected boolean isDone;

        public Task(String description) {
            this.description = description;
            this.isDone = false;
        }

        public String getStatusIcon() {
            return (isDone ? "X" : " "); // mark done task with X
        }

        public void markDone() {
            this.isDone = true;
        }

        public void markUndone() {
            this.isDone = false;
        }


        public String toString() {
            return "[" + getStatusIcon() + "] " + description;
        }
    }


    public static void main(String[] args) {
        String logo =
                " __     ___  ____ \n"
                        + " \\ \\   / / |/ ___|\n"
                        + "  \\ \\ / /| ' /    \n"
                        + "   \\ V / | . \\___ \n"
                        + "    \\_/  |_|| ___|  \n";

        System.out.println("Hello from\n" + logo);
        System.out.println("-".repeat(30));
        System.out.println("Hello! I'm Victoria");
        System.out.println("How may I help you?\n");
        System.out.println("-".repeat(30) + "\n");
        addList(args);



    }

}