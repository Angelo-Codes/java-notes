import java.util.List;

public class lambda {

    public static void main(String[] args) {
        List<List<String>> listoflist = List.of(List.of("how", "nw"), List.of("yow", "saw"));

        List<String> result = listoflist.stream()
        .flatMap( z -> z.)
    }
}

//collection stream
// = creating streams
// concat()
// empty()
// generate()
// iterate()
// of()
// = Intermediate Operations
// filter()
// map()
// flatMap()
// distinct()
// sorter()
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
