import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by karlen on 6/30/16.
 */
public class MainClass {

    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            String message = JOptionPane.showInputDialog("Input message");
            arrayList.add(message);
        }
        int maxLengthElement = arrayList.get(0).length();
        for (int i = 1; i < arrayList.size(); i++) {
            String current = arrayList.get(i);
            if (maxLengthElement < current.length()) {
                maxLengthElement = current.length();
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            String current = arrayList.get(i);
            if (current.length() == maxLengthElement) {
                System.out.println(current);
            }
        }
    }
}
