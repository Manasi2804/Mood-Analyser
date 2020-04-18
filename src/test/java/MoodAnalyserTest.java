import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest
{
    // Test 1.1:Given I am in sad mood message should return sad
    @Test
    public void givenMeassage_WhenSad_ThenReturnMood() throws MoodAnalyserException
    {
        MoodAnalyser mood=new MoodAnalyser("I am in sad mood");
        String result=mood.moodAnalyser("");
        Assert.assertEquals("sad", result);
    }

    // Test 1.2:Given I am in Any mood message should return happy
    @Test
    public void givenMeassage_WhenHappy_ThenReturnMood() throws MoodAnalyserException
    {
        MoodAnalyser mood=new MoodAnalyser("I am in happy mood");
        String result=mood.moodAnalyser("");
        Assert.assertEquals("happy",result);
    }

    // Test 3.1:Given NULL should throw MoodAnalyser Exception
    @Test
    public void givenNull_WhenNull_ThenThrowException() throws MoodAnalyserException
    {
        MoodAnalyser mood=new MoodAnalyser(null);
        try
        {
            String result = mood.moodAnalyser("");
            Assert.assertEquals("happy", result);
        }
        catch (MoodAnalyserException e)
        {
            Assert.assertEquals(MoodAnalyserException.MyException_Type.NULL,e.type);
        }
    }

    // Test 3.2:Given Empty should throw MoodAnalysis Exception
    @Test
    public void givenEmpty_WhenEmpty_ThenThrowException() throws MoodAnalyserException
    {
        MoodAnalyser mood=new MoodAnalyser("");
        try
        {
            String result = mood.moodAnalyser("");
            Assert.assertEquals("happy", result);
        }
        catch (MoodAnalyserException e)
        {
            Assert.assertEquals(MoodAnalyserException.MyException_Type.EMPTY,e.type);
        }
    }
}
