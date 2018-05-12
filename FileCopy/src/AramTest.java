import am.ak.question.util.Validator;

import javax.swing.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

/**
 * Created by karlen on 20.02.16.
 */
public class AramTest {

    public static void main(String[] args) {
        Random random = new Random();
        String question;
        do {
            question = JOptionPane.showInputDialog(null, "Գրեք հարցը");
        } while (Validator.isEmpty(question));
        double percent = 1 + (random.nextDouble() * (100 - 1));
        NumberFormat formatter = new DecimalFormat("#0.00");
        JOptionPane.showMessageDialog(null, question + "? " + formatter.format(percent));
    }
}
