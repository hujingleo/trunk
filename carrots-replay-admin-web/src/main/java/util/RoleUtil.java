package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.ptteng.carrots.replay.home.model.Role;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoleUtil {

	static public Role convertString2permission(Role role) {
		Map<Long, List<String>> result = new HashMap<Long, List<String>>();
		if (StringUtils.isBlank(role.getPermissions())) {
			role.setPermissionsSet(new HashMap());
			return role;
		} else {

			Gson gson = new GsonBuilder().create();
			result = gson.fromJson(role.getPermissions(),
					new TypeToken<Map<Long, List<String>>>() {
					}.getType());
			role.setPermissionsSet(result);
		}
		return role;
	}

	static public Role convertPermission2String(Role role) {
		Gson gson = new GsonBuilder().create();
		String permission = gson.toJson(role.getPermissionsSet());
		role.setPermissions(permission);
		return role;
	}

}
