/********************************
 Name:       Ethan Johnson
 Class:      CS 4306-03
 Term:       Fall 2023
 Instructor: Dr. Haddad
 IDE Name:   IntelliJ
 *********************************

 Algorithm Design Block

 Algorithm Title: Check if two strings are anagrams

 Logical Steps:

 Step 1: Declare variable to track the number of comparisons
 Step 2: Loop through string1
    Step 3: If current character is not a space
        Step 4: Declare variable to track if the current character is found
        Step 5: Loop through string2
            Step 6: If current character (string1) is found in string 2
                Step 7: Mark character as found
                Step 8: Remove character from string2
                Step 9: Break string2 loop
        Step 10: If current character (string1) not found in string 2
            Step 11: Display output and stop function
    Step 12: Display output

 Algorithm pseudocode syntax:

 Algorithm: Check if two strings are anagrams
 Input: string1 (shorter string, lower case)
        string2 (equal length/longer string, lower case)
 Output: Number of comparisons and if the string is an anagram or not

 Begin
 comps <- 0;
 for a <- 0 to string1.length do
    comps ++;
    if (string1[a] != " ")
        charFound <- false;
        for b <- 0 to string2.length do
            comps++;
            if (string2[b] == string1[a])
                string2 <- string2 - string2[b];
                charFound <- true;
                end for loop (b);
        end for loop (b)
        if (charFound == false)
            print(not anagram);
            print(comps);
            return;
 end for loop (a)
 print(is anagram);
 print(comps);
 End;
 *********************************************************/
import java.util.Scanner;

public class AnagramsCheck {

    public static void main(String[] args) {
        //declare lists
        String string1 = "", string2 = "";
        //declare value for input check
        boolean listsSet = false;
        //declare scanner
        Scanner myScanner = new Scanner(System.in);
        //declare loop end con
        boolean stop = false;
        //start loop
        do{
            //display the menu
            DisplayMenu();
            //read in input
            int response = myScanner.nextInt();
            //switch on input
            switch (response){
                //on set inputs
                case 1:
                    //get first list values
                    System.out.println("\n\nEnter string number 1 (ex: dormitory)");
                    myScanner = new Scanner(System.in);
                    string1 = myScanner.nextLine();

                    //get second list values
                    System.out.println("\n\nEnter string number 2 (ex: dirty room)");
                    myScanner = new Scanner(System.in);
                    string2 = myScanner.nextLine();

                    //input check value update
                    listsSet = true;
                    break;
                //on run algorithm
                case 2:
                    //ensure inputs given
                    if (!listsSet) {
                        System.out.println("\n\nNo inputs given.");
                        break;
                    }
                    //display input 1
                    System.out.println("String 1: \t\t" + string1);
                    //display input 2
                    System.out.println("String 2: \t\t" + string2);
                    //call algorithm with shorter list in first parameter
                    if (string1.length() >= string2.length()) Parse(string1.toLowerCase(), string2.toLowerCase());
                    else Parse(string2.toLowerCase(), string1.toLowerCase());
                    break;
                //on quit
                case 3:
                    //stop the loop
                    System.out.println("Stopping program.");
                    stop = true;
                    break;
            }
        } while (!stop);
    }

    //actual algorithm
    public static void Parse(String string1, String string2) {
        //variable to track the number of comparisons
        int comps = 0;

        //loop through the first string
        for (int a = 0; a < string1.length(); a++){
            //increase comparisons for every character
            comps++;
            //as long as character is not a space
            if (string1.charAt(a) != ' '){
                //declare temp variable to see if this character is found
                boolean charFound = false;
                //loop through the second string
                for (int b = 0; b < string2.length(); b++){
                    //increase comparison tracker
                    comps++;
                    //if this character is the character we are looking for
                    if (string2.charAt(b) == string1.charAt((a))){
                        //remove this character from string 2
                        string2 = string2.replaceFirst(Character.toString(string2.charAt(b)), "");
                        //mark character as found
                        charFound = true;
                        //break loop through second string
                        break;
                    }
                }
                //if the character was not found end the method and display outputs
                if (!charFound) {
                    System.out.println("Output:\t\tStrings are not anagrams");
                    System.out.println("Comparisions:\t" + comps);
                    return;
                }
            }
        }
        //display outputs
        System.out.println("Output:\t\tStrings are anagrams");
        System.out.println("Comparisions:\t" + comps);
    }

    //display the menu
    public static void DisplayMenu(){
        System.out.println("-----------------MAIN MENU--------------\n" +
                "\t1. Read input lists (strings)\n" +
                "\t2. Run algorithm and display output\n" +
                "\t3. Exit program\n\n" +
                "Enter option number:");
    }
}