/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.week3.softwarefundamentals.ice1;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author Sivagama 
 * @modifier : Bikranta Singha
 * @modifiedDate : 1st June, 2021
 * @studentNumber : 991546415
 */

import static java.lang.Math.*;
import java.util.*;


//Card Trick and the rest of the code
public class CardTrick {
    
    public static Scanner userInput = new Scanner(System.in);
    public static Card userCard = new Card();
    public static Card[] magicHand = new Card[7];
    
    
    public static void main(String[] args)
    {
        //adding hardcoded luckyCard object
        Card luckyCard = new Card();
        luckyCard.setSuit(luckyCard.SUITS[0]);
        luckyCard.setValue(1);
        
        for (int i=0; i<magicHand.length; i++)
        {
            Card c = new Card();
            c.setValue( (int)( Math.random() * 13 ) + 1);
            c.setSuit(c.SUITS[ (int)( Math.random() * 3 )]);
            magicHand[i] = c;
        }
        
        System.out.println("Please pick a card suit: ");
        System.out.println("0: Hearts, 1: Diamonds, 2: Spades, 3: Clubs");
        userCard.setSuit(userCard.SUITS[userInput.nextInt()]);
        System.out.println("Please enter a card value between 1-13");
        userCard.setValue(userInput.nextInt());
        
        if (cardsMatch()){
            System.out.println("Match found in our Magic Hand!");
            displayHand();
        } else {
            System.out.println("No matches found in our Magic Hand.");
            displayHand();
        }
        
    }
    
    public static boolean cardsMatch(){
        for(int i = 0; i < magicHand.length; i++){
            if(magicHand[i].getSuit() == userCard.getSuit()){
                if(magicHand[i].getValue() == userCard.getValue()){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public static void displayHand(){
        System.out.println("Our Magic Hand Cards were: ");
        for(int i = 0; i < magicHand.length; i++){
          System.out.println(magicHand[i].getSuit()+ " " + magicHand[i].getValue());
        }
        System.out.println("Your card was: ");
        System.out.println(userCard.getSuit() + " " + userCard.getValue());
    }
}
