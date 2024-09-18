package streaming;

import java.util.ArrayList;
import java.util.Iterator;

public class Streaming_Example {

	public static void main(String[] args) {
		standard_Example();
		stream_Example();
	}
	
	public static void standard_Example() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Vinoth");
		names.add("Aranganambi");
		names.add("Revathi");
		names.add("Elumalai");
		names.add("Vidhya");
		names.add("Selvanayagi");
		
		int count = 0;
		
		for (int i=0; i<names.size(); i++) {
			String actual = names.get(i);
			if (actual.startsWith("V")) {
				System.out.println(names.get(i));
				count++;
			}
			if (actual.startsWith("A")) {
				System.out.println(names.get(i));
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	public static void stream_Example() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Vinoth");
		names.add("Aranganambi");
		names.add("Revathi");
		names.add("Elumalai");
		names.add("Vidhya");
		names.add("Selvanayagi");
		
		long streameCount = names.stream().filter(s->s.startsWith("V")).count();
		System.out.println(streameCount);
		names.stream().filter(s->s.startsWith("V")).sorted().forEach(s->System.out.println(s));
		System.out.println("--------------------------------------");
		names.stream().filter(s->s.contains(s)).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
	}

}
