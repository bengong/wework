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
 * 權限
 */
@Table("wework_sso_permission")
public class Permission implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 143801911886927107L;
	@Name
	@ColDefine(type = ColType.VARCHAR, width = 100)
	public String permission_id;
	@Column
	@ColDefine(type = ColType.VARCHAR, width = 200)
	public String permission_name;
	@Column
	@ColDefine(type = ColType.VARCHAR, width = 500)
	public String permission_description = "";
	
	@ManyMany(target = Role.class, relation = "wework_sso_role_permission", from = "permission_id", to = "role_id")
	public List<Role> roles;

	@Column
	@ColDefine(type = ColType.VARCHAR)	
	public String ts;
	
	@Column
	@ColDefine(type = ColType.INT, width = 1)
	public int dr = 0;
	
	public String getPermission_id() {
		return permission_id;
	}

	public void setPermission_id(String permission_id) {
		this.permission_id = permission_id;
	}

	public String getPermission_name() {
		return permission_name;
	}

	public void setPermission_name(String permission_name) {
		this.permission_name = permission_name;
	}

	public String getPermission_description() {
		return permission_description;
	}

	public void setPermission_description(String permission_description) {
		this.permission_description = permission_description;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
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