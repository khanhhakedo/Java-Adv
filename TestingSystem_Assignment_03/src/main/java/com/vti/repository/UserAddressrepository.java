package com.vti.repository;

import com.vti.entity.Address;
import com.vti.entity.UserAddress;
import com.vti.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class UserAddressrepository {
    private HibernateUtils hibernateUtils;

    public UserAddressrepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    public void createUserAddress(UserAddress address) {

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

    public void getAll() {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();
            Query<UserAddress> query = session.createQuery("FROM UserAddress ");
            List<UserAddress> addressOneToOnes = query.list();
            for (int i = 0; i < addressOneToOnes.size(); i++) {

                System.out.println(addressOneToOnes.get(i).toString() + addressOneToOnes.get(i).getAddress().toString()+ "--"+addressOneToOnes.get(i).getUser().toString() + "\n");
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}

