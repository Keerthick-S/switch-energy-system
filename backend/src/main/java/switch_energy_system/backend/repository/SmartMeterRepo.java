package switch_energy_system.backend.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import switch_energy_system.backend.pojo.SmartMeter;
import switch_energy_system.backend.pojo.SmartMeterReading;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SmartMeterRepo {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private SmartMeterReadingRepo smartMeterReadingRepo;

    public void newSmartMeter(String userId, String providerName, String userName) {
        SmartMeter smartMeter = new SmartMeter(userId, providerName, userName);
        mongoTemplate.save(smartMeter);
        smartMeterReadingRepo.newSmartMeterReading(smartMeter.getId(), smartMeter.getEnrollStatus());
    }
    public String disabledSmartMeter(String userId) {
        mongoTemplate.findAndModify(Query.query(Criteria.where("userId").is(userId)), new Update().set("userId","").set("enrollStatus", "rejected"), SmartMeter.class);
        return "Disabled Successfully";
    }

    public void switchSmartMeter(String providerName, String variousProvider) {
        mongoTemplate.findAndModify(Query.query(Criteria.where("provider").is(providerName)), new Update().set("provider",variousProvider), SmartMeter.class);
    }

    public List<SmartMeter> getPendingSmartMeters() {
        return mongoTemplate.find(Query.query(Criteria.where("enrollStatus").is("pending")), SmartMeter.class);
    }

    public void setSmartMeterStatus(String smartMeterId, String status) {
        mongoTemplate.findAndModify(Query.query(Criteria.where("id").is(smartMeterId)), new Update().set("enrollStatus", status), SmartMeter.class);
    }

    public List<SmartMeter> getUserSmartMeter(String userId) {
        return mongoTemplate.stream(Query.query(Criteria.where("userId").is(userId)), SmartMeter.class).collect(Collectors.toList());
    }
}
