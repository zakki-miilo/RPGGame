import java.nio.charset.Charset;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Battle extends Character {
    DiceFate fateBattle = new DiceFate();
    Scanner scanBattle = new Scanner(System.in);
    ColorText color = new ColorText();
    String hero = "";
    Enemy orc1 = new Enemy();
    Random rand = new Random();
    int coin = 0;
    int fate = 0;
    Inventory inventory = new Inventory();
    //Timer timer = new Timer();
    boolean shield = false;

    public Battle(String hero, Character character) {
        super(hero);
        this.hero = character.heroName;
        this.coin = coin();
    }

    public void battleDeath(Character hero) throws InterruptedException {
        //if(hero.getHealth() > 0 || orc1.getAvgEnemyHealth() > 0) {

            System.out.println("* BATTLE Begins *");
            Thread.sleep(4000);
            showHealth(hero);
            System.out.println("*You pulls out a " + hero.heroWeapon + "*");
            Thread.sleep(3000);
            showEnemyHp(orc1);
            System.out.println("*Orc is staring... with " + orc1.getAvgEnemyWeapon()+ " in hand*");
            Thread.sleep(3000);
            coinFlip(coin, hero);

            while (hero.getHealth() > 0 || orc1.getAvgEnemyHealth() > 0) {
                if(coin == 1){
                        enemyBattle(hero);

                        heroBattle(hero);
                        if (orc1.getAvgEnemyHealth() == 0) {
                            orc1.isDead();
                            goldReward(hero, 5);
                            Thread.sleep(3000);
                            break;
                        }
                }else {
                    heroBattle(hero);
                    if(orc1.getAvgEnemyHealth() == 0){
                        orc1.isDead();
                        Thread.sleep(3000);
                        goldReward(hero, 5);
                        break;

                    }else{
                        enemyBattle(hero);
                    }
                }
            }

    }

    private int coin(){
        return coin = rand.nextInt(2);
    }
    private void coinFlip(int coin, Character hero) throws InterruptedException {
        if(coin == 1){
            System.out.println("---------------------------");
            System.out.println(color.TEXT_PURPLE + "Hero starts"+ color.TEXT_RESET);
            //System.out.println("__________________________");
            heroBattle(hero);
        }else {
            System.out.println("---------------------------");
            System.out.println(color.TEXT_PURPLE + "Orc starts"+ color.TEXT_RESET);
            //System.out.println("__________________________");
            enemyBattle(hero);
        }
    }

    private void heroBattle(Character hero) throws InterruptedException {
            fate = fateBattle.randomDice();
            System.out.println("__________________________");
            System.out.println("What do you do?");
            System.out.println("__________________________");
            System.out.println(color.TEXT_CYAN + "a: Attack | d: Defend | i: Inventory"+color.TEXT_RESET);
            System.out.println("---------------------------");
            String reply = scanBattle.nextLine().toLowerCase();

            if(reply.equals("inventory") || reply.equals("i")){
                inventory.showItems(hero);
                Thread.sleep(3000);
                showHealth(hero);
                Thread.sleep(3000);
            }else if(reply.equals("attack")|| reply.equals("a")){
                if (fate <= 3) {
                    heroMissedAtt(hero);
                    Thread.sleep(2000);
                } else {

                    heroAttacks();
                    Thread.sleep(3000);
                    System.out.println("---------------------------");
                    successHitEnemy(hero);
                    Thread.sleep(3000);
                    showEnemyHp(orc1);
                    Thread.sleep(3000);
                }
            }else if(reply.equals("defend")|| reply.equals("d")){
                System.out.println(color.TEXT_PURPLE+ "*In a defense stand. Ready to block*"+color.TEXT_RESET);
                Thread.sleep(3000);
                shield = true;
            }



        }

    private void enemyBattle(Character hero) throws InterruptedException {
            fate = fateBattle.randomDice();
            if (fate <= 3) {
                System.out.println("__________________________");
                System.out.println("Orc Attacks and misses!");
                Thread.sleep(2000);
                //System.out.println("__________________________");
            } else {
                if (shield == true) {
                    int normalStrength = orc1.getWeaponsStrength();
                    orc1.setWeaponsStrength(0);
                    System.out.println("---------------------------");
                    System.out.println("Orc swing his " + orc1.getAvgEnemyWeapon() + " at you");
                    Thread.sleep(2000);
                    hero.setHealth(orc1.getWeaponsStrength());
                    System.out.println("__________________________");
                    System.out.println(color.TEXT_RED +"*Attack had no affect*"+color.TEXT_RESET);
                    Thread.sleep(2000);
                    System.out.println("---------------------------");
                    showHealth(hero);
                    Thread.sleep(2000);

                    if (hero.getHealth() == 0) {
                        hero.gameOver();
                    }
                    shield = false;
                    orc1.setWeaponsStrength(normalStrength);
                }else {
                    Thread.sleep(3000);
                    System.out.println("---------------------------");
                    System.out.println("Orc swing his " + orc1.getAvgEnemyWeapon() + " at you");
                    Thread.sleep(3000);
                    hero.setHealth(orc1.getWeaponsStrength());
                    System.out.println("__________________________");
                    successHitHero();
                    Thread.sleep(3000);
                    System.out.println("---------------------------");
                    showHealth(hero);
                    Thread.sleep(3000);

                    if (hero.getHealth() == 0) {
                        hero.gameOver();
                    }
                }
            }
    }

    public void showHealth(Character hero){
        System.out.println(ColorText.TEXT_BLUE + "|| " + hero.heroName + " | HP: " + hero.getHealth() + " ||" + ColorText.TEXT_RESET);
    }

    private void showEnemyHp(Enemy orc){
        System.out.println(ColorText.TEXT_GREEN + "|| " + orc1.getEnemyType()+ " | HP: " +  orc1.getAvgEnemyHealth()+ " ||" +  ColorText.TEXT_RESET);
    }

    public void goldReward(Character hero, int gold){
        hero.setGold(gold);
        System.out.println(ColorText.TEXT_YELLOW + "| +"+ gold +"G |" + ColorText.TEXT_RESET);
    }

    private void successHitEnemy(Character hero){
        orc1.setAvgEnemyHealth(hero.getHeroStrength());
        System.out.println(ColorText.TEXT_RED +"HIT! The "+ orc1.getEnemyType() +" has taken damaged -" + hero.getHeroStrength()+ "HP"+ ColorText.TEXT_RESET);
    }

    private void successHitHero(){
        System.out.println(ColorText.TEXT_RED + "You have been HIT! ORC slashes with his " + orc1.getAvgEnemyWeapon() + "." + ColorText.TEXT_RESET);
        System.out.println(ColorText.TEXT_RED +"-" + orc1.getWeaponsStrength() + " HP" + ColorText.TEXT_RESET);
    }

    private void heroMissedAtt(Character hero){
        System.out.println(ColorText.TEXT_CYAN + hero.heroName + "'s ATTACK missed!"+ ColorText.TEXT_RESET);
    }

    private void heroAttacks(){
        System.out.println(color.TEXT_PURPLE + "*Attacks with the might of a hero*" +color.TEXT_RESET);
    }

}
