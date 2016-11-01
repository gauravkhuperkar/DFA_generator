import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class DFATest {
    @Test
    public void DFA_should_able_to_recognize_the_string() throws Exception {
        ArrayList<String> sigma = new ArrayList<>();
        sigma.add("0");
        sigma.add("1");
        ArrayList<String> states = new ArrayList<>();
        states.add("q0");
        states.add("q1");
        String initialState = "q0";
        ArrayList<String> final_states = new ArrayList<>();
        final_states.add("q2");
        States finalState = new States(final_states);

        HashMap path1 = new HashMap();
        path1.put("0","q0");
        path1.put("1","q1");
        HashMap path2 = new HashMap();
        path2.put("0","q1");
        path2.put("1","q2");
        HashMap path3 = new HashMap();
        path3.put("0","q2");
        path3.put("1","q2");
        HashMap delta = new HashMap();
        delta.put("q0",path1);
        delta.put("q1",path2);
        delta.put("q2",path3);

        DFA dfa = new DFA(sigma, states, initialState, finalState, delta);
        assertTrue(dfa.canRecognize("010101"));
    }
}
