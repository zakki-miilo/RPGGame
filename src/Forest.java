import java.util.Locale;
import java.util.Scanner;

public class Forest {
    Enemy wolf = new Enemy("Wolf");
    Scanner scan = new Scanner(System.in);
    public void chapter2(Character hero,Battle battle, Enemy enemy) throws InterruptedException {
        System.out.println(ColorText.TEXT_PURPLE+"*You Ride on Garr heading towards the forest below the mountains*"+ColorText.TEXT_RESET);
        System.out.println("The breeze is getting colder, the distance sounds of wolves howling can be heard. Night is fast approaching...");
        System.out.println("Its too dangerous to continue travelling. You'll have to stop somewhere for the night.");
        System.out.println(ColorText.TEXT_PURPLE+"*Night Fall*"+ColorText.TEXT_RESET);
        System.out.println("What do you do?");
        System.out.println(ColorText.TEXT_BLUE + "| a: Setup camp now | s: keeping riding | d: Go find an empty hut|" + ColorText.TEXT_RESET);
        String mount = scan.nextLine();
        switch (mount){
            case "a":
            case "camp":
            case "setup camp":
                setupTent();
                break;
        }
        System.out.println("As night grows deeper and so does your sleep... A few hours into your sleep you were awoken by a scream.");
        System.out.println("\"SOMEBODY help me! Ahhh-hh...\"");
        System.out.println("What do you do?");
        System.out.println(ColorText.TEXT_BLUE + "| a: Go help | d: Go back to sleep |" + ColorText.TEXT_RESET);
        mount = scan.nextLine().toLowerCase();
        switch (mount){
            case "a":
            case "go help":
            System.out.println("A man is in trouble, He's being attacked by two wolves. " +
                    "One of the wolf turns and starts attacking you\n");
            battle.battleDeath(hero, wolf);
                System.out.println("Thank you for saving me. Here please take this.\n" +
                        "If you didn't show up just then I would have surely died.");
                hero.goldReward(20);
                System.out.println("I'm a scholar researching rare artifacts. I heard there are some " +
                        "\nvery rare artifacts at this very location. If you help me search for it" +
                        "\nthen we can share on the findings.");
                System.out.println(ColorText.TEXT_PURPLE+"*Both of you search the area for some time.*"+ColorText.TEXT_RESET);
                System.out.println("I find it! I find it! It's down here in this small cave.");
                System.out.println(ColorText.TEXT_PURPLE+"*With his torch he lights up the whole cave.*"+ColorText.TEXT_RESET);
                System.out.println("The light shows skeletons, creates, and chests around the cave. The " +
                        "\nscholar was mostly interested in scrolls, and interesting looking things.\n" +
                        "\"take whatever equipment you find. I have no need of them.\"");
                System.out.println(ColorText.TEXT_BLUE+"Leather armour acquired! Defense + 20"+ColorText.TEXT_RESET);
                System.out.println(ColorText.TEXT_BLUE+"Buster Sword acquired!* Attack + 60"+ColorText.TEXT_RESET);
                hero.heroWeapon = "Buster Sword";
                hero.setHeroWeaponStrength(60);
                enemy.weaponStrengthDecrease(20);
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

    //TODO: setup tent
    public void setupTent(){
        System.out.println("You slow down and looked around the area to find a good area for camping." +
                "\nEventually you find a nice spot under a large tree near the forest wall. To your " +
                "\neast is an open field, with large rocks piled on one another spread out across the whole field." +
                "\nIt's as a giant has came along and played here.");
        System.out.println(ColorText.TEXT_PURPLE+"*You set up your tent and started a fire. Keeping Garr close and warm*"+ColorText.TEXT_RESET);
    }
    //TODO: go find an empty hut
    //TODO: keeping riding, then find a farmer. he asks you to stay the night.




}
