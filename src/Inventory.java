import java.util.Scanner;

public class Inventory{
Dialogue dialogue = new Dialogue();
Scanner inventScan = new Scanner(System.in);

String userPick = "";
private int potions;
private int breads;
private int sandwiches;
public Character hero;
public Enemy enemy;


    public Inventory(int sandwiches, int breads, int potions, Character hero, Enemy enemy){
        this.sandwiches = sandwiches;
        this.breads = breads;
        this.potions = potions;
        this.hero = hero;
        this.enemy = enemy;
    }

    public int getBreads() {
        return breads;
    }

    public int getSandwiches() {
        return sandwiches;
    }

    public void minusPotions(int potions) {
        this.potions = this.potions - potions;
    }

    public int getPotions() {
        return potions;
    }

    public void addPotion(int potions){
        this.potions = this.potions + potions;
    }

    public void addBread(int breads){
        this.breads = this.breads + breads;
    }

    public void addSandwiches(int sandwiches){
        this.sandwiches = this.sandwiches + sandwiches;
    }

    public void stock(int item, String name, int healing) throws InterruptedException {
        if(item !=0){
            hero.healing(healing);
            if(name.equals("potion")){
                dialogue.dialogue("Drinks one " +name+":" +ColorText.TEXT_GREEN+ healing+ "HP" +ColorText.TEXT_RESET, 1);
            }else{
                dialogue.dialogue("Ate a " +name+": " +ColorText.TEXT_GREEN+ healing+ "HP" +ColorText.TEXT_RESET, 1);
            }
            minusPotions(1);
            dialogue.cyanDialogue("["+name+" remaining: " + item+ "]", 1);
            hero.showHealth();
        }else{
            dialogue.purpleDialogue("[No more" +name+"...]", 1);
        }
    }

    public void showItems(Battle battle) throws InterruptedException {
        dialogue.blueDialogue("| a: Potions  | s: breads  |  d: sandwich   | b: Back |",0);
        dialogue.dialogue("| | POTION +" + highlight("30HP")+ "| BREAD +" + highlight("80HP")+ "| SANDWICH +" + highlight("50HP")+ " ||", 1);
        userPick = inventScan.nextLine().toLowerCase();
        switch (userPick){
            case "potions":
            case "a":
                stock(this.potions,"Potion",30);
                break;
            case "breads":
            case "s":
                stock(this.breads, "Bread",80);
                break;
            case "sandwich":
            case "d":
                stock(this.sandwiches, "Sandwich",50);
                break;
            case "back":
            case "b":
                battle.heroBattle(enemy);
                break;
            default:
                System.out.println("Cannot do that...Times up. Enemy is coming!");
        }
    }

    public String highlight(String text){
        return ColorText.TEXT_GREEN + text + ColorText.TEXT_RESET;
    }

}
