package com.sgic.internal.defecttracker.defectservice.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defectservice.entities.Comments;

@Service
public interface CommentService {
	public Comments createComments(Comments comments);

	public List<Comments> getCommentsById(String defectId);

	public List<Comments> getAllComments();

	public void deleteById(Long commentId);
}
