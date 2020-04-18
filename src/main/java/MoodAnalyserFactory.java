import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory
{
    //Return class object
    public static Constructor<?> getConstructor(String className, Class methodName) throws MoodAnalyserException
    {
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
    public static MoodAnalyser createMoodAnalyzer() throws MoodAnalyserException
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

    // Return class object with parameter constructor
    public static Object getParametericConstructor(String className,Class methodName,String mood) throws MoodAnalyserException
    {
        try
        {
            Class<?> moodAnalyser = Class.forName(className);
            Constructor<?> constructorMood = moodAnalyser.getConstructor(methodName);
            return constructorMood.newInstance(mood);
        }
        catch (ClassNotFoundException e)
        {
            throw new MoodAnalyserException(MoodAnalyserException.MyException_Type.CLASS_NOT_FOUND,"Please enter valid Class name");
        }
        catch (NoSuchMethodException e)
        {
            throw new MoodAnalyserException(MoodAnalyserException.MyException_Type.METHOD_NOT_FOUND,"Please enter valid method name");
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
        catch (InvocationTargetException e)
        {
            e.printStackTrace();
        }
        return (mood);
    }

    //Return class object when class name improper with parameter
    public static Object getClassNameImproperWithParameter(String className,Class methodName,String mood) throws MoodAnalyserException
    {
        try
        {
            Class<?> moodAnalyser = Class.forName(className);
            Constructor<?> construct = moodAnalyser.getConstructor(methodName);
            return construct.newInstance(mood);
        }
        catch (ClassNotFoundException e)
        {
            throw new MoodAnalyserException(MoodAnalyserException.MyException_Type.CLASS_NOT_FOUND, "Please enter valid Class neme");
        }
        catch (NoSuchMethodException e)
        {
            throw new MoodAnalyserException(MoodAnalyserException.MyException_Type.METHOD_NOT_FOUND, "Please enter valid method neme");
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
        catch (InvocationTargetException e)
        {
            e.printStackTrace();
        }
        return (mood);
    }

}