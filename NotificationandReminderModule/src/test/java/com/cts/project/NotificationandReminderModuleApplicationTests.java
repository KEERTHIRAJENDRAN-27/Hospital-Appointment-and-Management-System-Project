package com.cts.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.project.dto.NotificationDTO;
import com.cts.project.model.Notification;
import com.cts.project.repository.NotificationRepository;
import com.cts.project.service.NotificationServiceImpl;

@SpringBootTest
class NotificationandReminderModuleApplicationTests {

//	@Test
//	void contextLoads() {
//	}

	@Mock
    private NotificationRepository repository;
 
    @InjectMocks
    private NotificationServiceImpl service;
 
    @Test
    public void testSendNotification() {
        NotificationDTO dto = new NotificationDTO();
        dto.setPatientId(1L);
        dto.setMessage("Reminder!");
        dto.setTimestamp(LocalDateTime.now());
 
        Notification saved = new Notification();
        saved.setNotificationId(1L);
        saved.setPatientId(dto.getPatientId());
        saved.setMessage(dto.getMessage());
        saved.setTimestamp(dto.getTimestamp());
 
        when(repository.save(any(Notification.class))).thenReturn(saved);
 
        Notification result = service.sendNotification(dto);
        assertEquals(dto.getPatientId(), result.getPatientId());
        assertEquals(dto.getMessage(), result.getMessage());
    }
 
    @Test
    public void testGetNotificationById() {
        Notification notification = new Notification();
        notification.setNotificationId(1L);
        notification.setPatientId(1L);
        notification.setMessage("Reminder!");
 
        when(repository.findById(1L)).thenReturn(Optional.of(notification));
        Notification result = service.getNotificationById(1L);
 
        assertEquals("Reminder!", result.getMessage());
    }
 
    @Test
    public void testDeleteNotification() {
        when(repository.existsById(1L)).thenReturn(true);
        doNothing().when(repository).deleteById(1L);
        service.deleteNotification(1L);
        verify(repository).deleteById(1L);
    }
}
