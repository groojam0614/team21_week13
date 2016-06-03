package com.nts.cleancode.collections;

public class Set extends AbstractCollection {
	public void add(Object element) {
		if (readOnly)
			return ;
		
		if (shouldGrow()) 
			grow();
		
		addElement(element);
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
}
