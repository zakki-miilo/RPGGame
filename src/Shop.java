import java.util.ArrayList;

public class Shop {

    private int potions = 10;
    private int breads = 5;
    private int greatSword = 2;
    private int busterSword = 1;
    private int woodenShield = 3;
    private int bronzeShield = 1;
    private int sandwich = 7;
    private int campingTent =1;
    private int torch = 1;

    public Shop(){
        ColorText color = new ColorText();
    }

    public void inShop(){
        String[] inventory = {"Potions", "Breads", "torch", "Camping Tent", "Sandwich", "bronze Shield", "Wooden Shield","Great Sword",
                "Buster Sword"};
        double[] cost = {15, 5.6, 20, 65, 9, 90, 30.6, 95.8, 150.5};
        printBox(inventory,cost);

        }

    public static void printBox(String[] strings, double[] cost) {
        int maxBoxWidth = getMaxLength(strings);
        int[] stocks = {10,5,1,1,7,1,3,2,1};
        String line = "+" + fill('-', maxBoxWidth + 15) + "+";
        System.out.println(line);


        for (int i = 0; i < strings.length;i++) {
            int j = 0;
            double price = 0;
            for(int k = 0; k < stocks[i]; k++){
                j =stocks[i];
            }
            for(int f = 0; f < stocks[i]; f++){
                price =cost[i];
            }
            System.out.printf("| %s |"+ j +"| "+ price+ " G |%n", padString(strings[i],j,price, maxBoxWidth));

        }
        System.out.println(line);
    }

    private static int getMaxLength(String... strings) {
        int len = Integer.MIN_VALUE;
        for (String str : strings) {
            len = Math.max(str.length(), len);
        }
        return len;
    }/*
    private static String padString(String str, int len) {
        StringBuilder sb = new StringBuilder(str);
        return sb.append(fill(' ', len - str.length())).toString();
    }*/
    private static String padString(String str, int j, double price, int len) {
        StringBuilder sb = new StringBuilder(str);
        return sb.append(fill(' ', len - str.length())).toString();
    }

    private static String fill(char ch, int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
