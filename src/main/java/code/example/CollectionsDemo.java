package code.example;

import java.util.List;

public class CollectionsDemo {
    public static int countStringStartWith(List<String> lines, char startChar){
        int count = 0;
        for(int i = 0; i < lines.size(); i++){
            String str = lines.get(i);
            if(!str.isEmpty() && str.charAt(0) == startChar){
                count++;
            }
        }
        return count;
    }
}
