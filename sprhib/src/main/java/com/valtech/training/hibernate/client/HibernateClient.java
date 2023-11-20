package com.valtech.training.hibernate.client;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.valtech.training.hibernate.Account;
import com.valtech.training.hibernate.Address;
import com.valtech.training.hibernate.AtmTx;
import com.valtech.training.hibernate.BankAccount;
import com.valtech.training.hibernate.ChequeTx;
import com.valtech.training.hibernate.Customer;
import com.valtech.training.hibernate.Employee;
import com.valtech.training.hibernate.OrderSummary;
import com.valtech.training.hibernate.OrderSummaryId;
import com.valtech.training.hibernate.Registration;
import com.valtech.training.hibernate.TellerTx;
import com.valtech.training.hibernate.Tx;

public class HibernateClient {

	public static void main(String[] args)throws Exception {
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(Employee.class);
		cfg.addAnnotatedClass(Tx.class).addAnnotatedClass(ChequeTx.class).addAnnotatedClass(TellerTx.class).addAnnotatedClass(AtmTx.class);
		
		cfg.addAnnotatedClass(Customer.class).addAnnotatedClass(Address.class).addAnnotatedClass(Account.class);
		cfg.addAnnotatedClass(Registration.class).addAnnotatedClass(BankAccount.class);
		cfg.addAnnotatedClass(OrderSummary.class);


		
		SessionFactory sesFac = cfg.buildSessionFactory();
		Session ses = sesFac.openSession();
		Transaction tx = ses.beginTransaction();
		
		
		ses.persist(new OrderSummary(1,2,3));
		OrderSummary os = (OrderSummary) ses.load(OrderSummary.class,new OrderSummaryId(1,2));
		System.out.println("Qty = "+ os.getQuantity());
		
		
//		ses.persist(new BankAccount(new BankAccountId("SB", 1),40000));
//		BankAccountId id = new BankAccountId("SB", 1);
//		BankAccount ba = (BankAccount) ses.load(BankAccount.class, id);
//		Customer cus = new Customer("Ranjita",22);
//		ses.save(cus);
//		Address add = new Address("Dodmane","Sirsi",560026);
//		add.setCustomer(cus);
//		cus.setAddress(add);
//		ses.save(add);
////		
////		
//		Account acc = new Account(50000, "Axis");
//		Tx tx1 = new Tx(1000);
//		Tx tx2 = new ChequeTx(2000,456789,23450);
//		Tx tx3 = new TellerTx(4000,345,678);
//		Tx tx4 = new AtmTx(6000,998);
//		
//		ses.save(new Tx(1000));
//		ses.save(new ChequeTx(4000,145123,34435));
//		ses.save(new TellerTx(6000,123,345));
//		ses.save(new AtmTx(5000,789));
//		Account acc1 = new Account(20000,"CA");
//		Tx tx5 = new ChequeTx(3000,67890,45678);
//		
//		Customer cus1 = new Customer("Arpita", 23);
//		Address add1 = new Address("Jpnagar","blr",562789);
//		Customer cus2 = new Customer("Aparna", 24);
//		Address add2 = new Address("Jaynagar","blr",560056);
////
////
////		
////		
//////		
//////		
//		ses.persist(acc);
//		ses.persist(tx1);
//		ses.persist(tx2);
//		ses.persist(tx3);
//		ses.persist(tx4);
//		
////		
//		ses.persist(acc);
//		ses.persist(tx5);
//		ses.persist(cus1);
//		ses.persist(cus2);
//		ses.persist(add1);
//		ses.persist(add2);
////		
//		cus1.setAddress(add1);
//		add1.setCustomer(cus1);
//		cus1.setAddress(add2);
//		add1.setCustomer(cus2);
//		
////
////
////		
////		
//		acc.addTx((tx1));
//		acc.addTx((tx2));
//		acc.addTx((tx3));
//		acc.addTx((tx4));
//		acc.addTx((tx5));
//		acc1.addCustomer(cus2);acc1.addCustomer(cus);
//		acc.addCustomer(cus1);		acc.addCustomer(cus2);		acc.addCustomer(cus);
////
//
//



		
//		ses.createQuery("SELECT DISTINCT tx.account FROM Tx tx").list().forEach(t -> System.out.println(t));
//		
//		org.hibernate.Query query = ses.createQuery
//				("SELECT DISTINCT c FROM Customer c join c.accounts a join a.txs t where t.amount > ?");
//		query.setFloat(0,3000);
//		query.list().forEach(t -> System.out.println(t));
		
		Query query = ses.getNamedQuery("Tx.findAllByCityAndAmountGreaterThan");
//				ses.createQuery("SELECT t FROM Tx t JOIN t.account.customers c WHERE c.address.city =?  AND t.amount >?");
		query.setString(0, "Blr");
		query.setFloat(1, 3000);
		query.list().forEach(t -> System.out.println(t));
		
		
		
		//ses.persist(new Employee("Abc", Date., 20000, 'M',false));
		
//		int id = (Integer)ses.save(new Employee("Abc",df.parse("15-08-1947"), 20000,'M', false));
//		System.out.println(id);
//		
//		
//		Employee e = (Employee)ses.get(Employee.class, 1);
//		System.out.println(e.getClass().getName());
//		e.setName("Abc1");
		
		tx.commit();
		ses.close();
		sesFac.close();

	}

}
