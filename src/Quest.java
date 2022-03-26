import java.util.Scanner;
import java.io.*;


public class Quest {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        String heroName;
        Enemy bandit = new Enemy("Bandit");
        Enemy enemy = new Enemy();
        Forest forest = new Forest();
        Shop shop = new Shop();
        Story story = new Story();
        Town town = new Town();
        Castle castle = new Castle();
        Scanner scan = new Scanner(System.in);

        System.out.println(ColorText.TEXT_CYAN + "Welcome Player, to the world of Knight's Quest!"+ ColorText.TEXT_RESET);
        System.out.println(ColorText.TEXT_CYAN + "Whether you are ready or not. There is no turning back now..."+ ColorText.TEXT_RESET);
        //Thread.sleep(1000);
        story.intro();
        //Thread.sleep(1000);
        System.out.println(ColorText.TEXT_CYAN + "What is your name Hero?"+ColorText.TEXT_RESET);
        heroName = scan.nextLine();

        Character hero = new Character(heroName);
        Battle battle = new Battle(hero);

        castle.castleQuest(battle, hero);
        town.town(story, shop, hero, battle, bandit);
        forest.chapter2(hero, battle,enemy);
    }


}





