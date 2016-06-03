package com.nts.cleancode.collections;

public class Set extends AbstractCollection {
	public void add(Object element) {
		if (readOnly)
			return ;
		
		if (shouldGrow()) 
			grow();
		
		addElement(element);
	}

	private void grow() {
		Object[] newElements =
			new Object[elements.length + INITIAL_CAPACITY];
		for (int i = 0; i < size; i++)
			newElements[i] = elements[i];
		elements = newElements;
	}

	private boolean shouldGrow() {
		return (size + 1) > elements.length;
	}

	private void addElement(Object element) {
		elements[size++] = element;
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
