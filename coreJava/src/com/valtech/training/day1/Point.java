package com.valtech.training.day1;

import java.io.Serializable;

public class Point implements Comparable<Point>,Serializable{
	
	//1.constants
	//2.static block
	//3.variables
	//4.constructor
	//5.Methods
	
	public static final Point ORIGIN = new Point();
	
	static {
		//ORIGIN.x = 1000;
		//ORIGIN.y = 2000;
		System.out.println(ORIGIN);
	}
	public int x;
	public transient int y;
	
	public Point() {
		// TODO Auto-generated constructor stub
		System.out.println("Point Method");
	}
	
	public Point(int x,int y) {
		System.out.println("IN ctor of point");
		//super();
		this.x = x;
		this.y = y;
		
		}
	@Override
	public int compareTo(Point o) {
		int res = x - o.x;
		return (x - o.x) == 0 ? (y - o.y): (x - o.x);
	
	}
	
	@Override
	public boolean equals(Object obj) {
		Point p = (Point) obj;
		return p.x == x && p.y == y;
	}
	
	@Override
	public int hashCode() {
		return toString().hashCode();
	}
	
	@Override
	public String toString() {
		return "X = " + "Y = " + y + "distance = " +distance();
	}
	
	public double distance(Point other) {
		System.out.println("Distance with other point");
		return distance(other.x,other.y);
	}
	
	public double distance(int x,int y) {
		int diffx = this.x - x;
		int diffy = this.y -y;
		return Math.sqrt(diffx*diffx + diffy*diffy);
	}
	
	public double distance() {
		System.out.println("Distance in point");
		int diffx = x- ORIGIN.x;
		int diffy = y - ORIGIN.y;
		return Math.sqrt(diffx*diffx + diffy*diffy);
		
	}
	
	public static void main(String[] args) {
		Point p;
		p = new Point();
		
		p.x = 10;
		p.y = 20;
		System.out.println(p);
		//ORIGIN.x = 10;
		System.out.println(p.distance());
		ORIGIN.x = 10;
	}

}
