import java.util.Stack;
import java.util.*;
class CelebrityProblem{
    public static int celebrity(int mat[][]) {
        // code here
        // the idea is to implement the possible candidate by storing them in a 
        // STACK
        // Conditions to be a celebrity 
        // celeb doesnt know remaining 
        // all others know celeb
                
        Stack <Integer> stack = new Stack<>();
        // Pushing all possible candidates 
        for (int i=0;i<mat.length;i++)
        {
            stack.push(i);
        }
        
        // removing all non eligible candidates
        while (stack.size()>1)
        {
            int i=stack.pop(), j=stack.pop();
            if (mat[i][j]==1 && mat[j][i]==1)
            {
                continue;
            }else if(mat[i][j]==1)
            {
                stack.push(j);
            }else
            {
                stack.push(i);
            }
        }
        // checking if a valid canidate exists
        int celeb =-1;
        if (stack.isEmpty())return celeb;
        // verifying the candidate's eligibility
        int possibleCeleb=stack.pop();
        for (int i=0;i<mat.length;i++)
        {
            if (i!=possibleCeleb && mat[possibleCeleb][i]==1)return celeb;
             if (i!=possibleCeleb && mat[i][possibleCeleb]==0)return celeb;

        }
        return possibleCeleb;
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the count of attendees in the party: ");
        int n =sc.nextInt();
        int[][] mat = new int[n][n];
        for (int i=0;i<n;i++)
        {
            for (int j=0;j<n;j++)
            {
                System.out.print("Enter value at ["+i+"]["+j+"]: ");
                mat[i][j]=sc.nextInt();
            }
        }
        System.out.println(celebrity(mat)==-1?"No celebrity exists":celebrity(mat)+" is the celebrity person");
    }
}