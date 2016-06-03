package com.nts.cleancode.collections;

public abstract class AbstractCollection  {
	protected static int INITIAL_CAPACITY = 10;
	protected Object[] elements = new Object[INITIAL_CAPACITY];
	protected int size = 0;
	protected boolean readOnly;
	
	public void addAll(AbstractCollection c) {
		for (int i=0; i < c.size(); i++) {
			if (!contains(c.get(i))) {
				add(c.get(i));
			}
		}
	}
	
	public abstract void add(Object element);
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

	public boolean remove(Object element) {
		if (readOnly)
			return false;
		for (int i = 0; i < size; i++)
			if (elements[i].equals(element)) {
				removeElementAt(i);
				return true;
			}
		return false;
	}

	private void removeElementAt(int i) {
		elements[i] = null;
		Object[] newElements = new Object[size - 1];
		int k = 0;
		for (int j = 0; j < size; j++) {
			if (elements[j] != null)
				newElements[k++] = elements[j];
		}
		size--;
		elements = newElements;
	}
	
}
