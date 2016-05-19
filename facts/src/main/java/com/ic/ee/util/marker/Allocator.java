package com.ic.ee.util.marker;

import java.util.List;

import com.ic.ee.domain.course.assignment.submission.Submission;
import com.ic.ee.domain.user.marker.Marker;

public interface Allocator {

	public Marker getMarker(Submission submission, List<Marker> markers);

}
