package leetcode;

import leetcode.utils.UndirectedGraphNode;

/**
 * 题目描述
 *
 * 本题要求复制一个无向图，图中每个节点都包含一个标签和它的邻居列表
 * 我们无向图用以下的方法序列化：
 * 节点的标签是互不相同的，
 * 我们使用“#”作为节点之间的分隔符，使用“,”作为节点标签和节点的节点邻居的分隔符。
 * 例如：现在有一个序列化的无向图{0,1,2#1,2#2,2}.
 * 这个无向图一共有3个节点，因此序列被#分隔成三部分
 * 第一个节点的标签是0，节点0和节点1，节点2之间有边
 * 第二个节点的标签是1，节点1和节点2之间有边
 * 第三个节点的标签是2，节点2和节点2（它自己）之间有边，形成了自环
 * 这个无向图如下图所示
 *        1↵      / ↵     /   ↵    0 --- 2↵         / ↵         \_/↵
 *
 *
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 *
 * OJ's undirected graph serialization:
 * Nodes are labeled uniquely.
 *
 * We use#as a separator for each node, and,as a separator for node label and each neighbor of the node.
 *
 * As an example, consider the serialized graph{0,1,2# 1,2# 2,2}.
 *
 * The graph has a total of three nodes, and therefore contains three parts as separated by#.
 *
 * First node is labeled as 0. Connect node 0 to both nodes1and2.
 * Second node is labeled as1. Connect node1to node2.
 * Third node is labeled as2. Connect node2to node2(itself), thus forming a self-cycle.
 *
 * Visually, the graph looks like the following:
 *
 *        1↵      / ↵     /   ↵    0 --- 2↵         / ↵         \_/↵
 */
public class Solution_18 {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

        return null;
    }
}
