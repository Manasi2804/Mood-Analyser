public class MoodAnalyser {
    private String message;
    private String returnMessage;

    //no-arg constructor
    public MoodAnalyser()
    {

    }

    //parametrized constructor
    public MoodAnalyser(String message)

    {
        this.message = message;
    }

    public String analyseMood(String message)
    {
        this.message = message;
        return analyseMood();
    }

    // Overloaded analyseMood method
    public String analyseMood()
    {
        try
        {
            returnMessage = (message.contains("Sad")) ? "SAD" : "HAPPY";
        }
        catch (NullPointerException e)
        {
            return "HAPPY";
        }
        return returnMessage;
    }

    public static void main(String args[])
    {
        System.out.println("Welcome to Mood Analyser");
    }
}