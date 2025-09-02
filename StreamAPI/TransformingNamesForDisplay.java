package StreamAPI;
import java.util.*;
import java.util.stream.Collectors;

public class TransformingNamesForDisplay {
    
    public static void main(String[] args) {
        List<String> customerNames = Arrays.asList("john", "alice", "bob", "carol", "david");
        
        List<String> sortedNames = customerNames.stream()
            .map(String::toUpperCase)
            .sorted()
            .collect(Collectors.toList());
        
        System.out.println("Customer Names (Uppercase, Sorted):");
        sortedNames.forEach(System.out::println);
    }
}