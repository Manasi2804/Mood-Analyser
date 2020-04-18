import org.junit.Assert;
import org.junit.Test;
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
    public void givenClassName_DefaultConstructor_WhenProper_ThenReturnObject() throws MoodAnalyserException
    {
        try
        {
            MoodAnalyser mood = new MoodAnalyser();
            MoodAnalyser analysermood = MoodAnalyserFactory.createMoodAnalyser();
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
    public void givenClassName_WhenImproper_ThenThrowMoodAnalysisException() throws MoodAnalyserException
    {
        try
        {
            MoodAnalyser mood = new MoodAnalyser();
            MoodAnalyserFactory.getConstructor("MoodAnalyser", String.class);
        }
        catch (MoodAnalyserException e)
        {
            Assert.assertEquals(MoodAnalyserException.MyException_Type.METHOD_NOT_FOUND, e.type);
        }
    }
    // Test 4.3:Given class name when constructor improper then throw exception
    @Test
    public void givenClassName_Constructor_Whenimproper_ThenThrowMoodAnalysisException() throws MoodAnalyserException
    {
        try
        {
            MoodAnalyser mood = new MoodAnalyser();
            MoodAnalyserFactory.getConstructor("com.moodanalyser.MoodAnalyser", String.class);
        }
        catch (MoodAnalyserException e)
        {
            Assert.assertEquals(MoodAnalyserException.MyException_Type.CLASS_NOT_FOUND, e.type);
        }
    }
}