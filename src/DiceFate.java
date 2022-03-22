import java.util.Random;

public class DiceFate extends Quest{
    public int randomDice(){
        Random rand = new Random();

        int i = rand.nextInt(6) + 1;


        return i;

    }
}
