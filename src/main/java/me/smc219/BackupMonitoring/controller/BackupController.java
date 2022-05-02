package me.smc219.BackupMonitoring.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import me.smc219.BackupMonitoring.entity.Backup;
import me.smc219.BackupMonitoring.service.BackupService;

@RequiredArgsConstructor
@RestController
public class BackupController {
	private final BackupService backupService;

	@GetMapping("/backup/today")
	public List<Backup> findTodayBackup() {
		return backupService.findByMonthly();
	}
}
