package com.epam.pharmacymavenspringmvc.daojpa;

import com.epam.pharmacymavenspringmvc.dao.MedicineDAO;
import com.epam.pharmacymavenspringmvc.model.Medicine;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class MedicineDAOJPA implements MedicineDAO {

    private EntityManagerFactory emf;

    @Override
    public List<Medicine> findAll() {

        EntityManager em = emf.createEntityManager();
        List<Medicine> medicines = null;
        try {
            medicines = em.createQuery("Select m from Medicine m ORDER BY m.name").getResultList();
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        em.close();
        return medicines;
    }

    @Override
    public Medicine findById(Integer id) {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("Select m from Medicine m where m.id=:id");
        q.setParameter("id", id);
        Medicine medicine = null;
        try {
            medicine = (Medicine) q.getSingleResult();
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        em.close();
        return medicine;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    @Override
    public void create(Medicine medicine) {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("Select m from Medicine m where m.name=:name and m.releaseForm=:releaseForm and m.ages=:ages and m.quantityPerPack=:quantityPerPack");
        q.setParameter("name", medicine.getName());
        q.setParameter("releaseForm", medicine.getReleaseForm());
        q.setParameter("ages", medicine.getAges());
        q.setParameter("quantityPerPack", medicine.getQuantityPerPack());
        List<Medicine> m;
        try {
            m = q.getResultList();
            if (m != null && m.isEmpty()) {
                em.getTransaction().begin();
                em.persist(medicine);
                em.getTransaction().commit();
            }
        } catch (NoResultException ex) {
            em.getTransaction().begin();
            em.persist(medicine);
            em.getTransaction().commit();
        }
        em.close();
    }

    @Override
    public void addAll(List<Medicine> medicines) {
        for (Medicine medicine : medicines) {
            this.create(medicine);
        }
    }

    @Override
    @Transactional
    public void delete(Medicine medicine) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(medicine));
        em.getTransaction().commit();
        em.close();
    }

    @Override
    @Transactional
    public void update(Medicine medicine) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(medicine);
        em.getTransaction().commit();
        em.close();
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }
}
