import java.util.Random;

public class Character{
    private int health = 100;
    private int gold = 0;
    String heroName;
    String heroWeapon = "Broadsword";
    private int heroStrength;
    Random rand = new Random();

    public Character(String hero){
        this.heroName = hero;
        this.heroStrength = strength();
    }

    public String getHeroName() {
        return heroName;
    }

    public int getGold() {
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
    private int strength(){
        return this.heroStrength = rand.nextInt(25);
    }


    public int getHeroStrength() {
        return heroStrength;
    }

    public void setGold(int gold) {
        this.gold += gold;
    }
    public void withdrawGold(int gold){
        this.gold -= gold;
    }

    public void gameOver(){
            System.out.println(ColorText.TEXT_PURPLE + "| Game Over! You died |"+ ColorText.TEXT_RESET);
            System.exit(0);
    }

    public void goldInPocket(){
        System.out.println(ColorText.TEXT_YELLOW+"[ GOLD in Pocket: "+this.gold+" ]"+ColorText.TEXT_RESET);
    }


}
