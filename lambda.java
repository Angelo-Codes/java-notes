import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;

public class lambda {

    public static void main(String[] args) {
        List<List<String>> listoflist = Arrays.asList(Arrays.asList("how", "nw"), Arrays.asList("yow", "saw"));
        Set<String> intermediateResult = new HashSet<>();
        List<String> result = listoflist.stream()
        .flatMap(List::stream)
        .filter(s -> s.startWith("n"))
        .map(String::toUpperCase)
        .distinct()
        .sorted()
        .peek(t -> intermediateResult.add(t))
        .collect(Collectors::toList());
    }
}

//collection stream
// = creating streams
// concat() Stream<Integer> variable = Stream.of("A", "c")
// empty() 
// generate()
// iterate()
// of()
// = Intermediate Operations
// filter()
// map()
// flatMap()
// distinct()
// sorted()
// peek()
// limit()
// skip()
// = terminal operations
// forEach()
// forEachOrdered()
// toArray()
// reduce()
// collect()
// min()
// max()
// count()
// anyMatch()
// allMatch()
// noneMatch()
// findFirst()
// findAny()
