public class Shop {

    private final int  potions = 10;
    private final int breads = 5;
    private final int greatSword = 2;
    private final int busterSword = 1;
    private final int woodenShield = 3;
    private final int bronzeShield = 1;
    private final int sandwich = 7;
    private final int campingTent =1;
    private final int torch = 1;

    public void inShop(){
        String[] inventory = {"Potions", "Breads", "torch", "Camping Tent", "Sandwich", "Light Armour", "Wooden Shield","Great Sword",
                "Knife"};
        double[] cost = {15, 5.6, 20, 65, 9, 90, 30.6, 95.8, 15.5};
        int[] stocks = {10,5,1,1,7,1,3,2,1};
        printBox(inventory,cost,stocks);

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
            String str1= String.format("|%-15s|%5d|%8.2fG|", strings[i],j,price);
            System.out.println(str1);

        }
        System.out.println(line);
    }

    private static String fill() {
        return String.valueOf('-').repeat(Math.max(0, 32));
    }
}
