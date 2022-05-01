package me.smc219.BackupMonitoring.repository;

import java.lang.reflect.Member;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import me.smc219.BackupMonitoring.entity.Backup;

@Repository
@RequiredArgsConstructor
public class BackupRepository {
	private final EntityManager em;

	List<Backup> findBackupByName(String name) {
		return em.createQuery("select b from Backup b where b.name like :name", Backup.class).setParameter("name", name).getResultList();
	}

	Backup findBackupById(Long id) {
		return em.find(Backup.class, id);
	}

	List<Backup> findBackupByTime(LocalDateTime startTime, LocalDateTime endTime) {
		Query query = em.createQuery("select b from Backup b where b.startTime >= :startTime and b.endTime <= :endTime");
		query.setParameter("startTime", startTime);
		query.setParameter("endTime", endTime);
		return query.getResultList();
	}
}
