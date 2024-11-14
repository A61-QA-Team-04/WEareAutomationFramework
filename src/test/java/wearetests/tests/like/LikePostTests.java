package wearetests.tests.like;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LikePostTests extends BaseLike {
    @Test
    public void likePost_Test() {
        feedsPage.clickLikeButton();
        Assertions.assertEquals(feedsPage.getLikeCount(), "Likes: 1", "POST NOT LIKED");

    }

    @Test
    public void likePost_Then_DislikePost() {
        feedsPage.clickLikeButton();
        Assertions.assertEquals(feedsPage.getLikeCount(), "Likes: 1", "POST NOT LIKED");
        feedsPage.clickLikeButton();
        Assertions.assertEquals(feedsPage.getLikeCount(), "Likes: 0", "POST NOT LIKED");
    }

}
