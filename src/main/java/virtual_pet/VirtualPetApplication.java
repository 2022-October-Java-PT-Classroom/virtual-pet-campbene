package virtual_pet;

import java.util.Random;
import java.util.Scanner;

public class VirtualPetApplication {

    public static void main(String[] args) {
        //Interact with a virtual_pet.VirtualPet object in this method
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        boolean stillPlaying = true;
        int userSelection, randAction;

        System.out.println("Hello and welcome to Virtual Pet!");
        System.out.println("Here you will get to take care of your very own Virtual Pet!");
        System.out.println("First please enter a name for your pet: ");
        VirtualPet newPet = VirtualPet.createName(input.nextLine());
        System.out.println("\nExcellent, " + newPet.petName + " is a perfect name for your virtual pet!\n");

        System.out.println("Here are the rules:");
        System.out.println("1: Your pet has 3 attributes to take care of, Hunger, Happiness, and Sleepiness");
        System.out.println("2: Each one of these has a level between 0-10 where 10 is fully satisfied and 0 is completely neglected.");
        System.out.println("3: By choosing to Play, Feed or let your pet Sleep you can increase these levels back to 10!");
        System.out.println("4: After each task you complete with your pet a turn counter will go up and cause all pet levels to drop slightly");
        System.out.println("5: Be careful, if " + newPet.petName + " ever gets too low in one of their attributes they will act on their own.");
        System.out.println("6: If they are forced to act on their own too many times they might decide to leave, so make sure to always address their needs!");
        System.out.println("7: Sometimes they might do what they want instead of what you wanted, this is different from if they are forced to act from a level being to low.\n");
        //i feel like i understand Capcom games now and their massive quantity of instructions...

        while (stillPlaying && newPet.angerLevel < 4){
            System.out.println("Please select from the following to take care of your pet:");
            System.out.println("1: Feed " + newPet.petName);
            System.out.println("2: Play with " + newPet.petName);
            System.out.println("3: Put " + newPet.petName + " to bed");
            System.out.println("4: Do nothing...");
            System.out.println("5: Close the game\n");
            newPet.getStats();
            userSelection = input.nextInt();

            switch (userSelection) {
                case 1:
                    newPet.tick();
                    randAction = rand.nextInt(10);
                    if (newPet.hungerLevel < 2 || newPet.happinessLevel < 2 || newPet.sleepinessLevel < 2) {
                        newPet.autoPet();
                    } else if (randAction < 4){
                        newPet.randPet(userSelection);
                    } else {
                        newPet.feedPet();
                    }
                    break;
                case 2:
                    newPet.tick();
                    randAction = rand.nextInt(10);
                    if (newPet.hungerLevel < 2 || newPet.happinessLevel < 2 || newPet.sleepinessLevel < 2) {
                        newPet.autoPet();
                    } else if (randAction < 4) {
                        newPet.randPet(userSelection);
                    } else {
                        newPet.playGame();
                    }
                    break;
                case 3:
                    newPet.tick();
                    randAction = rand.nextInt(10);
                    if (newPet.hungerLevel < 2 || newPet.happinessLevel < 2 || newPet.sleepinessLevel < 2) {
                        newPet.autoPet();
                    } else if (randAction < 4) {
                        newPet.randPet(userSelection);
                    } else {
                        newPet.goToBed();
                    }
                    break;
                case 4:
                    newPet.tick();
                    randAction = rand.nextInt(10);
                    if (newPet.hungerLevel < 2 || newPet.happinessLevel < 2 || newPet.sleepinessLevel < 2) {
                        newPet.autoPet();
                    } else if (randAction < 4){
                        newPet.randPet(userSelection);
                    } else {
                        System.out.println(newPet.petName + " stares at you expectedly");
                    }
                    break;
                case 5:
                    stillPlaying = false;
                    System.out.println("Thanks for Playing! " + newPet.petName + " had a great time!");
                    break;
                default:
                    System.out.println("That was an invalid entry, try again...");
                    break;
            }

        }
        if (newPet.angerLevel == 4){
            System.out.println(newPet.petName + " has left because they were no longer getting the attention they needed...");
            System.out.println("Maybe a goldfish is a better option?");
        }
    }

}
