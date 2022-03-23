import java.util.Random;

public class Character{
    private int health = 100;
    private int gold = 0;
    String heroName = "";
    String heroWeapon = "Broadsword";
    private int heroStrength = 0;
    ColorText color = new ColorText();
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
        if(this.health >= 50){
            this.health = 50;
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

    public void gameOver(){
            System.out.println(color.TEXT_PURPLE + "| Game Over! You died |"+ color.TEXT_RESET);
            System.exit(0);
    }

    public void goldInPocket(){
        System.out.println(color.TEXT_YELLOW+"[ GOLD in Pocket: "+this.gold+" ]"+color.TEXT_RESET);
    }


}
