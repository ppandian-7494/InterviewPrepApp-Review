package com.iptech.interviewprepapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iptech.interviewprepapp.domain.Document;
import com.iptech.interviewprepapp.domain.User;
import com.iptech.interviewprepapp.service.DocumentService;
import com.iptech.interviewprepapp.service.UserService;

@Controller
@RequestMapping("/users/{userId}/documents")
public class DocumentController {
	@Autowired
	private UserService userService;
	@Autowired
	private DocumentService documentService;
	
	@PostMapping("")
	public String createDocument (@PathVariable Long userId) {
		Document document = new Document();
		User user = userService.findById(userId);
		document.getUsers().add(user);
		user.getDocuments().add(document);
		document.setTopic("Document " + user.getDocuments().size());
		document = documentService.save(document);
		return "redirect:/users/"+userId;

	}
	
	@PostMapping("{documentId}")
	public String saveDocument(Document document, @PathVariable Long userId) {
		document = documentService.save(document);
		return "redirect:/users/"+userId;
	}
	
	@PostMapping("/users/{userId}/documents/{documentId}/delete")
	public String deleteDocument(@PathVariable Long userId,@PathVariable Long documentId ) {
		documentService.delete(documentId);
		return "redirect:/users/"+userId;
	}
	@GetMapping("{documentId}")
	public String getDocument(ModelMap model, @PathVariable Long userId, @PathVariable Long documentId) {
		Document document = documentService.findById(documentId);
		User user = userService.findById(userId);
		model.put("document", document);
		model.put("user", user);
		return "document";
	}
}
