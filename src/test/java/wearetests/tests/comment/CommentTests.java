package wearetests.tests.comment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommentTests extends BaseComment{

    @Test
    public void createAComment() {
        commentPage.clickExploreThisPostButton();
        commentPage.createNewComment("A new comment is created");
        commentPage.clickPostCommentButton();

        String commentContent = commentPage.getCommentText();
        Assertions.assertTrue(commentContent.contains("A new comment is created"), "Post content does not match expected value.");
    }
}
