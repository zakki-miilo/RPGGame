import java.util.Random;

public class Enemy{
    private int enemyHp;
    private String avgEnemyWeapon;
    private int weaponsStrength;
    private String name = "";
    private String enemyType;
    ColorText color = new ColorText();

    Random rand = new Random();

    public Enemy(){
        this.enemyHp = avgEnemyHealthRandom();
        this.avgEnemyWeapon = avgWeapon();
        this.weaponsStrength = weaponStrength();
        this.enemyType = "Orc";

    }

    public String getEnemyType() {
        return enemyType;
    }

    public int getWeaponsStrength() {
        return weaponsStrength;
    }

    public void setWeaponsStrength(int weaponsStrength) {
        this.weaponsStrength = weaponsStrength;
    }

    public String getAvgEnemyWeapon() {
        return avgEnemyWeapon;
    }

    public int getAvgEnemyHealth() {
        return enemyHp;
    }

    public void setAvgEnemyHealth(int heroDamage) {
        this.enemyHp = this.enemyHp - heroDamage;
        if(this.enemyHp < 0){
            this.enemyHp = 0;
        }
    }

    private int avgEnemyHealthRandom(){
        return enemyHp = rand.nextInt(60)+30;
    }

    private String avgWeapon(){
        String[] weapons = {"Stick", "Short Sword", "Long Sword", "Club", "Axe"};

        avgEnemyWeapon = weapons[rand.nextInt(weapons.length)];

        return avgEnemyWeapon;
    }

    private int weaponStrength(){
        switch (avgEnemyWeapon){
            case "Stick":
                weaponsStrength = 15;
                break;
            case "Short Sword":
                weaponsStrength = 20;
                break;
            case "Long Sword":
                weaponsStrength = 25;
                break;
            case "Club":
                weaponsStrength = 28;
                break;
            case "Axe":
                weaponsStrength = 23;
                break;
        }
        return weaponsStrength;
    }

    public void isDead(){
        System.out.println(color.TEXT_RED + "______________"+ color.TEXT_RESET);
        System.out.println(color.TEXT_RED + "|Orc is Dead!|"+ color.TEXT_RESET+ " ~Loot " + getEnemyType());
        System.out.println(color.TEXT_RED + "--------------"+ color.TEXT_RESET);

    }

    @Override
    public String toString() {
        return "Enemy: " + this.name + "\n"+
                "|Health : " + enemyHp +
                "| Weapon: " + avgEnemyWeapon +
                "| Weapon's Strength: " + weaponsStrength ;
    }
}
