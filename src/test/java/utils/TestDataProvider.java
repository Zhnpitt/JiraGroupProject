package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;





public class TestDataProvider {

    private static List<User> userList;
    private static List<UserGroup> userGroupList;
    private static List<Issue> issueList;
    static {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            userList = Arrays.asList(objectMapper.readValue(new File("src/test/resources/testdata/users.json"), User[].class));
            userGroupList = Arrays.asList(objectMapper.readValue(new File("src/test/resources/testdata/groups.json"), UserGroup[].class));
            issueList = Arrays.asList(objectMapper.readValue(new File("src/test/resources/testdata/issues.json"), Issue[].class));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static User[] getUsers() {

        return userList.toArray(new User[0]);
    }
    public static UserGroup[] getGroups() {

        return userGroupList.toArray(new UserGroup[0]);
    }
}
