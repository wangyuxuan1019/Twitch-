package com.archtect.twitch.favorite;

import com.archtect.twitch.db.entity.UserEntity;
import com.archtect.twitch.model.FavoriteRequestBody;
import com.archtect.twitch.model.TypeGroupedItemList;
import com.archtect.twitch.user.UserService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.relational.core.conversion.DbActionExecutionException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/favorite")
public class FavoriteController {

    private final FavoriteService favoriteService;
    private final UserService userService;

//    private final UserEntity userEntity = new UserEntity(1L, "user0", "Foo", "Bar", "password");

    public FavoriteController (FavoriteService favoriteService, UserService userService) {
        this.favoriteService = favoriteService;
        this.userService = userService;
    }

    @GetMapping
    public TypeGroupedItemList getFavoriteItem(@AuthenticationPrincipal User user) {
        UserEntity userEntity = userService.findByUsername(user.getUsername());
        return favoriteService.getGroupFavoriteItems(userEntity);
    }


    @PostMapping
    public void setFavoriteItem(@AuthenticationPrincipal User user, @RequestBody FavoriteRequestBody body) {
        UserEntity userEntity = userService.findByUsername(user.getUsername());
        try {
            favoriteService.setFavoriteItem(userEntity, body.favorite());
        } catch (DbActionExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof DataIntegrityViolationException) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Duplicate entry for favorite record", e);
            } else {
                throw e;
            }
        }
    }

    @DeleteMapping
    public void unsetFavoriteItem(@AuthenticationPrincipal User user, @RequestBody FavoriteRequestBody body) {
        UserEntity userEntity = userService.findByUsername(user.getUsername());
        favoriteService.unsetFavoriteItem(userEntity, body.favorite().twitchId());
    }
}
