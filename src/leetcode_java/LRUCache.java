package leetcode_java;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LRUCache {

	LinkedHashSet<Integer> visitQueue;

	HashMap<Integer, Integer> cache;

	int capacity;

	public LRUCache(int capacity) {
		this.cache = new HashMap<Integer, Integer>(capacity);
		this.visitQueue = new LinkedHashSet<>();
		this.capacity = capacity;
	}

	public int get(int key) {
		Integer value = this.cache.get(key);
		if (value != null) {
			this.visitQueue.remove(Integer.valueOf(key));
			this.visitQueue.add(key);
			return value;
		}
		return -1;
	}

	public void set(int key, int value) {
		if (this.cache.get(key) == null && this.capacity == this.cache.size()) {
			Integer toRemove = this.visitQueue.iterator().next();
			this.cache.remove(toRemove);
			this.visitQueue.remove(toRemove);
		}
		this.cache.put(key, value);
		this.visitQueue.remove(Integer.valueOf(key));
		this.visitQueue.add(key);
	}
}