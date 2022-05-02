package me.smc219.BackupMonitoring.service;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import me.smc219.BackupMonitoring.entity.Backup;
import me.smc219.BackupMonitoring.repository.BackupRepository;

@RequiredArgsConstructor
@Service
public class BackupService {
	private final BackupRepository backupRepository;

	public List<Backup> findByMonthly() {
		LocalDateTime endTime = LocalDateTime.now();
		LocalDateTime startTime = endTime.minusMonths(1);
		return backupRepository.findBackupByTime(startTime, endTime);
	}

}
