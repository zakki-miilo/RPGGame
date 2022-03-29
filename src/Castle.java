import java.util.Scanner;

public class Castle {
    private int servant = 0;
    int princessRoomCount = 0;
    Dialogue dialogue = new Dialogue();
    Scanner scan = new Scanner(System.in);
    public Character hero;
    public Battle battle;
    public Inventory inventory;

    public Castle(Character hero, Battle battle, Inventory inventory){
        this.hero = hero;
        this.battle = battle;
        this.inventory = inventory;
    }

    public void setServant(int servant) {
        this.servant = servant;
    }
    public int getServant() {
        return servant;
    }

    public int getPrincessRoomCount() {
        return princessRoomCount;
    }

    public void castleIntro(Character hero) throws InterruptedException {
        dialogue.purpleDialogue("5 days later...",1);
        dialogue.dialogue("Welcome to the kingdom of Erzaakai! Mighty hero, "+ hero.heroName + ", I am king Elpeanor",1);
        dialogue.dialogue("I am grateful you have arrived so soon!", 1);
        dialogue.purpleDialogue("Angry and sad...with tears in his eyes",2);
        dialogue.dialogue("You may have heard by now...my dear princess has been captured.",2);
        dialogue.purpleDialogue("The King explains the situation to you", 1);
        dialogue.dialogue("Th-th-thank you brave hero! There is... still hope. Here, this is 200G to aid you in this Journey! Please hurry!", 3);
        dialogue.yellowDialogue("The King Gives " + hero.heroName + " 200G", 1);
        hero.setGold(200);
        dialogue.dialogue("Please talk to the servants, check the princess's room for clues. The culprit may have left something behind.", 2);
        dialogue.purpleDialogue("Left the throne room", 1);

    }

    public void setPrincessRoomCount(int princessRoomCount) {
        this.princessRoomCount = princessRoomCount;
    }

    public void castleQuest() throws InterruptedException {
        Enemy orc = new Enemy("Orc");
        String answer;
        castleIntro(hero);

        dialogue.dialogue("Where do you go?",1);
        do {
            dialogue.blueDialogue(" a: Princess's room | s: Check outside the castle | d:Talk to servants | f: leave ", 1);
            answer = scan.nextLine().toLowerCase();

            switch (answer) {
                case "princess":
                case "room":
                case "princess's room":
                case "a":
                    if(getPrincessRoomCount() ==1){
                        dialogue.dialogue("There's nothing in the room...",1);
                        break;
                    }

                    dialogue.cyanDialogue("*Walks into room...Crack!*",1);
                    System.out.println("\"What was that...?\"");

                    int chance = 0;
                    do {
                        System.out.println(ColorText.TEXT_CYAN + ColorText.GLASS_BG + " a: Search bed | s: Search draws | d: Search ceiling " + ColorText.RESET_BG + ColorText.TEXT_RESET);
                        answer = scan.nextLine();
                        System.out.println("Searching...");
                        if (answer.equals("ceiling") || answer.equals("d")) {
                            System.out.println(ColorText.TEXT_PURPLE + "* suddenly an orc jumps at you from the shadows above! *" + ColorText.TEXT_RESET);
                            battle.battleDeath(orc);
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
                    servant(getPrincessRoomCount());
                    break;
                case "f":
                    dialogue.purpleDialogue( "*Leaving the castle*",1);
                    break;
                default:
                    dialogue.cyanDialogue("Not an option...",1);
            }
            if (!answer.equals("f")) {
                dialogue.cyanDialogue("Anywhere else...?",0);
            }
        }while (!answer.equals("f"));
        dialogue.purpleDialogue("*Walking down to the center of the kingdom.*", 2);
    }

    public void servant(int princessRoomCount) throws InterruptedException {
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
                dialogue.dialogue("She is the princess's maid and I think they took her as well...bu-bu-but I'm not sure. She could still be" +
                        "\nsomewhere in the castle. If you find her I'll be in your dept. Please hurry, return to me if you find something.", 3);
                setServant(1);
            }
        } else {
            dialogue.blueDialogue("The chefs are busy cooking lunch for the king. Better leave them to their work...",2);
        }
    }
}
