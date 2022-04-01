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
    //Shop shop = new Shop();
    public Shop shop;
    public Character hero;
    public Enemy enemy;
    public Inventory inventory;
    Dialogue dialogue = new Dialogue();
    boolean leatherArmour = false;
    boolean kingsArmour = false;
    boolean lightArmour = false;
    boolean woodenShield = false;

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
                leatherArmour = true;
                lightArmour = false;
                break;
            case "Excalibur":
                hero.setArmor("King's Armour");
                kingsArmour = true;
                lightArmour = false;
                break;
        }
    }

    public void checkShield(){
        if(Objects.equals(hero.getShield(), "Wooden Shield")){
            hero.setShieldStrength(5);
            woodenShield = true;
        }
    }

    public void equipArmour(){
        if(hero.getArmor().equals("Light Armour")){
            lightArmour = true;
        }
    }


    public void battleDeath(Enemy enemy) throws InterruptedException {
        checkEquipment();
        equipArmour();
        checkShield();
        battleStart(enemy);
        coinFlip(coin, enemy);
        //dialogue.dialogue("Enemy weapon: " + enemy.weaponType(), 1);
        //dialogue.dialogue("Enemy weapon strength: " + enemy.getWeaponsStrength(), 1);
        int resetEnemyHP = enemy.getAvgEnemyHealth();

            if (enemy.getAvgEnemyHealth() <= 0) {
                enemy.isDead();
                hero.goldReward(5);
            }else {
                while (hero.getHealth() >= 0 || enemy.getAvgEnemyHealth() >= 0) {

                    if(coin == 1){ //change back to 1
                        enemyBattle(enemy);
                        if (enemy.getAvgEnemyHealth() <= 0) {
                            enemy.isDead();
                            hero.goldReward(5);
                            break;
                        }else {
                            heroBattle(enemy);
                        }
                    }else {
                        heroBattle(enemy);
                        if(enemy.getAvgEnemyHealth() <= 0) {
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
            dialogue.dialogue("---------------------------",1);
            dialogue.purpleDialogue( "Hero starts",1);

            heroBattle(enemy);
        }else {
            dialogue.dialogue("---------------------------",1);
            dialogue.purpleDialogue(enemy.getEnemyType() +" starts",1);

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
        dialogue.dialogue("__________________________",1);
            dialogue.dialogue("What do you do?", 1);
            dialogue.blueDialogue( "| a: Attack | s: Defend | d: Inventory |",1);
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
                    } else {
                        heroAttacks();
                        System.out.println("---------------------------");
                        successHitEnemy(enemy);
                        showEnemyHp(enemy);
                        break;
                    }
                    break;
                case "defend":
                case "s":
                    dialogue.purpleDialogue( "In a defense stand. Ready to block"+ColorText.TEXT_RESET, 1);
                    shield = true;
                    break;
                default:
                    dialogue.cyanDialogue("Cannot do that...Times up. Enemy is coming!",1);
            }

        }

    private void enemyBattle(Enemy enemy) throws InterruptedException {
        int roll = roll();
        fate = fateBattle.randomDice();
            if (fate == 1) {
                enemyMissed(enemy);
            }else if(fate == 2){
                dialogue.dialogue("------------------", 1);
                idling(enemy);
            }else{
                if (shield) {
                    int normalStrength = enemy.getWeaponsStrength();
                    int percentage = (normalStrength/4);
                    dialogue.dialogue("Enemy strength: " + normalStrength,1);
                    dialogue.dialogue("enemy 4 of strength: " + percentage,1);
                    enemy.setWeaponsStrength(percentage);
                    System.out.println("---------------------------");
                    attackType(enemy, roll);
                    hero.damageHealth(enemy.getWeaponsStrength());
                    System.out.println("__________________________");
                    dialogue.redDialogue("*Attack does a small amount of damage -" + percentage+ColorText.TEXT_RESET, 1);
                    System.out.println("---------------------------");
                    hero.showHealth();

                    if (hero.getHealth() == 0) {
                        hero.gameOver();
                    }
                    shield = false;
                    enemy.setWeaponsStrength(normalStrength);
                }else {
                    checkShield();
                    dialogue.dialogue("---------------------------", 1);
                    attackType(enemy,roll);
                    dialogue.dialogue("---------------------------", 1);
                    successHitHero(enemy);
                    dialogue.dialogue("---------------------------", 1);
                    hero.showHealth();
                    if (hero.getHealth() == 0) {
                        hero.gameOver();
                    }
                }
            }
    }

    private void battleStart(Enemy enemy) throws InterruptedException {
        dialogue.redGlassDialogue("»-(¯`·.·´¯)->BATTLE Begins<-(¯`·.·´¯)-«", 2);
        dialogue.dialogue(" ", 1);
        hero.showHealth();
        dialogue.dialogue(hero.heroName + " pulls out the " + hero.heroWeapon, 1);
        if(woodenShield){
            dialogue.dialogue("Wooden Shield is equipped. +5 Shield.", 1);
        }
        if(lightArmour){
            dialogue.dialogue("LIGHT armour is equipped + 7 DEF.", 1);
        }else if(leatherArmour){
            dialogue.dialogue("Leather armour is equipped + 10 DEF", 1);
        }else if(kingsArmour){
            dialogue.dialogue("King's armour is equipped + 20 DEF", 1);
        }

        showEnemyHp(enemy);
        if(Objects.equals(enemy.getEnemyType(), "Wolf")){
            dialogue.dialogue(enemy.getEnemyType()+ " is growing loudly at you!", 1);
        }else{
            dialogue.dialogue(enemy.getEnemyType()+ " holds a " + enemy.weaponType(), 1);

        }
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

    private void successHitEnemy(Enemy enemy) throws InterruptedException {
        critChance = rand.nextInt(15)+2; //15 and + 2. change back
        dialogue.dialogue("Critical attack +" + critChance, 1);
        enemy.setDamagedTaken(hero.getHeroStrength()+critChance);
        int totalHit = hero.getHeroStrength()+critChance;
        dialogue.redGlassDialogue(" | HIT! The "+ enemy.getEnemyType() +" has taken damaged -" + totalHit + " HP | ",1);
        dialogue.dialogue("__________________________",1);
    }

    private void enemyMissed(Enemy enemy) throws InterruptedException {
        dialogue.dialogue("__________________________", 1);
        dialogue.purpleDialogue( enemy.getEnemyType() +" Attacks and misses!", 1);
    }

    private void successHitHero(Enemy enemy) throws InterruptedException {
        int damage;
        critChance = rand.nextInt(20-7)+7;


        if(hero.getShieldStrength() != 0){
            //dialogue.dialogue("Hit Shield: -8 ATK",1);
            damage = (enemy.getWeaponsStrength()+critChance) - hero.getShieldStrength();
        }else {
            //dialogue.dialogue("No shield",1);//test
            damage = enemy.getWeaponsStrength() + critChance;
        }
        if(lightArmour){
            damage -= 7;
        }else if(kingsArmour){
            damage -= 20;
        }else if(leatherArmour){
            damage -= 10;
        }
        if(damage <= 0){
            damage = 0;
            critChance = 0;
            dialogue.dialogue("Attack has no affect!", 1);
        }
        dialogue.dialogue("Critical attack +" + critChance,1);
        hero.damageHealth(damage);


        dialogue.redGlassDialogue(" | You have been HIT! -" + damage + " HP | ",1);
    }

    private void heroMissedAtt() throws InterruptedException {
        dialogue.cyanDialogue( hero.heroName + "'s ATTACK missed!",1);
    }

    private void heroAttacks() throws InterruptedException {
        dialogue.purpleDialogue("Attacks with the might of a hero",1);
    }

}
