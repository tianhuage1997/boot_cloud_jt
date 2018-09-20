package com.jt.manage.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import com.jt.common.vo.PicUploadResult;
import com.jt.manage.config.PropertieService;


@Controller
public class PicUploadController {
	@Autowired
	private PropertieService prop;
	
	//图片上传
	//'/pic/upload'
	@RequestMapping("/pic/upload")
	@ResponseBody
	public PicUploadResult uploadPic(MultipartFile uploadFile) {
		/*
		 * 1 拿到文件文件名,判断是否合法,.jpg .png .gif
		 * 2 判断是否是木马(BufferedImage)
		 * 	判断木马应该使用第三方写好的jar包来判断
		 * 3 生成2个路径 存盘路径(存到当前工程的webapps中)
		 * 生成文件夹结构
		 * 	生成网络url访问的虚拟路径 域名+端口替代了存盘路径的webapps之前的内容
		 * 4 计算路径方法yyyy/mm/dd
		 * 5 重新命名图片名称
		 * 6 保存图片
		 * 7 封装对象返回
		 */
		
		PicUploadResult result=new PicUploadResult();
		//获取图片名称
		String oldFileName=uploadFile.getOriginalFilename();
		//获取后缀
		String extFileName=oldFileName.substring(
				oldFileName.lastIndexOf("."));
		//判断后缀合法性.jpg .png .gif,正则
		if(!extFileName.matches("^.(jpg|png|gif)$")) {
			//返回error=0的result对象
			result.setError(1);
			return result;
		};
		//判断木马
		//先将流对象转化成BufferedImage对象
		try {
			BufferedImage bufImage=ImageIO.
					read(uploadFile.getInputStream());
			int width = bufImage.getWidth();
			int height = bufImage.getHeight();
			result.setHeight(height+"");
			result.setWidth(width+"");
			//生成路径名称,共用路径名称 /image/2018/04/23/
			String dir="/image/"+new SimpleDateFormat	
					("yyyy/mm/dd").format(new Date())+"/";
			//生成一个url域名 image.jt.com
			String urlPrefix=prop.urlw+dir;
			//生成路径 指向当前manage的webapps根目录 + dir
			String path=prop.pathw+dir;
			//创建path
			File _dir=new File(path);
			//判断是否已经创建
			if(!_dir.exists()) {
			_dir.mkdirs();//创建多级目录
			}
			//文件名称重写 当前时间+3位随机数+后缀
			String fileName=System.currentTimeMillis()+
					RandomUtils.nextInt(100, 999)+extFileName;
			//设置url
			String imageUrl=urlPrefix+fileName;
			result.setUrl(imageUrl);
			//存盘
			uploadFile.transferTo(new File(path+fileName));
			return result;
		}catch(Exception e) {
			//说明不是图片数据流,直接返回失败
			result.setError(1);
			return result;
		}	
	}
	
}
