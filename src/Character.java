import java.util.Random;

public class Character{
    private int health = 100;
    private double gold = 0.0;
    String heroName;
    String heroWeapon = "";
    private int heroWeaponStrength;
    Random rand = new Random();
    String armor = "";
    String shield = "";
    private int shieldStrength = 0;
    boolean campingTent;
    boolean torch;
    Dialogue dialogue = new Dialogue();

public Character(){}


    public Character(String hero){
        this.heroName = hero;
        this.heroWeapon = "Broadsword";
        this.heroWeaponStrength = heroWeaponStrength();
        this.armor = "Light Clothing";
        this.campingTent = false;
        this.torch = false;
    }



    public int getShieldStrength() {
        return shieldStrength;
    }

    public void setShieldStrength(int shieldStrength) {
        this.shieldStrength = this.shieldStrength + shieldStrength;
    }

    public String getShield() {
        return shield;
    }

    public void setShield(String shield) {
        this.shield = shield;
    }

    public String getArmor() {
        return armor;
    }

    public void setArmor(String armor) {
        this.armor = armor;
    }

    public String getHeroName() {
        return heroName;
    }

    public double getGold() {
        return gold;
    }

    public int getHealth() {
        return health;
    }

    public void showHealth() throws InterruptedException {
        dialogue.greenGlassDialogue("|| " + heroName + " | HP: " + health + " ||", 1);
    }

    public void damageHealth(int damage) {
        this.health = this.health - damage;
        if(this.health < 0){
            this.health = 0;
        }
    }

    public void healing(int potion){
        this.health += potion;
        if(this.health >= 100){
            this.health = 100;
        }
    }
    private int heroWeaponStrength(){
        return heroWeaponStrength = 18;
    }

    public void setHeroWeaponStrength(int heroWeaponStrength) {
        this.heroWeaponStrength = heroWeaponStrength;
    }

    public int getHeroStrength() {
        return heroWeaponStrength;
    }

    public void setGold(int gold) {
        this.gold += gold;
    }
    public void withdrawGold(double gold){
        this.gold -= gold;
    }
    public void goldReward(int reward){
        int gold = rand.nextInt(40-15)+15;
        gold = gold + reward;
        this.setGold(gold);
        System.out.println(ColorText.TEXT_YELLOW + "| +"+ gold +"G |" + ColorText.TEXT_RESET);
    }

    public void gameOver(){
            System.out.println(ColorText.TEXT_PURPLE + "| Game Over! You died |"+ ColorText.TEXT_RESET);
            System.exit(0);
    }

    public void goldInPocket(){
        System.out.println(ColorText.TEXT_YELLOW+"[ GOLD in Pocket: "+this.gold+" ]"+ColorText.TEXT_RESET);
    }


}
