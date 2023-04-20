package com.hivetech.controller;

import com.hivetech.entities.Content;
import com.hivetech.services.ContentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ContentController {

    @Autowired
    private ContentServices contentServices;
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("contents", new Content());
        return "AddContent";
    }

    @PostMapping("/add")
    public String addContent(@ModelAttribute("contents") Content content) {

        contentServices.createContent(content);
        return "AddContent";
    }
    @GetMapping ("/list")
    public String listContent(Model model){
        List<Content> listContents = contentServices.getAllContent();
        model.addAttribute("listOfContents", listContents);
        return "ListContents";
    }


}
