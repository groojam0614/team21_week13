package com.nts.cleancode.collections;

public class List extends AbstractCollection {
	public void add(Object element) {
		if (readOnly) {
			return;
		}
		if (shouldGrow()) {
			grow();
		}
		addElement(element);
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
}
