import java.util.Scanner;

public class Forest {
    Enemy wolf = new Enemy("Wolf");
    Scanner scan = new Scanner(System.in);
    public void chapter2(Character hero,Battle battle) throws InterruptedException {
        System.out.println(ColorText.TEXT_PURPLE+"Riding on Garr heading towards the forest below the mountains"+ColorText.TEXT_RESET);
        System.out.println("The breeze is getting colder, the distance sounds of wolves howling can be heard. Night is fast approaching...");
        System.out.println("Its too dangerous to continue travelling. You'll have to stop somewhere for the night.");
        System.out.println(ColorText.TEXT_PURPLE+"*Night Fall*"+ColorText.TEXT_RESET);
        System.out.println("What do you do?");
        System.out.println(ColorText.TEXT_BLUE + "| s: Setup camp now | k: keeping riding | g: Go find an empty hut|" + ColorText.TEXT_RESET);
        String mount = scan.nextLine();
        System.out.println("As night grows deeper and so does your sleep, you were awoken by a scream.");
        System.out.println("\"SOMEBODY help me! Ahhh-hh...\"");
        System.out.println("What do you do?");

        System.out.println("A man is in trouble, He's being attacked by two wolves. " +
                "One of the wolf turns and starts attacking you\n");
        battle.battleDeath(hero, wolf);
    }

}
