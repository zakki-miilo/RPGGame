import java.util.Scanner;
import java.io.*;


public class Quest {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        String heroName;
        Enemy bandit = new Enemy("Bandit");
        Enemy enemy = new Enemy();

        Story story = new Story();
        Dialogue dialogue = new Dialogue();
        Scanner scan = new Scanner(System.in);

        dialogue.cyanDialogue("Welcome Player, to the world of Knight's Quest!", 1);
        dialogue.cyanDialogue("Whether you are ready or not. There is no turning back now...",2);

        story.intro();

        dialogue.cyanDialogue("What is your name Hero?",0);
        heroName = scan.nextLine();

        Character hero = new Character(heroName);
        Inventory inventory = new Inventory(1,1,3,hero,enemy);
        Shop shop = new Shop(hero);
        Battle battle = new Battle(hero,shop, inventory, enemy);
        Castle castle = new Castle(hero,battle,inventory);
        Town town = new Town(hero,battle,inventory,shop, story,bandit);
        castle.castleQuest();
        town.town();
        Forest forest = new Forest(hero,battle,inventory);
        forest.chapter2();
        Mountain mountain = new Mountain(hero,inventory, battle);
        mountain.finalChapter();
    }


}





