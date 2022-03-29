import java.io.FileNotFoundException;
import java.util.Scanner;

public class Town {
    Scanner scan = new Scanner(System.in);
    boolean notBuy = false;
    Dialogue dialogue = new Dialogue();
    Character hero;
    Battle battle;
    Inventory inventory;
    Shop shop;
    Story story;
    Enemy enemy;

    public Town(Character hero, Battle battle, Inventory inventory, Shop shop, Story story, Enemy enemy){
        this.hero = hero;
        this.battle = battle;
        this.inventory = inventory;
        this.shop = shop;
        this.story = story;
        this.enemy = enemy;
    }

    public void town() throws FileNotFoundException, InterruptedException {
        story.toTown();
        dialogue.dialogue("What do you do?",1);
        String decision;
        do {
            dialogue.blueDialogue("a: Blue's shop | s: Talk to Villagers | d: Head to pub | f: leave town |",1);
            decision = scan.nextLine().toLowerCase();
            switch (decision) {
                case "blue's shop":
                case "a":
                    dialogue.dialogue("Welcome to Blue's Good and More. How can I help you today? ( ‾ʖ̫‾)",0);
                    dialogue.dialogue("My Name is Billy, Here is what we have in stock",0);
                    dialogue.dialogue("A good advice if you are planning on traveling out of the kingdom. Buy the camping tent.\n" +
                            "you look exhausted and needing a good rest. If you fight a monster\n" +
                            "and don't rest, your health will not recover.",1);
                    shop.inShop();
                    shop.buyingItems(inventory);
                    break;
                case "talk to villagers":
                case "s":
                    dialogue.dialogue("A elder man and woman are going about their business selling fish.",1);
                    dialogue.purpleDialogue("*Approaching them...*",1);
                    dialogue.dialogue("Good afternoon my good sir, What can we get for ya today. Are we hungry for some delicious\n" +
                            "fish. We have mighty fine fish, caught by yours truly,\nor, could it be something else you interested in...? ",3);
                    do {
                        dialogue.blueDialogue("a: Ask about Orcs | s: Ask about troubles in the kingdom | d: How is business? | x: Leave",1);
                        decision = scan.nextLine().toLowerCase();
                        fisherman(decision);
                        if (!decision.equals("x")) {
                            dialogue.blueDialogue("Was there anything else...?",1);
                            dialogue.dialogue("\n",1);
                        }
                    }
                    while (!decision.equals("x"));
                    break;
                case "d":
                case "pub":
                    dialogue.purpleDialogue("*Heading to pub*",1);
                    dialogue.dialogue("The smell of brew, the laughter of joy and fun hits you as you enter the cabin.\n" +
                            "Many customers filling up most of the tables even at " +
                            "this time of the day.\nYou walk up to the counter. The bartender spots you and comes over.\n" +
                            "\"What can I do for ya? A cold brew beer? only 7G\"",4);
                    buying(hero, 7);
                    if(!notBuy){
                        hero.healing(100);
                        System.out.println(ColorText.TEXT_GREEN + "*FULLY Heal*" + ColorText.TEXT_RESET);
                        System.out.println(ColorText.TEXT_GREEN + hero.getHeroName()+ " HP: " + hero.getHealth()+ ColorText.TEXT_RESET);
                        dialogue.dialogue("Thanks for stopping by. Come again anytime.",1);
                    }else {
                        dialogue.dialogue("A'ite, if there isn't anything else, ya have a good day now.",1);
                        dialogue.purpleDialogue("*Bartender left to go serve another customer who just walked in*" , 2);

                    }
                    break;
                case "travel":
                case "f":
                    dialogue.dialogue("Heading out of town",1);
                    break;
                default:
                    dialogue.dialogue("This is not an option.",1);
            }
            if (!decision.equals("f")) {
                dialogue.cyanDialogue("Anywhere else...?",1);
            }
        } while (!decision.equals("f"));
        dialogue.purpleDialogue("Retrieving Garr the horse from the stable",1);
        dialogue.purpleDialogue("*Leaving Town*",1);
    }

