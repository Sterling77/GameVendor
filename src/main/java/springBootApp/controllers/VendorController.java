package springBootApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import springBootApp.entities.Vendor;
import springBootApp.entities.VendorDAO;

/**
 * Created by Letricia on 8/10/16.
 */
@Controller
@RequestMapping(value="/vendors/")
public class VendorController {

    @Autowired
    private VendorDAO vendorDAO;

    @RequestMapping(value="viewAllVendors")
    public String viewAllVendors(ModelMap model) {
        model.addAttribute("vendors",vendorDAO.findAll());
        return "vendors/viewAllVendors";
    }

    @RequestMapping(value="viewVendor")
    public String viewVendor(Long vendorId, ModelMap model) {
        Vendor vendor = vendorDAO.findOne(vendorId);
        model.addAttribute("vendor",vendor);
        return "vendors/viewVendor";
    }

    @RequestMapping(value="addVendor")
    public String addVendor(ModelMap model) {
        Vendor vendor = new Vendor();
        model.addAttribute("vendor",vendor);
        return "vendors/addVendor";
    }


    @RequestMapping(value="saveNewVendor")
    public String saveNewVendor(Vendor vendor) {
//    public String saveNewVendor(@ModelAttribute("vendor") Vendor vendor) {
        if(vendor != null) {
            vendorDAO.save(vendor);
        } else {
            System.out.println("ERROR: did NOT save new vendor, vendor was NULL!");
        }
        return "redirect:/vendors/viewAllVendors";
    }
}

