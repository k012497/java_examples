package chapter15.step15;

import java.util.ArrayList;
import java.util.List;

public class RandomListTest {

	public static void main(String[] args) {
		RandomList r = new RandomList();
		
		r.add(1);
		r.add(10);
		r.add(100);
		
		System.out.println(r.select());
		System.out.println(r.select());
		System.out.println(r.select());

	}
}
