public class Events extends Task{
    protected String From;
    protected String To;

    public Events(String description , String To , String From){
        super(description); // calling the superclass constructor
        this.From =From;
        this.To= To;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + From + " to: " + To + ")";
    }
}

