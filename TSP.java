import java.util.*;

class TSP {
	//int tsp_dp (int c[][MAX], int tour[], int start, int n);
 	static final int MAX = 100;
	int n; /* Number of cities. */
	int[][] c; /* Cost matrix. */
	int[] tour; /* Tour matrix. */
	int cost; /* Least cost. */

	TSP(int n)
	{
		this.n = n;
		c = new int[MAX][MAX];
		tour = new int[MAX];
		cost = 0;
	}

	static int tsp_dp (int c[][], int tour[], int start, int n)
	{
		int i, j, k; /* Loop counters. */
		int[] temp = new int[MAX]; /* Temporary during calculations. */
		int[] mintour = new int[MAX]; /* Minimal tour array. */
		int mincost; /* Minimal cost. */
		int ccost; /* Current cost. */
 
		/* End of recursion condition. */
		if (start == n - 2)
			return c[tour[n-2]][tour[n-1]] + c[tour[n-1]][0];
 
		/* Compute the tour starting from the current city. */
		mincost = 99999;
		for (i = start+1; i<n; i++)
		{ 
			for (j=0; j<n; j++)
				temp[j] = tour[j];
 
				/* Adjust positions. */
			temp[start+1] = tour[i];
			temp[i] = tour[start+1];
 
			/* Found a better cycle? (Recurrence derivable.) */
			if (c[tour[start]][tour[i]] +(ccost = tsp_dp (c, temp, start+1, n)) < mincost) 
			{
				mincost = c[tour[start]][tour[i]] + ccost;
				for (k=0; k<n; k++)
					mintour[k] = temp[k];
			}
		}
 
		/* Set the minimum-tour array. */
		for (i=0; i<n; i++)
			tour[i] = mintour[i];
 
		return mincost;
	}

	public static void main(String[] args)
	{
		int n; /* Number of cities. */
		Scanner s = new Scanner(System.in);
 
		System.out.printf ("This program demonstrates the TSP problem.");
		System.out.printf ("\nHow many cities to traverse? ");
		n = s.nextInt();
		TSP obj = new TSP(n);
		System.out.printf ("Enter the cost matrix: (999: no connection)\n");
		for (int i=0; i<n; i++)
		{
			for (int j=0; j<n; j++)
			{
				obj.c[i][j] = s.nextInt();
			}
 		}
		for (int i=0; i<n; i++)
			obj.tour[i] = i;
 
		obj.cost = tsp_dp (obj.c, obj.tour, 0, n);
 
		System.out.printf ("Minimum cost: %d.\nTour: ", obj.cost);
		for (int i=0; i<n; i++)
			System.out.printf ("%d ", obj.tour[i]+1);
		System.out.printf ("1\n");
	}
} 
