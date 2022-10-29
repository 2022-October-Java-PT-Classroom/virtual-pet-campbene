package virtual_pet;

public class VirtualPet {
    private String petName;
    private int hungerLevel = 6;
    private int happinessLevel = 6;
    private int sleepinessLevel = 6;
    private int angerLevel = 0;

    public String getPetName() {
        return petName;
    }
    public int getHungerLevel() {
        return hungerLevel;
    }
    public int getHappinessLevel() {
        return happinessLevel;
    }
    public int getSleepinessLevel() {
        return sleepinessLevel;
    }
    public int getAngerLevel() {
        return angerLevel;
    }

    public VirtualPet (String name){
        this.petName = name;
    }

    public void feedPet(){
        hungerLevel = 11;
    }

    public void playGame(){
        happinessLevel = 11;
    }

    public void goToBed(){
        sleepinessLevel = 11;
    }

    public void tick(){
        hungerLevel--;
        happinessLevel--;
        sleepinessLevel--;
    }

    public boolean checkLevel(int levelToCheck){
        if (levelToCheck < 2){
            return true;
        } else {
            return false;
        }
    }
    public void autoHungerLevel(){
        hungerLevel=6;
        angerLevel++;
    }
    public void autoHappinessLevel(){
        happinessLevel =6;
        angerLevel++;
    }
    public void autoSleepinessLevel(){
        sleepinessLevel = 6;
        angerLevel++;
    }

    public boolean checkLowestLevel(int levelToCheck, int levelCompared1, int levelCompared2){
        if (levelToCheck <= levelCompared1 && levelToCheck <= levelCompared2) {
            return true;
        } else {
            return false;
        }
    }

    public void randHunger() {
        hungerLevel += 2;
    }
    public void randHappy() {
        happinessLevel += 2;
    }
    public void randSleep(){
        sleepinessLevel+=2;
    }

    public String showLevel(int level){
        String levelMessage;
        if (level >= 8) levelMessage = " Very Satisfied!";
        else if (level >= 6) levelMessage = " Just OK";
        else if (level >= 3) levelMessage = " Needs Attention!";
        else levelMessage = " RAOR!";
        return levelMessage;
    }

}
