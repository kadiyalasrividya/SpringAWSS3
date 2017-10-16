package com.yash.aws.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.yash.aws.service.SpringAwsService;

@Controller
public class SpringAwsController {

	@Autowired
	SpringAwsService springAwsService;

	@RequestMapping(value="/", method=RequestMethod.POST)
	public String uploadFile(@RequestParam MultipartFile file,Model model) throws IOException {
		springAwsService.uploadFile(file.getInputStream(), file.getOriginalFilename());
		model.addAttribute("objects", springAwsService.getObjects());
		return "welcome";
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String showWelcomePage(Model model) {
		model.addAttribute("objects", springAwsService.getObjects());
		return "welcome";	
	}
	
	@RequestMapping(value="/deleteFile",method=RequestMethod.GET)
	public String deleteFile(Model model, @RequestParam("key") String key) {
		System.out.println(key);
		springAwsService.deleteObject(key);
		model.addAttribute("msg", "File was deleted successfully!");
		model.addAttribute("objects", springAwsService.getObjects());
		return "welcome";	
	}
}
