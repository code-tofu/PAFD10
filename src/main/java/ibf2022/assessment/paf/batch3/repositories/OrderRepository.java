package ibf2022.assessment.paf.batch3.repositories;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    // Task 5
    public String insertNewOrder(Map<Integer, Integer> orders, int breweryID) {
        Document newDoc = new Document();
        newDoc.append("orderId", OrderRepository.getUUID(8));
        newDoc.append("date", LocalDate.now());
        newDoc.append("breweryId", breweryID);

        // requirement is ambigious
        List<Document> ordersDocList = new ArrayList<>();
        for (int beerid : orders.keySet()) {
            Document newOrderDoc = new Document();
            newOrderDoc.append("beerId", beerid);
            newOrderDoc.append("quantity", orders.get(beerid));
            ordersDocList.add(newOrderDoc);
        }
        newDoc.append("orders", ordersDocList);

        Document returnDoc = mongoTemplate.insert(newDoc, "orders");
        return returnDoc.getString("orderId");
    }

    public static String getUUID(int numOfChar) {
        return UUID.randomUUID().toString().substring(0, numOfChar);
    }

}
