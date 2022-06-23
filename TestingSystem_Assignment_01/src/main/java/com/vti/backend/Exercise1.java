package com.vti.backend;

import com.vti.entity.Group;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.criteria.From;
import java.util.Date;
import java.util.List;

public class Exercise1 {

//    Question1: CreateGroup
    public static void Question1(){
        Session session = null;
        try {
        session = buildSessionFactory().openSession();
//            Create---
        session.beginTransaction();
            Group group1 = new Group();
            group1.setGroupName("Test");
            group1.setCreatedDate(new Date());
            System.out.println("Create success!");
            session.save(group1);

            Group group2 = new Group();
            group2.setGroupName("Pm");
            group2.setCreatedDate(new Date());
            System.out.println("Create success!");
            session.save(group2);

       session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

//    Question2: GetAllGroup

    public static void Question2(){
        Session session = null;
        try {
            session = buildSessionFactory().openSession();

            Query<Group> query = session.createQuery("FROM Group ");
            List<Group> groups = query.list();
            for (int i = 0; i< groups.size(); i++){
                System.out.println(groups.get(i).toString());
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

//    Question3: getGroupById

    public static void Question3() {

//        Session session = null;
//        try {
//            session = buildSessionFactory().openSession();
//
//            Group group = session.get(Group.class,1);
//            System.out.println(group.getGroupName());
//            System.out.println(group.getCreatedDate());
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
//
//    }

        //Cach 2:
        Session session = null;
        try {
            session = buildSessionFactory().openSession();
            session.beginTransaction();
//        From Group from where thuoc tinh = :param
            Query<Group> query = session.createQuery("FROM Group  WHERE id= :nameParam");
            query.setParameter("nameParam", 2);
            Group group = query.uniqueResult();
            System.out.println(group.toString());
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

//    Question4: getGroupByName
    public static void Question4(){
        Session session = null;
        try {
            session = buildSessionFactory().openSession();
            session.beginTransaction();
//        From Group from where thuoc tinh = :param
            Query<Group> query = session.createQuery("FROM Group  WHERE groupName = :nameParam");
            query.setParameter("nameParam", "Test");
            Group group = query.uniqueResult();
            System.out.println(group.toString());
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

//    Question5: Update
    public  static void Question5(){

        Session session = null;
        try {
            session = buildSessionFactory().openSession();
            session.beginTransaction();


            Group group = session.load(Group.class,1);
            group.setGroupName("Test1");

            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

//    Question6: Delete
    public static void Question6(){
        Session session = null;
        try {
            session = buildSessionFactory().openSession();
            session.beginTransaction();

            Group group = session.load(Group.class, 2);
            if (group != null){
                session.delete(group);
            }
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

//    Question7: existById
    public  static void Question7(){
        Session session = null;
        try {
            session = buildSessionFactory().openSession();
            session.beginTransaction();
            Query<Group>  query = session.createQuery("FROM Group  WHERE id = :nameParam");
            query.setParameter("nameParam", 1);
            Group group = query.uniqueResult();
            if (group != null){
                System.out.println("id da ton tai");;
            }else {
                System.out.println("ko ton tai id");
            }
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    //    Question7: existByName
    public  static void Question8(){
        Session session = null;
        try {
            session = buildSessionFactory().openSession();
            session.beginTransaction();
            Query<Group>  query = session.createQuery("FROM Group  WHERE groupName = :nameParam");
            query.setParameter("nameParam", "Test2");
            Group group = query.uniqueResult();
            if (group != null){
                System.out.println("groupName da ton tai");;
            }else {
                System.out.println("groupName ko ton tai ");
            }
            session.getTransaction().commit();
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
        configuration.addAnnotatedClass(Group.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

        return configuration.buildSessionFactory(serviceRegistry);
    }
}
