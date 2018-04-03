//*********************
// NumberFun Class
//-------------------------
// author: Tatenda Ndambakuwa
// version: 03/23/2018 
// Spring 2018 CMSC255 Section 2
// NumberFun.Java
// Project 4: Write a program called NumberFun.java that will determine if a positive, whole number is even, prime, a palindrome, or emirp.   
//*********************
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//*********************
//  NumberFun Class
//*********************
public class NumberFun {
//*********************
// IsEven Method
//---------------------
//helper method to check if the number is even
//*********************
private static boolean IsEven(int num) 
{
return (num % 2 == 0);
}

//*********************
// IsPrime Method
//---------------------
//helper method to check if the number is prime
//*********************

private static boolean IsPrime(int num) {
boolean flag = true;
for (int i = 2; i <= num / 2; i++) {
if (num % i == 0) {
flag = false;
break;
}
}
return flag;
}

//helper method to check if the number is Emirp
//*********************
// IsEmirp Method
//---------------------
//helper method to check if the number is emirp. An emirp is a prime number whose reversal is also a prime. 
//*********************
private static boolean IsEmirp(int num) {
int x, rem, rev = 0;
x = num;
while (num > 0) {
rem = num % 10;
rev = (rev * 10) + rem;
num = num / 10;
}
return (IsPrime(num) && IsPrime(rev));
}

//helper method to check if the number is palindrome
//*********************
// IsPalindrome Method
//---------------------
//helper method to check if the number is palindrome. A palindrome reads forward and backward in the same way. 
//*********************
private static boolean IsPalindrome(int num) {
int x, rem, rev = 0;
x = num;
while (num > 0) {
rem = num % 10;
rev = (rev * 10) + rem;
num = num / 10;
}
return (x == rev);
}

//helper method to print heading
private static void printHeading() {
System.out.println("Tatenda Ndambakuwa \n"
+ "CMSC 255 Section 2 \n"
+ "NumberFun.java, project 4");
}

// Main method
public static void main(String[] args) {
  
// PrintHeading method
printHeading();
File in; //file input
Scanner s = new Scanner(System.in); //reads input from console or user

// Prompts user to enter file name
System.out.print("Enter the file name: ");
in = new File(s.nextLine());
if (in.exists()) {
try {
//checks if input file exist or not
Scanner ints = new Scanner(in); //reads input file
boolean flag = false;

//-----------------------------------------
// While loop to read each number and process it
//-----------------------------------------
while (ints.hasNext()) {
  if (ints.hasNextInt()){
  
    int num = ints.nextInt();
    System.out.print(num + "\t" + num + "- ");
    flag = false;
    if (IsEven(num)) {
      if (flag == true) 
        {
        System.out.print(", ");
        
      }
      flag = true;
      System.out.print("even");
    }
    if (IsPrime(num)) {
        if (flag == true) 
        {
        System.out.print(", ");
        
      }
      flag = true;
      System.out.print("prime");
    }
    if (IsPalindrome(num)) {
        if (flag == true) 
        {
        System.out.print(", ");
        
      }
      flag = true; 
      System.out.print("palindrome");
    }
    if (IsEmirp(num)) {
        if (flag == true) 
        {
        System.out.print(", ");
      }
      flag = true;  
      System.out.print("emirp");
    }
    System.out.println(" ");

  } // end of if statement
  else {
  String err = ints.next();
  System.out.println(err + " -- invalid input");
} // end of else
} // end of while

} catch (FileNotFoundException ex) {
System.err.print(ex.getMessage());
} // end of system error message printing
} // end of try catch
} // end of main method
} // end of public class NumberFun 
