package org.designpattern.behavior.iterator._02_after;

import java.util.Iterator;
import java.util.List;

import org.designpattern.behavior.iterator._01_before.Post;

public class RecentPostIterator implements Iterator<Post> {

	private final Iterator<Post> internalIterator;

	/*
	최소한의 정보만 받고 싶다면 Board를 받을 필요 없이
	클라이언트 코드에서 board.getPosts()로 posts를 받으면 된다
	 */
	public RecentPostIterator(List<Post> posts) {
		posts.sort((p1, p2) -> p2.getCreatedDateTime().compareTo(p1.getCreatedDateTime()));
		this.internalIterator = posts.iterator();
	}

	@Override
	public boolean hasNext() {
		return this.internalIterator.hasNext();
	}

	@Override
	public Post next() {
		return this.internalIterator.next();
	}
}
