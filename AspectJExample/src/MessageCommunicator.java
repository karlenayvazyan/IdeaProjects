/**
 * Created by karlen on 6/5/17.
 */
public class MessageCommunicator {

    public void deliver(String message) {
        System.out.println(message);
    }

    public void deliver(String person, String message) {
        System.out.println(person + ", " + message);
    }
}
