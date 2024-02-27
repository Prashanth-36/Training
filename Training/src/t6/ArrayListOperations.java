package t6;

import java.lang.reflect.Constructor;
import java.util.List;

//import java.util.ArrayList;
import myException.InvalidValueException;
import utility.Utils;

//coding to the interface...

public class ArrayListOperations {

	@SuppressWarnings("unchecked")
	public <E> List<E> getList() throws InvalidValueException {
		try {
			Class<?> arrayListClass = Class.forName("java.util.ArrayList");
			Constructor<?> constructor = arrayListClass.getDeclaredConstructor();
			return (List<E>) constructor.newInstance();
		} catch (Exception e) {
			throw new InvalidValueException("Arraylist instance creation failed.", e);
		}
//		return new ArrayList<E>(); 
	}

	public <E> int size(List<E> al) throws InvalidValueException {
		Utils.checkNull(al);
		return al.size();
	}

	public <E> void add(List<E> al, E element) throws InvalidValueException {
		Utils.checkNull(al);
		al.add(element);
	}

	public <E> void add(List<E> al, int index, E element) throws InvalidValueException {
		Utils.checkRange(0, index, size(al), "Index out of bound");
		al.add(index, element);
	}

	public <E> void addAll(List<E> al, List<E> collection) throws InvalidValueException {
		Utils.checkNull(al);
		Utils.checkNull(collection);
		al.addAll(collection);
	}

	public <E> void remove(List<E> al, int index) throws InvalidValueException {
		Utils.checkNull(al);
		Utils.checkRange(0, index, size(al), "Index out of bound");
		al.remove(index);
	}

	public <E> void removeAll(List<E> al, List<E> collection) throws InvalidValueException {
		Utils.checkNull(al);
		Utils.checkNull(collection);
		al.removeAll(collection);
	}

	public <E> void retainAll(List<E> al, List<E> collection) throws InvalidValueException {
		Utils.checkNull(al);
		Utils.checkNull(collection);
		al.retainAll(collection);
	}

	public <E> int indexOf(List<E> al, E element) throws InvalidValueException {
		Utils.checkNull(al);
		return al.indexOf(element);
	}

	public <E> int lastIndexOf(List<E> al, E element) throws InvalidValueException {
		Utils.checkNull(al);
		return al.lastIndexOf(element);
	}

	public <E> List<E> subList(List<E> al, int from, int to) throws InvalidValueException {
		int size = size(al);
		Utils.checkRange(0, from, size);
		Utils.checkRange(0, to, size);
		if (from > to) {
			throw new InvalidValueException("list from and to index invalid.");
		}
		return al.subList(from, to);
	}

	public <E> void clear(List<E> al) throws InvalidValueException {
		Utils.checkNull(al);
		al.clear();
	}

	public <E> boolean contains(List<E> al, Object object) throws InvalidValueException {
		Utils.checkNull(al);
		return al.contains(object);
	}

	public <E> E get(List<E> al, int index) throws InvalidValueException {
		Utils.checkRange(0, index, size(al), "Index out of bound");
		return al.get(index);
	}
}
