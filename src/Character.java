import java.util.Random;

public class Character{
    private int health = 100;
    private double gold = 0.0;
    String heroName;
    String heroWeapon = "";
    private int heroWeaponStrength;
    Random rand = new Random();




    public Character(String hero){
        this.heroName = hero;
        this.heroWeapon = "Broadsword";
        this.heroWeaponStrength = heroWeaponStrength();
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

    public void setHealth(int damage) {
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
        int gold = rand.nextInt(20)+5;
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
