package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by aditya on 9/23/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/hibernate.xml"})
@Transactional
public class SpringHibernateTest {

    @Autowired
    private SessionFactory sessionFactory;

    @Test
    @Rollback(false)
    public void createPersonTest() {
        Person p = new Person();
        p.setFirst("ADitya");

        Address address = new Address();
        address.setAddressType(AddressType.HOME);
        address.setCity("Ashburn");
        address.setPerson(p);
        address.setStreet("ABC Street");

        p.addAddress(address);


        Address addressTwo = new Address();
        addressTwo.setAddressType(AddressType.OFFICE);
        addressTwo.setCity("Chantilly");
        addressTwo.setPerson(p);
        addressTwo.setStreet("ABC Lane One");

        p.addAddress(addressTwo);
        //personHibernateService.createPerson(p);

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(p);
    }
}
