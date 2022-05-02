package com.greatlearning.sumofpair;

import java.util.HashSet;

public class SumofPairBST {

	public static void main(String[] args) {
		SumofPairBST obbBst = new SumofPairBST();
		Node rootNode = null;
		rootNode = obbBst.insert(rootNode, 40);
		rootNode = obbBst.insert(rootNode, 20);
		rootNode = obbBst.insert(rootNode, 60);
		rootNode = obbBst.insert(rootNode, 10);
		rootNode = obbBst.insert(rootNode, 30);
		rootNode = obbBst.insert(rootNode, 50);
		rootNode = obbBst.insert(rootNode, 70);
		int inputSum = 130;
		obbBst.findPairWithGivenSum(rootNode, inputSum);

	}

	static class Node {
		int nodeData;
		Node leftNode, rightNode;

	};

	static Node newNode(int nodeData) {
		Node temp = new Node();
		temp.nodeData = nodeData;
		temp.leftNode = null;
		temp.rightNode = null;
		return temp;
	}

	public Node insert(Node root, int key) {
		if (root == null) {
			return newNode(key);
		}
		if (key < root.nodeData) {
			root.leftNode = insert(root.leftNode, key);
		} else {
			root.rightNode = insert(root.rightNode, key);
		}

		return root;

	}

	public boolean findPair(Node root, int sum, HashSet<Integer> set) {

		if (root == null) {
			return false;
		}
		if (findPair(root.leftNode, sum, set)) {
			return true;
		}
		if (set.contains(sum - root.nodeData)) {
			System.out.println("\n pair is found:(" + (sum - root.nodeData) + "," + root.nodeData + ")");
			return true;
		} else {
			set.add(root.nodeData);
		}
		return findPair(root.rightNode, sum, set);
	}

	public void findPairWithGivenSum(Node root, int sum) {
		HashSet<Integer> obj = new HashSet<Integer>();
		if (!findPair(root, sum, obj)) {
			System.out.println("pair does not exist!");
		}
	}

}
