package com.cts.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.project.dto.NotificationDTO;
import com.cts.project.exception.NotificationNotFoundException;
import com.cts.project.model.Notification;
import com.cts.project.repository.NotificationRepository;

@Service
public class NotificationServiceImpl implements NotificationService{
	@Autowired
	private NotificationRepository repository;

	public Notification sendNotification(NotificationDTO dto) {
		Notification n = new Notification();
		n.setPatientId(dto.getPatientId());
		n.setMessage(dto.getMessage());
		n.setTimestamp(dto.getTimestamp());
		return repository.save(n);
	}

	public List<Notification> getAllNotifications() {
		return repository.findAll();
	}

	public Notification getNotificationById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new NotificationNotFoundException("Notification not found with id: " + id));
	}

	public void deleteNotification(Long id) {
		if (!repository.existsById(id)) {
			throw new NotificationNotFoundException("Notification not found with id: " + id);
		}
		repository.deleteById(id);
	}
}
