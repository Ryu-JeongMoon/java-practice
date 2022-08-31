package org.designpattern.structure.decorator._01_before;

public class Client {

  private final CommentService commentService;

  public Client(CommentService commentService) {
    this.commentService = commentService;
  }

  public static void main(String[] args) {
    Client client = new Client(new TrimmingCommentService());
    client.writeComment("https://ryumodrn.tistory.com/");
    client.writeComment("티스토리");
    client.writeComment("보는게 하는거 보다 재밌을 수가 없지...");
  }

  private void writeComment(String comment) {
    commentService.addComment(comment);
  }

}
