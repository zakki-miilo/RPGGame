import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Battle{
    DiceFate fateBattle = new DiceFate();
    Scanner scanBattle = new Scanner(System.in);
    Orc orc = new Orc();
    Wolf wolf = new Wolf();
    Bandit bandit = new Bandit();
    Random rand = new Random();
    private int coin;
    private int roll;
    private int fate;
    boolean shield = false;
    private int critChance;
    private int resetEnemyHP;
    //Shop shop = new Shop();
    public Shop shop;
    public Character hero;
    public Enemy enemy;
    public Inventory inventory;
    Dialogue dialogue = new Dialogue();

    public Battle(Character hero, Shop shop, Inventory inventory, Enemy enemy) {
        this.hero = hero;
        this.coin = coin();
        this.roll = roll();
        this.shop = shop;
        this.inventory = inventory;
        this.enemy = enemy;
    }

    public void checkEquipment(){
        switch (hero.heroWeapon){
            case "Claymore Sword":
                hero.setArmor("Leather Armour");
                hero.healing(10);
                System.out.println("leather armour is equipped +10 defense");
                break;
            case "Excalibur":
                hero.setArmor("King's Armour");
                hero.healing(22);
                System.out.println("King's armour is equipped +22 defense");
                break;
        }
    }

    public void checkShield(){
        if(Objects.equals(hero.getShield(), "Wooden Shield")){
            hero.setShieldStrength(6);
            System.out.println("Shield is on. +10 Shield in applied every turn.");
        }
    }

    public void equipArmour(){
        if(hero.getArmor().equals("Light Armour")){
            hero.healing(8);
            System.out.println("Take armour from inventory and equip it: + 8 Defense.");
            System.out.println("You have Light armour on: +8 defense");
        }
    }


    public void battleDeath(Enemy enemy) throws InterruptedException {
        battleStart(enemy);
            coinFlip(coin, enemy);

            resetEnemyHP = enemy.getAvgEnemyHealth();

            if (enemy.getAvgEnemyHealth() == 0) {
                enemy.isDead();
                hero.goldReward(5);
                //Thread.sleep(3000);
            }else {
                while (hero.getHealth() > 0 || enemy.getAvgEnemyHealth() > 0) {

                    if(coin == 1){ //change back to 1
                        enemyBattle(enemy);
                        if (enemy.getAvgEnemyHealth() == 0) {
                            enemy.isDead();
                            hero.goldReward(5);
                            break;
                        }else {
                            heroBattle(enemy);
                        }
                    }else {
                        heroBattle(enemy);
                        if(enemy.getAvgEnemyHealth() == 0) {
                            enemy.isDead();
                            hero.goldReward(5);
                            break;
                        }
                            enemyBattle(enemy);


                    }
                }
            }
        enemy.setEnemyHp(resetEnemyHP);
    }

    private int coin(){
        return coin = rand.nextInt(2);
        //return 1; //TODO for testing, change back to random.
    }

    private int roll(){
        return roll = rand.nextInt(3);
    }

    private void coinFlip(int coin, Enemy enemy) throws InterruptedException {
        if(coin == 1){
            System.out.println("---------------------------");
            System.out.println(ColorText.TEXT_PURPLE + "Hero starts"+ ColorText.TEXT_RESET);

            heroBattle(enemy);
        }else {
            System.out.println("---------------------------");
            System.out.println(ColorText.TEXT_PURPLE + enemy.getEnemyType() +" starts"+ ColorText.TEXT_RESET);

            enemyBattle(enemy);
        }
    }

    public void attackType(Enemy enemy, int coin){
        switch (enemy.getEnemyType()){
            case "orc":
            case "fatOrc":
            case "Orc":
            case "Death-Eye, King of the ORC":
            case "Warrior Orc":
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
               break;
            case "Wolf":
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
                    }
                break;
            case "Bandit":
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
                break;
            }
    }

    public void heroBattle(Enemy enemy) throws InterruptedException {
        fate = fateBattle.randomDice();
            System.out.println("__________________________");
            System.out.println("What do you do?");
            System.out.println(ColorText.TEXT_CYAN +ColorText.GLASS_BG+ " a: Attack | s: Defend | d: Inventory "+ColorText.RESET_BG+ColorText.TEXT_RESET);
            String reply = scanBattle.nextLine().toLowerCase();

            switch (reply){
                case "inventory":
                case "d":
                    inventory.showItems(Battle.this);
                    //putting whatever in here will be looped if you go back and forward in the menu while play.
                    //but putting nothing here works for some reason
                    break;
                case "attack":
                case "a":
                    if (fate <= 2) { //testing purposes. Change back to 2
                        heroMissedAtt();
                        //Thread.sleep(2000);
                    } else {
                        heroAttacks();
                        //Thread.sleep(3000);
                        System.out.println("---------------------------");
                        successHitEnemy(enemy);
                        //Thread.sleep(3000);
                        showEnemyHp(enemy);
                        //Thread.sleep(3000);
                        break;
                    }
                    break;
                case "defend":
                case "s":
                    System.out.println(ColorText.TEXT_PURPLE+ "*In a defense stand. Ready to block*"+ColorText.TEXT_RESET);
                    //Thread.sleep(3000);
                    shield = true;
                    break;
                default:
                    System.out.println("Cannot do that...Times up. Enemy is coming!");
            }

        }

    private void enemyBattle(Enemy enemy) throws InterruptedException {
        int roll = roll();
        fate = fateBattle.randomDice();
            if (fate == 1) {
                enemyMissed(enemy);
                //Thread.sleep(2000);
            }else if(fate == 2){
                dialogue.dialogue("------------------", 1);
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
                    hero.damageHealth(enemy.getWeaponsStrength());
                    System.out.println("__________________________");
                    System.out.println(ColorText.TEXT_RED +"*Attack does a small amount of damage -" + percentage+ColorText.TEXT_RESET);
                    //Thread.sleep(2000);
                    System.out.println("---------------------------");
                    hero.showHealth();
                    //Thread.sleep(2000);

                    if (hero.getHealth() == 0) {
                        hero.gameOver();
                    }
                    shield = false;
                    enemy.setWeaponsStrength(normalStrength);
                }else {
                    checkShield();
                    //Thread.sleep(3000);
                    System.out.println("---------------------------");
                    attackType(enemy,roll);
                    //Thread.sleep(3000);
                    System.out.println("__________________________");
                    successHitHero(enemy);
                    //Thread.sleep(3000);
                    System.out.println("---------------------------");
                    hero.showHealth();
                    //Thread.sleep(3000);

                    if (hero.getHealth() == 0) {
                        hero.gameOver();
                    }
                }
            }
    }

    private void battleStart(Enemy enemy) throws InterruptedException {
        System.out.println(ColorText.TEXT_RED +ColorText.GLASS_BG+" »-(¯`·.·´¯)->BATTLE Begins" +
                "<-(¯`·.·´¯)-«   \n"+ColorText.RESET_BG+ColorText.TEXT_RESET);
        //Thread.sleep(4000);
        hero.showHealth();
        System.out.println("*You pull out the " + hero.heroWeapon + "*");
        //Thread.sleep(3000);
        showEnemyHp(enemy);
        idling(enemy);

    }

    private void idling(Enemy enemy){
        switch (enemy.getEnemyType()){
            case "Orc":
            case "Warrior Orc":
            case "fatOrc":
            case "Death-Eye, King of the ORC":
                orc.idle();
                break;
            case "Wolf":
                wolf.idle();
                break;
            case "Bandit":
                bandit.idle();
                break;
        }
    }


    private void showEnemyHp(Enemy enemy){
        System.out.println(ColorText.TEXT_GREEN +ColorText.GLASS_BG + "|| " + enemy.getEnemyType()+ " | HP: "  +  enemy.getAvgEnemyHealth()+ " ||" + ColorText.RESET_BG+  ColorText.TEXT_RESET);
    }

    private void successHitEnemy(Enemy enemy){
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

    private void successHitHero(Enemy enemy){
        int totalHit;
        critChance = rand.nextInt(10)+2;
        System.out.println("Critical attack +" + critChance);
        hero.damageHealth(enemy.getWeaponsStrength()+critChance);
        checkEquipment();
        equipArmour();
        if(hero.getShieldStrength() != 0){
            System.out.println("Hit Shield: - 10 Attack");
            totalHit = (enemy.getWeaponsStrength()+critChance) - hero.getShieldStrength();
        }else {
            System.out.println("No shield");//test
            totalHit = enemy.getWeaponsStrength()+critChance;
        }
        System.out.println(ColorText.TEXT_RED + "You have been HIT! -" + totalHit + " HP"+ ColorText.TEXT_RESET);
    }

    private void heroMissedAtt(){
        System.out.println(ColorText.TEXT_CYAN + hero.heroName + "'s ATTACK missed!"+ ColorText.TEXT_RESET);
    }

    private void heroAttacks(){
        System.out.println(ColorText.TEXT_PURPLE + "*Attacks with the might of a hero*" +ColorText.TEXT_RESET);
    }

}
