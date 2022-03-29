import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Shop {
    Scanner scanAmount = new Scanner(System.in);
    Dialogue dialogue = new Dialogue();
    int potions = 5;
    int breads = 3;
    int lightArmour = 1;
    int greatSword = 1;
    int woodenShield = 1;
    int sandwich = 6;
    int campingTent =1;
    int torch = 1;
    boolean stockIsZero = false;
    boolean notBuyItem = false;
    private Enemy enemy;
    public  Character hero;

    public Shop(Character hero){
        //this.enemy = enemy;
        this.hero = hero;
    }

    String[] products = {"p: Potions", "b: Breads", "t: torch", "c: Camping Tent", "s: Sandwich",
            "l: Light Armour", "w: Wooden Shield","g: Great Sword"};
    double[] cost = {15, 5, 20, 65, 9, 90, 30, 95, };

    ArrayList<String> inventory = new ArrayList<>();


    public void inShop(){}

    public void buyingItems(Inventory inGameInventory) throws InterruptedException{

        Scanner scan = new Scanner(System.in);
        dialogue.purpleDialogue("What do fancy today?",0);
        //readFile();
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
                    int isAmount = amount(potions, "potion");
                    if(isAmount != 0){
                        checkingBuyOrNot(isAmount, 15);
                        if(!notBuyItem){
                            potions = itemToInventory("potion", potions, isAmount);
                            displayPurchase(isAmount, potions, "potion");
                            inventory.remove("potion");
                            inGameInventory.addPotion(isAmount);
                            System.out.println(inGameInventory.getPotions() + ": is in pocket");
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
                    int isAmount = amount(breads, "bread");
                    if(isAmount != 0){
                        checkingBuyOrNot(isAmount, 5.6);
                        if(!notBuyItem){
                            breads = itemToInventory("bread", breads, isAmount);
                            displayPurchase(isAmount, breads, "bread");
                           inventory.remove("bread");
                            inGameInventory.addBread(isAmount);
                            System.out.println(inGameInventory.getBreads() + ": is in pocket");
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
                    int isAmount = amount(torch, "torch");
                    if(isAmount != 0){
                        checkingBuyOrNot(isAmount, 9);
                        if(!notBuyItem){
                            torch = itemToInventory("torch", torch, isAmount);
                            displayPurchase(isAmount, torch, "torch");
                            hero.torch = true;
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
                    int isAmount = amount(sandwich, "sandwich");
                    if(isAmount != 0){
                        checkingBuyOrNot(isAmount, 9);
                        if(!notBuyItem){
                            sandwich = itemToInventory("sandwich", sandwich, isAmount);
                            displayPurchase(isAmount, sandwich, "sandwich");
                            inventory.remove("sandwich");
                            inGameInventory.addSandwiches(isAmount);
                            System.out.println(inGameInventory.getSandwiches() + ": is in pocket");
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
                    int isAmount = amount(campingTent, "camping tent");
                    if(isAmount != 0){
                        checkingBuyOrNot(isAmount, 65);
                        if(!notBuyItem){
                            campingTent = itemToInventory("camping tent", campingTent, isAmount);
                            displayPurchase(isAmount, campingTent, "camping tent");
                            hero.campingTent = true;
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
                    int isAmount = amount(lightArmour, "light armour");
                    if(isAmount != 0){
                        checkingBuyOrNot(isAmount, 90);
                        if(!notBuyItem){
                            lightArmour = itemToInventory("light armour", lightArmour, isAmount);
                            displayPurchase(isAmount, lightArmour, "light armour");
                            //equipArmour(enemy);
                            hero.setArmor("Light Armour");
                            inventory.remove("light armour");
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
                    int isAmount = amount(greatSword, "great sword");
                    if(isAmount != 0){
                        checkingBuyOrNot( isAmount, 95);
                        if(!notBuyItem){
                            greatSword = itemToInventory("great sword", greatSword, isAmount);
                            displayPurchase(isAmount, greatSword, "great sword");
                            equipWeapon(); // it was equipWeapon(hero). changed it to try and improve code.
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
                    int isAmount = amount(woodenShield, "wooden shield");
                    if(isAmount != 0){
                        checkingBuyOrNot(isAmount, 30);
                        if(!notBuyItem){
                            woodenShield = itemToInventory( "wooden shield", woodenShield, isAmount);
                            displayPurchase(isAmount, woodenShield, "wooden shield");
                            hero.setShield("Wooden Shield");
                            inventory.remove("wooden shield");
                        }
                        if (woodenShield <= 0) {
                            stockIsZero = true;
                        }
                    }
                }
                break;
            case "f":
                dialogue.dialogue("Thank you for stopping by. Please visit again soon!",1);
                break;
            default:
                dialogue.purpleDialogue("That's not an option.",1);
                break;
        }
            if (!player.equals("f")) {
                dialogue.blueDialogue( "Would you like anything else? |f: exit",3);

            }
        } while (!player.equals("f"));
    }

    public void equipWeapon() throws InterruptedException {
        if(inventory.contains("great sword")){
            hero.heroWeapon = "Great Sword";
            dialogue.dialogue("Take Great Sword from inventory and equip it: +10 damage",1);
            hero.setHeroWeaponStrength(27);
            inventory.remove("great sword");
        }
    }

    public void checkingBuyOrNot(int isAmount, double price) throws InterruptedException {
        double totalPrice = isAmount * price;
        decisionToBuy(totalPrice);
      if(notBuyItem){
          dialogue.dialogue("Oh... you changed your mind...",1);
      }
    }

    public void displayPurchase(int isAmount, int item, String product) throws InterruptedException {
        dialogue.dialogue("+-----------------------+",0);
        dialogue.dialogue("| Item left in stock: " + item + " |",0);
        dialogue.dialogue("+-----------------------+",1);
        dialogue.purpleDialogue("You bought " + isAmount + " " + product,1);
        dialogue.dialogue("You have " + inventory + " in your inventory",1);
    }

    public void decisionToBuy(double totalPrice) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        String displayPrice = String.format("%.2f", totalPrice);
        dialogue.blueDialogue("| a: Pay " + displayPrice + "G | d: Don't pay |",1);
        String decision = scan.nextLine();
        switch (decision) {
            case "a":
            case "pay":
                dialogue.dialogue("In pocket :" + hero.getGold() + "| " + hero.heroName + " has paid " + displayPrice + "G",2);
                System.out.println(ColorText.TEXT_YELLOW + "-" + displayPrice + "G" + ColorText.TEXT_RESET);
                hero.withdrawGold(totalPrice);
                dialogue.dialogue("In pocket :" + hero.getGold(),0);
                notBuyItem = false;
                break;
            case "d":
            case "don't pay":
                notBuyItem = true;
                break;
            default:
                dialogue.dialogue("Sorry that's not an option",2);
                notBuyItem = true;
        }}

    public void isStockZero(int item, String product, double cost) {
        if (item == 0) {
            stockIsZero = true;
            System.out.println("Sorry we do not have anymore...");
        } else {
            System.out.println("A " + product + " is " + cost + "G.");
        }
    }

    public int amount(int item, String product) throws InterruptedException {
        int amount = item;
        if(item != 1){
            dialogue.dialogue("How many would you like?",1);
            while (!scanAmount.hasNextInt()) {
                dialogue.dialogue("That's not a number. Try again!",1);
                scanAmount.next();
            }
            amount = scanAmount.nextInt();

            if (amount > item) {
                dialogue.dialogue("Sorry we don't have that much in stock..." +
                        "\nPlease try again",2);
                dialogue.dialogue(product + " Left: " + item,1);
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

