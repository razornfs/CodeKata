package strip_comments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StripComments {

    public static String stripComments(String text, String[] commentSymbols) {
        String[] lines = text.split("\\n");
        List<String> ret = new ArrayList<>();
        for (String line : lines) {
            StringBuilder stringBuilder = new StringBuilder();
            for (char c : line.toCharArray()) {
                if (Arrays.asList(commentSymbols).contains(Character.toString(c))) {
                    break;
                }
                stringBuilder.append(c);
            }
            ret.add(stringBuilder.toString().trim());
        }
        return String.join("\\n", ret);
    }

}
