package com.zwc.service.impl;

import com.zwc.mapper.PlayerMapper;
import com.zwc.pojo.Player;
import com.zwc.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerMapper playerMapper;

    public int addPlayer(Player player) {
        return playerMapper.addPlayer(player);
    }

    public List<Player> getAllPlayer() {
        return playerMapper.getAllPlayer();
    }
}
