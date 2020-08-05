package wework.util;

/**
 * 权限集合。
 */
public interface Permissions {
	
	public interface module {
		
	}
	
	/**
	 * 菜单
	 */
	public interface menu {
		public final static String all = "menu:*";
		public final static String view = "menu:view";
		public final static String create = "menu:create";
		public final static String edit = "menu:edit";
		public final static String delete = "menu:delete";
	}
	
	public interface role {
		public final static String all = "role:*";
		public final static String view = "role:view";
		public final static String create = "role:create";
		public final static String edit = "role:edit";
		public final static String delete = "role:delete";
	}
	
	public interface user {
		public final static String all = "user:*";
		public final static String view = "user:view";
		public final static String create = "user:create";
		public final static String edit = "user:edit";
		public final static String delete = "user:delete";
	}
}
