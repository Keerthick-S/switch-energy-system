package switch_energy_system.backend.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import switch_energy_system.backend.pojo.SmartMeter;

import javax.swing.*;

@Repository
public class SmartMeterRepo {
    @Autowired
    private MongoTemplate mongoTemplate;
    public void newSmartMeter(String userId, String providerName) {
        mongoTemplate.save(new SmartMeter(userId, providerName));
    }
    public String disabledSmartMeter(String userId) {
        mongoTemplate.findAndModify(Query.query(Criteria.where("userId").is(userId)), new Update().set("userId","").set("enrollStatus", "rejected"), SmartMeter.class);
        return "Disabled Successfully";
    }

    public void switchSmartMeter(String providerName, String variousProvider) {
        mongoTemplate.findAndModify(Query.query(Criteria.where("provider").is(providerName)), new Update().set("provider",variousProvider), SmartMeter.class);
    }
}
