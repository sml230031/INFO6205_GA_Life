package edu.neu.coe.info6205.life.library;

import java.util.HashMap;
import java.util.Map;

public class Library {

		final public static String Blip = "0 0";

		final public static String Blip2 = "0 0, 1 0";

		final public static String Block = "1 1, 1 2, 2 2, 2 1";

		final public static String Beehive = "1 2, 2 1, 3 1, 4 2, 3 3, 2 3";

		final public static String Loaf = "1 3, 2 4, 3 4, 4 3, 4 2, 3 1, 2 2";

		final public static String Blinker = "0 -1, 0 0, 0 1";

		final public static String Glider1 = "0 0, 1 0, 2 0, 2 -1, 1 -2";

		final public static String Glider2 = "2 0, 1 0, 0 0, 0 -1, 1 -2";

		final public static String Glider3 = "0 0, 1 0, 2 0, 2 1, 1 2";

     	final public static String Mine =  "0 0, 0 1, 0 2, 1 1, 2 2";

	    final public static String Mine2 =  "0 0, 0 1, 0 2, 2 1, 1 2, 2 2";

	    final public static String Butterfly =  "0 0,0 1,1 1,1 2,2 0,2 1";

		final public static Map<String, String> map = new HashMap<>();

		public static String get(String key) {
				return map.get(key.toLowerCase());
		}

		public static String put(String key, String value) {
				return map.put(key.toLowerCase(), value);
		}

		static {
				put("Blip", Blip);
				put("Blip2", Blip2);
				put("Block", Block);
				put("Beehive", Beehive);
				put("Loaf", Loaf);
				put("Blinker", Blinker);
				put("Glider1", Glider1);
				put("Glider2", Glider2);
				put("Glider3", Glider3);
			    put("Mine", Mine);
			    put("Mine2", Mine2);
			    put("Butterfly",Butterfly);
			    put("20","0 0,0 1,0 3,0 4,0 5,0 6,0 7,0 8,0 12,0 15,0 17,0 18,0 19,1 1,1 5,1 7,1 8,1 9,1 10,1 11,1 13,1 15,1 16,2 1,2 2,2 7,2 8,2 11,2 15,2 16,2 19,3 1,3 2,3 3,3 8,3 9,3 10,3 11,3 15,3 16,3 17,4 0,4 6,4 12,4 13,4 15,4 16,4 19,5 0,5 1,5 2,5 3,5 6,5 8,5 9,5 10,5 13,5 16,5 17,5 18,5 19,6 0,6 6,6 7,6 11,6 12,6 14,6 15,6 16,6 17,6 18,6 19,7 5,7 8,7 11,7 13,7 14,7 15,7 16,7 17,7 18,8 1,8 6,8 7,8 9,8 11,8 14,8 15,8 16,8 17,9 6,9 7,9 9,9 10,9 11,9 12,9 13,9 14,9 16,9 18,10 1,10 7,10 9,10 15,10 16,10 17,10 18,10 19,11 0,11 9,11 11,11 12,11 15,11 18,11 19,12 0,12 4,12 5,12 7,12 9,12 11,12 12,12 14,12 16,12 19,13 1,13 2,13 4,13 8,13 14,13 15,13 19,14 1,14 4,14 5,14 6,14 10,14 11,14 12,14 13,14 16,14 17,14 18,14 19,15 0,15 3,15 5,15 8,15 9,15 16,15 17,15 18,15 19,16 0,16 1,16 4,16 5,16 15,16 16,16 17,16 19,17 6,17 7,17 10,17 11,17 15,17 16,17 18,18 0,18 4,18 5,18 6,18 7,18 9,18 11,18 13,18 15,18 16,18 18,19 0,19 4,19 5,19 7,19 11,19 16,19 18,19 19,");
		}
}
