package am.gevor.game;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = GevorGameApplication.class)
@WebAppConfiguration
public class GevorGameApplicationTests {

    interface StringFunc {
        String func(String n);
    }

    class MyStringOps {

        String strReverse(String str) {
            String result = "";
            for (int i = str.length() - 1; i >= 0; i--) {
                result += str.charAt(i);
            }
            return result;
        }
    }

    static class MethodRefDemo {
        static String stringOp(StringFunc sf, String s) {
            return sf.func(s);
        }
    }

	@Test
	public void arrayListTest() {
        String inStr = "Лямбда- выражения повышают эффе ктивность Java ";

        String outStr = MethodRefDemo.stringOp(new MyStringOps()::strReverse, inStr);

        System.out.println("Иcxoдн a я строка: " + inStr) ;
        System.out.println("Oбpaщeннaя строка: " + outStr) ;
    }
}
