package id.co.backend.presentase.flyweight;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoleDao {
    private static final Map<String,Role> roleMap = new HashMap<>();

    public static Role getRole(String roleName){
        Role role = roleMap.computeIfAbsent(roleName,newRole ->{
            Role role1 = Role.builder()
                    .headName("Head " + roleName)
                    .personally(2).name(roleName)
                    .build();
            return role1;
        });
        return role;
    }
}
