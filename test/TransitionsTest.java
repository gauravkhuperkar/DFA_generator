import org.junit.Assert;
import java.util.HashMap;

public class TransitionsTest {
    @org.junit.Test
    public void transitions_should_map_string_to_hashmap() throws Exception {
        String language = "1,2,3\n4,5,6";
        Transitions transitions = new Transitions(language);
        HashMap delta  = transitions.getTransition();
        HashMap expected = new HashMap();
        HashMap value1 = new HashMap();
        HashMap value2 = new HashMap();

        value1.put(2,3);
        value2.put(5,6);
        expected.put(1, value1);
        expected.put(4,value2);

        Assert.assertEquals(expected.toString(), delta.toString());
    }
}
