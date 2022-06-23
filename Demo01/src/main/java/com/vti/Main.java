package com.vti;


import com.vti.entity.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Date;
import java.util.List;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        Session session = null;
        try {
            session = buildSessionFactory().openSession();
//            Create---
//            Product product = new Product();
//            product.setProductName("Quan ao2");
//            product.setPrice("1000000");
//            product.setCreatedDate(new Date());
//            product.setUpdatedDate(new Date());
//            session.save(product);
//            System.out.println("Create success!");


//            Query<Product> query = session.createQuery("FROM Product ");
//            List<Product> products = query.list();
//            for (int i = 0; i< products.size(); i++){
//                System.out.println(products.get(i).getProductName());
//            }


//            Get byID---
//            Product product = session.get(Product.class,1);
//            System.out.println(product.getProductName());
//            System.out.println(product.getPrice());

//            getbyname----
//            From Product from where thuoc tinh = :param
//            Query<Product> query = session.createQuery("FROM Product  WHERE productName = :nameParam");
//            query.setParameter("nameParam", "Muc tien");
//            Product product = query.uniqueResult();
//            System.out.println(product.getProductName());
//            System.out.println(product.getPrice());

//            Update---

//            session.beginTransaction();
//            Product product = session.load(Product.class,1);
//            product.setProductName("Giay dep");
//            product.setPrice("120000");
//            session.getTransaction().commit();

//            delete---
//            session.beginTransaction();
//            Product product = session.load(Product.class, 2);
//            if (product != null){
//                session.delete(product);
//                session.getTransaction().commit();
//            }

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    private static SessionFactory buildSessionFactory () {
        // load configuration
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        // add entity
        configuration.addAnnotatedClass(Product.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

        return configuration.buildSessionFactory(serviceRegistry);
    }
}







