package wework.domain;

import java.io.Serializable;
import java.util.List;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.ManyMany;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

/**
 * 角色。
 */
@Table("wework_sso_role")
public class Role implements Serializable {	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -24693995352963039L;

	@Name
	@ColDefine(type = ColType.VARCHAR, width = 100)
	public String role_id;
	
	@Column
	@ColDefine(type = ColType.VARCHAR, width = 200)
	public String role_name;
	@Column
	@ColDefine(type = ColType.VARCHAR, width = 500)
	public String role_description;
	
	@ManyMany(target = User.class, relation = "wework_sso_user_role", from = "role_id", to = "username")
	public List<User> users;
	@ManyMany(target = Permission.class, relation = "wework_sso_role_permission", from = "role_id", to = "permission_id")
	public List<Permission> permissions;
	
	@Column
	@ColDefine(type = ColType.VARCHAR)	
	public String ts;
	
	@Column
	@ColDefine(type = ColType.INT, width = 1)
	public int dr = 0;
	
	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getRole_description() {
		return role_description;
	}

	public void setRole_description(String role_description) {
		this.role_description = role_description;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public int getDr() {
		return dr;
	}

	public void setDr(int dr) {
		this.dr = dr;
	}	
}
