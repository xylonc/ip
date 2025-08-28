import java.util.Scanner;

public class Victoria {
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
        String answer;
        do {
            Scanner reply = new Scanner(System.in);
            answer = reply.nextLine();
            System.out.println("-".repeat(30));
            System.out.println(answer + "\n");
            System.out.println("-".repeat(30) + "\n");
        }
        while(!answer.equals("bye"));

        System.out.println("-".repeat(30));
        System.out.println("Bye.Hope to see you again soon!\n");
        System.out.println("-".repeat(30));

    }
}