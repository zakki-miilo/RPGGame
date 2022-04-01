public class Dialogue {
    public void blueDialogue(String dialogue, int time) throws InterruptedException {
        System.out.println(ColorText.TEXT_BLUE +ColorText.GLASS_BG + "| "+ dialogue+" |" + ColorText.RESET_BG + ColorText.TEXT_RESET);
        longDialogue(secToMi(0)); //TODO: change back to time.
    }

    public void dialogue(String dialogue, int time) throws InterruptedException {
        System.out.println(dialogue);
        longDialogue(secToMi(0));
    }


    public void purpleDialogue(String dialogue, int time) throws InterruptedException {
        System.out.println(ColorText.TEXT_PURPLE + "*"+ dialogue+"*" + ColorText.TEXT_RESET);
        longDialogue(secToMi(0));
    }
    public void redDialogue(String dialogue, int time) throws InterruptedException {
        System.out.println(ColorText.TEXT_PURPLE + "*"+ dialogue+"*" + ColorText.TEXT_RESET);
        longDialogue(secToMi(0));
    }
    public void redGlassDialogue(String dialogue, int time) throws InterruptedException {
        System.out.println(ColorText.TEXT_RED +ColorText.GLASS_BG+  dialogue+ ColorText.RESET_BG + ColorText.TEXT_RESET);
        longDialogue(secToMi(0));
    }

    public void greenGlassDialogue(String dialogue, int time) throws InterruptedException {
        System.out.println(ColorText.TEXT_GREEN +ColorText.GLASS_BG+  dialogue+ ColorText.RESET_BG + ColorText.TEXT_RESET);
        longDialogue(secToMi(0));
    }


    public void cyanDialogue(String dialogue, int time) throws InterruptedException {
        System.out.println(ColorText.TEXT_CYAN + dialogue+ColorText.TEXT_RESET);
        longDialogue(secToMi(0));
    }
    public void yellowDialogue(String dialogue, int time) throws InterruptedException {
        System.out.println(ColorText.TEXT_YELLOW+ ColorText.GLASS_BG +"| " + dialogue+ " |"+ColorText.RESET_BG+ColorText.TEXT_RESET);
        longDialogue(secToMi(0));
    }

    public int secToMi(int time){
        return time * 1000;
    }

    public void longDialogue(int time) throws InterruptedException {
        Thread.sleep(time);
    }



}

