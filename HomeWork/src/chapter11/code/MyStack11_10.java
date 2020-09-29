package chapter11.code;

import java.util.ArrayList;

public class MyStack11_10 {
	private ArrayList<Object> list = new ArrayList<Object>();
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public int getSize() {
		return list.size();
	}
	
	public Object peek() {
		return list.get(getSize() - 1);
	}
	
	public Object pop() {
		Object object = list.get(getSize() - 1);
		list.remove(getSize() - 1);
		return object;
	}
	
	public void push(Object object) {
		list.add(object);
	}
	
	@Override
	public String toString() {
		return "stack: " + list.toString();
	}
	
}
