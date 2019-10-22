package tree;

import java.util.*;

public class RedundantConnection {
	public int[] findRedundantConnection(int[][] edges) {
		if (edges.length == 0)
			return new int[0];

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		int n = 0;
		for (int[] edge : edges) {
			n = Math.max(n, edge[1]);
		}

		for (int i = 0; i <= n; ++i) {
			graph.add(new ArrayList<Integer>());
		}

		for (int[] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
		}

		HashSet<Integer> set = new HashSet<>();
		int[] rv = new int[2];
		dfs(graph, edges[edges.length-1][0], set, rv);
		return rv;
	}

	public void dfs(ArrayList<ArrayList<Integer>> graph, int src, HashSet<Integer> set, int[] rv) {
		set.add(src);
		for (int dest : graph.get(src)) {
			if (set.contains(dest)) {
				rv[0] = src;
				rv[1] = dest;
			} else {
				dfs(graph, dest, set, rv);
			}
		}
	}
}
