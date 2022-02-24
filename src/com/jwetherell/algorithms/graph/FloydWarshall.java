package com.jwetherell.algorithms.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jwetherell.algorithms.data_structures.Graph;

/**
 * Floyd–Warshall algorithm is a graph analysis algorithm for finding shortest
 * paths in a weighted graph (with positive or negative edge weights).
 * <p>
 * Worst case: O(V^3)
 * <p>
 * @see <a href="https://en.wikipedia.org/wiki/Floyd%E2%80%93Warshall_algorithm">Floyd-Warshall Algorithm (Wikipedia)</a>
 * <br>
 * @author Justin Wetherell <phishman3579@gmail.com>
 */
public class FloydWarshall {
    static boolean[] reachedBranch = new boolean[100];

    static void BRANCH(int index) {
            if (!reachedBranch[index]) {
                reachedBranch[index] = true;
                System.out.println("--------------");
                System.out.println("FloydWarshall.getAllPairsShortestPaths\n");
                for (int i = 0; i < reachedBranch.length; i++) {
                    if (reachedBranch[i]) {
                        System.out.println("REACHED BRANCH #" + i);
                    }
                }
            }
        }

    private FloydWarshall() { }

    public static Map<Graph.Vertex<Integer>, Map<Graph.Vertex<Integer>, Integer>> getAllPairsShortestPaths(Graph<Integer> graph) {
        if (graph == null){
            BRANCH(0);
            throw (new NullPointerException("Graph must be non-NULL."));
        }
        else{
            BRANCH(1);
        }
        final List<Graph.Vertex<Integer>> vertices = graph.getVertices();

        final int[][] sums = new int[vertices.size()][vertices.size()];
        for (int i = 0; i < sums.length; i++) {
            BRANCH(2);
            for (int j = 0; j < sums[i].length; j++) {
                BRANCH(3);
                sums[i][j] = Integer.MAX_VALUE;
            }
        }

        final List<Graph.Edge<Integer>> edges = graph.getEdges();
        for (Graph.Edge<Integer> e : edges) {
            BRANCH(4);
            final int indexOfFrom = vertices.indexOf(e.getFromVertex());
            final int indexOfTo = vertices.indexOf(e.getToVertex());
            sums[indexOfFrom][indexOfTo] = e.getCost();
        }

        for (int k = 0; k < vertices.size(); k++) {
            BRANCH(5);
            for (int i = 0; i < vertices.size(); i++) {
                BRANCH(6);
                for (int j = 0; j < vertices.size(); j++) {
                    BRANCH(7);
                    if (i == j) {
                        BRANCH(8);
                        sums[i][j] = 0;
                    } else {
                        BRANCH(9);
                        final int ijCost = sums[i][j];
                        final int ikCost = sums[i][k];
                        final int kjCost = sums[k][j];
                        final int summed = (ikCost != Integer.MAX_VALUE && 
                                            kjCost != Integer.MAX_VALUE) ? 
                                                   (ikCost + kjCost)
                                               : 
                                                   Integer.MAX_VALUE;
                        if (ijCost > summed){
                            BRANCH(10);
                            sums[i][j] = summed;
                        }
                        else{
                            BRANCH(11);

                        }
                            
                    }
                }
            }
        }

        final Map<Graph.Vertex<Integer>, Map<Graph.Vertex<Integer>, Integer>> allShortestPaths = new HashMap<Graph.Vertex<Integer>, Map<Graph.Vertex<Integer>, Integer>>();
        for (int i = 0; i < sums.length; i++) {
            BRANCH(12);
            for (int j = 0; j < sums[i].length; j++) {
                BRANCH(13);
                final Graph.Vertex<Integer> from = vertices.get(i);
                final Graph.Vertex<Integer> to = vertices.get(j);

                Map<Graph.Vertex<Integer>, Integer> map = allShortestPaths.get(from);
                if (map == null){
                    BRANCH(14);
                    map = new HashMap<Graph.Vertex<Integer>, Integer>();
                }
                else{
                    BRANCH(15);
                }  
                final int cost = sums[i][j];
                if (cost != Integer.MAX_VALUE){
                    BRANCH(16);
                    map.put(to, cost);
                }
                else{
                    BRANCH(17);
                }
                    
                allShortestPaths.put(from, map);
            }
        }
        return allShortestPaths;
    }
}