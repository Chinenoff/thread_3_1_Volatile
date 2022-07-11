public class Box {
    private static volatile boolean boxSwitch = false;

    public boolean isBoxSwitch() {
        return boxSwitch;
    }

    public void setBoxSwitchOn() {
        this.boxSwitch = true;
    }

    public void setBoxSwitchOff() {
        this.boxSwitch = false;
    }

    public static boolean getBoxSwitch(){
        return boxSwitch;
    }
}
