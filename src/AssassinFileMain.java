// EGR221 Homework 3 Assasin
// Instructor-provided testing program.

//import java.io.*;
//import java.util.*;
//
//public class AssassinFileMain {
//    public static final String INPUT_FILE = "test_input.txt";
//
//    public static void main(String[] args) throws FileNotFoundException, IOException {
//        // prompt for file name
//        Scanner inputFileScanner = new Scanner(new File(INPUT_FILE));
//        while(inputFileScanner.hasNextLine()) {
//            String line = inputFileScanner.nextLine();
//            Scanner lineScanner = new Scanner(line);
//            String actualOutputFileName = "actual_" + lineScanner.next();
//            PrintWriter outFile = new PrintWriter(new FileWriter(actualOutputFileName));
//
//            outFile.println("Welcome to the EGR221 Assassin Manager");
//            outFile.println();
//            outFile.print("What name file do you want to use this time? ");
//            String fileName = lineScanner.next();
//            outFile.println(fileName);
//
//            // read names into a list, using a Set to avoid duplicates
//            Scanner input = new Scanner(new File(fileName));
//            Set<String> names = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
//            List<String> names2 = new ArrayList<String>();
//            while (input.hasNextLine()) {
//                String name = input.nextLine().trim();
//                if (name.length() > 0 && !names.contains(name)) {
//                    names.add(name);
//                    names2.add(name);
//                }
//            }
//
//            // Shuffle if desired
//            if (yesTo(lineScanner, "Do you want the names shuffled?", outFile)) {
//                Collections.shuffle(names2);
//            }
//            // Make an immutable version and use it to build an AssassinManager
//            List<String> names3 = Collections.unmodifiableList(names2);
//            AssassinManager manager = new AssassinManager(names3);
//            outFile.println();
//            if(lineScanner.hasNextLine()) {
//                Scanner nameScanner = new Scanner(lineScanner.nextLine());
//                nameScanner.useDelimiter(", ");
//                // Prompt the user for victims until the game is over
//                while (!manager.isGameOver())
//                    oneKill(nameScanner, manager, outFile);
//            }
//            // Report who won
//            outFile.println("Game was won by " + manager.winner());
//            outFile.println("Final graveyard is as follows:");
//            manager.printGraveyard(outFile);
//            outFile.close();
//        }
//    }
//
//    // Handles the details of recording one victim.  Shows the current kill
//    // ring and graveyard to the user, prompts for a name and records the
//    // kill if the name is legal.
//    public static void oneKill(Scanner nameScanner, AssassinManager manager, PrintWriter outFile) {
//        outFile.println("Current kill ring:");
//        manager.printKillRing(outFile);
//        outFile.println("Current graveyard:");
//        manager.printGraveyard(outFile);
//        outFile.println();
//        outFile.print("next victim? ");
//        String name = nameScanner.next().trim();
//        outFile.println(name);
//        if (manager.graveyardContains(name)) {
//            outFile.println(name + " is already dead.");
//        } else if (!manager.killRingContains(name)) {
//            outFile.println("Unknown person.");
//        } else {
//            manager.kill(name);
//        }
//        outFile.println();
//    }
//
//    // post: asks the user a question, forcing an answer of "y" or "n";
//    //       returns true if the answer was yes, returns false otherwise
//    public static boolean yesTo(Scanner lineScanner, String prompt, PrintWriter outFile) {
//        outFile.print(prompt + " (y/n)? ");
//        String response = lineScanner.next().trim().toLowerCase();
//        outFile.println(response);
//        while (!response.equals("y") && !response.equals("n")) {
//            outFile.println("Please answer y or n.");
//            outFile.print(prompt + " (y/n)? ");
//            response = lineScanner.next().trim().toLowerCase();
//            outFile.println(response);
//        }
//        return response.equals("y");
//    }
//}