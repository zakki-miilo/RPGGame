import java.util.Scanner;
import java.io.*;


public class Quest {


    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        String heroName;
        String answer;
        Enemy orc = new Enemy("Orc");
        Enemy bandit = new Enemy("Bandit");
        Forest forest = new Forest();
        Shop shop = new Shop();
        Story story = new Story();
        Town town = new Town();
        //ColorText color = new ColorText();
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
        System.out.println(ColorText.TEXT_PURPLE + "*Two days later...*" + ColorText.TEXT_RESET);
        System.out.println("Welcome to the kingdom of Erzaakai! Mighty hero, "+heroName + ", I am king Elpeanor");
        System.out.println("I am grateful you have arrived so soon!");
        System.out.println(ColorText.TEXT_PURPLE +" * Angry and sad...with tears in his eyes*"+ ColorText.TEXT_RESET);
        System.out.println("You may have heard by now...my dear princess has been captured.");
        System.out.println(ColorText.TEXT_CYAN+ "Will you accept this quest to find and rescue her?"+ColorText.TEXT_RESET);
        answer = scan.nextLine();
        System.out.println("Th-th-thank you brave hero! There is... still hope. Here, this is 300G to aid you in this Journey! Please hurry!");
        //Thread.sleep(1000);
        System.out.println(ColorText.TEXT_YELLOW + "*The King Gives " + heroName + " 300G*" + ColorText.TEXT_RESET);
        //Thread.sleep(1000);
        hero.setGold(300);
       // Thread.sleep(500);
        System.out.println("\"Please talk to the servants, check the princess's room for clues. The culprit may have left something behind.\"");
        //Thread.sleep(1000);
        System.out.println(ColorText.TEXT_PURPLE + "*Left the throne room*" + ColorText.TEXT_RESET);
        //Thread.sleep(1000);
        System.out.println("Where do you go?");
        do {
            System.out.println(ColorText.TEXT_CYAN + ColorText.GLASS_BG + " a: Princess's room | s: Check outside the castle | d:Talk to servants | f: leave " + ColorText.RESET_BG + ColorText.TEXT_RESET);
            answer = scan.nextLine().toLowerCase();

            switch (answer) {
                case "princess":
                case "room":
                case "princess's room":
                case "a":
                    System.out.println(ColorText.TEXT_CYAN + "*Walks into room...Crack!*" + ColorText.TEXT_RESET);
                    System.out.println("\"What was that...?\"");

                    int chance = 0;
                    do {
                        System.out.println(ColorText.TEXT_CYAN + ColorText.GLASS_BG + " a: Search bed | s: Search draws | d: Search ceiling " + ColorText.RESET_BG + ColorText.TEXT_RESET);
                        answer = scan.nextLine();
                        System.out.println("Searching...");
                        if (answer.equals("ceiling") || answer.equals("d")) {
                            System.out.println(ColorText.TEXT_PURPLE + "* suddenly an orc jumps at you from the shadows above! *" + ColorText.TEXT_RESET);
                            battle.battleDeath(hero, orc);
                            //Thread.sleep(3000);
                            System.out.println("\"Th-th-thank you for saving me...It-it...captured me while I went to check on the princess last night\" ");
                            //Thread.sleep(3000);
                            System.out.println(ColorText.TEXT_PURPLE + "* a frightened servant girl appeared from where the Orc jumped. *" + ColorText.TEXT_RESET);
                            //Thread.sleep(3000);
                            System.out.println("It has been hiding waiting to ambush the king." +
                                    "\nHere, this is all I can offer you as gratitude." +
                                    "\nThis is all so scary... I'll tell the king what happened. Pl-pl-please head to th-the town centre. " +
                                    "\nThere you'll find supplies, potions and armours to aid you in this quest.");
                            //Thread.sleep(8000);
                            hero.goldReward();
                            hero.goldInPocket();
                            break;
                        } else {
                            System.out.println("Nothing is there...");
                            chance++;
                        }
                    } while (chance < 2);
                    //Thread.sleep(3000);
                    break;
                case "outside the castle":
                case "outside castle":
                case "s":
                    System.out.println(ColorText.TEXT_PURPLE + "*Talking to the guards around the area*" + ColorText.TEXT_RESET);
                    break;
                case "servant":
                case "talk to servant":
                case "d":
                    servant();
                    break;
                case "f":
                    System.out.println(ColorText.TEXT_PURPLE + "*Leaving the castle*" + ColorText.TEXT_RESET);
                    break;
                default:
                    System.out.println("Not an option...");
            }
            if (!answer.equals("f")) {
                System.out.println(ColorText.TEXT_BLUE + "Anywhere else...?" + ColorText.TEXT_RESET);
            }
        }while (!answer.equals("f"));
        //System.out.println("\n");
        System.out.println(ColorText.TEXT_PURPLE+"*Walking down to the center of the kingdom.*" +ColorText.TEXT_RESET);

        town.town(story, shop, hero, battle, bandit);
        forest.chapter2(hero, battle);
    }
    private static void servant(){
        System.out.println(ColorText.TEXT_PURPLE+"*You search the rooms and talked to the servants of the place.*" +ColorText.TEXT_RESET);
        System.out.println("Nobody seems to have any information. Then you walked into the kitchen and find a woman crying there.");
        System.out.println(ColorText.TEXT_PURPLE+"*She looks up you. With a sigh of relieved...*" +ColorText.TEXT_RESET);
        System.out.println("Pl-pl-please help me. My younger sister went missing last night..." +
                "\nShe is the princess's maid and I think they took her as well...bu-bu-but I'm not sure. She could still be" +
                "\nsomewhere in the castle. If you find her I'll be in your dept. Please hurry, return to me if you find something.");

    }







}
