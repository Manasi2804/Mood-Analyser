import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserTest
{
    // Test 1.1:Given I am in sad mood message should return sad
    @Test
    public void givenMeassage_WhenSad_ThenReturnMood() throws MoodAnalyserException
    {
        MoodAnalyser mood = new MoodAnalyser("I am in sad mood");
        String result = mood.moodAnalyser("");
        Assert.assertEquals("sad", result);
    }

    // Test 1.2:Given I am in Any mood message should return happy
    @Test
    public void givenMeassage_WhenHappy_ThenReturnMood() throws MoodAnalyserException
    {
        MoodAnalyser mood = new MoodAnalyser("I am in happy mood");
        String result = mood.moodAnalyser("");
        Assert.assertEquals("happy", result);
    }

    // Test 3.1:Given NULL should throw MoodAnalyser Exception
    @Test
    public void givenNull_WhenNull_ThenThrowException() throws MoodAnalyserException
    {
        MoodAnalyser mood = new MoodAnalyser(null);
        try
        {
            String result = mood.moodAnalyser("");
            Assert.assertEquals("happy", result);
        }
        catch (MoodAnalyserException e)
        {
            Assert.assertEquals(MoodAnalyserException.MyException_Type.NULL, e.type);
        }
    }

    // Test 3.2:Given Empty should throw MoodAnalysis Exception
    @Test
    public void givenEmpty_WhenEmpty_ThenThrowException() throws MoodAnalyserException
    {
        MoodAnalyser mood = new MoodAnalyser("");
        try
        {
            String result = mood.moodAnalyser("");
            Assert.assertEquals("happy", result);
        }
        catch (MoodAnalyserException e)
        {
            Assert.assertEquals(MoodAnalyserException.MyException_Type.EMPTY, e.type);
        }
    }

    // Test 4.1:Given class name should return MoodAnalyzer object
    @Test
    public void givenClassName_DefaultConstructor_WhenProper_ThenReturnObject() throws MoodAnalyserException {
        try
        {
            MoodAnalyser mood = new MoodAnalyser();
            MoodAnalyser analysermood = MoodAnalyserFactory.createMoodAnalyzer();
            boolean result = analysermood.equals(mood);
            Assert.assertEquals(true, result);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    // Test 4.2:Given class name when improper should throw MoodAnalysis exception
    @Test
    public void givenClassName_WhenImproper_ThenThrowMoodAnalysisException() throws MoodAnalyserException {
        try
        {
            MoodAnalyser mood = new MoodAnalyser();
            MoodAnalyserFactory.getConstructor("com.moodAnalyser.MoodAnalyser",String.class);
        }
        catch (MoodAnalyserException e)
        {
            Assert.assertEquals(MoodAnalyserException.MyException_Type.CLASS_NOT_FOUND, e.type);
        }
    }

    // Test 4.3:Given class name when constructor improper then throw exception
    @Test
    public void givenClassName_Constructor_Whenimproper_ThenThrowMoodAnalysisException() throws MoodAnalyserException {
        try
        {
            MoodAnalyser mood = new MoodAnalyser();
            MoodAnalyserFactory.getConstructor("MoodAnalyser",Integer.class);
        }

        catch (MoodAnalyserException e)
        {
            Assert.assertEquals(MoodAnalyserException.MyException_Type.METHOD_NOT_FOUND, e.type);
        }
    }

    // Test 5.1:Given class name when proper should return MoodAnalyser object
    @Test
    public void givenMoodAnalyser_ParameterConstructor_WhenProper_ThenReturnObject() throws MoodAnalyserException {
        try
        {
            MoodAnalyser mood = new MoodAnalyser("i am in happy mood");
            Object returnMood = MoodAnalyserFactory.getParametericConstructor("com.moodanalyser.MoodAnalyser", String.class, "i am in happy mood");
            boolean result = returnMood.equals(mood);
            Assert.assertEquals(true, result);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    // Test 5.2:Given class name when improper should throw MoodAnalyser exception
    @Test
    public void givenClassName_WhenImproper_ShouldThrowMoodAnalysisException() throws MoodAnalyserException {
        try
        {
            MoodAnalyser mood = new MoodAnalyser("i am in happy mood");
            Object returnMood = MoodAnalyserFactory.getClassNameImproperWithParameter("com.moodAnalyser.MoodAnalyze", String.class, "i am in happy mood");
            boolean result = returnMood.equals(mood);
            Assert.assertEquals(true, result);
        }
        catch (MoodAnalyserException e)
        {
            Assert.assertEquals(MoodAnalyserException.MyException_Type.CLASS_NOT_FOUND, e.type);
        }
    }

    // Test 5.3:Given class name when constructor improper should throw MoodAnalyser exception
    @Test
    public void givenClassName_WhenConstructorImproper_ThenThrowMoodAnalysisException() throws MoodAnalyserException {
        try
        {
            MoodAnalyser mood = new MoodAnalyser("i am in happy mood");
            Object returnMood = MoodAnalyserFactory.getParametericConstructor("MoodAnalyser", Integer.class, "i am in happy mood");
            boolean result = returnMood.equals(mood);
        }
        catch (MoodAnalyserException e)
        {
            Assert.assertEquals(MoodAnalyserException.MyException_Type.METHOD_NOT_FOUND, e.type);
        }
    }
    // Test 6.1:Given message when proper should return happy
    @Test
    public void givenHappy_WhenProper_ThenReturnHappyMood() throws MoodAnalyserException
    {
        try
        {
            Constructor<?> constructor = MoodAnalyserFactory.getConstructor("com.moodanalyserMoodAnalyser",String.class);
            Object instance = constructor.newInstance("i am in happy mood");
            String analyser = MoodAnalyserFactory.moodAnalyser( (MoodAnalyser) instance ,"moodAnalyser") ;
            Assert.assertEquals("happy",analyser);
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
    }
    // Test 6.2:Given message when improper should throw MoodAnalysis Exception
    @Test
    public void givenHappyMessage_WhenImproperMethod_ShouldThrowMoodAnalysisException()
    {
        try
        {
            Constructor<?> constructor = MoodAnalyserFactory.getConstructor("com.moodanalyser.MoodAnalyzer",Integer.class);
            Object instance = constructor.newInstance("i am in happy mood");
            String analyser = MoodAnalyserFactory.moodAnalyser ( (MoodAnalyser) instance ,"moodAnalyser") ;
            Assert.assertEquals("happy",analyser);
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
        catch (MoodAnalyserException e)
        {
            Assert.assertEquals(MoodAnalyserException.MyException_Type.METHOD_NOT_FOUND,e.type);
        }
    }
}





