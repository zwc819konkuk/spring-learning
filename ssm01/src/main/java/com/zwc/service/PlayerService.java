package com.zwc.service;

import com.zwc.pojo.Player;

import java.util.List;

public interface PlayerService {
    int addPlayer(Player player);

    List<Player> getAllPlayer();
}
