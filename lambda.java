import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class lambda {

    public static void main(String[] args) {
        // sample one
        /*List<List<String>> listoflist = Arrays.asList(
            Arrays.asList("how", "nw"),
            Arrays.asList("yow", "saw")
        );

        Set<String> intermediateResult = new HashSet<>();

        List<String> result = listoflist
            .stream()
            .flatMap(List::stream)
            .filter(s -> s.startsWith("n"))
            .map(String::toUpperCase)
            .distinct()
            .sorted()
            .peek(t -> intermediateResult.add(t))
            .collect(Collectors.toList());

        intermediateResult.forEach(System.out::println)*/

        //sample two
        /*var number = Arrays.asList(1, 2, 3, 4);

        number
            .stream()
            .map(lambda::addten)
            .filter(lambda::evenNumber)
            .forEach(System.out::println);*/

        Stream.iterate(10, n -> n + 10)
            .limit(10)
            .forEach(System.out::println);
    }
    // for sample number two
    /*public static int addten(int n) {
        return n + 10;
    }

    public static boolean evenNumber(int n) {
        return n % 2 == 0;
    }*/
}

//collection stream
//
// = creating streams
// concat() Stream<Integer> streamsIntoOneCombined = Stream.concat(streamOne, streamTwo)
// empty() Stream<Integer> numberstream = Stream.empty(); returning optional stream
// generate() Stream<Integer> infiniteStreamGenerateOnDemand = Stream.generate(Math::random); should it limit if possible
// iterate() Stream<Integer> infiniteStreamBasedOnSeedValueComputeNextValue = Stream.iterate(0, n -> n + 2);
// of() Stream<Integer> valueyouDirectPass = Stream.of(1, 2, 3, 5, 6)
//
// = Intermediate Operations
// filter()
// map()
// flatMap()
// distinct()
// sorted()
// peek()
// limit()
// skip()
//
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
