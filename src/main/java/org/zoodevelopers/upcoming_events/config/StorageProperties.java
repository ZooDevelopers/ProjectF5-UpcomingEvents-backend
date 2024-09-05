package org.zoodevelopers.upcoming_events.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("storage")
public class StorageProperties {
	private String location = "src\\main\\resources\\static"; //Preguntar a Giaco si esto es lo que se espera en cuanto a rutas

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
    
}
