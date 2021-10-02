/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adameinstein
 */
public class FindingCycles {
    public static void cycles(int[][] m) {
        int s = m.length;
        boolean[] visited = new boolean[s];
        int[] sNode = new int[s];
        for (int k = 0; k < s; k++) {
            for(int l = 0; l < sNode.length; l++) {
                sNode[k] = 0;
            }
            pathEdge(m, sNode, visited, k, k, 0, false);
        }
    }
    ////////////////////////////////////////////////////////////
    
    public static void pathEdge(int[][] m, int[] sNode, boolean[] visited, int v, int n1, int n2,
        boolean finished) {
        if(n1 >= m.length || n2 >= m.length) {
            return;
        }
        if (finished) {
           System.out.print((v + 1));
           middlePath(sNode, v, sNode[v]);
           System.out.print(" " + (v + 1) + "\n");
           return;
        }
        if ((m[n1][n2] != 0) && (!visited[n2])) {
            visited[n2] = true;
            sNode[n2] = n1;
            finished = v == n2;
            pathEdge(m, sNode, visited, v, n2, 0, finished);
            visited[n2] = false;
            sNode[n2] = 0;
            finished = false;
        }
        pathEdge(m, sNode, visited, v, n1, n2 + 1, finished);
    }
    
    public static void middlePath(int[] sNode, int node, int next) {
        if (next == node){ 
           return;
       }
        middlePath(sNode, node, sNode[next]);
        System.out.print(" " + (next + 1));      
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

