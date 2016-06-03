package com.nts.cleancode.collections;

public class Set extends AbstractCollection {
	private boolean readOnly;

	public void add(Object element) {
		if (!readOnly) {
			int newSize = size + 1;
			if (newSize > elements.length) {
				Object[] newElements =
					new Object[elements.length + INITIAL_CAPACITY];
				for (int i = 0; i < size; i++)
					newElements[i] = elements[i];
				elements = newElements;
			}

			if (contains(element))
				return;
			elements[size++] = element;
		}
	}

	public boolean remove(Object element) {
		if (readOnly)
			return false;
		for (int i = 0; i < size; i++)
			if (elements[i].equals(element)) {
				elements[i] = null;
				Object[] newElements = new Object[size - 1];
				int k = 0;
				for (int j = 0; j < size; j++) {
					if (elements[j] != null)
						newElements[k++] = elements[j];
				}
				size--;
				elements = newElements;
				return true;
			}
		return false;
	}

	public void addAll(AbstractCollection l) {
		for (int i = 0; i < l.size(); i++) {
			if (!contains(l.get(i)))
				elements[size++] = l.get(i);
		}
	}

	public int capacity() {
		return elements.length;
	}

	public void setReadOnly(boolean b) {
		readOnly = b;
	}
}
