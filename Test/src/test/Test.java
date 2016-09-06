package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
 public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("How Old are you? ");
    String ageString = br.readLine();
   int age = Integer.parseInt(ageString);
   if (age > 75) {
    System.out.print("You are too old to play this game.");                   
   } else {
    System.out.print("Please enter a noun"); 
    String noun = br.readLine();
    System.out.print("Please enter an adjective"); 
    String adjective = br.readLine();
   }
   System.out.print("Your story");
   System.out.print("--------------");
   
  } 
}