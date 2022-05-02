package me.smc219.BackupMonitoring.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import me.smc219.BackupMonitoring.entity.Server;

@Repository
@RequiredArgsConstructor
public class ServerRepository {
	private final EntityManager em;

	List<Server> findByHostname(String name) {
		Query query = em.createQuery("select s from Server s where s.hostname like :name");
		query.setParameter("name", name);
		return query.getResultList();
	}

	Server findById(String id) {
		return em.find(Server.class, id);
	}

}
