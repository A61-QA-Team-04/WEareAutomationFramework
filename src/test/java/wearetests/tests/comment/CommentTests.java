package wearetests.tests.comment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommentTests extends BaseComment{

    String comment = "Prowerka";
    String longText = "testtesttesttesttesttesttesttest ";
    String longComment = longText.repeat(66);

    @Test
    public void createAComment_Test() {
        //   createComment(comment);
        commentPage.createNewComment(comment);
        commentPage.clickPostCommentButton();
        commentPage.clickShowCommentsButton();
        Assertions.assertTrue(commentPage.isCommentConfirmationDisplayed(comment),
                "Post content does not match expected value.");
    }

    @Test
    public void deleteAComment_Test() {
        deleteComment();
        Assertions.assertEquals(commentPage.getDeleteMesaggeText(),
                "Comment deleted successfully",
                "Comment is not deleted.");
    }

    @Test
    public void createAComment_with_long_message_Test() {
        // createComment(longComment);
        commentPage.createNewComment(longComment);
        commentPage.clickPostCommentButton();
        commentPage.clickShowCommentsButton();
        Assertions.assertEquals(
                longComment.trim(),
                commentPage.getCommentText(longComment).trim(),
                "The posted comment does not match the expected value."
        );
    }
}
