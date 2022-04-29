package me.smc219.BackupMonitoring.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Server {
	@Id
	private String ip;
	private String hostname;

	@OneToMany(mappedBy = "server")
	List<Backup> backupList = new java.util.ArrayList<>();

}
