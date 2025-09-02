package StreamAPI;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class FilteringExpiringMemberships {
    
    static class Member {
        private String name;
        private LocalDate expiryDate;
        
        public Member(String name, LocalDate expiryDate) {
            this.name = name;
            this.expiryDate = expiryDate;
        }
        
        public LocalDate getExpiryDate() { return expiryDate; }
        public String getName() { return name; }
    }
    
    public static void main(String[] args) {
        List<Member> members = Arrays.asList(
            new Member("John", LocalDate.now().plusDays(15)),
            new Member("Alice", LocalDate.now().plusDays(45)),
            new Member("Bob", LocalDate.now().plusDays(5)),
            new Member("Carol", LocalDate.now().plusDays(60))
        );
        
        LocalDate today = LocalDate.now();
        List<Member> expiringMembers = members.stream()
            .filter(m -> m.getExpiryDate().isBefore(today.plusDays(30)))
            .collect(Collectors.toList());
        
        System.out.println("Members with expiring memberships (within 30 days):");
        expiringMembers.forEach(m -> System.out.println(m.getName() + " - Expires: " + m.getExpiryDate()));
    }
}