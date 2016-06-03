package com.nts.cleancode.collections;

public class List extends AbstractCollection {
	public void add(Object element) {
		if (readOnly) {
			return;
		}
		if (shoudlGrow()) {
			grow();
		}
		addElement(element);
	}

	private boolean shoudlGrow() {
		return (size + 1) > elements.length;
	}

	private void grow() {
		Object[] newElements =
			new Object[elements.length + 10];
		for (int i = 0; i < size; i++)
			newElements[i] = elements[i];
		elements = newElements;
	}

	private void addElement(Object element) {
		elements[size++] = element;
	}

	public int capacity() {
		return elements.length;
	}

	public void set(int i, Object value) {
		if (!readOnly) {
			if (i >= size)
				throw new ArrayIndexOutOfBoundsException();
			elements[i] = value;
		}
	}

	public void setReadOnly(boolean b) {
		readOnly = b;
	}
}
