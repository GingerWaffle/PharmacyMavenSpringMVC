package com.epam.pharmacymavenspringmvc.controller;

import com.epam.pharmacymavenspringmvc.dao.DAOFactory;
import com.epam.pharmacymavenspringmvc.dao.MedicineDAO;
import com.epam.pharmacymavenspringmvc.model.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminMedicineController {

    @Autowired(required = true)
    private DAOFactory daoFactory;

    @RequestMapping("/viewmed")
    public String viewMedicine(@RequestParam("medid") Integer medid, Model model) {
        MedicineDAO medicineDAO = daoFactory.getMedicineDAO();
        model.addAttribute("medicine", medicineDAO.findById(medid));
        return "admin/ViewMedicine";
    }

    @RequestMapping("/viewall")
    public String viewAll(Model model) {
        MedicineDAO medicineDAO = daoFactory.getMedicineDAO();
        model.addAttribute("medicines", medicineDAO.findAll());
        return "admin/ViewAll";
    }

    @RequestMapping("/deletemed")
    public String deleteMedicine(@RequestParam("medid") Integer medid, Model model) {
        MedicineDAO medicineDAO = daoFactory.getMedicineDAO();
        medicineDAO.delete(medicineDAO.findById(medid));
        model.addAttribute("medicines", medicineDAO.findAll());
        return "admin/ViewAll";
    }

    @RequestMapping("/addmed")
    public String addMedicine(Model model) {
        model.addAttribute("medicine", new Medicine());
        return "admin/AddMedicine";
    }

    @RequestMapping("/updatemed")
    public String updateMedicine(@ModelAttribute("medicine") Medicine medicine,
            @RequestParam("medid") Integer id, Model model) {
        MedicineDAO medicineDAO = daoFactory.getMedicineDAO();
        medicine.setId(id);
        medicineDAO.update(medicine);
        model.addAttribute("medicine", medicine);
        return "admin/ViewMedicine";
    }

    @RequestMapping("/createmed")
    public String createMedicine(@ModelAttribute("medicine") Medicine medicine, Model model) {
        MedicineDAO medicineDAO = daoFactory.getMedicineDAO();
        medicineDAO.create(medicine);
        model.addAttribute("medicine", medicine);
        return "admin/ViewMedicine";
    }
}
