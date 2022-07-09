public class Main {
    public static void main(String[] args) {

        Box myBox = new Box();

        //активируем пользователя
        UserThread userThread = new UserThread(myBox);
        userThread.setName("ПОЛЬЗОВАТЕЛЬ");
        userThread.start();

        //активируем игрушку
        ToyThread toyThread = new ToyThread(myBox);
        toyThread.setName("ИГРУШКА");
        toyThread.start();

        //блок корректного завершения
        try {
            userThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        toyThread.interrupt();
        System.out.println("Все потоки отработали, завершаем программу");
    }
}
