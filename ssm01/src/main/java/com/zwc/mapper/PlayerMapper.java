package com.zwc.mapper;

import com.zwc.pojo.Player;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PlayerMapper {

    public int addPlayer(Player player);

    @Select("select * from player")
    List<Player> getAllPlayer();
}
