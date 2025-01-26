import java.io.*;
import java.util.*;

public class p5639 {
    static class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
        }
    }

    static Node buildTree(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }

        Node root = new Node(preorder[start]);
        int splitIndex = start + 1;

        // Find the first index where the value is greater than the root
        while (splitIndex <= end && preorder[splitIndex] < root.key) {
            splitIndex++;
        }

        // Recursively build left and right subtrees
        root.left = buildTree(preorder, start + 1, splitIndex - 1);
        root.right = buildTree(preorder, splitIndex, end);

        return root;
    }

    static void postOrder(Node root)  {
        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);

        System.out.println(root.key);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> inputList = new ArrayList<>();
        String line;

        while ((line = reader.readLine()) != null && !line.isEmpty()) {
            inputList.add(Integer.parseInt(line));
        }

        int[] preorder = inputList.stream().mapToInt(Integer::intValue).toArray();

        Node root = buildTree(preorder, 0, preorder.length - 1);

        postOrder(root);
    }
}