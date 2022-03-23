import java.util.Scanner;
import java.io.*;


public class Quest {


    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        String heroName;
        String answer;
        Story story = new Story();
        ColorText color = new ColorText();
        Scanner scan = new Scanner(System.in);
        System.out.println(color.TEXT_CYAN + "Welcome Player, to the world of Knight's Quest!"+ color.TEXT_RESET);
        System.out.println(color.TEXT_CYAN+ "Whether you are ready or not. There is no turning back now..."+ color.TEXT_RESET);
        Thread.sleep(2000);
        story.intro();
        Thread.sleep(4000);
        System.out.println(color.TEXT_CYAN+ "What is your name Hero?"+color.TEXT_RESET);

        heroName = scan.nextLine();
        Character hero = new Character(heroName);
        Battle battle = new Battle(heroName, hero);
        System.out.println(color.TEXT_PURPLE + "*Two days later...*" + color.TEXT_RESET);
        System.out.println("Welcome to the kingdom of Erzaakai! Mighty hero, "+heroName + ", I am king Elpeanor");
        System.out.println("I am grateful you have arrived so soon!");
        System.out.println(color.TEXT_PURPLE +" * Angry and sad...with tears in his eyes*"+ color.TEXT_RESET);
        System.out.println("You may have heard by now...my dear princess has been captured.");
        System.out.println(color.TEXT_CYAN+ "Will you accept this quest to find and rescue her?"+color.TEXT_RESET);
        answer = scan.nextLine();
        System.out.println("Th-th-thank you brave hero! There is... still hope. Here, this is 500G to aid you in this Journey! Please hurry!");
        Thread.sleep(3000);
        System.out.println(color.TEXT_YELLOW + "*The King Gives " + heroName + " 500G*" + color.TEXT_RESET);
        Thread.sleep(1000);
        hero.setGold(500);
        Thread.sleep(500);
        System.out.println("\"Please talk to the servants, check the princess's room for clues. The culprit may have left something behind.\"");
        Thread.sleep(1000);
        System.out.println(color.TEXT_PURPLE + "*Left the throne room*" + color.TEXT_RESET);
        Thread.sleep(1000);
        System.out.println("Where do you go?");
        System.out.println("| p: Princess's room | c:Town Centre | s:Talk to servant |");
        answer = scan.nextLine().toLowerCase();

            if (answer.equals("princess") || answer.equals("room") || answer.equals("princess's room")|| answer.equals("p")) {
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
                        System.out.println("It has been hiding waiting to ambush the king." +
                                "\nHere, this is all I can offer you as gratitude." +
                                "\nThis is all so scary... Pl-pl-please head to th-the town centre. " +
                                "\nThere you'll find supplies, potions and armours to aid you in this quest.");
                        Thread.sleep(8000);
                        battle.goldReward(hero, 5);
                        hero.goldInPocket();
                        break;
                    }else {
                        System.out.println("Nothing is there...");
                        chance++;
                    }
                }while (chance < 2);
                System.out.println(color.TEXT_PURPLE+"*Head To Town*"+color.TEXT_RESET);
                Thread.sleep(3000);
            } else if (answer.equals("town")|| answer.equals("t")) {
                //go to town
                System.out.println(color.TEXT_PURPLE+"*Head To Town*"+color.TEXT_RESET);
                story.toTown();
            } else if (answer.equals("servant") || answer.equals("talk to servant")|| answer.equals("s")) {
                //go to talk to servant
                System.out.println("talking to servant");
            }

            story.toTown();
        Thread.sleep(5000);
        System.out.println("What do you do?");
        System.out.println(color.TEXT_BLUE + "| b: Blue's shop | v: Talk to Villagers | t: travel out of town |" + color.TEXT_RESET);
        String decision = scan.nextLine().toLowerCase();
        if (decision.equals("blue's shop") || decision.equals("b")) {
            System.out.println("Welcome to Blue's Good and More. How can I help you today?");
        } else if (decision.equals("talk to villagers") || decision.equals("v")) {

            System.out.println("A elder man and woman are going about their business selling fish.");
            System.out.println("*Approaching them...*");
        } else if (decision.equals("travel") || decision.equals("t")){
            System.out.println("Heading out of town");
        }else {
            System.out.println("This is not an option.");
        }
    }





}
