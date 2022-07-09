public class Box {
    volatile boolean boxSwitch = false;

    public boolean isBoxSwitch() {
        return boxSwitch;
    }

    public void setBoxSwitchOn() {
        this.boxSwitch = true;
    }

    public void setBoxSwitchOff() {
        this.boxSwitch = false;
    }
}
