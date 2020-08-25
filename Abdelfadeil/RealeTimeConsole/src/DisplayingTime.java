import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

public class DisplayingTime extends TimerTask {

    @Override
    public void run() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new DisplayingTime(), 0, 1000);

    }
}
