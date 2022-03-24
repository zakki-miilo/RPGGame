import java.util.Random;

public class DiceFate extends Quest{
    Random rand = new Random();
    public int randomDice(){
        return rand.nextInt(6) + 1;
    }

}




