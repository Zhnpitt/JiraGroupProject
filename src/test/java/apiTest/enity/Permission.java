package apiTest.enity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Permission {
    private String permission;
    private Holder holder;

    @Data
    @Builder
    public static class Holder {
        private String type;
        private String parameter;

        // 构造函数、getters、setters省略
    }
}
