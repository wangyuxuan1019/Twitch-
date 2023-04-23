package com.archtect.twitch;

import com.archtect.twitch.db.FavoriteRecordRepository;
import com.archtect.twitch.db.ItemRepository;
import com.archtect.twitch.db.UserRepository;
import com.archtect.twitch.db.entity.FavoriteRecordEntity;
import com.archtect.twitch.db.entity.ItemEntity;
import com.archtect.twitch.db.entity.UserEntity;
import com.archtect.twitch.external.TwitchService;
import com.archtect.twitch.external.model.Clip;
import com.archtect.twitch.external.model.Game;
import com.archtect.twitch.external.model.Stream;
import com.archtect.twitch.external.model.Video;
import com.archtect.twitch.model.ItemType;
import com.archtect.twitch.user.UserService;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@Component
public class DevelopmentTester implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(DevelopmentTester.class);

    private final UserService userService;
    public DevelopmentTester(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(ApplicationArguments args) {
        userService.register("default", "123456", "John", "Smith");
    }

// ----------------------------------------------------------------------------------------------------

//    private static final Logger logger = LoggerFactory.getLogger(DevelopmentTester.class);
//
//    private final UserRepository userRepository;
//    public DevelopmentTester(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public void run(ApplicationArguments args) {
//        UserEntity newUser = new UserEntity(null, "user0", "Foo", "Bar", "password");
//        userRepository.save(newUser);
//    }



//    -----------------------------------------------------------------------------------------------------

//    private static final Logger logger = LoggerFactory.getLogger(DevelopmentTester.class);
//    private final UserRepository userRepository;
//    private final ItemRepository itemRepository;
//    private final FavoriteRecordRepository favoriteRecordRepository;
//
//
//    public DevelopmentTester(
//            UserRepository userRepository,
//            ItemRepository itemRepository,
//            FavoriteRecordRepository favoriteRecordRepository
//    ) {
//        this.userRepository = userRepository;
//        this.itemRepository = itemRepository;
//        this.favoriteRecordRepository = favoriteRecordRepository;
//    }
//
//    @Override
//    public void run(ApplicationArguments args) {
//
//        UserEntity newUser = new UserEntity(null, "user0", "Foo", "Bar", "password");
//        userRepository.save(newUser);
//
//        UserEntity user1 = new UserEntity(null, "user1", "John", "Smith", "password");
//        UserEntity user2 = new UserEntity(null, "user2", "Jane", "Smith", "password");
//        UserEntity user3 = new UserEntity(null, "user3", "John", "Doe", "password");
//        userRepository.saveAll(List.of(user1, user2, user3));
//
//        ItemEntity newItem = new ItemEntity(null, "abc0", "Title0", "url0", "thumb0", "name0", "game0", ItemType.CLIP);
//        itemRepository.save(newItem);
//
//        List<ItemEntity> newItems = List.of(
//                new ItemEntity(null, "abc1", "Title1", "url1", "thumb1", "name1", "game1", ItemType.VIDEO),
//                new ItemEntity(null, "abc2", "Title2", "url2", "thumb2", "name2", "game2", ItemType.VIDEO),
//                new ItemEntity(null, "abc3", "Title3", "url3", "thumb3", "name3", "game3", ItemType.STREAM),
//                new ItemEntity(null, "abc4", "Title4", "url4", "thumb4", "name4", "game4", ItemType.STREAM)
//                );
//        itemRepository.saveAll(newItems);
//
//        favoriteRecordRepository.saveAll(List.of(
//                new FavoriteRecordEntity(null, 1L, 1L, Instant.now()),
//                new FavoriteRecordEntity(null, 1L, 3L, Instant.now()),
//                new FavoriteRecordEntity(null, 1L, 4L, Instant.now()),
//                new FavoriteRecordEntity(null, 2L, 2L, Instant.now())
//        ));
//
//        userRepository.updateNameByUsername("user0", "Far", "Boo");
//
//        List<UserEntity> johns = userRepository.findByFirstName("John");
//        logger.info("John: " + johns);
//        List<UserEntity> smiths = userRepository.findByLastName("Smith");
//        logger.info("Smith: " + smiths);
//
//        UserEntity user0 = userRepository.findByUsername("user0");
//        logger.info("user0: " + user0);
//
//        boolean item1Exists = itemRepository.existsById(1L);
//        boolean item100Exists = itemRepository.existsById(100L);
//        logger.info("Item1exists: " + item1Exists);
//        logger.info("Item100exists: " + item100Exists);
//        ItemEntity abc11 = itemRepository.findByTwitchId("abc1");
//
//        itemRepository.deleteById(2L);
//        boolean item2Exists = itemRepository.existsById(2L);
//
//        ItemEntity abc1 = itemRepository.findByTwitchId("abc1");
//
//        List<FavoriteRecordEntity> user1Favorites = favoriteRecordRepository.findAllByUserId(1L);
//        List<FavoriteRecordEntity> user2Favorites = favoriteRecordRepository.findAllByUserId(2L);
//
//        List<Long> user1FavoriteItemIds = favoriteRecordRepository.findFavoriteItemIdsByUserId(1L);
//        List<Long> user2FavoriteItemIds = favoriteRecordRepository.findFavoriteItemIdsByUserId(2L);
//
//        favoriteRecordRepository.delete(1L, 3L);
//        List<FavoriteRecordEntity> user1FavoritesAfterDelete = favoriteRecordRepository.findAllByUserId(1L);
//
//    }


// ----------------------------------------------------------------------------------------------------

//    private static final Logger logger = LoggerFactory.getLogger(DevelopmentTester.class);

//    private final TwitchService twitchService;
//
//    public DevelopmentTester(TwitchService twitchService) {
//        this.twitchService = twitchService;
//    }
//
//    @Override
//    public void run(ApplicationArguments args) {
//        List<Game> games = twitchService.getGames("fortnite");
//        List<Game> topGames = twitchService.getTopGames();
//        List<Video> videos = twitchService.getVideos("21779", 2);
//        List<Clip> clips = twitchService.getClips("21779", 2);
//        List<Stream> streams = twitchService.getStreams(List.of("18122", "21779", "33214"), 10);
//
//        logger.info(games.toString());
//        logger.info(topGames.toString());
//        logger.info(videos.toString());
//        logger.info(clips.toString());
//        logger.info(streams.toString());
//    }
}
