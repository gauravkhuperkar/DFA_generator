import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NFATest {
    @Test
    public void NFA_should_able_to_recognize_the_string() throws Exception {
        ArrayList<String> sigma = new ArrayList<>();
        sigma.add("a");
        sigma.add("b");
        ArrayList<String> states = new ArrayList<>();
        states.add("q0");
        states.add("q1");
        states.add("q2");
        String initialState = "q0";
        ArrayList<String> finalStates = new ArrayList<>();
        finalStates.add("q0");
        States finalState = new States(finalStates);

        HashMap path0 = new HashMap();
        HashMap path1 = new HashMap();
        HashMap path2 = new HashMap();

        ArrayList nextStates0 = new ArrayList();
        ArrayList nextStates1 = new ArrayList();
        ArrayList nextStates2 = new ArrayList();
        ArrayList nextStates3 = new ArrayList();

        nextStates0.add("q0");
        nextStates1.add("q1");
        nextStates2.add("q2");
        nextStates3.add("q1");
        nextStates3.add("q2");

        path0.put("b",nextStates1);
        path0.put("#",nextStates2);

        path1.put("a",nextStates3);
        path1.put("b",nextStates2);

        path2.put("a",nextStates0);

        HashMap delta = new HashMap();

        delta.put("q0",path0);
        delta.put("q1",path1);
        delta.put("q2",path2);

        NFA nfa = new NFA(sigma, states, initialState, finalState, delta);
        assertTrue(nfa.canRecognize("baba"));
        assertTrue(nfa.canRecognize("baaba"));
        assertTrue(nfa.canRecognize("baaaaaaaaba"));
        assertTrue(nfa.canRecognize("abba"));
        assertFalse(nfa.canRecognize("b"));
    }

    @Test
    public void NFA_should_not_recognize_the_string_out_of_language() throws Exception {
        ArrayList<String> sigma = new ArrayList<>();
        sigma.add("a");
        sigma.add("b");
        ArrayList<String> states = new ArrayList<>();
        states.add("q0");
        states.add("q1");
        states.add("q2");
        String initialState = "q0";
        ArrayList<String> finalStates = new ArrayList<>();
        finalStates.add("q0");
        States finalState = new States(finalStates);

        HashMap path0 = new HashMap();
        HashMap path1 = new HashMap();
        HashMap path2 = new HashMap();

        ArrayList nextStates0 = new ArrayList();
        ArrayList nextStates1 = new ArrayList();
        ArrayList nextStates2 = new ArrayList();
        ArrayList nextStates3 = new ArrayList();

        nextStates0.add("q0");
        nextStates1.add("q1");
        nextStates2.add("q2");
        nextStates3.add("q1");
        nextStates3.add("q2");

        path0.put("b",nextStates1);
        path0.put("#",nextStates2);

        path1.put("a",nextStates3);
        path1.put("b",nextStates2);

        path2.put("a",nextStates0);

        HashMap delta = new HashMap();

        delta.put("q0",path0);
        delta.put("q1",path1);
        delta.put("q2",path2);

        NFA nfa = new NFA(sigma, states, initialState, finalState, delta);
        assertFalse(nfa.canRecognize("b"));
    }
}
