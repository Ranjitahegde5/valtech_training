package com.valtech.training.hibernate.client;

import org.hibernate.SessionFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.imageio.spi.RegisterableService;
import javax.persistence.FetchType;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.valtech.training.orderInvoice.CustomerAddress;
import com.valtech.training.orderInvoice.Customers;
import com.valtech.training.orderInvoice.Items;
import com.valtech.training.orderInvoice.OrderDescription;
import com.valtech.training.orderInvoice.Orders;
import com.valtech.training.orderInvoice.VendorAddress;
import com.valtech.training.orderInvoice.Vendors;

public class HibernateClient {
	
	public static void main(String[] args) throws Exception {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//		c
		
		cfg.addAnnotatedClass(Customers.class).addAnnotatedClass(CustomerAddress.class);
		cfg.addAnnotatedClass(Orders.class).addAnnotatedClass(OrderDescription.class);
		cfg.addAnnotatedClass(Vendors.class).addAnnotatedClass(VendorAddress.class);
		cfg.addAnnotatedClass(Items.class);
		DateFormat dateFormat = new SimpleDateFormat();
		
		SessionFactory sesFac = cfg.buildSessionFactory();
		Session ses = sesFac.openSession();
		Transaction tr = ses.beginTransaction();
		
		
		
		Customers cus1 = new Customers("Ranjita","9380426127","ranjitahegde@gmail.com");
		CustomerAddress custAdd1 = new CustomerAddress("Dodmane","Sirsi","Karnataka",581322);
		Customers cus2 = new Customers("Shraddha","9676765432","shraddha@gmail.com");
		CustomerAddress custAdd2 = new CustomerAddress("Btm layout","Bangalore","Karnataka",560029);
		
		cus1.setCustomerAddress(custAdd1);
		cus2.setCustomerAddress(custAdd2);
		
		Orders order1 = new Orders(df.parse("15-08-1947"));
		Orders order2 = new Orders(df.parse("09-01-2023"));
		
		Vendors vendor1 = new Vendors("Apple"); 
		VendorAddress vendorAdd1 = new VendorAddress("Church Street","Blr","Karnataka",450034);
		vendor1.setVendorAddress(vendorAdd1 );
		Vendors vendor2 = new Vendors("Reliance"); 
		VendorAddress vendorAdd2 = new VendorAddress("BEL Road","Pune","Maharashtra",120012);
		vendor1.setVendorAddress(vendorAdd1 );
		
		Items items1 = new Items("Pencils", 5);
		Items items2 = new Items("Pens", 30);
		items1.addVendors(vendor1);
		items2.addVendors(vendor2);
		
//		vendor1.addItems(items1);
//		vendor2.addItems(items2);
		
		OrderDescription orderDesc1 = new OrderDescription(1,15,order2,items1);
		OrderDescription orderDesc2 = new OrderDescription(2,30,order1,items2);
		orderDesc1.setOrders(order1);
		orderDesc2.setOrders(order2);
		
		

		custAdd1.setCustomer(cus1);

		custAdd2.setCustomer(cus2);
	
		vendorAdd1.setVendor(vendor1);
		
		vendorAdd2.setVendor(vendor2);
		
		order1.setCustomers(cus1);
		order2.setCustomers(cus2);
		
		List<OrderDescription> orderDescList = new ArrayList<OrderDescription>();
		orderDescList.add(orderDesc1);
		orderDescList.add(orderDesc2);
		
		
		orderDesc1.setItems(items2);
		orderDesc2.setItems(items1);
		
		ses.persist(custAdd1);
		ses.persist(cus2);
		
		ses.persist(vendorAdd1);
		ses.persist(vendor1);
		ses.persist(vendorAdd2);
		ses.persist(vendor2);
		ses.persist(order1);
		ses.persist(order2);
		ses.persist(items1);
		ses.persist(items2);
		ses.persist(orderDesc1);
		ses.persist(orderDesc2);
		ses.persist(vendor1);
		ses.persist(vendor2);
		
	
		
		tr.commit();
		ses.close();
		sesFac.close();
	
	}

}
