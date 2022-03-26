import java.util.Random;
import java.util.Scanner;

public class Battle{
    DiceFate fateBattle = new DiceFate();
    Scanner scanBattle = new Scanner(System.in);
    String hero;


    Orc orc = new Orc();
    Wolf wolf = new Wolf();
    Bandit bandit = new Bandit();
    Random rand = new Random();
    int coin;
    int roll;
    int fate;
    Inventory inventory = new Inventory();
    boolean shield = false;
    int critChance;
    int resetEnemyHP;
    Shop shop = new Shop();

    public Battle(Character hero) {
        this.hero = hero.heroName;
        this.coin = coin();
        this.roll = roll();

    }

    //TODO: tutorial battle
    //TODO: if enemy type is a wolf or beast then fight with no weapons.
    //TODO: create method to check, then change how they fight depending on the type.
    //TODO: final boss. Big ORC King.

    public void battleDeath(Character hero, Enemy enemy) throws InterruptedException {
            battleStart(hero, enemy);
            System.out.println(enemy.weaponType() +": "+ enemy.getWeaponsStrength()); //for testing
            System.out.println(hero.heroWeapon + " : " + hero.getHeroStrength()); //for testing
            coinFlip(coin,hero, enemy);
            coin = 2; //for testing purposes. delete after.
            resetEnemyHP = enemy.getAvgEnemyHealth();
            if (enemy.getAvgEnemyHealth() == 0) {
                enemy.isDead();
                hero.goldReward();
                //Thread.sleep(3000);
            }else {
                while (hero.getHealth() > 0 || enemy.getAvgEnemyHealth() > 0) {
                    System.out.println(enemy.weaponType() +": "+ enemy.getWeaponsStrength()); // for testiing
                    System.out.println(hero.heroWeapon + " : " + hero.getHeroStrength()); // for testing
                    if(coin == 1){ //change back to 1
                        enemyBattle(hero, enemy);
                        if (enemy.getAvgEnemyHealth() == 0) {
                            enemy.isDead();
                            hero.goldReward();
                            break;
                        }else {
                            heroBattle(hero, enemy,shop);
                        }
                    }else {
                        heroBattle(hero, enemy,shop);
                        if(enemy.getAvgEnemyHealth() == 0) {
                            enemy.isDead();
                            hero.goldReward();
                            break;
                        }
                            enemyBattle(hero, enemy);


                    }
                }
            }
        enemy.setEnemyHp(resetEnemyHP);
    }

    private int coin(){
        return coin = rand.nextInt(2);
    }

    private int roll(){
        return roll = rand.nextInt(3);
    }

    private void coinFlip(int coin, Character hero, Enemy enemy) throws InterruptedException {
        if(coin == 1){
            System.out.println("---------------------------");
            System.out.println(ColorText.TEXT_PURPLE + "Hero starts"+ ColorText.TEXT_RESET);

            heroBattle(hero, enemy, shop);
        }else {
            System.out.println("---------------------------");
            System.out.println(ColorText.TEXT_PURPLE + enemy.getEnemyType() +" starts"+ ColorText.TEXT_RESET);

            enemyBattle(hero, enemy);
        }
    }

    public void attackType(Enemy enemy, int coin){
        if(enemy.getEnemyType().equals("Orc")){
           switch (coin) {
               case 0:
                   orc.attack(enemy);
                   break;
               case 1:
                   orc.attack2(enemy);
                   break;
               case 2:
                   orc.attack3(enemy);
                   break;
           }
        }else if(enemy.getEnemyType().equals("Wolf")){
            switch (coin) {
                case 0:
                    wolf.attack(enemy);
                    break;
                case 1:
                    wolf.attack2(enemy);
                    break;
                case 2:
                    wolf.attack3(enemy);
                    break;
            }}
            else if(enemy.getEnemyType().equals("Bandit")){
                switch (coin) {
                    case 0:
                        bandit.attack(enemy);
                        break;
                    case 1:
                        bandit.attack2(enemy);
                        break;
                    case 2:
                        bandit.attack3(enemy);
                        break;
                }
        }

    }

    public void heroBattle(Character hero, Enemy enemy, Shop shop) throws InterruptedException {
        fate = fateBattle.randomDice();
            System.out.println("__________________________");
            System.out.println("What do you do?");
            System.out.println(ColorText.TEXT_CYAN +ColorText.GLASS_BG+ " a: Attack | d: Defend | i: Inventory "+ColorText.RESET_BG+ColorText.TEXT_RESET);
            String reply = scanBattle.nextLine().toLowerCase();

            switch (reply){
                case "inventory":
                case "i":
                    inventory.showItems(hero ,enemy);
                    //putting whatever in here will be looped if you go back and forward in the menu while play.
                    //but putting nothing here works for some reason
                    break;
                case "attack":
                case "a":
                    if (fate <= 2) { //testing purposes. Change back to 2
                        heroMissedAtt(hero);
                        //Thread.sleep(2000);
                    } else {
                        heroAttacks();
                        //Thread.sleep(3000);
                        System.out.println("---------------------------");
                        successHitEnemy(hero, enemy);
                        //Thread.sleep(3000);
                        showEnemyHp(enemy);
                        //Thread.sleep(3000);
                        break;
                    }
                    break;
                case "defend":
                case "d":
                    System.out.println(ColorText.TEXT_PURPLE+ "*In a defense stand. Ready to block*"+ColorText.TEXT_RESET);
                    //Thread.sleep(3000);
                    shield = true;
                    break;
                default:
                    System.out.println("Cannot do that...Times up. Enemy is coming!");
            }

        }

