package wework.module;

import java.io.File;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Files;
import org.nutz.lang.util.NutMap;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;

import wework.WeWork;

/**
 * 媒体素材。
 */
@IocBean
@At("media")
public class MediaModule {
	@Inject
	WeWork weWork;

	Log log = Logs.get();
	
	/**
	 * 上传临时素材。
	 * 
	 * @param agentid 应用id
	 * @param type 媒体文件类型，分别有图片（image）、语音（voice）、视频（video），普通文件（file）
	 * @param path 本地文件路径。可能来自js upload组件。
	 * @return
	 */
	@At("/upload/?/?/?")
	public Object upload(String agentid, String type, String path) {
		File file = Files.findFile(path+".png");
		NutMap data = new NutMap();
		data.put(file.getName(), file);
		
		Object result = weWork.mediaMethods.upload(type, data);
		
//		返回值样例
//		{
//		   "errcode": 0,
//		   "errmsg": ""，
//		   "type": "image",// 媒体文件类型，分别有图片（image）、语音（voice）、视频（video），普通文件(file)
//		   "media_id": "1G6nrLmr5EC3MMb_-zK1dDdzmd0p7cNliYu9V5w7o8K0",// 媒体文件上传后获取的唯一标识，3天内有效
//		   "created_at": "1380000000" // 媒体文件上传时间戳
//		}
		
		return result;
	}
	
	/**
	 * <p>上传图片。</p>
	 * 
	 * <p>上传的图片大小限制：图片文件大小应在 5B ~ 2MB 之间</p>
	 * 
	 * @param agentid 应用id
	 * @param path 本地文件路径。可能来自js upload组件。
	 * @return
	 */
	@At("/uploadimg/?/?")
	public Object uploadimg(String agentid, String path) {
		File file = Files.findFile(path+".png");
		NutMap data = new NutMap();
		data.put(file.getName(), file);
		
		Object result =  weWork.mediaMethods.uploadimg(data);

//		返回值样例
//		{
//		   "errcode": 0,
//		   "errmsg": ""，
//		   "url" : "http://p.qpic.cn/pic_wework/3474110808/7a7c8471673ff0f178f63447935d35a5c1247a7f31d9c060/0" // 上传后得到的图片URL。永久有效
//		}
		
		return result;
	}
	
	/**
	 * 获取临时素材。
	 * 
	 * @param agentid 应用id
	 * @param media_id 媒体文件id
	 * @return
	 */
	@At("/download/?/?")
	@Ok("raw:file")
	public Object download(String agentid, String media_id) {
		// 已上传临时文件。
		// 375SQwdxk3pYWdEDjagCkdEMeiMEBG5Rl9peCWIF6Em708nj24gOgPHP1FadubrSk
		// 3avuTt1i9bZtlmYJlAdrb3q6D0mO6AeVjDRyZgbJhkKc

		return weWork.mediaMethods.download(media_id);		
	}
	
	/**
	 * 获取高清语音素材
	 * 
	 * @param agentid 应用id
	 * @param media_id 媒体文件id
	 * @return
	 */
	@At("/downloadvoice/?/?")
	@Ok("raw:file")
	public Object downloadVoice(String agentid, String media_id) {
		return weWork.mediaMethods.downloadVoice(media_id);
	}
}
