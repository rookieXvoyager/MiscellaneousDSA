import java.util.*;
public class KnightProbabilityInChessboard {
      public static double knightProbability(int n, int k, int row, int column) {
        // The idea is to use two dp arrays - curr and next
        // the curr would store the curr probabilities whereas next 'd store ps after changes
        double [][] curr = new double [n][n];
        int [] dx ={2,-2,1,-1,2,-2,1,-1};
        int [] dy={1,1,2,2,-1,-1,-2,-2};
        curr[row][column]=1.00;

        for ( int moves=0;moves<k;moves++)
        {
            double [][] next = new double[n][n];
            // keep updating for new moves 
            for(int i =0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                     if (curr[i][j]>0)
                        {
                    for (int m=0;m<8;m++)
                    {
                       
                            int nx =dx[m]+i;
                            int ny=dy[m]+j;

                            if((nx>=0 && nx<n) && (ny>=0 && ny<n))
                            {
                                next[nx][ny]+=curr[i][j]/8.0;
                            }
                        }
                    }
                }
            }
            curr=next;
        }

        double sum=0;
        for (double []rows:curr)
            for (double el:rows)
                sum+=el;

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of an array(n):");
        int n =sc.nextInt();
        System.out.println("Enter the no. of moves:");
        int k =sc.nextInt();
        System.out.println("Enter the postion as row column:");
        int row =sc.nextInt(), col=sc.nextInt();
        System.out.println("The probability of knight staying in the board is: "+knightProbability(n, k, row, col)  );
        
    }
}
