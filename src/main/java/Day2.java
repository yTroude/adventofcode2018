import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day2 {
    private static final String FILE_NAME = "src/main/resources/Day2Input";
    List<String> inputList;

    public Day2() {
        try {
            inputList = Files.lines(Paths.get(FILE_NAME)).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int part1() {
        int twoCount=0,threeCount=0;
        for(String line :inputList) {
            HashMap<Character, Integer> counts = new HashMap<>();
            line.chars()
                .mapToObj(c->(char)c)
                .forEach(c-> {
                    if (counts.containsKey(c)) counts.compute(c, (key, val) -> val + 1);
                    else counts.put(c, 1);
                });
            if (counts.containsValue(Integer.valueOf(2))) twoCount++;
            if (counts.containsValue(Integer.valueOf(3))) threeCount++;
        }
        return twoCount*threeCount;
    }

    public String part2(){
        int strLen = inputList.get(0).length();
        for(int strIndex1=0,maxIndex=inputList.size();strIndex1<maxIndex;strIndex1++){
            String str1 = inputList.get(strIndex1);
            for(int strIndex2=strIndex1+1;strIndex2<maxIndex;strIndex2++){
                String str2 = inputList.get(strIndex2);
                String commonChars="";
                int diffCount=0;
                for(int charIndex = 0;charIndex<strLen;charIndex++){
                    if (str1.charAt(charIndex)!=str2.charAt(charIndex)){
                        diffCount++;
                        if (diffCount==2){
                            break;
                        }
                    }
                    else {
                        commonChars+=str1.charAt(charIndex);
                    }
                }
                if (diffCount==1){
                    return commonChars;
                }

            }
        }
        return "";
    }

}