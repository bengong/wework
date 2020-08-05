package wework.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

import wework.domain.Permission;
import wework.util.EntityServiceImpl;

@IocBean(args = { "refer:dao" })
public class PermissionService extends EntityServiceImpl<Permission> {

	public PermissionService(Dao dao) {
		super(dao);
	}

	public Map<String, String> map() {
		Map<String, String> map = new HashMap<String, String>();
		List<Permission> permissions = query(null, null);
		for (Permission permission : permissions) {
			map.put(permission.permission_id, permission.permission_name);
		}
		return map;
	}
}
