import java.util.Scanner;

public class Inventory {
    Scanner inventScan = new Scanner(System.in);

    String userPick = "";
    int potions;
    int rocks;


    public Inventory(){
        this.potions = 3;
        this.rocks = 5;
    }

    //TODO: retrieve the arraylist from shop and count how many of the same items are in there. then add that to here.

    public void stock(Character hero){
        Battle battle = new Battle(hero);
        if(potions ==0){
            System.out.println(ColorText.TEXT_PURPLE + "[No more potions...]" + ColorText.TEXT_RESET);
        }else{
            hero.healing(35);
            System.out.println("[Drinks one potion:" +ColorText.TEXT_GREEN+ " 35HP]"+ColorText.TEXT_RESET);
            potions--;
            System.out.println("[Potions remaining: " + potions+ "]");
            battle.showHealth(hero);
        }
    }

    public void showItems(Character hero, Enemy enemy) throws InterruptedException {
        Battle battle = new Battle(hero);
        //TODO: loop this menu
        System.out.println(ColorText.TEXT_CYAN +ColorText.GLASS_BG+ "| p: Potions | r: Rocks | n: Notebook | b: Back |"+ColorText.RESET_BG+ColorText.TEXT_RESET);
        userPick = inventScan.nextLine().toLowerCase();
        switch (userPick){
            case "potions":
            case "p":
                stock(hero);
                break;
            case "rocks":
            case "r":
                System.out.println("Throw a rock. Orc is unaffected");
                break;
            case "notebook":
            case "n":
                System.out.println("No information on this creature.");
                break;
            case "back":
            case "b":
                battle.heroBattle(hero, enemy, battle.shop);
                break;
            default:
                System.out.println("Cannot do that...Times up. Enemy is coming!");
        }
    }

}
