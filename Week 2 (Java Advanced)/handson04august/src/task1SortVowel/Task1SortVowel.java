package task1SortVowel;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Task1SortVowel {

	public static void main(String[] args) {

		String s = "hey hello everyone its getting complicated right that's why we should wrap up the tasks given on same day but we rarely stick to it sad";
		System.out.println(sortOnVowels(s));

		System.out.println("\n");

		s = "Hello My name is Rohit";
		System.out.println(sortOnVowels(s));

	}

	public static String sortOnVowels(String s) {

		Map<Integer, String> map = new TreeMap<>(Collections.reverseOrder());
		String ar[] = s.split(" ");
		Arrays.sort(ar, Collections.reverseOrder());
		for (String w : ar) {
			int count = 0;
			char x;
			for (int i = 0; i < w.length(); i++) {
				x = Character.toUpperCase(w.charAt(i));
				if (x == 'A' || x == 'E' || x == 'I' || x == 'O' || x == 'U') {
					count += 1;
				}
			}

			if (map.containsKey(count)) {
				String temp = map.get(count);
				temp = temp + " " + w;
				map.put(count, temp);
			} else {
				map.put(count, w);
			}
		}
		System.out.println("map : " + map);
		StringBuilder sb = new StringBuilder();
		for (Entry<Integer, String> e : map.entrySet()) {
			sb.append(e.getValue()).append(" ");
		}
		return sb.toString().trim();
	}
}