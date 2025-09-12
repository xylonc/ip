public class Victoria {
    public static void main(String[] args) throws Exception {
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
        try {
            AddList.main(args);
        }
        catch(EmptyStringException e){
            System.out.println(":( there is no input , please type something");
        }
        catch(UnknownInputException e){
            System.out.println("oops sorry bro im not sure what does that mean, can you type another command");
        }
    }

}