package wework.util;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.FieldFilter;
import org.nutz.dao.entity.Entity;
import org.nutz.dao.entity.MappingField;
import org.nutz.dao.entity.PkType;
import org.nutz.lang.Lang;
import org.nutz.service.NameEntityService;

public class EntityServiceImpl<T> extends NameEntityService<T> {

    public EntityServiceImpl() {
        super();
    }
	
	public EntityServiceImpl(Dao dao) {
		super(dao);
	}
	
	public List<T> query() {
		return dao().fetchLinks(super.query(), null);
	}
	
	public Result insert(T data) {
		try {
			data = dao().insert(data);
			return Result.success("已保存").setData(data);
		} catch (Exception e) {
			return Result.error(e.getMessage()).setData(data);
		}	
	}
	
	public Result update(T data) {
		return update(data, null);
	}	
	
	public Result update(T data, String actived) {
		int result = dao().update(data, FieldFilter.create(data.getClass(), actived, null, true));
		if(result > 0) {
			return Result.success("已更新").setData(data);
		}
		
		return Result.error("數據已發生更新，忽略").setData(data);
	}

	/**
	 * 更新時間戳。
	 * 
	 * @param data
	 * @return
	 */
	public T insertOrUpdate(T data) {
        if (data == null)
            return null;
        Object obj = Lang.first(data);
        Entity<?> en = dao().getEntity(obj.getClass());
        if (en.getPkType() == PkType.NAME) {
            MappingField mf = en.getNameField();
            Object val = mf.getValue(obj);
            if (val == null || dao().fetch(obj.getClass(), Cnd.where(mf.getName(), "=", val)) == null) {
                insert(data);
            } else {
                update(data);
            }
            return data;
        }
        
        if (dao().fetch(data) != null)
            update(data);
        else
            insert(data);

        return data;
	}	

	public T fetch(String name) {
		T data =  super.fetch(name);
		
		return dao().fetchLinks(data, null);
	}
	
	/**
	 * 刪除數據。
	 * 
	 * @param id
	 * @return
	 */
	public Result deletex(String id) {
		T data = fetch(id);
		
		if(Lang.isEmpty(data)) {
			return Result.error("數據不存在").setData(id);
		}
		
		int result = _delete(data);			
		return result == 1 ? Result.success("已刪除").setData(data) : Result.error("刪除失敗");		
	}
}
