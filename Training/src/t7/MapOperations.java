package t7;

import java.lang.reflect.Constructor;
//import java.util.HashMap;
import java.util.Map;

import myException.InvalidValueException;
import utility.Utils;

public class MapOperations {

	@SuppressWarnings("unchecked")
	public <K, V> Map<K, V> getMap() throws InvalidValueException {
		try {
			Class<?> map = Class.forName("java.util.HashMap");
			Constructor<?> constructor = map.getDeclaredConstructor();
			return (Map<K, V>) constructor.newInstance();
		} catch (Exception e) {
			throw new InvalidValueException("map instance creation failed", e);
		}
//		return new HashMap<>();
	}

	public <K, V> int size(Map<K, V> map) throws InvalidValueException {
		Utils.checkNull(map);
		return map.size();
	}

	public <K, V> void put(Map<K, V> map, K key, V value) throws InvalidValueException {
		Utils.checkNull(map);
		map.put(key, value);
	}

	public <K, V> void putAll(Map<K, V> map, Map<K, V> source) throws InvalidValueException {
		Utils.checkNull(map);
		Utils.checkNull(source);
		map.putAll(source);
	}

	public <K, V> boolean containsKey(Map<K, V> map, K key) throws InvalidValueException {
		Utils.checkNull(map);
		return map.containsKey(key);
	}

	public <K, V> boolean containsValue(Map<K, V> map, V value) throws InvalidValueException {
		Utils.checkNull(map);
		return map.containsValue(value);
	}

	public <K, V> void replace(Map<K, V> map, K key, V value) throws InvalidValueException {
		Utils.checkNull(map);
		map.replace(key, value);
	}

	public <K, V> void replace(Map<K, V> map, K key, V oldValue, V newValue) throws InvalidValueException {
		Utils.checkNull(map);
		map.replace(key, oldValue, newValue);
	}

	public <K, V> V get(Map<K, V> map, K key) throws InvalidValueException {
		Utils.checkNull(map);
		return map.get(key);
	}

	public <K, V> void remove(Map<K, V> map, K key) throws InvalidValueException {
		Utils.checkNull(map);
		map.remove(key);
	}

	public <K, V> void remove(Map<K, V> map, K key, V value) throws InvalidValueException {
		Utils.checkNull(map);
		map.remove(key, value);
	}

	public <K, V> void clear(Map<K, V> map) throws InvalidValueException {
		Utils.checkNull(map);
		map.clear();
	}

	public <K, V> V getOrDefault(Map<K, V> map, K key, V defaultValue) throws InvalidValueException {
		Utils.checkNull(map);
		return map.getOrDefault(key, defaultValue);
	}

}
