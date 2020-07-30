package wework.api;

import java.io.InputStream;
import java.util.Map;

import org.nutz.http.Header;
import org.nutz.ioc.loader.annotation.IocBean;

/**
 * 素材管理。
 */
@IocBean
public class MediaMethods extends AbstractMethods {
	
	/**
	 * <p>上传临时素材。</p>
	 * 
	 * <p>使用multipart/form-data POST上传文件， 文件标识名为”media”</p>
	 * 
	 * <p>POST的请求包中，form-data中媒体文件标识，应包含有 filename、filelength、content-type等信息</p>
	 * 
	 * <p>filename标识文件展示的名称。比如，使用该media_id发消息时，展示的文件名由该字段控制</p>
	 * 
	 * <p>文件类型：
	 * <ul>
	 * <li>image : 图片</li>
	 * <li>voice : 语音</li>
	 * <li>video : 视频</li>
	 * <li>file : 普通文件</li>
	 * </ul>
	 * </p>
	 * 
	 * @param access_token 调用接口凭证
	 * @param type 媒体文件类型，分别有图片（image）、语音（voice）、视频（video），普通文件（file）
	 * @param data
	 * @return
	 */
	public Object upload(String access_token, String type, Map<String, Object> data) {		
		// type 媒体文件类型，分别有图片（image）、语音（voice）、视频（video），普通文件（file）
		String url =  String.format("/media/upload?access_token=%s&type=%s", access_token, type);
		return upload(url, data, Header.create());
	}
	
	/**
	 * 上传图片。
	 * 
	 * @param access_token
	 * @param data
	 * @return
	 */
	public Object uploadimg(String access_token, Map<String, Object> data) {
		String url =  String.format("/media/upload?uploadimg=%s", access_token);		
		return upload(url, data, Header.create());
	}
	
	/**
	 * 获取临时素材
	 * 
	 * 完全公开，media_id在同一企业内所有应用之间可以共享。
	 * 
	 * @param access_token 调用接口凭证
	 * @param media_id 媒体文件id, 见<a href="https://work.weixin.qq.com/api/doc/90000/90135/90253">上传临时素材</a>
	 * @return
	 */
	public InputStream download(String access_token, String media_id) {
		String url =  String.format("/media/get?access_token=%s&media_id=%s", access_token, media_id);		
		return download(url);
	}
	
	/**
	 * 获取高清语音素材
	 * 
	 * 完全公开，media_id在同一企业内所有应用之间可以共享。
	 * 
	 * 可以使用本接口获取从JSSDK的uploadVoice接口上传的临时语音素材，格式为speex，16K采样率。该音频比上文的临时素材获取接口（格式为amr，8K采样率）更加清晰，适合用作语音识别等对音质要求较高的业务。
	 * 
	 * @param access_token 调用接口凭证
	 * @param media_id 通过JSSDK的uploadVoice接口上传的语音文件id
	 * @return
	 */
	public Object downloadVoice(String access_token, String media_id) {
		String url =  String.format("/media/get/jssdk?access_token=%s&media_id=%s", access_token, media_id);		
		return download(url);
	}
}
