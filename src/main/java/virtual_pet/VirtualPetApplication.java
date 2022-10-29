package virtual_pet;

import java.util.Random;
import java.util.Scanner;

public class VirtualPetApplication {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        VirtualPet newPet;
        boolean stillPlaying = true;
        int userSelection, randAction, caseSwitch;
        String userName;

        System.out.println("Hello and welcome to Virtual Pet!");
        System.out.println("Here you will get to take care of your very own Virtual Pet!");
        System.out.println("First please enter a name for your pet: ");
        userName = input.nextLine();
        newPet = new VirtualPet(userName);
        System.out.println("\nExcellent, " + newPet.getPetName() + " is a perfect name for your virtual pet!\n");

        System.out.println("Here are the rules:");
        System.out.println("1: Your pet has 3 attributes to take care of, Hunger, Happiness, and Sleepiness");
        System.out.println("2: Each one of these has a level between 0-10 where 10 is fully satisfied and 0 is completely neglected.");
        System.out.println("3: By choosing to Play, Feed or let your pet Sleep you can increase these levels back to 10!");
        System.out.println("4: After each task you complete with your pet a turn counter will go up and cause all pet levels to drop slightly");
        System.out.println("5: Be careful, if " + newPet.getPetName() + " ever gets too low in one of their attributes they will act on their own.");
        System.out.println("6: If they are forced to act on their own too many times they might decide to leave, so make sure to always address their needs!");
        System.out.println("7: Sometimes they might do what they want instead of what you wanted, this is different from if they are forced to act from a level being to low.\n");

        while (stillPlaying && newPet.getAngerLevel() < 4){
            System.out.println("Please select from the following to take care of your pet:");
            System.out.println("1: Feed " + newPet.getPetName());
            System.out.println("2: Play with " + newPet.getPetName());
            System.out.println("3: Put " + newPet.getPetName() + " to bed");
            System.out.println("4: Do nothing...");
            System.out.println("5: Close the game\n");
            System.out.println("Here are " + newPet.getPetName() + "'s current stats:");
            System.out.println("Hunger Level: " + newPet.getHungerLevel() + newPet.showLevel(newPet.getHungerLevel()) + "   " +
                "Happiness Level: " + newPet.getHappinessLevel() + newPet.showLevel(newPet.getHappinessLevel()) + "   " +
                "Sleepiness Level: " + newPet.getSleepinessLevel() + newPet.showLevel(newPet.getSleepinessLevel()));
            userSelection = input.nextInt();
            caseSwitch = userSelection;
            if (userSelection!=5) {
                if (newPet.checkLevel(newPet.getHungerLevel()) && userSelection != 1) {
                    caseSwitch = 6;
                } else if (newPet.checkLevel(newPet.getHappinessLevel()) && userSelection != 2) {
                    caseSwitch = 7;
                } else if (newPet.checkLevel(newPet.getSleepinessLevel()) && userSelection != 3) {
                    caseSwitch = 8;
                } else {
                    randAction = rand.nextInt(10);
                    if (randAction < 4) {
                        if (newPet.checkLowestLevel(newPet.getHungerLevel(), newPet.getHappinessLevel(), newPet.getSleepinessLevel()) && userSelection != 1) {
                            caseSwitch = 9;
                        } else if (newPet.checkLowestLevel(newPet.getHappinessLevel(), newPet.getHungerLevel(), newPet.getSleepinessLevel()) && userSelection != 2) {
                            caseSwitch = 10;
                        } else if (userSelection != 3) {
                            caseSwitch = 11;
                        }
                    }
                }
            }

            switch (caseSwitch) {
                case 1:
                    newPet.feedPet();
                    System.out.println(newPet.getPetName() + " is super happy to eat some food!");
                    break;
                case 2:
                    newPet.playGame();
                    System.out.println(newPet.getPetName() + " loves getting to play with you!");
                    break;
                case 3:
                    newPet.goToBed();
                    System.out.println(newPet.getPetName() + " is sleeping peacefully in their bed!");
                    break;
                case 4:
                    System.out.println(newPet.getPetName() + " stares at you expectedly");
                    break;
                case 5:
                    stillPlaying = false;
                    System.out.println("Thanks for Playing! " + newPet.getPetName() + " had a great time!");
                    break;
                case 6:
                    newPet.autoHungerLevel();
                    System.out.println(newPet.getPetName() + " got angry and ate your plants...");
                    break;
                case 7:
                    newPet.autoHappinessLevel();
                    System.out.println(newPet.getPetName() + " got angry and tore up you couch because they were bored...");
                    break;
                case 8:
                    newPet.autoSleepinessLevel();
                    System.out.println(newPet.getPetName() + " got angry slept on your favorite pillow...");
                    break;
                case 9:
                    newPet.randHunger();
                    System.out.println(newPet.getPetName() + " decided they would rather eat some leftover kibble instead.");
                    break;
                case 10:
                    newPet.randHappy();
                    System.out.println(newPet.getPetName() + " is bored and is playing with some toys by itself instead");
                    break;
                case 11:
                    newPet.randSleep();
                    System.out.println(newPet.getPetName() + " found a nice spot in the sun and took a quick nap instead.");
                    break;
                default:
                    System.out.println("That was an invalid entry, try again...");
                    break;
            }

            newPet.tick();
        }
        if (newPet.getAngerLevel() == 4){
            System.out.println(newPet.getPetName() + " has left because they were no longer getting the attention they needed...");
            System.out.println("Maybe a goldfish is a better option?");
        }
    }

}
