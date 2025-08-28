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
        String[] list = new String[100];
        int count =0;
        String task;
        while(true) {
            Scanner scanner = new Scanner(System.in);
            task = scanner.nextLine();
            if (task.equals("list")) {
                for (int i = 0; i < count; i++) {
                    System.out.println((i + 1) + ". " + list[i]);
                }
                System.out.println("\n" + "-".repeat(30));
            } else if(task.equals("bye")) {
                System.out.println("\n" + "-".repeat(30));
                System.out.println("Bye.Hope to see you again soon!\n");
                System.out.println("-".repeat(30));
                break;
            }
            else{
                System.out.println("\n" + "-".repeat(30));
                list[count] = task;
                count++;
                System.out.println("added:" + task + "\n");
                System.out.println("-".repeat(30) + "\n");
            }
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