package switch_energy_system.backend.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import switch_energy_system.backend.pojo.SmartMeter;
import switch_energy_system.backend.pojo.SmartMeterReading;

@Repository
public class SmartMeterReadingRepo {
    @Autowired
    private MongoTemplate mongoTemplate;

    public void newSmartMeterReading(String smartMeterId, String enrollStatus) {
        mongoTemplate.save(new SmartMeterReading(smartMeterId));
    }

    public void setSmartMeterStatus(String id , String status) {
        mongoTemplate.findAndModify(Query.query(Criteria.where("id").is(id)), new Update().set("enrollStatus", status), SmartMeterReading.class);
    }

    public void storeReading() {
//        mongoTemplate.findAndModify(
    }
}
