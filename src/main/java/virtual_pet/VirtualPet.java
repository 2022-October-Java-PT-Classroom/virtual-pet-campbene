package virtual_pet;

import java.util.Scanner;

public class VirtualPet {
    Scanner input = new Scanner(System.in);
    String petName;
    int hungerLevel = 6, happinessLevel = 6, sleepinessLevel = 6;
    int angerLevel = 0; // value to track when a pet might leave if it gets neglected
//  attribute levels are determined from 0-10 with 10 being fully satisfied
//  and 0 being extreme need of attention.
    public static VirtualPet createName(String name){
        VirtualPet n = new VirtualPet();
        n.petName = name;
        return n;
    }

    public void feedPet(){
        hungerLevel = 10;
        System.out.println(petName + " is super happy to eat some food!");
    }

    public void playGame(){
        happinessLevel = 10;
        System.out.println(petName + " loves getting to play with you!");
    }

    public void goToBed(){
        sleepinessLevel = 10;
        System.out.println(petName + " is sleeping peacefully in their bed!");
    }

    public void tick(){
        hungerLevel--;
        happinessLevel--;
        sleepinessLevel--;
    }

    public void autoPet(){
        if(hungerLevel < 2) {
            System.out.println(petName + " is too hungry to do anything else and has instead eats your house plants");
            hungerLevel = 6;
            angerLevel++;
        }
        if(sleepinessLevel < 2){
            System.out.println(petName + " is way too tired, they are napping on their bed instead");
            sleepinessLevel = 6;
            angerLevel++;
        }
        if(happinessLevel < 2) {
            System.out.println(petName + " has way to much energy and is now tearing up your couch for fun instead.");
            happinessLevel = 6;
            angerLevel++;
        }
    }

    public void randPet(int userTask){
        if(hungerLevel <= sleepinessLevel && hungerLevel <= happinessLevel){
            if (userTask == 1) feedPet();
            else {
                System.out.println(petName + " decided they would rather eat some leftover kibble instead.");
                hungerLevel+=2;
            }
        } else if(sleepinessLevel <= hungerLevel && sleepinessLevel <= happinessLevel){
            if (userTask == 3) goToBed();
            else {
                System.out.println(petName + " found a nice spot in the sun and took a quick nap instead.");
                sleepinessLevel+=2;
            }
        } else { //if(happinessLevel <= hungerLevel && happinessLevel <= sleepinessLevel)
            if (userTask == 2) playGame();
            else {
                System.out.println(petName + " is bored and is playing with some toys by itself instead");
                happinessLevel+=2;
            }
        }
    }

    public void getStats(){
        System.out.println("Here are " + petName + "'s current stats:");
        System.out.println("Hunger Level: " + hungerLevel + showLevel(hungerLevel) + "   " +
                "Happiness Level: " + happinessLevel + showLevel(happinessLevel) + "   " +
                "Sleepiness Level: " + sleepinessLevel + showLevel(sleepinessLevel));
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

/*things to add:
1: check that rand does not overwrite the action you chose if it would have been the same action
2:
 */