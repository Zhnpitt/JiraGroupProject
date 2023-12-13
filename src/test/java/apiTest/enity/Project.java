package apiTest.enity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Project {
    private String name;
    private String key;
    private String projectTypeKey;
    private String lead;

    private int permissionScheme;
}