    private void enemyBattle(Character hero, Enemy enemy) throws InterruptedException {
        int roll = roll();
        fate = fateBattle.randomDice();
            if (fate <= 1) {
                enemyMissed(enemy);
                //Thread.sleep(2000);
            }else if(fate == 2){
                idling(enemy);
            }else{
                if (shield) {
                    int normalStrength = enemy.getWeaponsStrength();
                    int percentage = (normalStrength/4);
                    System.out.println("Enemy strength: " + normalStrength);
                    System.out.println("enemy 4 of strength: " + percentage);
                    enemy.setWeaponsStrength(percentage);
                    System.out.println("---------------------------");
                    attackType(enemy, roll);
                    //System.out.println(enemy.getEnemyType() + "do something"+ enemy.getAvgEnemyWeapon() + " at you");
                    //Thread.sleep(2000);
                    hero.setHealth(enemy.getWeaponsStrength());
                    System.out.println("__________________________");
                    System.out.println(ColorText.TEXT_RED +"*Attack does a small amount of damage -" + percentage+ColorText.TEXT_RESET);
                    //Thread.sleep(2000);
                    System.out.println("---------------------------");
                    showHealth(hero);
                    //Thread.sleep(2000);

                    if (hero.getHealth() == 0) {
                        hero.gameOver();
                    }
                    shield = false;
                    enemy.setWeaponsStrength(normalStrength);
                }else {
                    //Thread.sleep(3000);
                    System.out.println("---------------------------");
                    attackType(enemy,roll);
                    //System.out.println(enemy.getEnemyType()+ " swing his " + enemy.getAvgEnemyWeapon() + " at you");
                    //Thread.sleep(3000);
                    System.out.println("__________________________");
                    successHitHero(hero,enemy);
                    //Thread.sleep(3000);
                    System.out.println("---------------------------");
                    showHealth(hero);
                    //Thread.sleep(3000);

                    if (hero.getHealth() == 0) {
                        hero.gameOver();
                    }
                }
            }
    }

    private void battleStart(Character hero,Enemy enemy) throws InterruptedException {
        System.out.println(ColorText.TEXT_RED +ColorText.GLASS_BG+" »-(¯`·.·´¯)->BATTLE Begins" +
                "<-(¯`·.·´¯)-«   \n"+ColorText.RESET_BG+ColorText.TEXT_RESET);
        //Thread.sleep(4000);
        showHealth(hero);
        System.out.println("*You pull out a " + hero.heroWeapon + "*");
        //Thread.sleep(3000);
        showEnemyHp(enemy);
        idling(enemy);

    }

    private void idling(Enemy enemy){
        switch (enemy.getEnemyType()){
            case "Orc":
                orc.idle();
                break;
            case "Wolf":
                wolf.idle();
                break;
        }
    }

    public void showHealth(Character hero){
        System.out.println(ColorText.TEXT_BLUE + ColorText.GLASS_BG +"|| " + hero.heroName + " | HP: " + hero.getHealth() + " ||"+ ColorText.RESET_BG + ColorText.TEXT_RESET);
    }

    private void showEnemyHp(Enemy enemy){
        System.out.println(ColorText.TEXT_GREEN +ColorText.GLASS_BG + "|| " + enemy.getEnemyType()+ " | HP: "  +  enemy.getAvgEnemyHealth()+ " ||" + ColorText.RESET_BG+  ColorText.TEXT_RESET);

    }



    private void successHitEnemy(Character hero, Enemy enemy){
        critChance = rand.nextInt(15)+2; //15 and + 2. change back
        System.out.println("Critical attack +" + critChance);
        enemy.setDamagedTaken(hero.getHeroStrength()+critChance);
        int totalHit = hero.getHeroStrength()+critChance;
        System.out.println(ColorText.TEXT_BLUE +"HIT! The "+ enemy.getEnemyType() +" has taken damaged -" + totalHit + " HP"+ ColorText.TEXT_RESET);
        System.out.println("__________________________");
    }

    private void enemyMissed(Enemy enemy){
        System.out.println("__________________________");
        System.out.println(ColorText.TEXT_PURPLE + enemy.getEnemyType() +" Attacks and misses!"+ColorText.TEXT_RESET);
    }

    private void successHitHero(Character hero, Enemy enemy){
        critChance = rand.nextInt(10)+2;
        System.out.println("Critical attack +" + critChance);
        hero.setHealth(enemy.getWeaponsStrength()+critChance);
        int totalHit = enemy.getWeaponsStrength()+critChance;
        System.out.println(ColorText.TEXT_RED + "You have been HIT! -" + totalHit + " HP"+ ColorText.TEXT_RESET);
    }

    private void heroMissedAtt(Character hero){
        System.out.println(ColorText.TEXT_CYAN + hero.heroName + "'s ATTACK missed!"+ ColorText.TEXT_RESET);
    }

    private void heroAttacks(){
        System.out.println(ColorText.TEXT_PURPLE + "*Attacks with the might of a hero*" +ColorText.TEXT_RESET);
    }

}
