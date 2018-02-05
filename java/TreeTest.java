package com.antengine.armchair.test;

public class TreeTest {

	public static class TreeNode {
		public TreeNode left;
		public TreeNode right;
		public int value;
		public TreeNode(int value, TreeNode left, TreeNode right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
	public static boolean isValidBST(TreeNode node) {
		if (node == null) return true;

		if (node.left != null && node.left.value >= node.value)  return false;
		if (node.right != null && node.right.value <= node.value)  return false;
		return isValidBST(node.left) && isValidBST(node.right);
	}

	public static void main(String[] args) {
		TreeNode one = new TreeNode(1, null, null);
		TreeNode two = new TreeNode(2, one, null);
		TreeNode four = new TreeNode(4, null, null);
		TreeNode three = new TreeNode(3, two, four);
		TreeNode seven = new TreeNode(7, null, null);
		TreeNode nine = new TreeNode(6, null, null);
		TreeNode eight = new TreeNode(8, seven, nine);
		TreeNode five = new TreeNode(5, three, eight);

		System.out.printf("isValidBST = %b\n", isValidBST(five));
	}
}
