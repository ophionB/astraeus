package io.battlerune.util;

import java.util.stream.IntStream;

public class HashUtils {
	
	private static int _hash(String string) {
		return IntStream.range(0, string.length()).reduce(0, (hash, index) -> hash * 61 + string.charAt(index) - 32);
	}
	
	public static int hash(String string) {
		return _hash(string.toUpperCase());
	}

}
