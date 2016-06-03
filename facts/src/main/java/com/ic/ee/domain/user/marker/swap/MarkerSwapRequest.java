package com.ic.ee.domain.user.marker.swap;

import com.fasterxml.jackson.annotation.JsonView;
import com.ic.ee.domain.Views;
import com.ic.ee.domain.common.feedback.Feedback;
import com.ic.ee.domain.user.marker.Marker;

public class MarkerSwapRequest {

	@JsonView(Views.Marker.class)
	private Integer markerSwapRequestId;

	@JsonView(Views.Marker.class)
	private Feedback feedback;

	@JsonView(Views.Marker.class)
	private Marker newMarker;

	@JsonView(Views.Marker.class)
	private MarkerSwapRequestStatus status;

	public MarkerSwapRequest() {
	}

	public MarkerSwapRequest(Integer markerSwapRequestId) {
		this.markerSwapRequestId = markerSwapRequestId;
	}

	public Integer getMarkerSwapRequestId() {
		return markerSwapRequestId;
	}

	public void setMarkerSwapRequestId(Integer markerSwapRequestId) {
		this.markerSwapRequestId = markerSwapRequestId;
	}

	public Feedback getFeedback() {
		return feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}

	public Marker getNewMarker() {
		return newMarker;
	}

	public void setNewMarker(Marker newMarker) {
		this.newMarker = newMarker;
	}

	public MarkerSwapRequestStatus getStatus() {
		return status;
	}

	public void setStatus(MarkerSwapRequestStatus status) {
		this.status = status;
	}
}
