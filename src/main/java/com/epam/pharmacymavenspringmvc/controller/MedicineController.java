package com.epam.pharmacymavenspringmvc.controller;

import com.epam.pharmacymavenspringmvc.dao.DAOFactory;
import com.epam.pharmacymavenspringmvc.dao.MedicineDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MedicineController {

    @Autowired
    private DAOFactory daoFactory;

    @RequestMapping("/viewmed")
    public String viewMedicine(@RequestParam("medid") Integer medid, Model model) {
        MedicineDAO medicineDAO = daoFactory.getMedicineDAO();
        model.addAttribute("medicine", medicineDAO.findById(medid));
        return "ViewMedicine";
    }

    @RequestMapping("/viewall")
    public String viewAll(Model model) {
        MedicineDAO medicineDAO = daoFactory.getMedicineDAO();
        model.addAttribute("medicines", medicineDAO.findAll());
        return "ViewAll";
    }
}