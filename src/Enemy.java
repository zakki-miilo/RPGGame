import java.util.Random;

public class Enemy{
    private int enemyHp;
    private String weaponType;
    private int weaponsStrength;
    private final String enemyType;
    Random rand = new Random();

    public Enemy(String type){
        this.enemyHp = avgEnemyHealthRandom();
        this.weaponType = weapon();
        this.weaponsStrength = weaponStrength();
        this.enemyType = type;

    }
/*
    private String types(){
        String[] types = {"WEAK ORC", "WARRIOR ORC", "WOLF", "BANDIT"};
        int enemyType = rand.nextInt(3);
        String t = types[enemyType];
        return t;
    }*/

    public String getEnemyType() {
        return enemyType;
    }

    public int getWeaponsStrength() {
        return weaponsStrength;
    }

    public void setWeaponsStrength(int weaponsStrength) {
        this.weaponsStrength = weaponsStrength;
    }

    public void weaponStrengthDecrease(int armour){
        this.weaponsStrength -= armour;
    }

    public String weaponType() {
        return weaponType;
    }

    public int getAvgEnemyHealth() {
        return enemyHp;
    }

    public void setEnemyHp(int enemyHp) {
        this.enemyHp = enemyHp;
    }

    public void setDamagedTaken(int heroDamage) {
        this.enemyHp = this.enemyHp - heroDamage;
        if(this.enemyHp < 0){
            this.enemyHp = 0;
        }
    }

    private int avgEnemyHealthRandom(){
        return enemyHp = rand.nextInt(70-45)+45;
    }

    private String weapon(){
        String[] weapons = {"Stick", "Short Sword", "Long Sword", "Club", "Axe"};

        weaponType = weapons[rand.nextInt(weapons.length)];

        return weaponType;
    }

    private int weaponStrength(){
        switch (weaponType){
            case "Stick":
                weaponsStrength = 17;
                break;
            case "Short Sword":
                weaponsStrength = 18;
                break;
            case "Long Sword":
                weaponsStrength = 24;
                break;
            case "Club":
                weaponsStrength = 26;
                break;
            case "Axe":
                weaponsStrength = 25;
                break;
        }
        return weaponsStrength;
    }

    public void isDead(){
        System.out.println(ColorText.TEXT_RED + "______________"+ ColorText.TEXT_RESET);
        System.out.println(ColorText.TEXT_RED + "|" + enemyType + " is Dead!|"+ ColorText.TEXT_RESET+ " ~Loot " + getEnemyType());
        System.out.println(ColorText.TEXT_RED + "--------------"+ ColorText.TEXT_RESET);

    }

}
