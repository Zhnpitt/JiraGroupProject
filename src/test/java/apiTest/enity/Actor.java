package apiTest.enity;

import lombok.Builder;
import lombok.Data;
import org.json.JSONArray;
import org.json.JSONObject;

@Data
@Builder
public class Actor {
    private JSONArray user;
}
