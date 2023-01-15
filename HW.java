import java.util.Scanner;
import java.util.ArrayList;

public class HW
{  
    public static void main(String[] args) 
    {
        String UserInput = getUserInput();
        String Algo1Result = Algorithm1(UserInput);
        System.out.println();
        String Algo2Result = Algorithm2(UserInput);
    }

    static Character[] vowels = {'a', 'e', 'i', 'o', 'u'};

    public static String Algorithm1(String input) 
    {
        int NumVowelsRemoved = 0, NumRepeatsRemoved = 0;
        int StringLength = input.length();

        Boolean NonSpaceReached = false;

        String output = "";

        //Iterate through the string and decide what to remove
        for (int i = 0; i < StringLength; i++)
        {
            //CASE: Past spaces at the beginning of the string
            if(NonSpaceReached)
            {
                //CASE: Current character is a vowel
                if(isVowel(input.charAt(i)))
                {
                    //CASE: Current character is an important vowel
                    if(input.charAt(i - 1) == ' ')
                    {
                        output += input.charAt(i);
                    }
                    //CASE: Current character is an unimportant vowel
                    else
                    {
                        NumVowelsRemoved++;
                    }
                }
                //CASE: char is not the same as previous and will be kept
                else if(input.charAt(i) != input.charAt(i - 1))
                {
                    output += input.charAt(i);
                }
                //CASE: char equals previous character and should be removed, do nothing
                else
                {
                    NumRepeatsRemoved++;
                }
            }
            //CASE: No non space characters have been reached yet
            else
            {
                //CASE: Current character is not a space and the main string has begun!
                if(input.charAt(i) != ' ')
                {
                    NonSpaceReached = true;
                    output += input.charAt(i);
                }
                //CASE: Current character is still a space and will not be included
                else
                {
                    NumRepeatsRemoved++;
                }
            }
        }

        System.out.println("Algorithm 1");
        System.out.println("Vowels removed: " + NumVowelsRemoved);
        System.out.println("Repeats removed:" + NumRepeatsRemoved);
        System.out.println("Algorithm 1 message: " + output);
        System.out.println("Characters saved: " + (StringLength - output.length()));
        return output;
    }

    public static String Algorithm2(String input) 
    {
        int StringLength = input.length();

        String output = "";

        ArrayList<Character> IncludedChars = new ArrayList<>();
        ArrayList<Integer> CharCounts = new ArrayList<>();

        for(int i = 0; i < StringLength; i++)
        {
            //CASE: current char is not a space
            if(input.charAt(i) != ' ')
            {
                Boolean CharAlreadyIncluded = false;
                for(int j = 0; j < IncludedChars.size(); j++) //CAN BE BROKEN**********************
                {
                    //CASE: current char is already a part of IncludedChars
                    if(input.charAt(i) == IncludedChars.get(j))
                    {
                        CharCounts.set(j, CharCounts.get(j) + 1);
                        CharAlreadyIncluded = true;
                        break; //BREAK*************************************************************
                    }
                }
                //CASE: current char is not yet a part of IncludedChars
                if(!CharAlreadyIncluded)
                {
                    IncludedChars.add(input.charAt(i));
                    CharCounts.add(1);
                }
            }
        }

        for(int i = 0; i < CharCounts.size(); i++)
        {
            output += CharCounts.get(i);
            output += IncludedChars.get(i);
        }

        System.out.println("Algorithm 2");
        System.out.println("Unique characters: " + IncludedChars.size());
        System.out.println("Algorithm 2 message: " + output);
        System.out.println("Characters saved: " + (StringLength - output.length()));
        return output;
    }

    public static String getUserInput()
    {
        Scanner stdin = new Scanner(System.in);
        System.out.print("Type a Message: ");
        String name = stdin.nextLine();
        stdin.close();
        return name.toLowerCase();
    }

    public static Boolean isVowel(Character input)
    {
        for (Character i : vowels) 
        {
            if(input == i)
            {
                return true;
            }
        }
        return false;
    }
}