package cn.herculas.leetCode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int label) {
        this.label = label;
        this.neighbors = new ArrayList<>();
    }
}

public class CloneGraph_133 {

    private Map<Integer, UndirectedGraphNode> visited = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return this.dfs(node);
    }

    private UndirectedGraphNode dfs(UndirectedGraphNode node) {
        if (node == null)
            return null;

        if (visited.containsKey(node.label))
            return visited.get(node.label);

        UndirectedGraphNode clonedNode = new UndirectedGraphNode(node.label);
        visited.put(clonedNode.label, clonedNode);

        for (UndirectedGraphNode near : node.neighbors) {
            clonedNode.neighbors.add(this.dfs(near));
        }

        return clonedNode;
    }

    public static void main(String[] args) {
        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);
        UndirectedGraphNode node0 = new UndirectedGraphNode(0);

        node1.neighbors.add(node0);
        node1.neighbors.add(node2);

        node1.neighbors.add(node0);
        node1.neighbors.add(node2);

        node2.neighbors.add(node0);
        node2.neighbors.add(node1);
        node2.neighbors.add(node2);

        CloneGraph_133 cloneGraph_133 = new CloneGraph_133();
        UndirectedGraphNode newNode = cloneGraph_133.cloneGraph(node0);
    }
}
