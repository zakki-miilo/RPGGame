import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Shop {
    Scanner scanAmount = new Scanner(System.in);

    int potions = 5;
    int breads = 3;
    int lightArmour = 1;
    int greatSword = 1;
    int woodenShield = 3;
    int sandwich = 6;
    int campingTent =1;
    int torch = 1;
    boolean stockIsZero = false;
    Town town = new Town();
    boolean notBuyItem = false;

    String[] products = {"p: Potions", "b: Breads", "t: torch", "c: Camping Tent", "s: Sandwich",
            "l: Light Armour", "w: Wooden Shield","g: Great Sword"};
    double[] cost = {15, 5, 20, 65, 9, 90, 30, 95, };

    ArrayList<String> inventory = new ArrayList<>();

    public void inShop(){

        }

    public void buyingItems(Character hero, Enemy enemy){
        Scanner scan = new Scanner(System.in);
        System.out.println(ColorText.TEXT_PURPLE + "What do fancy today?" + ColorText.TEXT_RESET);
        String player;
        do{
        int[] stocks = {potions,breads,torch,campingTent,sandwich,lightArmour,woodenShield,greatSword};
        printBox(products,cost,stocks);
        player = scan.nextLine().toLowerCase();
        switch (player){
            case "potion":
            case "a potion":
            case "p":
                isStockZero(potions, "potion", 15);
                if(potions != 0){
                    int isAmount = amount(potions, "potion", hero);
                    if(isAmount != 0){
                        checkingBuyOrNot(hero, isAmount, 15);
                        if(!notBuyItem){
                            potions = itemToInventory("potion", potions, isAmount);
                            displayPurchase(isAmount, potions, "potion");
                        }
                        if (potions <= 0) {
                            stockIsZero = true;
                        }
                    }
                }
                break;
            case "bread":
            case "a bread":
            case "b":
                isStockZero(breads, "bread", 5.6);
                if(breads != 0){
                    int isAmount = amount(breads, "bread", hero);
                    if(isAmount != 0){
                        checkingBuyOrNot(hero, isAmount, 5.6);
                        if(!notBuyItem){
                            breads = itemToInventory("bread", breads, isAmount);
                            displayPurchase(isAmount, breads, "bread");
                        }
                        if (breads <= 0) {
                            stockIsZero = true;
                        }
                    }
                }
                break;
            case "torch":
            case "t":
            case "a torch":
                isStockZero(torch,"torch", 20);
                if(torch != 0){
                    int isAmount = amount(torch, "torch", hero);
                    if(isAmount != 0){
                        checkingBuyOrNot(hero, isAmount, 9);
                        if(!notBuyItem){
                            torch = itemToInventory("torch", torch, isAmount);
                            displayPurchase(isAmount, torch, "torch");
                        }
                        if (torch <= 0) {
                            stockIsZero = true;
                        }
                    }
                }
                break;
            case "sandwich":
            case "s":
            case "a sandwich":
                isStockZero(sandwich,"sandwich", 9);
                if(sandwich != 0){
                    int isAmount = amount(sandwich, "sandwich", hero);
                    if(isAmount != 0){
                        checkingBuyOrNot(hero, isAmount, 9);
                        if(!notBuyItem){
                            sandwich = itemToInventory("sandwich", sandwich, isAmount);
                            displayPurchase(isAmount, sandwich, "sandwich");
                        }
                        if (sandwich <= 0) {
                            stockIsZero = true;
                        }
                    }
                }
                break;
            case "camping tent":
            case "c":
                isStockZero(campingTent, "camping tent", 65);
                if(campingTent != 0){
                    int isAmount = amount(campingTent, "camping tent", hero);
                    if(isAmount != 0){
                        checkingBuyOrNot(hero, isAmount, 65);
                        if(!notBuyItem){
                            campingTent = itemToInventory("camping tent", campingTent, isAmount);
                            displayPurchase(isAmount, campingTent, "camping tent");
                        }
                        if (campingTent <= 0) {
                            stockIsZero = true;
                        }
                    }
                }
                break;
            case "light armour":
            case "l":
                isStockZero(lightArmour, "light armour", 90);
                if(lightArmour != 0){
                    int isAmount = amount(lightArmour, "light armour", hero);
                    if(isAmount != 0){
                        checkingBuyOrNot(hero, isAmount, 90);
                        if(!notBuyItem){
                            lightArmour = itemToInventory("light armour", lightArmour, isAmount);
                            displayPurchase(isAmount, lightArmour, "light armour");
                            equipArmour(enemy);
                        }
                        if (lightArmour <= 0) {
                            stockIsZero = true;
                        }
                    }
                }
                break;
            case "great sword":
            case "g":
                isStockZero(greatSword, "great sword", 95);
                if(greatSword != 0){
                    int isAmount = amount(greatSword, "great sword", hero);
                    if(isAmount != 0){
                        checkingBuyOrNot(hero, isAmount, 95);
                        if(!notBuyItem){
                            greatSword = itemToInventory("great sword", greatSword, isAmount);
                            displayPurchase(isAmount, greatSword, "great sword");
                            equipWeapon(hero);
                        }
                        if (greatSword <= 0) {
                            stockIsZero = true;
                        }
                    }
                }
                break;
            case "wooden shield":
            case "w":
                isStockZero(woodenShield, "wooden shield", 30);
                if(woodenShield != 0){
                    int isAmount = amount(woodenShield, "wooden shield", hero);
                    if(isAmount != 0){
                        checkingBuyOrNot(hero, isAmount, 30);
                        if(!notBuyItem){
                            woodenShield = itemToInventory( "wooden shield", woodenShield, isAmount);
                            displayPurchase(isAmount, woodenShield, "wooden shield");
                        }
                        if (woodenShield <= 0) {
                            stockIsZero = true;
                        }
                    }
                }
                break;
            case "f":
                System.out.println("Thank you for stopping by. Please visit again soon!");
                break;
            default:
                System.out.println(ColorText.TEXT_PURPLE +"That's not an option."+ ColorText.TEXT_RESET);
                break;
        }
            if (!player.equals("f")) {
                System.out.println(ColorText.TEXT_BLUE + "Would you like anything else? |f: exit |" + ColorText.TEXT_RESET);

            }
        } while (!player.equals("f"));
    }

    public void equipArmour(Enemy enemy){
        if(inventory.contains("light armour")){
            enemy.weaponStrengthDecrease(8);
            System.out.println("Take armour from inventory and equip it: + 8 Defence.");
            inventory.remove("light armour");
        }
    }
    public void equipWeapon(Character hero){
        Random rand = new Random();
        if(inventory.contains("great sword")){
            hero.heroWeapon = "Great Sword";
            System.out.println("Take Great Sword from inventory and equip it: +10 damage");
            hero.setHeroWeaponStrength(27);
            inventory.remove("great sword");
        }
    }

    public void checkingBuyOrNot(Character hero, int isAmount, double price){
        double totalPrice = isAmount * price;
        decisionToBuy(hero, totalPrice);
      if(notBuyItem){
          System.out.println("Oh... you changed your mind...");}
    }

    public void displayPurchase(int isAmount, int item, String product){
        System.out.println("+-----------------------+");
        System.out.println("| Item left in stock: " + item + " |");
        System.out.println("+-----------------------+");
        System.out.println(ColorText.TEXT_PURPLE + "You bought " + isAmount + " " + product + ColorText.TEXT_RESET);
        System.out.println("You have " + inventory + " in your inventory");
    }

    public void decisionToBuy(Character hero, double totalPrice) {
        Scanner scan = new Scanner(System.in);
        String displayPrice = String.format("%.2f", totalPrice);
        System.out.println(ColorText.TEXT_BLUE +ColorText.GLASS_BG + "| a: Pay " + displayPrice + "G | d: Don't pay |"+ ColorText.RESET_BG + ColorText.TEXT_RESET);
        String decision = scan.nextLine();
        switch (decision) {
            case "a":
            case "pay":
                System.out.println("In pocket :" + hero.getGold() + "| " + hero.heroName + " has paid " + displayPrice + "G");
                System.out.println(ColorText.TEXT_YELLOW + "-" + displayPrice + "G" + ColorText.TEXT_RESET);
                hero.withdrawGold(totalPrice);
                System.out.println("In pocket :" + hero.getGold());
                notBuyItem = false;
                break;
            case "d":
            case "don't pay":
                notBuyItem = true;
                break;
            default:
                System.out.println("Sorry that's not an option");
        }}

    public void isStockZero(int item, String product, double cost) {
        if (item == 0) {
            stockIsZero = true;
            System.out.println("Sorry we do not have anymore...");
        } else {
            System.out.println("A " + product + " is " + cost + "G.");
        }


    }

    public int amount(int item, String product, Character hero){
        int amount = item;
        if(item != 1){
            System.out.println("How many would you like?");
            while (!scanAmount.hasNextInt()) {
                System.out.println("That's not a number. Try again!");
                scanAmount.next();
            }
            amount = scanAmount.nextInt();

            if (amount > item) {
                System.out.println("Sorry we don't have that much in stock..." +
                        "\nPlease try again");
                System.out.println(product + " Left: " + item);
                amount = 0;
            }
        }
        return amount;

    }

    public int itemToInventory(String product, int item, int amount){
        for (int i = 0; i < amount; i++) {
                inventory.add(product);
                if(item != 0){
                    item--;
                }
            }
        return item;
    }

    public static void printBox(String[] strings, double[] cost, int[] stocks) {
        String line = "+" + fill() + "+";
        System.out.println(line);

        for (int i = 0; i < strings.length;i++) {
            int j = 0;
            double price = 0;

            for(int k = 0; k < stocks[i]; k++){
                j =stocks[i];
            }
            for(int f = 0; f < cost[i]; f++){
                price =cost[i];
            }
            String str1= String.format("|%-16s|%6d|%9.2fG|", strings[i],j,price);
            System.out.println(str1);

        }
        System.out.println(line);
    }

    private static String fill() {
        return String.valueOf('-').repeat(Math.max(0, 34));
    }
}
