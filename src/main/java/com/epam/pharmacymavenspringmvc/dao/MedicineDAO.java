package com.epam.pharmacymavenspringmvc.dao;

import com.epam.pharmacymavenspringmvc.model.Medicine;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface MedicineDAO {

    public List<Medicine> findAll();

    public Medicine findById(Integer id);

    public void create(Medicine medicine);

    public void addAll(List<Medicine> medicines);

    public void delete(Medicine medicine);

    public void update(Medicine medicine);
}
