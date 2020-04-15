import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest
{
    MoodAnalyser moodAnalyse = new MoodAnalyser("I am in sad Mood");
    MoodAnalyser moodAnalyser;
    String result;
     // Test case for Given “I am in Sad Mood” message should return SAD
    @Test
    public void givenMessage_WhenProper_RespondAsSadMood()
    {
        moodAnalyser= new MoodAnalyser ("I am in Sad Mood");
        result = moodAnalyser.analyseMood();
        Assert.assertEquals("SAD", result);
    }
    // Test case for Given “I am in Happy Mood” message should return Happy
    @Test
    public void givenMessage_WhenProper_RespondAsHappyMood()
    {
        moodAnalyser = new MoodAnalyser ("I am in Happy Mood");
        result = moodAnalyser.analyseMood();
        Assert.assertEquals("HAPPY",result);
    }
}