    private void fisherman(String decision) throws InterruptedException {
        switch (decision) {
            case "a":
            case "orcs":
            case "ask about orcs":
            case "about orcs":
                System.out.println("You want some information aye...It's going to cost you. How about...5G");
                buying(hero, 5);
                if(notBuy){
                    System.out.println("Sorry then aye, I cannot help you... information are valuable these days.");

                }else {
                    fishermanQuest();
                }
                break;
            case "troubles":
            case "kingdom":
            case "s":
                System.out.println("have you heard... The princess has been kidnapped.");
                break;
            case "business":
            case "how's business":
            case "d":
                System.out.println("Very good. Thank you for asking. Are we interested in purchasing something...");
                System.out.println(ColorText.TEXT_PURPLE + "*Waiting impatiently, looking eager for you to buy something*" + ColorText.TEXT_RESET);
                break;
            case "x":
            case "leave":
                System.out.println("Thank you for visiting our shop. Please stop by if you need something else. FISH, VERY CHEAP FISH!\n" +
                        "only 1G! COME on ladies and gents COME and buy our delicious fish!\n");
                break;
            default:
                System.out.println("Sorry we can't help ya there... If you want nothing more. we have customers\n" +
                        "we must attend to. Good day my good sir.");
                System.out.println(ColorText.TEXT_PURPLE + "*Looking irritated...excepting you to leave now...*" + ColorText.TEXT_RESET);
                break;
        }
    }

    public void buying(Character hero, double price) {
        String displayPrice = String.format("%.2f", price);
        System.out.println(ColorText.TEXT_BLUE + ColorText.GLASS_BG +"| a: Pay " + displayPrice + "G | d: Don't pay |" + ColorText.RESET_BG+ ColorText.TEXT_RESET);
        String decision = scan.nextLine();
        switch (decision) {
            case "a":
            case "pay":
                System.out.println("In pocket :" + hero.getGold() + "| " + hero.heroName + " has paid |" + displayPrice + "G");
                System.out.println(ColorText.TEXT_YELLOW + "-" + displayPrice + "G" + ColorText.TEXT_RESET);
                hero.withdrawGold(price);
                System.out.println("In pocket :" + hero.getGold());
                notBuy = false;
                break;
            case "d":
            case "don't pay":
                notBuy = true;
                break;
            default:
                System.out.println("That's not an option.");
                notBuy = true;
        }

    }

    public void fishermanQuest() throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        System.out.println("-------------------------");
        System.out.println("Thanks aye, heard the Orcs and bandits are feeling\n" +
                "restless these days. Thee horrible " +
                "Orcs are still living...hiding in the shadows and wrecking havoc n' everything!\n" +
                "ruined one of me fishing spot, stoling all me fishes, they did aye...\n" +
                "heard them dwelling deep in mountains...up to something, feel it in me bones.");
        System.out.println(ColorText.TEXT_PURPLE + "*Suddenly the fisherman had an idea*"+ ColorText.TEXT_RESET);
        System.out.println("Aye, say ya help an old man out. Mind going and check'n the fishing area and getting rid of anything" +
                "\nthere ya see? will pay ya greatly, wat aye say..");
        System.out.println(ColorText.TEXT_CYAN + "Do you accept quest?"+ ColorText.TEXT_RESET);
        System.out.println(ColorText.TEXT_CYAN + ColorText.GLASS_BG + " a: Yes | d: No " + ColorText.RESET_BG + ColorText.TEXT_RESET);
        String decision = scan.nextLine().toLowerCase();
        switch (decision){
            case "a":
            case "yes":
                System.out.println("Thankss...you do an old man great favour, you arr. Here show ya area on map.");
                System.out.println(ColorText.TEXT_PURPLE + "*The fisherman draws on your map...*"+ ColorText.TEXT_RESET);
                System.out.println("alrite. ain't about half a day on horse to the south aye.");
                System.out.println(ColorText.TEXT_PURPLE + "*You go to the saddle house and retrieve your horse, Garr.*\n"+ ColorText.TEXT_RESET);
                battle.battleDeath(enemy);
                System.out.println(ColorText.TEXT_PURPLE + "*After clearing the fishing spot you return to the fisherman*\n"+ ColorText.TEXT_RESET);
                System.out.println("Yo-you're back already aye! defeated all the creatures that were there? ain't you something, Great Hero!\n" +
                        "Here's your reward.");
                hero.goldReward(10);
                hero.goldInPocket();
                break;
            default:
                dialogue.dialogue("Ah...say no more, busy are we. Fair is fair. Another day maybe...",2);
                break;
        }
    }
}
