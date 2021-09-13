package dijkstra;

/*Name: Maria Jane Wehbe
* Last Modification: May 6, 2021
*/

public class Dijkstra {
	
	public static void dijkstra(int[][] graph, int s)
	{
		int length = graph.length;
		boolean isVisited[] = new boolean[length];
		int d[] = new int[length];
		
		for(int i=0; i<length; i++)
		{
			isVisited[i] = false;
			d[i] = Integer.MAX_VALUE;
		}
		
		d[s] = 0;
		for(int i=0; i<length; i++)
		{
			int u = minKey(d, isVisited);
			isVisited[u] = true;
			
			for(int j=0; j<length; j++)
			{
				if(isVisited[j] == false && graph[u][j] != 0 && (d[u] + graph[u][j] < d[j]))
					d[j] = d[u] + graph[u][j];
			}
			
		}
		for (int i = 0; i < d.length; i++)
			System.out.println("Distance from " + s + " to " + i + " is " + d[i]);
	}
	
	public static int minKey(int[] d, boolean[] isVisited)
	{
		int min = Integer.MAX_VALUE;
		int minVertex = -99;
		for(int i=0; i<d.length; i++)
		{
			if(isVisited[i] == false && d[i] < min)
			{
				min = d[i];
				minVertex = i;
			}
		}
		return minVertex;
	}

	public static void main(String[] args)
	{
		int graph[][] = {{0, 10, 5, 0, 0},
				{0, 0, 2, 1, 0},
				{0, 3, 0, 9, 2},
				{0, 0, 0, 0, 4},
				{7, 0, 0, 6, 0}};
		dijkstra(graph, 0);
	}
	
}
