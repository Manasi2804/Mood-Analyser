import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
    MoodAnalyser moodAnalyser = new MoodAnalyser();
    String result;
    // Test case for Given “I am in Sad Mood” message should return SAD
    @Test
    public void givenMessage_WhenProper_RespondAsSadMood() {
        result = moodAnalyser.analyseMood("I am in Sad Mood");
        Assert.assertEquals("SAD", result);
    }
    // Test case for Given “I am in Any Mood” message should return Happy
    @Test
    public void givenMessage_WhenProper_RespondAsHappyMood()
    {
        result = moodAnalyser.analyseMood("I am in Any Mood");
        Assert.assertEquals("HAPPY",result);
    }
}