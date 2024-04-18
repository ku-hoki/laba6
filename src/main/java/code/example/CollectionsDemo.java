package code.example;

import java.util.List;

public class CollectionsDemo {
    public static int countStringStartWith(List<String> lines, char startChar) {
        int count = 0;
        for (String str : lines) {
            if (!str.isEmpty() && str.charAt(0) == startChar) {
                count++;
            }
        }
        if (count == 0) {
            throw new IllegalArgumentException("No strings start with the specified character");
        }
        return count;
    }
}
