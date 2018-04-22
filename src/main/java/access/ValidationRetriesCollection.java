package access;

/**
 * Created by alex on 28/6/2017.
 */
import java.util.NavigableSet;
import java.util.concurrent.ConcurrentSkipListSet;

public class ValidationRetriesCollection {
    private final NavigableSet<ValidationRetries> retries = new ConcurrentSkipListSet<ValidationRetries>();

    public ValidationRetries getForLogin(String login) {
        ValidationRetries retry = null;
        for (ValidationRetries r: retries) {
            if (System.currentTimeMillis() - r.getLastRetry() > 120000) {
                retries.remove(r);
            }
            else if (login.equals(r.getLogin())) retry = r;
        }

        if (retry != null) return retry;

        //In any other case:
        retry = new ValidationRetries(login);
        retries.add(retry);
        return retry;
    }

    public int size() {
        return retries.size();
    }
}
