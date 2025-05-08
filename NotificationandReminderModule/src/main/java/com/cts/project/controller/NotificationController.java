package com.cts.project.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.project.dto.NotificationDTO;
import com.cts.project.model.Notification;
import com.cts.project.service.NotificationService;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
	@Autowired
	private NotificationService service;

	@PostMapping("/save")
	public Notification sendNotification(@RequestBody NotificationDTO dto) {
		return service.sendNotification(dto);
	}

	@GetMapping("/fetchAll")
	public List<Notification> getAll() {
		return service.getAllNotifications();
	}

	@GetMapping("/fetchByid/{id}")
	public Notification getById(@PathVariable Long id) {
		return service.getNotificationById(id);
	}

	@DeleteMapping("/Delete/{id}")
	public String delete(@PathVariable Long id) {
		service.deleteNotification(id);
		return "Notification deleted";
	}
}
