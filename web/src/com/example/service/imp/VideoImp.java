package com.example.service.imp;

import java.util.ArrayList;
import java.util.List;

import com.example.domin.Video;
import com.example.service.VideoIm;

public class VideoImp implements VideoIm {
	
	public List<Video> getLast() {
		List<Video> videos=new ArrayList<Video>();
		videos.add(new Video(12,"楚乔传",45));
		videos.add(new Video(13,"快乐大本营",90));
		videos.add(new Video(14,"你太过分了",60));
		return videos;
	}
}
