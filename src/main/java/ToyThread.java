import java.util.Random;

public class ToyThread extends Thread {

    //private final int TIME_TOY_CLOSE = 0; //Мгновенное отключение тумблера
    private Box box;

    ToyThread(Box box) {
        this.box = box;
    }

    Random random = new Random();

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                if (box.isBoxSwitch()) {
                    int timeToyRundom = random.nextInt(UserThread.getTIME_USER_OPEN()); //Рандомное отключение
                    Thread.sleep(timeToyRundom);
                    System.out.println("Игрушка ОТКЛЮЧИЛА тумблер!");
                    box.setBoxSwitchOff();
                }
            }
        } catch (InterruptedException err) {

        } finally {
            System.out.printf("%s довольная спряталась в коробку =)\n", getName());
        }
    }
}
