import java.util.Scanner;
import java.io.*;


public class Quest {


    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        String heroName = "";
        String answer = "";
        Story story = new Story();
        ColorText color = new ColorText();
        Scanner scan = new Scanner(System.in);
        System.out.println(color.TEXT_CYAN + "Welcome Player, to the world of Knight's Quest!"+ color.TEXT_RESET);
        System.out.println(color.TEXT_CYAN+ "Are you ready to dive in?!"+ color.TEXT_RESET);
        Thread.sleep(2000);
        story.intro();
        Thread.sleep(4000);
        System.out.println(color.TEXT_CYAN+ "What is your name Hero?"+color.TEXT_RESET);

        heroName = scan.nextLine();
        Character hero = new Character(heroName);
        Battle battle = new Battle(heroName, hero);
        System.out.println("Welcome to the kingdom of Erzaakai! Mighty hero, "+heroName + ", I am king Elpeanor");
        System.out.println("I am grateful you have arrived so soon!");
        System.out.println(color.TEXT_PURPLE +" * Angry and sad...with tears in his eyes*"+ color.TEXT_RESET);
        System.out.println("You may have heard by now...my dear princess has been captured.");
        System.out.println(color.TEXT_CYAN+ "Will you accept this quest to find and rescue her?"+color.TEXT_RESET);
        answer = scan.nextLine();
        System.out.println("Th-th-thank you brave hero! There is... still hope. Here, this is 500G to aid you in this Journey! Please hurry!");
        Thread.sleep(3000);
        System.out.println(color.TEXT_YELLOW + "*The King Gives " + heroName + " 500G*" + color.TEXT_RESET);
        Thread.sleep(3000);
        hero.setGold(500);
        Thread.sleep(3000);
        System.out.println("\"Please talk to the servants, check for clues. The culprit may have left something behind.\"");
        Thread.sleep(2000);
        System.out.println(color.TEXT_PURPLE + "*Left the throne room*" + color.TEXT_RESET);
        Thread.sleep(1000);
        System.out.println("Where do you go?");
        System.out.println("| Princess's room | Town Centre | Talk to servant |");
        answer = scan.nextLine().toLowerCase();

            if (answer.equals("princess") || answer.equals("room") || answer.equals("princess's room")) {
                System.out.println(color.TEXT_PURPLE+ "*Walks into room...Crack!*"+color.TEXT_RESET);
                System.out.println("\"What was that...?\"");

                int chance = 0;
                do {
                    System.out.println("Search under the bed | Search the cabinet | Search the ceiling");
                    answer = scan.nextLine();
                    System.out.println("Searching...");
                    if(answer.equals("ceiling")){
                        System.out.println(color.TEXT_PURPLE +"* suddenly an orc jumps at you from the shadows above! *"+ color.TEXT_RESET);
                        battle.battleDeath(hero);
                        Thread.sleep(3000);
                        System.out.println("\"Th-th-thank you for saving me...It-it...captured me while I went to check on the princess last night\" ");
                        Thread.sleep(3000);
                        System.out.println(color.TEXT_PURPLE+"* a frightened servant girl appeared from where the Orc jumped. *" +color.TEXT_RESET);
                        Thread.sleep(3000);
                        System.out.println("\nIt has been hiding waiting to ambush the king." +
                                "\nHere, this is all I can offer you as gratitude." +
                                "\nThis is all so scary... Pl-pl-please head to th-the town centre. " +
                                "\nThere you'll find supplies, potions and armours to aid you in this quest.\n");
                        Thread.sleep(7000);
                        battle.goldReward(hero, 5);
                        hero.goldInPocket();
                        break;
                    }else {
                        System.out.println("Nothing is there...");
                        chance++;
                    }
                }while (chance < 2);
                System.out.println("*Head To Town*");

            } else if (answer.equals("town")) {
                //go to town
                System.out.println("In town");
            } else if (answer.equals("servant") || answer.equals("talk to servant")) {
                //go to talk to servant
                System.out.println("talking to servant");
            }



    }
}
