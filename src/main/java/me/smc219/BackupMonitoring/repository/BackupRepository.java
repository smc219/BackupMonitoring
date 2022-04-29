package me.smc219.BackupMonitoring.repository;

import java.lang.reflect.Member;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import me.smc219.BackupMonitoring.entity.Backup;

@Repository
@RequiredArgsConstructor
public class BackupRepository {
	private final EntityManager em;

	List<Backup> findBackupByName(String name) {
		return em.createQuery("select * from Backup b where b.name like :name", Backup.class).setParameter("name", name).getResultList();
	}

	Backup findBackupById(Long id) {
		return em.find(Backup.class, id);
	}

}
