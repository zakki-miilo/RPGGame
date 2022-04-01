import java.util.Scanner;

public class Forest {
    Enemy wolf = new Enemy("Wolf");
    Enemy fatOrc = new Enemy("Fat Orc");
    Scanner scan = new Scanner(System.in);
    Character hero;
    Battle battle;
    Inventory inventory;
    Dialogue dialogue = new Dialogue();
    String mount;
    public Forest(Character hero, Battle battle, Inventory inventory){
    this.hero = hero;
    this.battle = battle;
    this.inventory = inventory;
    }

    public void chapter2() throws InterruptedException {

        dialogue.purpleDialogue("*You Ride on Garr heading towards the forest below the mountains*", 1);
        dialogue.dialogue("The breeze is getting colder, the distance sounds of wolves howling can be heard. Night is fast approaching...", 2);
        dialogue.dialogue("Its too dangerous to continue travelling. You'll have to stop somewhere for the night.", 2);
        dialogue.purpleDialogue("*Night Fall*", 1);
        dialogue.dialogue("What do you do?", 1);


        boolean decisionMade;
        do {
            dialogue.blueDialogue("| a: Setup camp now | s: Keep riding", 1);
            mount = scan.nextLine();
            decisionMade = false;
            switch (mount) {
                case "a":
                case "camp":
                case "setup camp":
                    setupTent();
                    scholarStory();
                    decisionMade = true;
                    break;
                case "s":
                case "keep riding":
                case "riding":
                    farmer();
                    decisionMade = true;
                    break;
                default:
                    dialogue.dialogue("That's not an option!", 1);
            }
        } while (!decisionMade);

    }

    public void setupTent() throws InterruptedException {
        if(hero.campingTent){
            hero.healing(100);
            dialogue.dialogue("You slow down and looked around the area to find a good area for camping", 2);
            dialogue.dialogue("Eventually you find a nice spot under a large tree near the forest wall. To your", 2);
            dialogue.dialogue("It's as a giant has came along and played here.", 2);
            dialogue.purpleDialogue("You set up your tent and started a fire. Keeping Garr close and warm", 2);
            dialogue.cyanDialogue("FULL RECOVERY: MAX HEALTH", 1);
        }else{
            hero.healing(70);
            dialogue.dialogue("You forgot to buy a camping tent in town. Without one you will have to sleep outdoor under the trees.",2);
            dialogue.dialogue("Your health won't recover as much as sleeping in a camping tent.",2);
            dialogue.cyanDialogue("+70 HP", 1);
        }
    }

    public void scholarStory() throws InterruptedException {
        System.out.println("As night grows deeper, so does your sleep... A few hours into your sleep you were awoken by a scream.");
        System.out.println("\"SOMEBODY help me! Ahhh-hh...\"");
        System.out.println("What do you do?");
        System.out.println(ColorText.TEXT_BLUE + "| a: Go help | d: Go back to sleep |" + ColorText.TEXT_RESET);
        mount = scan.nextLine().toLowerCase();
        switch (mount){
            case "a":
            case "go help":
                System.out.println("A man is in trouble, He's being attacked by two wolves. " +
                        "One of the wolf turns and starts attacking you\n");
                wolf.setWeaponsStrength(30);
                battle.battleDeath(wolf);
                System.out.println("Thank you for saving me. Here please take this.\n" +
                        "If you didn't show up just then I would have surely died.");
                hero.goldReward(20);
                System.out.println("I'm a scholar researching rare artifacts. I heard there are some " +
                        "\nvery rare artifacts at this very location. If you help me search for it" +
                        "\nthen we can share on the findings.");
                if(hero.torch){
                    torchReward();
                }else {
                    withoutTorch();
                }
                break;
            default:
                System.out.println("You thought it was a dream, too tired to tell if it was real. " +
                        "\nwithin a few seconds you fall back into a deep sleep.");
                System.out.println(ColorText.TEXT_PURPLE+"*It's morning, the light of the sun wakes you from your deep sleep.*"+ColorText.TEXT_RESET);
                System.out.println("What a strange dream it was last night. It felt like someone was in trouble. " +
                        "\nAs you step outside your tummy starts to grow, you take some loafs and eggs from Garr's " +
                        "\nporches and make yourself breakfast.");
                System.out.println(ColorText.TEXT_PURPLE+"*You get on Garr and continue heading into the forest, towards the mountains.*"+ColorText.TEXT_RESET);
                System.out.println("As you go further you noticed birds flying strangely in a spot to the east, just behind " +
                        "\na few boulders.");
                System.out.println(ColorText.TEXT_PURPLE+"*You ride there to have a look*"+ColorText.TEXT_RESET);
                System.out.println("There laid a dead man. You realised what had happened. What you thought was a " +
                        "\ndream was not a dream at all. It looked like he was attacked by wolves from all these" +
                        " \nclaws marked. It's too late now, with a sad heart for the man, you continue into the forest.");
                break;
        }
    }

