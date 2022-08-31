package org.designpattern.structure.decorator._02_after;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Client {

  private final CommentService commentService;

  public void writeComment(String comment) {
    commentService.addComment(comment);
  }
}
