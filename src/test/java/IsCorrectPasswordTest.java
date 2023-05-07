import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.edu.agh.qa.substring.SubstringAnalyser;

public class IsCorrectPasswordTest {
    @DataProvider(name = "tooShort")
    public Object[][] tooShortPasswords(){
        return new Object[] []
                {{"a"},
                        {"ab"},
                        {"abc"},
                        {"abcd"},
                        {"abcde"},
                        {"abcdef"},
                        {"abcdefg"},
                        {"abcdefgh"},
                        {"abcdefghi"},
                        {"abcdefghij"},
                        {"abcdefghijk"},

                };
    }

    @Test (dataProvider = "tooShort")
    public void shouldNotAcceptLessThan12Chars(String password){
        SubstringAnalyser sa = new SubstringAnalyser(5);

        Assert.assertFalse(sa.isCorrectPassword(password));
    }
}
