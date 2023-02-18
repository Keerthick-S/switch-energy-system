package switch_energy_system.backend.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import switch_energy_system.backend.pojo.SmartMeter;
import switch_energy_system.backend.pojo.User;
import switch_energy_system.backend.service.SmartMeterService;

@Repository
public class UserRepo {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private SmartMeterService smartMeterService;

    public String createUser(User user) {
        mongoTemplate.save(user);
        smartMeterService.newSmartMeter(user.getId(), user.getName());
        return "created successfully";
    }
    public void switchProvider(String smartMeterId, String providerName) {
        mongoTemplate.findAndModify(Query.query(Criteria.where("id").is(smartMeterId)), new Update().set("provider", providerName), SmartMeter.class);
    }

    public User getUser(long phoneNumber) {
        return mongoTemplate.findOne(Query.query(Criteria.where("phoneNumber").is(phoneNumber)), User.class);
    }

    public User getUserById(String userName) {
        return mongoTemplate.findOne(Query.query(Criteria.where("userName").is(userName)), User.class);
    }
}
