package com.xiamuyao.localService.controller;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PageController {

	private static final Charset CHARSET = Charsets.toCharset("UTF-8");

	@Value("${app.stub.folder}")
	private String stubFolder;

	@GetMapping("/")
	public String index(ModelMap map, @ModelAttribute("type") String type) {
		List<String> existsFiles = new ArrayList<>();
		if (!StringUtils.isEmpty(stubFolder)) {
			File folder = new File(stubFolder);
			File[] listOfFiles = folder.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					existsFiles.add(listOfFiles[i].getName());
				}
			}
		}
		if ("upload-error".equals(type)) {
			map.addAttribute("message", " Please select json file.");
		}
		else if ("upload-ok".equals(type)) {
			map.addAttribute("message", " Upload ok.");
		}
		else if ("update-ok".equals(type)) {
			map.addAttribute("message", " Update ok.");
		}
		map.addAttribute("fileList", existsFiles);
		return "index";
	}

	@GetMapping("/detail")
	public String detail(ModelMap map, @RequestParam("f") String f) throws Exception {
		if (StringUtils.isEmpty(f)) {
			return null;
		}
		File file = new File(stubFolder+ File.separator + f);
		String fileContent = FileUtils.readFileToString(file, CHARSET);
		map.addAttribute("fileName", f);
		map.addAttribute("fileContent", fileContent);
		return "detail";
	}

	@PostMapping("/update")
	public String update(ModelMap map, 
			@RequestParam("fileName") String fileName, 
			@RequestParam("fileContent") String fileContent,
			RedirectAttributes redirectAttributes) throws Exception {

		File file = new File(stubFolder+ File.separator + fileName);
		if (!file.exists()) {
			redirectAttributes.addFlashAttribute("type", "update-error");
			return "redirect:/";
		}
		FileUtils.write(file, fileContent, CHARSET);
		redirectAttributes.addFlashAttribute("type", "update-ok");
		return "redirect:/";
	}

	@PostMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes)  throws Exception {
		String filename = file.getOriginalFilename();
		if (!filename.endsWith("json")) {
			redirectAttributes.addFlashAttribute("type", "upload-error");
			return "redirect:/";
		}
		File newfile = new File(stubFolder+ File.separator + file.getOriginalFilename());  
		file.transferTo(newfile); 
		redirectAttributes.addFlashAttribute("type", "upload-ok");
		return "redirect:/";
	}

}
