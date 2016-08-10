package springBootApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springBootApp.entities.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping(value="/games/")
public class GameController {

    @Autowired
    private GameDAO gameDAO;

    @Autowired
    private CategoryDAO categoryDAO;

    @Autowired
    private VendorDAO vendorDAO;  //instruction #2//

    @RequestMapping(value = "viewAllGames")
    public String viewAllGames(ModelMap model) {
        model.addAttribute("games", gameDAO.findAll());
        return "games/viewAllGames";
    }

    @RequestMapping(value = "viewGamesInCategory")
    public String viewGamesInCategory(Long categoryId, ModelMap model) {
        model.addAttribute("games", gameDAO.findByCategoryId(categoryId));
        return "games/viewAllGames";
    }

    @RequestMapping(value = "viewGamesSearch")
    public String viewGamesSearch(String searchStr, ModelMap model) {
        model.addAttribute("games", gameDAO.findByNameStartsWith(searchStr));
        return "games/viewAllGames";
    }

    @RequestMapping(value = "findGame")
    public String findGame() {
        return "games/findGame";
    }

    @RequestMapping(value = "viewGame")
    public String viewGame(Long gameId, ModelMap model) {
        Game game = gameDAO.findOne(gameId);
        Category category = categoryDAO.findOne(game.getCategoryId());
        model.addAttribute("category", category);
        model.addAttribute("game", game);
        return "games/viewGame";
    }

    @RequestMapping(value = "addGame")
    public String addGame(ModelMap model) {
        Game game = new Game();
        model.addAttribute("game", game);
        model.addAttribute("categoryIdAndNameList", getCategoryIdsAndNames());
        model.addAttribute("vendorIdAndNameList", getVendorIdsAndNames());
        return "games/addGame";
    }

    @RequestMapping(value = "saveNewGame")
    public String saveNewGame(Game game) {
        if (game != null) {
            gameDAO.save(game);
        } else {
            System.out.println("ERROR: did NOT save new game, game was NULL!");
        }
        return "redirect:/games/viewAllGames";
    }

    private Map<String, String> getCategoryIdsAndNames() {
        LinkedHashMap<String, String> hashMap = new LinkedHashMap<String, String>();
        hashMap.put("-1", "-- None --");
        for (Category category : categoryDAO.findAll()) {
            hashMap.put(category.getCategoryId() + "", category.getCategoryTitle());
        }
        return hashMap;

    }

    private Map<String, String> getVendorIdsAndNames() {
        LinkedHashMap<String, String> hashMap = new LinkedHashMap<String, String>();
        hashMap.put("-1", "-- None --");
        // TODO: loop through vendors here...
        for (Vendor vendor : vendorDAO.findAll()) {
            hashMap.put(vendor.getVendorId() + "", vendor.getVendorTitle());

        }
        return hashMap;
    }

}

//    @RequestMapping(value="viewAllVendors")
//    public String viewAllVendors(ModelMap model) {
//        model.addAttribute("vendors",vendorDAO.findAll());
//        return "vendors/viewAllVendors";
//    }
//    @RequestMapping(value="viewVendorsInCategory")
//    public String viewVendorsInCategory(Long categoryId, ModelMap model) {
//        model.addAttribute("vendors",vendorDAO.findByCategoryId(categoryId));
//        return "vendors/viewAllVendors";
//    }
//    @RequestMapping(value="viewVendorsSearch")
//    public String viewVendorsSearch(String searchStr, ModelMap model) {
//        model.addAttribute("vendors",vendorDAO.findByNameStartsWith(searchStr));
//        return "vendors/viewAllVendors";
//    }
//
//    @RequestMapping(value="findVendor")
//    public String findVendor() {
//        return "vendors/findVendor";
//    }
//
//    @RequestMapping(value="viewVendor")
//    public String viewVendor(Long vendorId, ModelMap model) {
//        Game vendor = vendorDAO.findOne(vendorId);
//        Category category = categoryDAO.findOne(vendor.getCategoryId());
//        model.addAttribute("category",category);
//        model.addAttribute("vendor",vendor);
//        return "vendors/viewVendor";
//    }
//
//    @RequestMapping(value="addVendor")
//    public String addVendor(ModelMap model) {
//        Game vendor = new Game();
//        model.addAttribute("vendor",vendor);
//        model.addAttribute("categoryIdAndNameList", getCategoryIdsAndNames());
//        model.addAttribute("vendorIdAndNameList", getVendorIdsAndNames());
//        return "vendors/addVendor";
//    }
//
//    @RequestMapping(value="saveNewVendor")
//    public String saveNewVendor(Vendor vendor) {
//        if(vendor != null) {
//            vendorDAO.save(vendor);
//        } else {
//            System.out.println("ERROR: did NOT save new vendor, vendor was NULL!");
//        }
//        return "redirect:/vendors/viewAllVendors";
//    }