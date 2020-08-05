package wework.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nutz.dao.Chain;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

import wework.domain.Permission;
import wework.domain.Role;
import wework.util.EntityServiceImpl;
import wework.util.Result;

@IocBean(args = { "refer:dao" })
public class RoleService extends EntityServiceImpl<Role> {

	public RoleService(Dao dao) {
		super(dao);
	}

	public List<String> getPermissionNameList(Role role) {
		dao().fetchLinks(role, null);
		List<String> permissionNameList = new ArrayList<String>();

		for (Permission permission : role.getPermissions()) {
			permissionNameList.add(permission.permission_id);
		}
		return permissionNameList;
	}

	public Map<String, String> map() {
		Map<String, String> map = new HashMap<String, String>();
		List<Role> roles = query(null, null);
		for (Role role : roles) {
			map.put(role.role_id, role.role_name);
		}
		return map;
	}

	/**
	 * 添加權限。
	 * 
	 * @param role_id
	 * @param permission_id
	 */
	public Result add(String role_id, String permission_id) {
		try {
			dao().insert("wework_sso_role_permission", Chain.make("role_id", role_id).add("permission_id", permission_id));
			return Result.success("添加權限成功");
		} catch (Exception e) {
			return Result.error(e.getMessage());
		}
	}

	/**
	 * 刪除權限。
	 * 
	 * @param role_id
	 * @param permission_id
	 */
	public Result remove(String role_id, String permission_id) {
		try {
			int result = dao().clear("wework_sso_role_permission", Cnd.where("role_id", "=", role_id).and("permission_id", "=", permission_id));
			return result > 0 ? Result.success("刪除權限成功") : Result.error("數據已發生變化，刪除權限失敗");
		} catch (Exception e) {
			return Result.error(e.getMessage());
		}
	}
}
