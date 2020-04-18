import java.util.Objects;

public class MoodAnalyser
{
    private String message;

    // no -arg constructor
    public MoodAnalyser()
    {
        message = null;
    }
    // parametrized constructor
    public MoodAnalyser(String message)
    {
            this.message = message;
    }
    // Method that return the mood
    public String moodAnalyser(String mood) throws MoodAnalyserException
    {
        try
        {
            if (message.length() == 0)
            {
                throw new MoodAnalyserException(MoodAnalyserException.MyException_Type.EMPTY, "You entered empty mood,please enter valid mood");
            }
            if (message.contains("sad"))
            {
                return ("sad");
            }
            else if (message.contains("happy"))
            {
                return ("happy");
            }
        }
        catch (NullPointerException e)
        {
            throw new MoodAnalyserException(MoodAnalyserException.MyException_Type.NULL, "You entered null mood,please enter valid mood");
        }
        return (null);
    }
    //main method
    public static void main(String[] args)
    {
        System.out.println("Welcome to mood analyser problems");
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        MoodAnalyser that = (MoodAnalyser) o;
        return Objects.equals(message, that.message);
    }

}