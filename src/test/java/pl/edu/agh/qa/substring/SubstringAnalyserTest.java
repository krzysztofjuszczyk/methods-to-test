package pl.edu.agh.qa.substring;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;



public class SubstringAnalyserTest {
    private String appUrl = System.getProperty("url");

    private static Logger log = LoggerFactory.getLogger(SubstringAnalyserTest.class);

    public static void setUp() {
        log.info("Tests run on environemnt: " + System.getProperty("ENV"));
    }

    @Test
    public void shouldReturnFalseWhenNoDigit() {
        log.info("Run on url: " + appUrl);
        SubstringAnalyser substringAnalyser = new SubstringAnalyser(1);
        boolean result = substringAnalyser.isCorrectPassword("Asdfgo&fsdfsdfsd");
        Assert.assertFalse(result);
    }

}