    public void torchReward() throws InterruptedException {
        dialogue.dialogue("You take out your torch and lit up the field to search for these artifacts.", 1);
        dialogue.dialogue("With the torch, you were able to spot a large door with ancient runes on them.", 1);
        dialogue.dialogue("You tell the scholar to come have a look. This must be the place. He pushed the door opened.", 1);
        dialogue.dialogue("It looks like it has been abandoned for some time. Inside you can see many artifacts and treasures.", 2);
        dialogue.dialogue("Swords, armors and many stranges looking objects laid all over the room. At the back there is another", 2);
        dialogue.dialogue("door, this time, its a regular size door. You and the scholar went inside. In the center there is ", 2);
        dialogue.dialogue("A table with scrolls and manuals. Something in the corner spotted your eyes. A magnificent ", 2);
        dialogue.dialogue("set of armour you have seen, and beside that lays something even greater. It's the legendary Excalibur. ", 2);
        dialogue.purpleDialogue("You take the treasures and said goodbye to the scholar. He stayed behind and study what he found.", 1);
        System.out.println(ColorText.TEXT_BLUE+"King's armour acquired! Defense + 20"+ColorText.TEXT_RESET);
        System.out.println(ColorText.TEXT_BLUE+"Excalibur acquired!* Attack + 60"+ColorText.TEXT_RESET);
        hero.heroWeapon = "Excalibur";
        hero.setHeroWeaponStrength(60);
        hero.healing(100);
    }

    public void withoutTorch(){
        System.out.println(ColorText.TEXT_PURPLE+"*Both of you search the area for some time.*"+ColorText.TEXT_RESET);
        System.out.println("I find it! I find it! It's down here in this small cave.");
        System.out.println(ColorText.TEXT_PURPLE+"*With his torch he lights up the whole cave.*"+ColorText.TEXT_RESET);
        System.out.println("The light shows skeletons, creates, and chests around the cave. The " +
                "\nscholar was mostly interested in scrolls, and interesting looking things.\n" +
                "\"take whatever equipment you find. I have no need of them.\"");
        System.out.println(ColorText.TEXT_BLUE+"Leather armour acquired! Defense + 10"+ColorText.TEXT_RESET);
        System.out.println(ColorText.TEXT_BLUE+"Claymore Sword acquired!* Attack + 40"+ColorText.TEXT_RESET);
        hero.heroWeapon = "Claymore Sword";
        hero.setHeroWeaponStrength(60);
        hero.healing(100);
        System.out.println("-----------------------------");
    }

    //TODO: go find an empty hut

    public void farmer() throws InterruptedException {
        dialogue.dialogue("...",1);
        dialogue.purpleDialogue("You keep riding for a few more kilometers until you reached a farm.", 2);
        dialogue.purpleDialogue("Farmers are finishing up their tasks for the day and heading inside. They see you arriving!", 2);
        dialogue.dialogue("Greeting traveler. What can we do for ya? You explained the situation with the princess and" +
                "\nasked them if they has seen any strange happenings lately. As you do... BOOM! a big bang came from behind the barn.", 1);
        dialogue.cyanDialogue("You hurry closer...You can see a large fat Orc, hungry and ready to kill for food.", 2);
        dialogue.dialogue("...",1);
        battle.battleDeath(fatOrc);
        dialogue.dialogue("Thank you for saving us...pl-please won't you say and have supper with us. Its the least we can do.", 2);
        dialogue.purpleDialogue("The farmer and his wife asked you to stay for supper.", 1);
        dialogue.blueDialogue("a: Stay | d: leave", 1);
        String farm = scan.nextLine();
        switch (farm){
            case "a":
            case "stay":
                dialogue.dialogue("The farmers made a feast for you to celebrate! You enjoyed the evening with them," +
                        "\nsharing stories, singing and dancing with the folks. They tell you that this wasn't the first time",2);
                dialogue.dialogue("that an orc has attacked here. The fat orc has a brother and is sometime seen in the morning.", 2);
                hero.healing(100);
                dialogue.purpleDialogue("After a good night sleep, you are ready to go.",1);
                dialogue.purpleDialogue("Before you leave you decided to wait and help the farmers with their orc problem.",1);
                dialogue.cyanDialogue("As the farmers said, the orc showed up. Looking for its' breakfast.", 2);
                dialogue.dialogue("...", 1);
                battle.battleDeath(fatOrc);
                dialogue.dialogue("You did! you beat the brothers. Now we can live in peace here.",1);
                dialogue.purpleDialogue("Everybody thanks you and after the excitement has settle down everyone went back to work.", 1);
                dialogue.dialogue("You decided to followed the trail the orc took and return to it's home, a small cave surrounded by large trees.", 2);
                dialogue.purpleDialogue("Many chests and creates inside. Broken things... Then, something clean and shiny caught your attention.", 2);
                dialogue.purpleDialogue("A rare sword. It looks dark and power.", 2);
                dialogue.cyanDialogue("SOUL-EATER BLADE ACQUIRED. +70 Strength",1);
                hero.heroWeapon = "Soul-Eater blade";
                hero.setHeroWeaponStrength(70);
                hero.healing(100);
                break;
            default:
                dialogue.dialogue("Very well...You are in a hurry to find the princess. If you happen to travel this way again" +
                        "\nplease stop by.", 2);
                dialogue.dialogue("Before you leave we have something to give you. This armour has been with us for some time but" +
                        "\nit's only collecting dusk. We want you to have it.", 1);
                dialogue.blueDialogue("ACQUIRED gold armour!", 1);
                hero.setArmor("Gold Armour");
                hero.healing(100);

        }

    }


}
