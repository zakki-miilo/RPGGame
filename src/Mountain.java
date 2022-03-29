import java.util.Scanner;

public class Mountain {
Enemy bandit = new Enemy("Bandit");
Enemy orc = new Enemy("Warrior Orc");
Enemy boss = new Enemy("Death-Eye, King of the ORC");
Battle battle;
Scanner scanner = new Scanner(System.in);
Dialogue dialogue = new Dialogue();
Character hero;
Inventory inventory;
public Mountain(Character hero,Inventory inventory, Battle battle){
    this.hero = hero;
    this.inventory = inventory;
    this.battle = battle;
}


    public void finalChapter() throws InterruptedException {
        dialogue.dialogue("...",0);
        dialogue.purpleDialogue("A few days passes riding to the mountains",1);
        entranceCave();
        boss();
        savingThePrincess();
    }

    public void entranceCave() throws InterruptedException {
        dialogue.dialogue("You have arrived at the base of the mountain. You search around the area." +
                "\neventually you see a armoured orc and a bandit guarding something that looks like" +
                "\na secret hidden door into the mountains. ",4);
        dialogue.purpleDialogue("You hide in the bush, watching them, waiting for a chance",1);
        dialogue.dialogue("The bandit left his post and walked off into the bush.",2);
        dialogue.blueDialogue("a: Follow bandit? | d: Stay and fight orc",1);

        String decision = scanner.nextLine();
        switch (decision){
            case "a":
            case "bandit":
            case "follow bandit":
                dialogue.dialogue("You follow the bandit" +
                        "\nWhen it was far enough you attack him!",3);
                bandit.setWeaponsStrength(35);
                bandit.setEnemyHp(80);
                battle.battleDeath(bandit);
                break;
            case "d":
            case "stay":
            case "fight orc":
                dialogue.purpleDialogue("*You stay and watch the orc. Waiting for a chance to kill it*",1);
                dialogue.dialogue("The bandit should have gone far enough by now. There is a chance, so you take it!" +
                        "\nyou dashed at the orc and attack him!\n",4);
                orc.setEnemyHp(100);
                orc.setWeaponsStrength(40);
                orc.setWeaponType("Steel Hammer");
                battle.battleDeath(orc);
        }
    }

    public void boss() throws InterruptedException {
        boss.setWeaponType("God's Axe");
        boss.setEnemyHp(200);
        boss.setWeaponsStrength(10); //change back to 60

        dialogue.dialogue("A massive orc sits in his throne in the middle of the large open cave. Torches lit all over." +
                "\nBehind this King Orc you see the princess. She's being held captive in a bird cage hanging beside the " +
                "\nthe throne.",4);
        dialogue.purpleDialogue("Death-Eye doesn't say or do anything. He just watches you with a bored look",1);
        dialogue.dialogue("Your eye locks onto his and you get chills down your spine.",3);
        dialogue.purpleDialogue("There are orcs and bandits surrounding the cave. All cheering and waiting for some action",1);
        dialogue.dialogue("Come here little human! Fight me! Come save your precious princess.",3);
        dialogue.purpleDialogue("The King Orc stands up and grabs his weapon and waits for you to approach.",1);
        dialogue.purpleDialogue("You walk to the center of the cave. With your weapon in hand. Its do or die now!",1);
        battle.battleDeath(boss);
    }

    public void savingThePrincess() throws InterruptedException {
        defeatBossDialogue("You defeated Death-Eye King of the ORC!");
        dialogue.dialogue("ALl the reminding orcs and bandits have ran away!",2);
        dialogue.dialogue("Nobody dares to challenge you now.",2);
        dialogue.dialogue("You took the key from the dead King Orc and let the cage down,",2);
        dialogue.dialogue("using the key to unlock the door. You help the princess out of the cage.",2);
        dialogue.purpleDialogue("Weak and hungry she is unable to stand. You give her food and water",1);
        dialogue.dialogue("...",1);
        dialogue.dialogue("Th-thank you my hero. I'm sorry for the trouble you have gone through.\nI am forever in your" +
                " debt.\nWhen we return, my father will grant you anything you wish.",4);
        dialogue.dialogue("...",1);
        dialogue.purpleDialogue("You take the princess out of the cave and to Garr.",1);
        dialogue.purpleDialogue("Proudly Riding back to the kingdom in the bright setting sunlight",1);
        dialogue.dialogue("...",1);
        dialogue.dialogue("You ponder the wish you would like to ask...\n",2);
        dialogue.dialogue("+----------+",0);
        dialogue.dialogue("||THE END!||",2);
        dialogue.dialogue("+----------+",0);
    }

    public void defeatBossDialogue(String dialogue){
        System.out.println("+------------------------------------------+");
        System.out.println(ColorText.TEXT_BLUE + "|| "+ dialogue+"||" + ColorText.TEXT_RESET);
        System.out.println("+------------------------------------------+");
    }

}
