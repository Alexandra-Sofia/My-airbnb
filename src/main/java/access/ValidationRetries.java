package access;

/**
 * Created by alex on 28/6/2017.
 */

public class ValidationRetries implements Comparable<ValidationRetries> {
    private final String login;
    private long lastRetry = System.currentTimeMillis();
    private int numOfRetries = 0;

    public ValidationRetries(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public long getLastRetry() {
        return lastRetry;
    }

    /**
     *
     * @return the num of millis the user have to wait for a retry;
     */
    private long getRetryMillis() {
        long lastRetryInterval = System.currentTimeMillis() - lastRetry;
        lastRetry = System.currentTimeMillis();

        long millisForRetry = 0;

        if (numOfRetries == 0) millisForRetry = 0;
        else if (numOfRetries < 3) millisForRetry = lastRetryInterval > 5000 ? 0 : 5000;
        else millisForRetry = lastRetryInterval > 60000 ? 0 : 60000;

        numOfRetries++;
        return millisForRetry;
    }

    /**
     * WARNING: Every time you use this method a new retry is assumed that took place.
     *
     * @return the num of seconds the user have to wait for a retry
     */
    public int getRetrySec() {
        long millis = getRetryMillis();
        if (millis <= 0) return 0;

        int sec = Math.round(millis / 1000);
        if (sec == 0) return 1;
        return sec;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((login == null) ? 0 : login.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        ValidationRetries other = (ValidationRetries) obj;
        if (login == null) {
            if (other.login != null) return false;
        }
        else if (!login.equals(other.login)) return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s(%s, retries: %s, last retry interval: %s)", ValidationRetries.class.getSimpleName(), login, numOfRetries, System.currentTimeMillis() - lastRetry);
    }

    public int compareTo(ValidationRetries o) {
        return login.compareTo(o.getLogin());
    }

}
