import org.junit.Test;

public class ParserTest {
    @Test
    public void Parser_should_parse_the_json_string_and_make_hashMap() throws Exception {
        Parser parser = new Parser();
        DFAEquation equation = (DFAEquation) parser.parse().get(1);
    }
}