import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.nio.file.Files;

public class Day1 {

    private static final String FILE_NAME = "src/main/resources/Day1Input";
    List<Integer> inputList;

    public Day1() {
        try {
            inputList = Files.lines(Paths.get(FILE_NAME)).map(x -> Integer.valueOf(x)).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int part1(){
        int sum = inputList.stream().mapToInt(x->x).sum();
        return sum;
    }

    public int part2(){
        int sum = 0;
        Set<Integer> valuesAlreadySeen = new HashSet<Integer>();

        while (true){
            for(int i=0,max=inputList.size();i<max;i++){
                sum+=inputList.get(i);
                if(valuesAlreadySeen.contains(Integer.valueOf(sum))){
                    return sum;
                }
                valuesAlreadySeen.add(Integer.valueOf(sum));
            }
        }
    }

}
