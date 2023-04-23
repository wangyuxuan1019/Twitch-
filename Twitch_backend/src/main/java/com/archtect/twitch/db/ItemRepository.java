package com.archtect.twitch.db;

import com.archtect.twitch.db.entity.ItemEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface ItemRepository extends ListCrudRepository<ItemEntity, Long> {
    ItemEntity findByTwitchId(String twitchId);
}
