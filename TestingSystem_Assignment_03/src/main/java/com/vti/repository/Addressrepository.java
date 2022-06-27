package com.vti.repository;

import com.vti.entity.*;
//import com.vti.entity.AddressManyToManyNewClass;
import com.vti.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class Addressrepository {
    private HibernateUtils hibernateUtils;

    public Addressrepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    public AddressOneToOne getAddressByID(int id) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // get department by id
            AddressOneToOne addressOneToOne = session.get(AddressOneToOne.class, id);
            System.out.println(addressOneToOne.toString());
            return addressOneToOne;


        } finally {
            if (session != null) {
                session.close();
            }
        }
    }




    public AddressOneToOne getAddressByStreet(String street) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            session.beginTransaction();
//        From Group from where thuoc tinh = :param
            Query<AddressOneToOne> query = session.createQuery("FROM AddressOneToOne  WHERE street = :nameParam");
            query.setParameter("nameParam", street);
            AddressOneToOne addressOneToOne = query.uniqueResult();

            session.getTransaction().commit();
            return addressOneToOne;


        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void createAddress(AddressOneToOne addressOneToOne) {

        Session session = null;
        try {

            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();

            // create
            session.save(addressOneToOne);
            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    public void getAllAddress() {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();
            Query<AddressOneToOne> query = session.createQuery("FROM AddressOneToOne ");
            List<AddressOneToOne> addressOneToOnes = query.list();
            for (int i = 0; i < addressOneToOnes.size(); i++) {
                System.out.println(addressOneToOnes.get(i).toString());
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void deleteAddress(AddressOneToOne addressOneToOne) {

        Session session = null;
        try {

            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();

            // create
            session.delete(addressOneToOne);
            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void getAllAndUserAddress() {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();
            Query<AddressOneToOne> query = session.createQuery("FROM AddressOneToOne ");
            List<AddressOneToOne> addressOneToOnes = query.list();
            for (int i = 0; i < addressOneToOnes.size(); i++) {
                System.out.println(addressOneToOnes.get(i).toString() + addressOneToOnes.get(i).getUser().toStringNotAddress());
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public AddressManyToOne getAddressAndUserByID(int id) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            // get department by id
            AddressManyToOne addressManyToOne = session.get(AddressManyToOne.class, id);

            System.out.println(addressManyToOne.toString() + addressManyToOne.getUserManyToOne() +"\n");
            return addressManyToOne;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void createAddressManyToOne(AddressManyToOne addressManyToOne) {

        Session session = null;
        try {

            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();

            // create
            session.save(addressManyToOne);
            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public AddressManyToOne getAddressByIDManyToOne(int id) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // get department by id
            AddressManyToOne addressManyToOne = session.get(AddressManyToOne.class, id);
            System.out.println(addressManyToOne.toString());
            return addressManyToOne;


        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void getAllAndUserAddressManyToOne() {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();
            Query<AddressManyToOne> query = session.createQuery("FROM AddressManyToOne ");
            List<AddressManyToOne> addressOneToOnes = query.list();
            for (int i = 0; i < addressOneToOnes.size(); i++) {

                System.out.println(addressOneToOnes.get(i).toString() + addressOneToOnes.get(i).getUserManyToOne()+"\n");
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void createAddressManyToMany(AddressManyToMany addressManyToMany) {

        Session session = null;
        try {

            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();

            // create
            session.save(addressManyToMany);
            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void getAllAndUserAddressManyToMany() {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();
            Query<AddressManyToMany> query = session.createQuery("FROM AddressManyToMany ");
            List<AddressManyToMany> addressManyToMany = query.list();
            for (int i = 0; i < addressManyToMany.size(); i++) {
                System.out.println(addressManyToMany.get(i).toString() + addressManyToMany.get(i).getUserManyToMany());
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public AddressManyToMany getAddressByIDManyToMany(int id) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // get department by id
            AddressManyToMany addressManyToOne = session.get(AddressManyToMany.class, id);
            System.out.println(addressManyToOne.toString());
            return addressManyToOne;


        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


    public void createAddress(Address address) {

        Session session = null;
        try {

            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();

            // create
            session.save(address);
            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


    public Address getAddresByID(int id) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // get department by id
            Address address = session.get(Address.class, id);

            return address;

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void getAllAddressNew() {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();
            Query<Address> query = session.createQuery("FROM Address ");
            List<Address> addressOneToOnes = query.list();
            for (int i = 0; i < addressOneToOnes.size(); i++) {

                System.out.println(addressOneToOnes.get(i).toString() + addressOneToOnes.get(i).getUserAddresses()+"\n");
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
