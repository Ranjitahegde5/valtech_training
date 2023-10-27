//package com.valtech.training.day4;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//
//import com.valtech.training.day1.Point;
//
//public class SerialTest {
//
//	public static void main(String[] args)throws Exception {
//		Point p = new Point(2,3);
//		System.out.println(p);
//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("Objects")));
//		oos.writeObject(p);
//		oos.flush();
//		oos.close();
//		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("Objects")));
//		Point p1 = (Point) ois.readObject();
//		System.out.println(p1);
//		System.out.println(p == p1);
//
//	}
//
//}


//create table employee(
//	    -> name varchar(20),
//	    -> age int,
//	    -> experience int,
//	    -> seniority int,
//	    -> salary int);


//insert into employee (name,age,experience,seniority,salary) values('Abc',23,1,1,20000);

//insert into employee(name,age,experience,seniority,salary) values ('DEF',32,12,3,50000);
package com.valtech.training.day4;
import com.valtech.training.day1.Point3D;

import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerialTest {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		//Serialization of Point class 
		
//		Point p = new Point();
//		System.out.println(p);
//		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("object")));
//		out.writeObject(p);
//		out.flush();
//		out.close();
//		
//		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("object")));
//		Point p1 = (Point) ois.readObject();
//		
//		System.out.println(p1);
//		System.out.println(p==p1);
		
		//Serialization of Point3d class after setting y as transient
		
		Point3D point3d = new Point3D();
		System.out.println(point3d);
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("object")));
		out.writeObject(point3d);
		out.flush();
		out.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("object")));
		Point3D point = (Point3D) ois.readObject();
		
		System.out.println(point);
		System.out.println(point==point3d);
	}
}

