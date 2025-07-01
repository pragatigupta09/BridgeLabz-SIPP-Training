import java.util.*;
public class longestSmallestWord {
	public static void main(String[] args) {
		String sentence="The girl is really beautiful";
		String[] words = sentence.split("\\s+");
		String shortest=words[0];
		String longest=words[0];
		for(String s:words) {
			if(s.length()<shortest.length()) {
				shortest=s;
			} else if(s.length()>longest.length()) {
				longest=s;
			}
		}
		System.out.println("Shortest word:" + shortest);
		System.out.println("Longest word:" + longest);
	}
	
}