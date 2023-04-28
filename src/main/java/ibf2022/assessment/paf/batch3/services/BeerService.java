package ibf2022.assessment.paf.batch3.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibf2022.assessment.paf.batch3.models.Beer;
import ibf2022.assessment.paf.batch3.models.Brewery;
import ibf2022.assessment.paf.batch3.models.Style;
import ibf2022.assessment.paf.batch3.repositories.BeerRepository;
import ibf2022.assessment.paf.batch3.repositories.OrderRepository;

@Service
public class BeerService {

    @Autowired
    BeerRepository beerRepo;

    @Autowired
    OrderRepository orderRepo;

    // TASK 2:
    public List<Style> getStylesSvc() {
        return beerRepo.getStyles();
    }

    // TASK 3:
    public List<Beer> getBreweriesByBeer(int styleID) {
        return beerRepo.getBreweriesByBeer(styleID);
    }

    // TASK 4:
    public Optional<Brewery> getBeersFromBrewery(int breweryID) {
        return beerRepo.getBeersFromBrewery(breweryID);
    }

    // Task 5: DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
    public String placeOrder(String orderString, int breweryID) {
        Map<Integer, Integer> orders = BeerService.decodeOrder(orderString);
        if (orders.size() < 1) {
            return "null_order";
        }
        String returnOrderId = orderRepo.insertNewOrder(orders, breweryID);
        // System.out.println(returnOrderId);
        return returnOrderId;
    }

    public static Map<Integer, Integer> decodeOrder(String orderString) {
        String[] splitorder = orderString.split("&");
        // System.out.println(Arrays.toString(splitorder));
        Map<Integer, Integer> orders = new HashMap<>();
        for (String order : splitorder) {
            String[] splitqty = order.split("=", 2);
            // System.out.println(Arrays.toString(splitqty));
            if (splitqty[1].equals(""))
                continue;
            if (splitqty[1].equals("0"))
                continue;
            orders.put(Integer.parseInt(splitqty[0]), Integer.parseInt(splitqty[1]));
        }
        // System.out.println(orders.toString());
        return orders;
    }

}
