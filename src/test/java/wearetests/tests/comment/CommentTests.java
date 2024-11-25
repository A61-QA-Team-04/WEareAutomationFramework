package wearetests.tests.comment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommentTests extends BaseComment{

    @Test
    public void createAComment_Test() {
        commentPage.clickExploreThisPostButton();
        commentPage.createNewComment("Тестер");
        commentPage.clickPostCommentButton();
        commentPage.clickShowCommentsButton();

        String commentContent = commentPage.getCommentText();
        Assertions.assertTrue(commentContent.contains("Тестер"), "Post content does not match expected value.");
    }

    @Test
    public void deleteAComment_Test() {
        commentPage.clickExploreThisPostButton();
        commentPage.clickShowCommentsButton();
        commentPage.clickDeleteCommentsButton();
        commentPage.selectDeleteOption("Delete comment");
        commentPage.clickSubmitButton();

        String commentContent = commentPage.getDeleteMesaggeText();
        Assertions.assertTrue(commentContent.contains("Comment deleted successfully"), "Comment is not deleted.");
    }

    @Test
    public void createAComment_with_long_message_Test() {
        commentPage.clickExploreThisPostButton();
        commentPage.createNewComment("testtesttesttesttesttesttesttest testtesttesttesttesttesttesttest " +
                "testtesttesttesttesttesttesttest testtesttesttesttesttesttesttest testtesttesttesttesttesttesttest " +
                "testtesttesttesttesttesttesttest testtesttesttesttesttesttesttest testtesttesttesttesttesttesttest " +
                "testtesttesttesttesttesttesttest testtesttesttesttesttesttesttest testtesttesttesttesttesttesttest " +
                "testtesttesttesttesttesttesttest testtesttesttesttesttesttesttest testtesttesttesttesttesttesttest " +
                "testtesttesttesttesttesttesttest testtesttesttesttesttesttesttest testtesttesttesttesttesttesttest " +
                "testtesttesttesttesttesttesttest testtesttesttesttesttesttesttest testtesttesttesttesttesttesttest " +
                "testtesttesttesttesttesttesttest testtesttesttesttesttesttesttest testtesttesttesttesttesttesttest " +
                "testtesttesttesttesttesttesttest testtesttesttesttesttesttesttest testtesttesttesttesttesttesttest " +
                "testtesttesttesttesttesttesttest testtesttesttesttesttesttesttest testtesttesttesttesttesttesttest " +
                "testtesttesttesttesttesttesttest testtesttesttesttesttesttesttest testtesttesttesttesttesttesttest " +
                "testtesttesttesttesttesttesttest testtesttesttesttesttesttesttest testtesttesttesttesttesttesttest " +
                "testtesttesttesttesttesttesttest testtesttesttesttesttesttesttest testtesttesttesttesttesttesttest " +
                "testtesttesttesttesttesttesttest testtesttesttesttesttesttesttest testtesttesttesttesttesttesttest " +
                "testtesttesttesttesttesttesttest testtesttesttesttesttesttesttest testtesttesttesttesttesttesttest " +
                "testtesttesttesttesttesttesttest testtesttesttesttesttesttesttest testtesttesttesttesttesttesttest " +
                "testtesttesttesttesttesttesttest testtesttesttesttesttesttesttest testtesttesttesttesttesttesttest " +
                "testtesttesttesttesttesttesttest testtesttesttesttesttesttesttest testtesttesttesttesttesttesttest " +
                "testtesttesttesttesttesttesttest testtesttesttesttesttesttesttest testtesttesttesttesttesttesttest " +
                "testtesttesttesttesttesttesttest testtesttesttesttesttesttesttest testtesttesttesttesttesttesttest " +
                "testtesttesttesttesttesttesttest testtesttesttesttesttesttesttest testtesttesttesttesttesttesttest " +
                "testtesttesttesttesttesttesttest testtesttesttesttesttesttesttest testtesttesttesttesttesttesttest " +
                "testtesttesttesttesttesttesttest");
        commentPage.clickPostCommentButton();

        String commentContent = commentPage.getCommentText();
        Assertions.assertTrue(commentContent.contains("A new comment is created"), "Post content does not match expected value.");
    }
}
