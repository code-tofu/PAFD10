package ibf2022.assessment.paf.batch3.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ibf2022.assessment.paf.batch3.models.Beer;
import ibf2022.assessment.paf.batch3.models.Style;
import ibf2022.assessment.paf.batch3.repositories.BeerRepository;
import ibf2022.assessment.paf.batch3.services.BeerService;

@Controller
public class BeerController {
    @Autowired
    BeerService beerSvc;

    // Task 2 - view 0
    @GetMapping("/")
    public String view0Page(Model model) {
        List<Style> styles = beerSvc.getStylesSvc();
        model.addAttribute("styles", styles);
        return "view0";
    }

    // Task 3 - view 1
    @GetMapping("/beer/style/{styleID}")
    public String view1Page(@PathVariable String styleID, @RequestParam String styleName, Model model) {
        List<Beer> beerList = beerRepo.getBreweriesByBeer(Integer.parseInt(styleID));
        model.addAttribute("styleName", styleName);
        model.addAttribute("styleID", styleID);
        model.addAttribute("beers", beerList);
        return "view1";
    }

    // TODO Task 4 - view 2

    // TODO Task 5 - view 2, place order

    @Autowired
    BeerRepository beerRepo;

    @GetMapping("/test")
    @ResponseBody
    public ResponseEntity<String> testController() {
        List<Beer> beerList = beerRepo.getBreweriesByBeer(31);
        int result = beerList.size();
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Integer.toString(result));
    }

}
