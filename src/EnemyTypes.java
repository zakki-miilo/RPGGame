interface Types{
        void attack(Enemy enemy);
        void attack2(Enemy enemy);
        void attack3(Enemy enemy);
        void idle();
    }

class Orc implements Types{
    public void attack(Enemy enemy){
                System.out.println(ColorText.TEXT_RED + "Orc SLASHES with it's " + enemy.weaponType()+ColorText.TEXT_RESET);
    }

    @Override
    public  void attack2(Enemy enemy) {
        System.out.println(ColorText.TEXT_RED + "Orc does a Jumps attack with it's " + enemy.weaponType()+ColorText.TEXT_RESET);
    }

    @Override
    public void attack3(Enemy enemy) {
        System.out.println(ColorText.TEXT_RED + "Orc Dashes and Swings it's " + enemy.weaponType()+ " at you."+ColorText.TEXT_RESET);

    }

    @Override
    public void idle() {
        System.out.println(ColorText.TEXT_PURPLE + "*The Orc is jumping excitingly!*"+ColorText.TEXT_RESET);
    }
}

class Wolf implements Types{
    @Override
    public void attack(Enemy enemy) {
        System.out.println(ColorText.TEXT_RED +"Wolf viciously bites at you!"+ColorText.TEXT_RESET);
    }

    @Override
    public void attack2(Enemy enemy) {
        System.out.println(ColorText.TEXT_RED +"Wolf use Claws!"+ColorText.TEXT_RESET);
    }

    @Override
    public void attack3(Enemy enemy) {
        System.out.println(ColorText.TEXT_RED +"Wolf dashes at you"+ColorText.TEXT_RESET);
    }

    @Override
    public void idle() {
        System.out.println(ColorText.TEXT_PURPLE + "Wolf is watching you intensity..."+ColorText.TEXT_RESET);
    }

}

