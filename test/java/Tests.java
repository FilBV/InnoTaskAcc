import org.junit.jupiter.api.Test;
import ru.inno.task.Account;
import ru.inno.task.Save;

public class Tests {
    @Test
    public void SecondTest() {
        Account acc = new Account("Устинов Сергей Иванович");
        acc.addCur(Account.Currency.RUB, 59);
        acc.addCur(Account.Currency.EUR, 25);
        acc.setName("Иванов Петр Сергеевич");
        acc.addCur(Account.Currency.RUB, 74);
        acc.addCur(Account.Currency.USD, 62);
        Save save = acc.save();
        acc.undo();
    }
}
