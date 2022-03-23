import java.util.Scanner;

public class Inventory {
    Scanner inventScan = new Scanner(System.in);
    String userPick = "";
    int potions = 0;
    int rocks = 0;
    ColorText color = new ColorText();

    public Inventory(){
        this.potions = 3;
        this.rocks = 5;
    }

    public void stock(Character hero){
        if(potions ==0){
            System.out.println(color.TEXT_PURPLE + "[No more potions...]" + color.TEXT_RESET);
        }else{
            hero.healing(10);
            System.out.println("[Drinks one potion:" +color.TEXT_GREEN+ " 10HP]"+color.TEXT_RESET);
            potions--;
            System.out.println("[Potions remaining: " + potions+ "]");
        }
    }

    public void showItems(Character hero) {
        //TODO: loop this menu
        System.out.println("| p: Potions | r: Rocks | n: Notebook |");
        userPick = inventScan.nextLine().toLowerCase();
        if (userPick.equals("potions") || userPick.equals("p")) {
            stock(hero);
        } else if (userPick.equals("rocks") || userPick.equals("r")) {

            System.out.println("Throw a rock. Orc is unaffected");
        } else if (userPick.equals("notebook") || userPick.equals("n")){

            System.out.println("No information on this creature.");
        }else {
            System.out.println("This is not an option.");
        }
    }
}
