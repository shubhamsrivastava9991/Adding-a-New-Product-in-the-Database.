package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


import com.model.Product;
import com.utl.HibernateUtil;

/**
 * database operations
 * 
 *
 */
public class ProductDao {

    /**
     * Save Product
     * @param product
     */
    public void saveProduct(Product product) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(product);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Update Product
     * @param product
     */
    public void updateProduct(Product product) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(product);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Delete Product
     * @param id
     */
    public void deleteProduct(int id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a user object
            Product product = session.get(Product.class, id);
            if (product != null) {
                session.delete(product);
                System.out.println("product is deleted");
            }

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Get Product By ID
     * @param id
     * @return
     */
    public static Product getProduct(int id) {

        Transaction transaction = null;
        Product product = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            product = session.get(Product.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return product;
    }

    /**
     * Get all Products
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List < Product > getAllProduct() {

        Transaction transaction = null;
        List < Product > listOfProduct = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object

            listOfProduct = session.createQuery("from Product").getResultList();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfProduct;
    }
}