package com.nts.cleancode.collections;

public abstract class AbstractCollection  {
	protected static int INITIAL_CAPACITY = 10;
	protected Object[] elements = new Object[INITIAL_CAPACITY];
	protected int size = 0;
	
	public void addAll(AbstractCollection c) {
		for (int i=0; i < c.size(); i++) {
			if (!contains(c.get(i))) {
				add(c.get(i));
			}
		}
	}
	
	public abstract void add(Object element);
	public abstract boolean remove(Object element);

	public Object get(int index) {
		return elements[index];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean contains(Object element) {
		for (int i = 0; i < size; i++)
			if (elements[i].equals(element))
				return true;
		return false;
	}

	public int size() {
		return size;
	}
	
}
