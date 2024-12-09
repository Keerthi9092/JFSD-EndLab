package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ClientDemo {
    public static void main(String[] args) {
        Configuration config = new Configuration().configure(); // This will look for hibernate.cfg.xml in the classpath
        SessionFactory factory = config.buildSessionFactory();

        // Open a session
        Session session = factory.openSession();

        // Insert records
        Transaction transaction = session.beginTransaction();
        Client client1 = new Client();
        client1.setName("Alice");
        client1.setGender("Female");
        client1.setAge(28);
        client1.setLocation("New York");
        client1.setEmail("alice@example.com");
        client1.setMobileNumber("1234567890");

        Client client2 = new Client();
        client2.setName("Bob");
        client2.setGender("Male");
        client2.setAge(30);
        client2.setLocation("Los Angeles");
        client2.setEmail("bob@example.com");
        client2.setMobileNumber("0987654321");

        session.save(client1);
        session.save(client2);
        transaction.commit();

        // Print all records
        List<Client> clients = session.createQuery("from Client", Client.class).list();
        for (Client client : clients) {
            System.out.println(client);
        }

        // Close the session and factory
        session.close();
        factory.close();
    }
}
