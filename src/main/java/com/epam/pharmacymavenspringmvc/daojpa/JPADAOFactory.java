package com.epam.pharmacymavenspringmvc.daojpa;

import com.epam.pharmacymavenspringmvc.dao.DAOFactory;
import com.epam.pharmacymavenspringmvc.dao.MedicineDAO;
import org.springframework.stereotype.Repository;

@Repository
public class JPADAOFactory implements DAOFactory {

    MedicineDAO medicineDAO;

    @Override
    public MedicineDAO getMedicineDAO() {
        return medicineDAO;
    }

    public void setMedicineDAO(MedicineDAO medicineDAO) {
        this.medicineDAO = medicineDAO;
    }
}
