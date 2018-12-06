package cy.cms.application.dx.Controller;

import java.io.*;
import java.util.UUID;

import org.springframework.stereotype.Controller;
/**
 * 
 * @author nuoqin
 * @since 2018/12/4
 * @version 1.0 
 * @category 文件上传
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cy.cms.application.dx.util.FileResult;
@Controller
public class FileUploadController {

	//文件上传
	@RequestMapping("/fileUpload")
	@ResponseBody
	public FileResult fileUpload(@RequestParam("file") MultipartFile file) throws Exception{
		FileResult result=new FileResult();
		//1.判断文件是否为空
		if(file.isEmpty()){
			result.setMsg("error");
			result.setUrl("");
			return result;
		}
		//2.上传文件名
		String filename = file.getOriginalFilename();
		//3.取出文件名后缀
		String filesuffix=filename.substring(filename.indexOf("."));
		//4.文件上传路径
		String filePath = "D://img//";
		//5.新文件名
		filename = UUID.randomUUID() + filesuffix;
		//6保存
		 File dest = new File(filePath + filename);
		 file.transferTo(dest);
		 //7.文件路径
		 String path = "/img/" + filename;
		 result.setMsg("ok");
		 result.setUrl(path);
		return result;
	}
	@RequestMapping("/file")

	public String f(){
		
		return "user/file";
	}
}
