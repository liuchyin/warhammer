package com.marc.warhammer.data;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class GameServer {
	private static final Log LOGGER = LogFactory.getLog(GameServer.class);
	private Map<String, Integer> tables = new HashMap<>();
	public GameServer(){
		for(int i = 0; i < 10; ++i) {
			tables.put(String.valueOf(i), 0);
		}
	}

	public Map<String, Integer> getTables() {
		return tables;
	}

	public void setTables(Map<String, Integer> tables) {
		this.tables = tables;
	}

	//锁住整个map
	public synchronized void joinWithLockAllTable(String id) {
		Integer count = tables.get(id);
		count += 1;
		LOGGER.info(String.format("table id: %s, count: %d", id, count));
	}
	
	
	//只锁住对应的记录
	public void joinWithLockOneTable(String id) {
		Integer count = tables.get(id);
		synchronized(count) {
			count += 1;
		}
		LOGGER.info(String.format("table id: %s, count: %d", id, count));
	}
	
}
