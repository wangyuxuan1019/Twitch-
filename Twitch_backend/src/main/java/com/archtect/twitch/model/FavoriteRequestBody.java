package com.archtect.twitch.model;

import com.archtect.twitch.db.entity.ItemEntity;

public record FavoriteRequestBody(
        ItemEntity favorite
) {
}
