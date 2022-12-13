package org.eternity.playlist.step02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Playlist {

	private final List<Song> tracks = new ArrayList<>();
	private final Map<String, String> singers = new HashMap<>();

	public void append(Song song) {
		tracks.add(song);
		singers.put(song.singer(), song.title());
	}

	public List<Song> getTracks() {
		return tracks;
	}

	public Map<String, String> getSingers() {
		return singers;
	}
}
