package strip_comments;

public class Test {
    public static void main(String[] args) {
        System.out.println(StripComments.stripComments("apples, pears # and bananas\ngrapes\nbananas !apples",
                                                       new String[]{"#", "!"}));
    }
}
