package org.designpattern.behavior.iterator._02_after;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.designpattern.behavior.iterator._01_before.Post;

public class Board {

	List<Post> posts = new ArrayList<>();

	public List<Post> getPosts() {
		return posts;
	}

	public void addPost(String content) {
		this.posts.add(new Post(content));
	}

	public Iterator<Post> getRecentPostIterator() {
		return new RecentPostIterator(this.posts);
	}

}
