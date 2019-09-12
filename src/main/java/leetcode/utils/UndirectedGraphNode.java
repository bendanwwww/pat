package leetcode.utils;

import java.util.ArrayList;

/**
 * Definition for undirected graph.
 */
public class UndirectedGraphNode {

    public int label;
    public ArrayList<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }

}
