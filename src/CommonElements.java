/********************************
Name:       Ethan Johnson
Class:      CS 4306-03
Term:       Fall 2023
Instructor: Dr. Haddad
IDE Name:   IntelliJ
*********************************

 Algorithm Design Block

 Algorithm Title: Find and print common elements in sorted number lists

 Logical Steps:

 Step 1: Declare variables to track the current index of L and M and the number of comparisons
 Step 2: Loop until L or M index tracker is out of range
    Step 3: If current L is less than current M mark L as not matched and increase L index
    Step 4: Else if current L is equal to current M, increase L index and M index
    Step 4: Else (if current L is greater than current M) increase M index
 Step 5: Add matched values to a display string
 Step 6: Print display string & number of comparisions

 Algorithm pseudocode syntax:

 Algorithm: Find and print common elements in sorted number lists
 Input: Non-empty list (L) of sorted numbers (ascending order, shorter list)
        Non-empty list (M) of sorted numbers (ascending order, equal length/longer list)
 Output: List of common values (C) from L and M

 Begin
        lIndex <- 0;
        mIndex <- 0;
        comps <- 0;
        *
        do while (lIndex < L.length and mIndex < M.length)
            comps ++;

            if (L[lIndex] < M[mIndex])
                L[lIndex] <- -9999;
                lIndex++;
            end if
            else if (L[lIndex] == M[mIndex]){
                lIndex++;
                mIndex++;
                comps++;
            end if
            else
                mIndex++;
                comps++;
            emd else

        end do while

        display <- "";

        for i <- 0 to L.length do
            if (L[i] != -9999)
                display <- display + L[i] + " ");
        end loop

        print (display)
        print (comps)

 *********************************************************/
import java.util.Scanner;

public class CommonElements {

    public static void main(String[] args) {
        //declare lists
        int[] L = new int[0];
        int[] M = new int[0];
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
                    System.out.println("\n\nEnter sorted number set 1 separated by spaces (ex: 1 2 3 4)");
                    myScanner = new Scanner(System.in);
                    String numSet1String = myScanner.nextLine();
                    String[] numSet1 = numSet1String.split(" ");
                    //parse values into L
                    L = new int[numSet1.length];
                    for (int a = 0; a < numSet1.length; a++){
                        L[a] = Integer.parseInt(numSet1[a]);
                    }

                    //get second list values
                    System.out.println("\n\nEnter sorted number set 2 separated by spaces (ex: 1 2 3 4)");
                    myScanner = new Scanner(System.in);
                    String numSet2String = myScanner.nextLine();
                    String[] numSet2 = numSet2String.split(" ");
                    //parse values into <
                    M = new int[numSet2.length];
                    for (int a = 0; a < numSet2.length; a++){
                        M[a] = Integer.parseInt(numSet2[a]);
                    }

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
                    String lDisplay = "";
                    for (int a = 0; a < L.length; a++){
                        lDisplay += L[a] + " ";
                    }
                    System.out.println("List 1: \t\t" + lDisplay);
                    //display input 2
                    String mDisplay = "";
                    for (int a = 0; a < M.length; a++){
                        mDisplay += M[a] + " ";
                    }
                    System.out.println("List 2: \t\t" + mDisplay);
                    //call algorithm with shorter list in first parameter
                    if (M.length >= L.length) Parse(L, M);
                    else Parse(M, L);
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
    public static void Parse(int[] L, int[] M) {
        //declare tracker values
        int lIndex = 0;
        int mIndex = 0;
        int comps = 0;

        //loop through L
        do{
            comps ++;
            //if current l is smaller than current m
            if (L[lIndex] < M[mIndex]){
                L[lIndex] = -9999;
                lIndex++;
            }
            //if current l is equal to current m
            else if (L[lIndex] == M[mIndex]){
                lIndex++;
                mIndex++;
                comps++;
            }
            //if current l is larger than current m
            else {
                mIndex++;
                comps++;
            }
        //end loop when L or M are outside of range
        } while (lIndex < L.length && mIndex < M.length);

        //parse output to a display string
        String display = "";
        for (int i = 0; i < L.length; i++){
            if (L[i] != -9999) display += L[i] + " ";
        }
        //display data
        System.out.println("Common values: \t" + display);
        System.out.println("Comparisons: \t\t" + comps);
    }

    //display the menu
    public static void DisplayMenu(){
        System.out.println("-----------------MAIN MENU--------------\n" +
        "\t1. Read input lists (integer values)\n" +
        "\t2. Run algorithm and display output\n" +
        "\t3. Exit program\n\n" +
        "Enter option number:");
    }
}