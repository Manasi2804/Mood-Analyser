import java.lang.reflect.Constructor;

public class MoodAnalyserFactory
{
    //Return class object
    public static Constructor<?> getConstructor(String className, Class methodName) throws MoodAnalyserException {
        try
        {
            Class <?> moodAnalyser=Class.forName(className);
            return moodAnalyser.getConstructor(methodName);
        }
        catch (ClassNotFoundException e)
        {
            throw new MoodAnalyserException(MoodAnalyserException.MyException_Type.CLASS_NOT_FOUND,"Please enter valid class name");
        }
        catch (NoSuchMethodException e)
        {
            throw new MoodAnalyserException(MoodAnalyserException.MyException_Type.METHOD_NOT_FOUND,"Please enter valid method name");
        }
    }

    //Return the constructor instance
    public static MoodAnalyser createMoodAnalyser() throws MoodAnalyserException
    {
        try
        {
            Class<?> moodAnalyser = Class.forName("com.moodanalyser.MoodAnalyser");
            Constructor<?> constructor = moodAnalyser.getConstructor();
            Object instance = moodAnalyser.newInstance();
            return (MoodAnalyser) instance;
        }
        catch (ClassNotFoundException e)
        {
            throw new MoodAnalyserException(MoodAnalyserException.MyException_Type.CLASS_NOT_FOUND,"Please enter valid class name");
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
        catch (NoSuchMethodException e)
        {
            throw new MoodAnalyserException(MoodAnalyserException.MyException_Type.METHOD_NOT_FOUND,"please enter valid method");
        }
        return null;
    }
}