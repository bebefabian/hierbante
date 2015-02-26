package hibernate.pojo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import hibernate.persistence.HibernateUtil;

public class Test {

	public static void main(String[] args) { 
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry(); 
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session=sessionFactory.openSession(); session.enableFilter("tenantFilter").setParameter("tenantId", "TID1"); 
		session.beginTransaction(); 
		Product p1=new Product(); 
		p1.setId(222); p1.setTenantId("TID1");
		p1.setProdName("Lollypop"); session.persist(p1);
		session.getTransaction().commit(); session.close(); 
		session=sessionFactory.openSession(); 
		session.enableFilter("tenantFilter").setParameter("tenantId", "TID1"); session.beginTransaction(); 
		Product p2=(Product)session.createQuery("from Product").uniqueResult(); 
		session.getTransaction().commit(); System.out.println("Tenant ID: "+p2.getTenantId()); System.out.println("ID : "+p2.getId()); System.out.println("Product Name : "+p2.getProdName()); 
		session.close(); } }
