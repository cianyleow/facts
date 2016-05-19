package com.ic.ee.util.marker.impl;

import java.util.List;

import com.ic.ee.domain.course.assignment.submission.Submission;
import com.ic.ee.domain.user.marker.Marker;
import com.ic.ee.util.marker.Allocator;

public class RoundRobinAllocator implements Allocator {

	private int currentMarker;

	@Override
	public Marker getMarker(Submission submission, List<Marker> markers) {
		Marker marker = markers.get(currentMarker % markers.size());
		currentMarker++;
		return marker;
	}
}
