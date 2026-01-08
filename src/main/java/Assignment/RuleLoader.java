package Assignment;

import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RuleLoader {

    public RuleConfig load(String path) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(new File("src/main/java/Assignment/rules.json"), RuleConfig.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load rules.json", e);
        }
    }
}