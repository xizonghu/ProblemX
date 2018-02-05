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

	public static int getMaxValue(TreeNode node) {
		if (node == null) return 0;
		int max;
		max = Integer.max(node.value, getMaxValue(node.left));
		max = Integer.max(max, getMaxValue(node.right));
		return max;
	}

	public static int getMinValue(TreeNode node) {
		if (node == null) return 0;
		int min;
		min = Integer.min(node.value, getMaxValue(node.left));
		min = Integer.min(min, getMaxValue(node.right));
		return min;
	}

	public static boolean isValidBST(TreeNode root) {
		if (root == null) return true;

		if (root.left != null && getMaxValue(root.left) >= root.value)  return false;
		if (root.right != null && getMinValue(root.right) <= root.value)  return false;
		return isValidBST(root.left) && isValidBST(root.right);
	}

	public static void main(String[] args) {
		TreeNode one = new TreeNode(1, null, null);
		TreeNode two = new TreeNode(2, one, null);
		TreeNode four = new TreeNode(4, null, null);
		TreeNode three = new TreeNode(3, two, four);
		TreeNode seven = new TreeNode(4, null, null);
		TreeNode nine = new TreeNode(9, null, null);
		TreeNode eight = new TreeNode(8, seven, nine);
		TreeNode five = new TreeNode(5, three, eight);

		System.out.printf("isValidBST = %b\n", isValidBST(five));
	}
}
