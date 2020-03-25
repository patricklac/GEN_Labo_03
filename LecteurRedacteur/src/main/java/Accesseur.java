public class Accesseur {
    private Controleur ctrl;

    public Accesseur(Controleur ctrl){
        this.ctrl = ctrl;
    }

    public void startRead(){}

    public void stopRead(){}

    public Boolean isWaiting(){return false;}
}
