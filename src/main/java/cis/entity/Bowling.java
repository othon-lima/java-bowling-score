package cis.entity;
import cis.util.CisUtility;

/**
 * Represents a bowling game
 * @author Othon Lima
 * @since  Jan 26, 2022
 */
public class Bowling 
{
    public static final int PLAYER_COUNT = 4;
    public static final int END_COUNT = 10;
    
    private String[] players = new String[PLAYER_COUNT];
    private int[][] scores = new int[PLAYER_COUNT][END_COUNT];
    private int[] scoresTotal = new int[PLAYER_COUNT];
    
    //Constructor
    public Bowling()
    {
    }  
    
    /**
     * Asks user for players name
     * @since 20220127
     * @author OOL
     */
    public void addPlayers()
    {
        for (int i = 0; i < PLAYER_COUNT; i++)
        {
            int playerNumber = i + 1;
            players[i] = CisUtility.getInputString("Enter name for player #" + playerNumber);
        }
    }
    
    /**
     * Asks users to enter end scores. It asks each individual player, then 
     * moves to the next end until all scores are entered.
     * @since 20220127
     * @author OOL
     */
    public void addScores()
    {
        for (int endIndex = 0; endIndex < END_COUNT; endIndex++)
        {
            for (int playerIndex = 0; playerIndex < PLAYER_COUNT; playerIndex++)
            {
                scores[playerIndex][endIndex] = CisUtility.getInputInt("Enter score for " + players[playerIndex] + " -->");
                scoresTotal[playerIndex] += scores[playerIndex][endIndex];
                display();
            }
        }        
    }
    
    /**
     * Picks and announces the winner according to total score
     * @since 20220128
     * @author OOL
     */
    public void announceWinner()
    {
        int winnerIndex = 0;
        int highestScore = scoresTotal[0];
        
        for (int playerIndex = 1; playerIndex < PLAYER_COUNT; playerIndex++)
        {
            if (scoresTotal[playerIndex] > highestScore)
            {
                highestScore = scoresTotal[playerIndex];
                winnerIndex = playerIndex;
            }
        }
 
        System.out.println("Congratulations " + players[winnerIndex] + "!");
    }
    
    //Getters and Setters
    public String[] getPlayers()
    {
        return players;
    }

    public void setPlayers(String[] players)
    {
        this.players = players;
    }

    public int[][] getScores()
    {
        return scores;
    }

    public void setScores(int[][] scores)
    {
        this.scores = scores;
    }

    public int[] getScoresTotal()
    {
        return scoresTotal;
    }

    public void setScoresTotal(int[] scoresTotal)
    {
        this.scoresTotal = scoresTotal;
    }
    
    //Displays score table
    public void display()
    {
        System.out.println("\nCurrent Score");
        
        for (int playerIndex = 0; playerIndex < PLAYER_COUNT; playerIndex++)
        {            
            System.out.format("%-10s", players[playerIndex]);
            
            for (int endIndex = 0; endIndex < END_COUNT; endIndex++)
            {
                    System.out.format("%4s", scores[playerIndex][endIndex]);
            }
            
            System.out.print("  | ");
            System.out.format("%-3d", scoresTotal[playerIndex]);
            System.out.println("");
        }      
    }

    
    
    
}
