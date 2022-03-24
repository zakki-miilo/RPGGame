import java.io.FileNotFoundException;
import java.util.Scanner;

public class Town {
    Scanner scan = new Scanner(System.in);

    public void town(Story story, Shop shop, Character hero) throws FileNotFoundException, InterruptedException {
        story.toTown();
        Thread.sleep(1000);
        System.out.println("What do you do?");
        String decision;
        do {
            System.out.println(ColorText.TEXT_BLUE + "| a: Blue's shop | s: Talk to Villagers | d: head to pub | f: leave town" + ColorText.TEXT_RESET);
            decision = scan.nextLine().toLowerCase();
            switch (decision) {
                case "blue's shop":
                case "a":
                    System.out.println("Welcome to Blue's Good and More. How can I help you today? ( ‾ʖ̫‾)");
                    System.out.println("My Name is Billy, Here is what we have in stock");
                    System.out.println("A good advice if you are planning on traveling out of the kingdom. Buy the camping tent.\n" +
                            "you look exhausted and needing a good rest. If you fight a monster\n" +
                            "and don't rest, your strength will not recover.");
                    shop.inShop();
                    System.out.println("What would you like?");
                    break;
                case "talk to villagers":
                case "s":
                    System.out.println("A elder man and woman are going about their business selling fish.");
                    System.out.println(ColorText.TEXT_PURPLE + "*Approaching them...*" + ColorText.TEXT_RESET);
                    System.out.println("Good afternoon my good sir, What can we get for ya today. Are we hungry for some delicious\n" +
                            "fish. We have mighty fine fish, caught by yours truly,\nor, could it be something else you interested in...? ");
                    do {
                        System.out.println(ColorText.TEXT_BLUE + "| a: Ask about Orcs | s: Ask about troubles in the kingdom | d: How is business? | x: Leave" + ColorText.TEXT_RESET);
                        decision = scan.nextLine().toLowerCase();
                        fisherman(decision, hero);
                        if (!decision.equals("x")) {
                            System.out.println(ColorText.TEXT_BLUE + "Was there anything else...?" + ColorText.TEXT_RESET);
                        }
                    }
                    while (!decision.equals("x"));
                    break;
                case "d":
                case "pub":
                    System.out.println(ColorText.TEXT_PURPLE + "*Heading to pub*" + ColorText.TEXT_RESET);

                    System.out.println("The smell of brew, the laugher of worryless. Many cusomters already crowded the floor at this" +
                            " time of the day. You walk up to the counter. The bartender spots you and comes over.\n" +
                            "\"What can I do for ya? A cold brew beer? only 7G\"");
                    buying(decision, hero, 7);
                    hero.healing(100);
                    System.out.println(ColorText.TEXT_GREEN + "*FULLY Heal*" + ColorText.TEXT_RESET);
                    System.out.println(ColorText.TEXT_GREEN + hero.getHeroName()+ " HP: " + hero.getHealth()+ ColorText.TEXT_RESET);


                    break;
                case "travel":
                case "f":
                    System.out.println("Heading out of town");
                    break;
                default:
                    System.out.println("This is not an option.");
            }
            if (!decision.equals("f")) {
                System.out.println(ColorText.TEXT_BLUE + "Anywhere else...?" + ColorText.TEXT_RESET);
            }
        } while (!decision.equals("f"));


        System.out.println(ColorText.TEXT_PURPLE + "*Retrieve Garr the horse from the Saddle house*" + ColorText.TEXT_RESET);
        System.out.println(ColorText.TEXT_PURPLE + "*Leaving Town*" + ColorText.TEXT_RESET);
    }

    private void fisherman(String decision, Character hero) {
        switch (decision) {
            case "a":
            case "orcs":
            case "ask about orcs":
            case "about orcs":
                System.out.println("You want some information aye...It's going to cost you. How about...5G");
                buying(decision, hero, 5);
                System.out.println("Thanks aye, have you heard the Orcs are starting to get restless these days. Do you know those horrible\n" +
                        "creatures are still around...hiding in the shadows and wrecking havoc during this peace.\n" +
                        "They have even ruined one of my fishing spot and stole all the fish, they did aye...\n" +
                        "its said they are dwelling deep in the mountains. They are up to something, I can feel it in me bones.");

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

    private void buying(String decision, Character hero, int price) {
        System.out.println(ColorText.TEXT_BLUE + "| p: Pay " + price + "G | d: Don't pay" + ColorText.TEXT_RESET);
        decision = scan.nextLine();
        switch (decision) {
            case "p":
            case "pay":
                System.out.println("In pocket :" + hero.getGold());
                System.out.println(hero.heroName + " has paid the fishman " + price + "G");
                System.out.println(ColorText.TEXT_YELLOW + "-" + price + "G" + ColorText.TEXT_RESET);
                hero.withdrawGold(price);
                System.out.println("In pocket :" + hero.getGold());
                break;
        }
    }
}
