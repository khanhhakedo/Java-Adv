package com.vti.repository;

import com.vti.entity.*;
import com.vti.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class UserRepository {
    private HibernateUtils hibernateUtils;

    public UserRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    public void getAllUsers() {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();
            Query<UserOneToOne> query = session.createQuery("FROM UserOneToOne ");
            List<UserOneToOne> userOneToOnes = query.list();
            for (int i = 0; i < userOneToOnes.size(); i++) {
                System.out.println(userOneToOnes.get(i).toString());
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void createUser(UserOneToOne userOneToOne) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();

            // create
            session.save(userOneToOne);
            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void createUserManyToOne(UserManyToOne userManyToOne) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();

            // create
            session.save(userManyToOne);
            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void getAllUsersManyToOne() {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();
            Query<UserManyToOne> query = session.createQuery("FROM UserManyToOne ");
            List<UserManyToOne> userOneToOnes = query.list();
            for (int i = 0; i < userOneToOnes.size(); i++) {
                System.out.println(userOneToOnes.get(i).toString());
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void createUserManyToMany(UserManyToMany userManyToOne) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();

            // create
            session.save(userManyToOne);
            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    public void getAllUsersManyToMany() {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();
            Query<UserManyToMany> query = session.createQuery("FROM UserManyToMany");
            List<UserManyToMany> userOneToOnes = query.list();
            for (int i = 0; i < userOneToOnes.size(); i++) {
                System.out.println(userOneToOnes.get(i).toStringNotAddress());
            }

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public User getUserByID(int id) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // get department by id
            User user = session.get(User.class, id);

            return user;

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void createUser1(User user) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();

            // create
            session.save(user);
            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
