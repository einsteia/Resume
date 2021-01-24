
public class GraphPath {

    public static void cycles(int[][] matrix) {
        int size = matrix.length;
        boolean[] visited = new boolean[size];
        int[] startnode = new int[size];
        for (int i = 0; i < size; i++) {
            for(int j = 0; j < startnode.length; j++) {
                startnode[i] = 0;
            }
            pathEdge(matrix, startnode, visited, i, i, 0, false);
        }
    }
    
    public static void pathEdge(int[][] matrix, int[] startnode, boolean[] visited, int vertex, int n1, int n2,
        boolean finished) {
        if(n1 >= matrix.length || n2 >= matrix.length) {
            return;
        }
        if (finished) {
           System.out.print((vertex + 1));
           middlePath(startnode, vertex, startnode[vertex]);
           System.out.print(" " + (vertex + 1) + "\n");
           return;
        }
        if ((matrix[n1][n2] != 0) && (!visited[n2])) {
            visited[n2] = true;
            startnode[n2] = n1;
            if (vertex == n2) {
                finished = true;
            } else {
                finished = false;
            }
            pathEdge(matrix, startnode, visited, vertex, n2, 0, finished);
            visited[n2] = false;
            startnode[n2] = 0;
            finished = false;
        }
        pathEdge(matrix, startnode, visited, vertex, n1, n2 + 1, finished);
    }
    
    public static void middlePath(int[] startnode, int node, int nextN) {
        if (nextN == node){ 
           return;
       }
        middlePath(startnode, node, startnode[nextN]);
        System.out.print(" " + (nextN + 1));      
    }
    
    
    public static void main(String[] args) {
         int[][] matrix = new int[][] {{0,0,0,0,1,0,0},
                                   {1,0,0,0,0,0,0},
                                   {1,0,0,0,0,0,0},
                                   {0,1,0,0,0,0,0},
                                   {0,1,1,0,0,0,1},
                                   {0,0,1,0,0,0,0},
                                   {0,0,0,1,0,1,0}};
        System.out.println("The cycles for this graph are: ");
        cycles(matrix);
        
    }
    
}
