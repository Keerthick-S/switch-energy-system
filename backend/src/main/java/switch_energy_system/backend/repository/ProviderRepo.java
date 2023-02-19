package switch_energy_system.backend.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import switch_energy_system.backend.pojo.Provider;
import switch_energy_system.backend.pojo.SmartMeter;

import java.util.List;

@Repository
public class ProviderRepo {
    @Autowired
    private MongoTemplate mongoTemplate;

    public void createProvider(Provider provider) {
        mongoTemplate.save(provider);
    }
    public void enableDisabledProvider(String providerName, boolean isEnable) {
        mongoTemplate.findAndModify(Query.query(Criteria.where("name").is(providerName)), new Update().set("isEnable", isEnable), Provider.class);

    }
    public List<Provider> allProvider() {
        return mongoTemplate.findAll(Provider.class);
    }
    public List<Provider> allProviderWithPagination(int page) {
        Query query = new Query().skip(page * 6).limit(6);
        return mongoTemplate.findAll(Provider.class);
    }
    public Provider getProviderByName(String providerName) {
        return mongoTemplate.findOne(Query.query(Criteria.where("name").is(providerName)), Provider.class);
    }
    public void switchProvider(String smartMeterId, String providerName) {
        mongoTemplate.findAndModify(Query.query(Criteria.where("id").is(smartMeterId)), new Update().set("provider", providerName), SmartMeter.class);
    }

}
