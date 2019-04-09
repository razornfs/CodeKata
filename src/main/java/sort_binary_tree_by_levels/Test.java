package sort_binary_tree_by_levels;

public class Test {
    public static void main(String[] args) {
        System.out.println(Kata.treeByLevels(new Node(new Node(null, new Node(null, null, 4), 2),
                                                      new Node(new Node(null, null, 5), new Node(null, null, 6), 3),
                                                      1)));
        System.out.println(Kata.treeByLevels(null));

    }
}
