import com.iancaffey.magtrack.CardReader;
import com.iancaffey.magtrack.TrackParseException;

import java.util.Scanner;

/**
 * CreditCardTest
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class CreditCardTest {
    public static void main(String[] args) throws TrackParseException {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext())
            CardReader.creditCardReader().read(scanner.nextLine()).forEach(System.out::println);
    }
}
