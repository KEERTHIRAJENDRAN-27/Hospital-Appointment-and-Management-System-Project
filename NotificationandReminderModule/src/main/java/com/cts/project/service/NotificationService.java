package com.cts.project.service;

import java.util.List;

import com.cts.project.dto.NotificationDTO;
import com.cts.project.model.Notification;

public interface NotificationService {
	public abstract Notification sendNotification(NotificationDTO dto);

	public abstract List<Notification> getAllNotifications();

	public abstract Notification getNotificationById(Long id);

	public abstract void deleteNotification(Long id);
}
