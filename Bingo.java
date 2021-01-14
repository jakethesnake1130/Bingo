import java.util.Random;
import java.util.ArrayList;


public class Bingo
{

   public static void main(String[] args)
   {
      //Random number generator, will be used for generating the board
      Random rng = new Random();
      
      //Initializing the array that will make up the Bingo board
      int[][] bingoCard = { {0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0}
                          };
      
      //ArrayLists that will make up each letter and their range
      ArrayList<Integer> b = new ArrayList<Integer>();
      ArrayList<Integer> i = new ArrayList<Integer>();
      ArrayList<Integer> n = new ArrayList<Integer>();
      ArrayList<Integer> g = new ArrayList<Integer>();
      ArrayList<Integer> o = new ArrayList<Integer>();
      
      
      //This was the laziest way I could think of setting the ArrayList values
      //I didn't feel like writing 75 .add statements, so I set up this loop
      //As x ticks up, its value is added to the appropriate ArrayList.
      for(int x = 1; x < 76; x++)
      {
         if(x < 16)
         {
            b.add(x);
         }
         else if(x < 31)
         {
            i.add(x);
         }
         else if(x < 46)
         {
            n.add(x);
         }
         else if(x < 61)
         {
            g.add(x);
         }
         else if(x < 76)
         {
            o.add(x);
         }
      }      
      
      //BINGO Banner
      System.out.println("B  I  N  G  O");
      
      //Now into the meat and potatoes
      //Outer loop goes by columns, inner loop goes by rows; the program will loop through a column and then refresh and do the next column
      //My thinking on this was that the colums share their ArrayList, and so they should be generated together
      for(int c = 0; c < bingoCard.length; c++)
      {
      
         for(int r = 0; r < bingoCard.length; r++)
         {                  
            
            //These if statements determine which ArrayList will be drawn from                       
            if(c == 0)
            {
                                                   /*I was running into problems with the
                                                   ArrayList removing indexes and then having the rng
                                                   go out of bounds, so I added '- r' to the equation
                                                   that way the rng would stay in the limit as it
                                                   updated*/
               bingoCard[c][r] = b.get(rng.nextInt(15 - r));
               b.remove(b.indexOf(bingoCard[c][r]));
            }
            if(c == 1)
            {
               bingoCard[c][r] = i.get(rng.nextInt(15 - r));
               i.remove(i.indexOf(bingoCard[c][r]));
            }
            if(c == 2)
            {
               bingoCard[c][r] = n.get(rng.nextInt(15 - r));
               n.remove(n.indexOf(bingoCard[c][r]));
            }
            if(c == 3)
            {
               bingoCard[c][r] = g.get(rng.nextInt(15 - r));
               g.remove(g.indexOf(bingoCard[c][r]));
            }
            if(c == 4)
            {
               bingoCard[c][r] = o.get(rng.nextInt(15 - r));
               o.remove(o.indexOf(bingoCard[c][r]));
            }
                        
         }
         
         //Manually set the free space
         bingoCard[2][2] = 0;
      }
      
      //For the print statement, unlike the generator, rows need to be done all at once before moving on
      //So this time, row is the outer loop, and column is the inner loop
      for(int r = 0; r < bingoCard.length; r++)
      {
         for(int c = 0; c < bingoCard.length; c++)
         {
            //I have it print all the values for one row on the line, and then manually force through a new line once the 'c' value refreshes (signalling a new row)
            if(c == 0)
            {
            System.out.print("\n");
            }
            //This if statement makes sure that two spaces are added between a single-digit number and its next-door neighboor, for cosmetic reasons only
            if(bingoCard[c][r] < 10)
            {
               System.out.print(bingoCard[c][r] + "  ");
            }
            else
            {
               System.out.print(bingoCard[c][r] + " ");
            }               
         }  
      }
   }

}