import java.util.Scanner;

public class Castle {
    private int servant = 0;
    int princessRoomCount = 0;
    Scanner scan = new Scanner(System.in);
    public void setServant(int servant) {
        this.servant = servant;
    }
    public int getServant() {
        return servant;
    }

    public int getPrincessRoomCount() {
        return princessRoomCount;
    }

    public void setPrincessRoomCount(int princessRoomCount) {
        this.princessRoomCount = princessRoomCount;
    }

    public void castleIntro(Character hero){
        System.out.println(ColorText.TEXT_PURPLE + "*Two days later...*" + ColorText.TEXT_RESET);
        System.out.println("Welcome to the kingdom of Erzaakai! Mighty hero, "+ hero.heroName + ", I am king Elpeanor");
        System.out.println("I am grateful you have arrived so soon!");
        System.out.println(ColorText.TEXT_PURPLE +" * Angry and sad...with tears in his eyes*"+ ColorText.TEXT_RESET);
        System.out.println("You may have heard by now...my dear princess has been captured.");
        System.out.println(ColorText.TEXT_CYAN+ "Will you accept this quest to find and rescue her?"+ColorText.TEXT_RESET);
        String answer = scan.nextLine();
        System.out.println("Th-th-thank you brave hero! There is... still hope. Here, this is 200G to aid you in this Journey! Please hurry!");
        //Thread.sleep(1000);
        System.out.println(ColorText.TEXT_YELLOW + "*The King Gives " + hero.heroName + " 200G*" + ColorText.TEXT_RESET);
        //Thread.sleep(1000);
        hero.setGold(200);
        // Thread.sleep(500);
        System.out.println("\"Please talk to the servants, check the princess's room for clues. The culprit may have left something behind.\"");
        //Thread.sleep(1000);
        System.out.println(ColorText.TEXT_PURPLE + "*Left the throne room*" + ColorText.TEXT_RESET);
        //Thread.sleep(1000);
    }

    public void castleQuest(Battle battle, Character hero) throws InterruptedException {
        String answer;
        castleIntro(hero);
        Enemy orc = new Enemy("Orc");
        System.out.println("Where do you go?");
        do {
            System.out.println(ColorText.TEXT_CYAN + ColorText.GLASS_BG + " a: Princess's room | s: Check outside the castle | d:Talk to servants | f: leave " + ColorText.RESET_BG + ColorText.TEXT_RESET);
            answer = scan.nextLine().toLowerCase();

            switch (answer) {
                case "princess":
                case "room":
                case "princess's room":
                case "a":
                    if(getPrincessRoomCount() ==1){
                        System.out.println("There's nothing in the room...");
                        break;
                    }

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
                                    "\nThis is all so scary... ");
                            if(getServant() == 1){
                                System.out.println(ColorText.TEXT_PURPLE + "*exhausted and very frighten on the ground with jelly legs. You tell her about her sister*" + ColorText.TEXT_RESET);
                                System.out.println("What?...M-mmm-my sister is looking for me... she's been worried sick? She thought I was taken too?" +
                                        "\nI must hurry back to her! o-oh dear. Bu-but first...");
                                System.out.println(ColorText.TEXT_PURPLE + "*She quickly straighten herself out and brush of the dirt from her uniform*" + ColorText.TEXT_RESET);

                            }
                            System.out.println("I must inform the king of what happened. Pl-pl-please head to th-the town centre. " +
                                    "\nThere you'll find supplies, potions and armours to aid you in this quest.");
                            //Thread.sleep(8000);
                            hero.goldReward(5);
                            hero.goldInPocket();
                            setPrincessRoomCount(1);
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
                    System.out.println("You asked the guards for any information, any clues but they have no idea what happened." +
                            "\nThey seem quite annoyed that the kind summoned an outsider for this, instead of relying on them..." +
                            "\nThe king is already mad at them. Most of the guards are already sent out on a quest to find the" +
                            "\nprincess. The ones that stayed says they wish it was them that should have gone on the quest to find the princess." +
                            "\nInstead of doing nothing here in the castle.");
                    break;
                case "servant":
                case "talk to servant":
                case "d":
                    servant(getPrincessRoomCount(), hero);
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
    }


    public void servant(int princessRoomCount, Character hero) {
        if (getServant() != 2) {
            if (princessRoomCount != 1 || getServant() == 0) {
                System.out.println(ColorText.TEXT_PURPLE + "*You search the rooms and talked to the servants of the palace.*" + ColorText.TEXT_RESET);
                System.out.println("Nobody seems to have any information. Then you walked into the kitchen and find a woman crying there.");
                System.out.println(ColorText.TEXT_PURPLE + "*She looks up you. With a sigh of relieved...*" + ColorText.TEXT_RESET);
                System.out.println("Pl-pl-please help me. My younger sister went missing last night...");
            }
            if (princessRoomCount == 1) {
                System.out.println("Wh-wh-what...?! you already find her.");
                System.out.println(ColorText.TEXT_PURPLE + "*Tears pouring from her eyes. She stood up and grabbed you, hugging you tightly*" + ColorText.TEXT_RESET);
                System.out.println("Oh dear lord... Thank you, thank you. You're saying you killed the orc that was" +
                        "\nhiding her in the princess's room. Now she's informing the king of the situation..." +
                        "\nHow did we missed an orc hiding in the princess's room? " +
                        "\nAs a token of my gratitude please accept this.");
                System.out.println(ColorText.TEXT_PURPLE + "*She hands you a sack of gold*" + ColorText.TEXT_RESET);
                hero.goldReward(10);
                setServant(2);
            } else {
                System.out.println("\nShe is the princess's maid and I think they took her as well...bu-bu-but I'm not sure. She could still be" +
                        "\nsomewhere in the castle. If you find her I'll be in your dept. Please hurry, return to me if you find something.");
                setServant(1);
            }
        } else {
            System.out.println("The chefs are busy cooking lunch for the king. Better leave them to their work...");
        }
    }

}
