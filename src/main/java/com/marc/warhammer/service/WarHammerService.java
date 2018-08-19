package com.marc.warhammer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marc.warhammer.data.GameServer;

@Service
public class WarHammerService {

	@Autowired
	GameServer gameServer;
	
	public void joinWithLockAllTable(String id) {
		gameServer.joinWithLockAllTable(id);
	}
	
	public void joinWithLockOneTable(String id) {
		gameServer.joinWithLockOneTable(id);
	}
	
}
