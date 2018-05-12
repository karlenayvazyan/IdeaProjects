import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by karlen on 5/29/17.
 */
public class TestExpressionLanguage {

    @Test
    public void testSpringExpresionLanguage() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression("'Hello world'.bytes.length");
        assertNotNull(expression.getValue());
        Integer value = (Integer) expression.getValue();
        Integer expect = 11;
        assertEquals(expect, value);
    }

    @Test
    public void testExpressionLanguage() {
        // Create and set a calendar
        GregorianCalendar c = new GregorianCalendar();
        c.set(1856, 7, 9);
        // The constructor arguments are name, birthday, and nationality.
        Inventor tesla = new Inventor("Nikola Tesla", c.getTime(), "Serbian");

        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("name");

        EvaluationContext context = new StandardEvaluationContext(tesla);
        String name = (String) exp.getValue(context);
        assertNotNull(name);
        assertEquals("Nikola Tesla", name);
    }

    @Test
    public void testExpressionLanguageNew() {
        // Create and set a calendar
        GregorianCalendar c = new GregorianCalendar();
        c.set(1856, 7, 9);
        // The constructor arguments are name, birthday, and nationality.
        Inventor tesla = new Inventor("Nikola Tesla", c.getTime(), "Serbian");

        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("name");

        String name = (String) exp.getValue(tesla);
        assertNotNull(name);
        assertEquals("Nikola Tesla", name);
    }

    @Test
    public void testBoolean() {
        // Create and set a calendar
        GregorianCalendar c = new GregorianCalendar();
        c.set(1856, 7, 9);
        // The constructor arguments are name, birthday, and nationality.
        Inventor tesla = new Inventor("Nikola Tesla", c.getTime(), "Serbian");
        EvaluationContext context = new StandardEvaluationContext(tesla);
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("name == 'Nikola Tesla'");
        boolean result = exp.getValue(context, Boolean.class); // evaluates to true
        assertTrue(result);
    }

    @Test
    public void testTypeConversion() {
        Simple simple = new Simple();
        simple.booleanList.add(true);
        StandardEvaluationContext simpleContext = new StandardEvaluationContext(simple);
        // false is passed in here as a string. SpEL and the conversion service will
        // correctly recognize that it needs to be a Boolean and convert it
        ExpressionParser parser = new SpelExpressionParser();
        parser.parseExpression("booleanList[0]").setValue(simpleContext, "false");
        // b will be false
        Boolean b = simple.booleanList.get(0);
        assertFalse(b);
    }

    class Simple {
        public List<Boolean> booleanList = new ArrayList<Boolean>();
    }

    @Test
    public void testParserConfiguration() {
        // Turn on:
        // - auto null reference initialization
        // - auto collection growing
        SpelParserConfiguration config = new SpelParserConfiguration(true, true);
        ExpressionParser parser = new SpelExpressionParser(config);
        Expression expression = parser.parseExpression("list[3]");
        Demo demo = new Demo();
        String strings = (String) expression.getValue(demo);
        // demo.list will now be a real collection of 4 entries
        // Each entry is a new empty String
        assertNotNull(strings);
    }

    class Demo {
        public List<String> list;
    }
}
