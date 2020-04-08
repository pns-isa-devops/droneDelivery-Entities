package fr.unice.polytech.isa.dd.entities;

import arquillian.AbstractEntitiesTest;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.*;


@RunWith(Arquillian.class)
public class CustomerStorageTest extends AbstractEntitiesTest {

    @PersistenceContext(unitName = "dd_persistence_unit")
    private EntityManager entityManager;

    @Test
    @Transactional(TransactionMode.COMMIT)
    public void testCustomerStorage(){
        Customer customer = new Customer();
        customer.setName("Paul");
        customer.setAddress("i dont know");

        assertEquals(0,customer.getId());

        entityManager.persist(customer);
        int id = customer.getId();
        assertNotEquals(0,id);
        Customer stored = (Customer) entityManager.find(Customer.class, id);
        assertEquals(customer, stored);
    }

    @Test
    @Transactional(TransactionMode.COMMIT)
    public void testProviderStorage(){
        Provider provider = new Provider();
        provider.setName("Aug");
        entityManager.persist(provider);

        Package package1 = new Package();
        package1.setWeight(10.0);
        package1.setProvider(provider);
        entityManager.persist(package1);
        provider.add(package1);

        Package package2 = new Package();
        package2.setWeight(20.0);
        package2.setProvider(provider);
        entityManager.persist(package2);
        provider.add(package2);

        int idp1 = package1.getId();
        provider.getPackages().remove(package1);
        entityManager.remove(package1);

        assertNull(entityManager.find(Package.class, idp1));
        assertNotNull(entityManager.find(Package.class, package2.getId()));
        assertEquals(1, provider.getPackages().size());
        assertEquals(package2, provider.getPackages().toArray()[0]);
        assertEquals(provider, entityManager.find(Provider.class, provider.getId()));
    }

    @Test
    @Transactional(TransactionMode.COMMIT)
    public void testCustomerDeliveriesStorage(){
        Customer customer = new Customer("Pm","earth");
        entityManager.persist(customer);

        Provider provider = new Provider();
        provider.setName("Aug");
        entityManager.persist(provider);

        Package package1 = new Package();
        package1.setWeight(10.0);
        package1.setProvider(provider);
        entityManager.persist(package1);
        provider.add(package1);

        Package package2 = new Package();
        package2.setWeight(20.0);
        package2.setProvider(provider);
        entityManager.persist(package2);
        provider.add(package2);

        Delivery delivery1 = new Delivery();
        delivery1.setCustomer(customer);
        delivery1.setPackageDelivered(package1);
        entityManager.persist(delivery1);
        customer.add_a_customer_delivery(delivery1);

        Delivery delivery2 = new Delivery();
        delivery1.setCustomer(customer);
        delivery1.setPackageDelivered(package2);
        entityManager.persist(delivery2);
        customer.add_a_customer_delivery(delivery2);


        int iddel1 = delivery1.getId();
        customer.getCustomer_deliveries().remove(delivery1);
        entityManager.remove(delivery1);

        assertNull(entityManager.find(Delivery.class, iddel1));
        assertNotNull(entityManager.find(Delivery.class, delivery2.getId()));
        assertEquals(1, customer.getCustomer_deliveries().size());
        assertEquals(delivery2, customer.getCustomer_deliveries().toArray()[0]);
        assertEquals(customer, entityManager.find(Customer.class, customer.getId()));
    }

    @Test
    @Transactional(TransactionMode.COMMIT)
    public void testBiilsStorage(){
        Customer customer = new Customer("Pm","earth");
        entityManager.persist(customer);

        Provider provider = new Provider();
        provider.setName("Aug");
        entityManager.persist(provider);

        Package package1 = new Package();
        package1.setWeight(10.0);
        package1.setProvider(provider);
        entityManager.persist(package1);
        provider.add(package1);

        Package package2 = new Package();
        package2.setWeight(20.0);
        package2.setProvider(provider);
        entityManager.persist(package2);
        provider.add(package2);

        Delivery delivery1 = new Delivery();
        delivery1.setCustomer(customer);
        delivery1.setPackageDelivered(package1);
        entityManager.persist(delivery1);
        customer.add_a_customer_delivery(delivery1);

        Delivery delivery2 = new Delivery();
        delivery1.setCustomer(customer);
        delivery1.setPackageDelivered(package2);
        entityManager.persist(delivery2);
        customer.add_a_customer_delivery(delivery2);

        Bill bill = new Bill();
        bill.setProvider(provider);
        bill.setDeliveries(new ArrayList<>(Arrays.asList(delivery1,delivery2)));
        provider.getProvider_bills().add(bill);
        entityManager.persist(bill);

        assertNotNull(entityManager.find(Bill.class, bill.getId()));
        assertEquals(1, provider.getProvider_bills().size());
        assertEquals(bill, provider.getProvider_bills().toArray()[0]);

        int idbill = bill.getId();
        provider.getProvider_bills().remove(bill);
        entityManager.remove(bill);

        assertNull(entityManager.find(Bill.class, idbill));
    }

}
