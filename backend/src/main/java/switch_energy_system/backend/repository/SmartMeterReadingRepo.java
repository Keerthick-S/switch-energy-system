package switch_energy_system.backend.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import switch_energy_system.backend.dto.ReadingRes;
import switch_energy_system.backend.pojo.Reading;
import switch_energy_system.backend.pojo.SmartMeterReading;

import java.util.List;

@Repository
public class SmartMeterReadingRepo {
    @Autowired
    private MongoTemplate mongoTemplate;

    public void newSmartMeterReading(String smartMeterId, String enrollStatus) {
        mongoTemplate.save(new SmartMeterReading(smartMeterId));
    }

    public void setSmartMeterStatus(String id , boolean status) {
        mongoTemplate.findAndModify(Query.query(Criteria.where("id").is(id)), new Update().set("enrollStatus", status), SmartMeterReading.class);
    }

    public void storeReading() {
        Reading reading = new Reading(10);
        mongoTemplate.updateMulti(Query.query(Criteria.where("enrollStatus").is(true)), new Update().push("electricityReading", reading), SmartMeterReading.class);
    }

    public void getTotalReading() {
        UnwindOperation unwindOperation = Aggregation.unwind("electricityReading");
        MatchOperation matchOperation = Aggregation.match(Criteria.where("enrollStatus").is(true));
        GroupOperation group = Aggregation.group("smartMeterId").sum("electricityReading.reading").as("totalReading");

        Aggregation aggregation = Aggregation.newAggregation(unwindOperation, matchOperation, group);
        AggregationResults<ReadingRes> totalReadings = mongoTemplate.aggregate(aggregation, SmartMeterReading.class, ReadingRes.class);
//        mongoTemplate.save(totalReadings.getMappedResults());
    }
}
