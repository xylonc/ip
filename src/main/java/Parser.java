public class Parser {

    public static ParsedCommand parse(String input) throws UnknownInputException {
        String[] parts = input.split(" ", 2);
        String command = parts[0];
        String arguments = parts.length > 1 ? parts[1] : "";
        switch (command) {
        case "todo":
        case "list":
        case "mark":
        case "unmark":
        case "event":
        case "deadline":
        case "bye":
        case "delete":
        case "save":
        case "find":
            return new ParsedCommand(command, arguments);
        default:
            throw new UnknownInputException();
        }
    }

    public static class ParsedCommand {
        public final String command;
        public final String args;
        public ParsedCommand(String command, String args) {
            this.command = command;
            this.args = args;
        }
    }
}
