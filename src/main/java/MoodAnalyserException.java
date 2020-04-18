public class MoodAnalyserException extends Exception
{
    enum MyException_Type
    {
        EMPTY, NULL;
    }

    MyException_Type type;
    MyException_Type exceptionMessage;

    MoodAnalyserException(MyException_Type type, String message)
    {
        super(message);
        this.type = type;
        System.out.println(message);
    }
}