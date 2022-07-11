public class UserThread extends Thread {

    private static final int TIME_USER_OPEN = 2500;
    private final int counterAttempt = 4;
    private int currentCounter = 0;
    private Box box;

    UserThread(Box box) {
        this.box = box;
    }

    public static int getTIME_USER_OPEN() {
        return TIME_USER_OPEN;
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                Thread.sleep(TIME_USER_OPEN);
                if (!Box.getBoxSwitch()) {
                    System.out.printf("попытка %d \n", 1 + currentCounter);
                    System.out.println("Пользователь ВКЛЮЧИЛ тумблер!");
                    box.setBoxSwitchOn();
                    currentCounter++;
                }
                if (currentCounter == counterAttempt) {
                    Thread.sleep(TIME_USER_OPEN);
                    //this.interrupt();
                    return;
                }
            }
        } catch (InterruptedException err) {

        } finally {
            System.out.printf("%s больше не хочет играть\n", getName());
        }
    }
}
