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

    @DataProvider(name = "noCapital")
    public Object[][] noCapital(){
        return new Object[] []
                {
                        {"abcdefghij1!l"},
                        {"a2345678901!l"},
                        {"abcd6f@^ij1!l"},
                        {"%bcdefghij1!l"},
                        {"*&^^^%$^%j1!l"},

                };
    }

    @Test (dataProvider = "tooShort")
    public void shouldNotAcceptLessThan12Chars(String password){
        SubstringAnalyser sa = new SubstringAnalyser(5);

        Assert.assertFalse(sa.isCorrectPassword(password));
    }

    @Test (dataProvider = "noCapital")
    public void shouldNotAcceptPassWithoutCapitalLetter  (String password){
        SubstringAnalyser sa = new SubstringAnalyser(10);
        Assert.assertFalse(sa.isCorrectPassword(password));
    }
}
