package switch_energy_system.backend.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import switch_energy_system.backend.pojo.Provider;

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
}
