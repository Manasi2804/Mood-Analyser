public class MoodAnalyser {
    public static void main(String[] args)

    private String returnMessage;
    public String analyseMood(String message)
    {
        System.out.println(" Welcome to mood analyser problem");
        if (message.equals("I am in Sad Mood"))
        {
            returnMessage = "SAD";
        }
        else if (message.equals("I am in Any Mood"))
        {
            returnMessage = "HAPPY";
        }
        return  returnMessage;
    }
}
