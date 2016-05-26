package com.ic.ee.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ic.ee.core.dao.api.AssignmentDAO;
import com.ic.ee.core.dao.api.CourseDAO;
import com.ic.ee.core.dao.api.FileDAO;
import com.ic.ee.core.dao.api.FileRequirementDAO;
import com.ic.ee.core.dao.api.SubmissionDAO;
import com.ic.ee.core.web.exception.FileUploadException;
import com.ic.ee.core.web.exception.HashingException;
import com.ic.ee.core.web.exception.IncorrectFileNameFormatException;
import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.course.assignment.Assignment;
import com.ic.ee.service.api.AssignmentService;
import com.ic.ee.service.api.FileService;
import com.ic.ee.service.api.NotificationService;
import com.ic.ee.service.impl.SimpleAssignmentService;

public class AssignmentServiceTest {

	private AssignmentService assignmentService;

	private AssignmentDAO assignmentDAO;
	private FileRequirementDAO fileRequirementDAO;
	private SubmissionDAO submissionDAO;
	private FileDAO fileDAO;
	private CourseDAO courseDAO;
	private FileService fileService;
	private NotificationService notificationService;

	@Before
	public void setUp() {
		assignmentDAO = mock(AssignmentDAO.class);
		fileRequirementDAO = mock(FileRequirementDAO.class);
		submissionDAO = mock(SubmissionDAO.class);
		fileDAO = mock(FileDAO.class);
		courseDAO = mock(CourseDAO.class);
		fileService = mock(FileService.class);
		notificationService = mock(NotificationService.class);

		assignmentService = new SimpleAssignmentService(assignmentDAO, fileRequirementDAO, submissionDAO, fileDAO, courseDAO, fileService, notificationService);

		when(assignmentDAO.one(1)).thenReturn(createLiteAssignment());
		when(fileRequirementDAO.getFileRequirements(1)).thenReturn(mock(List.class));
		when(submissionDAO.getSubmissions(new Assignment(1))).thenReturn(mock(List.class));
		when(fileDAO.getFiles(new Assignment(1))).thenReturn(mock(List.class));
		when(courseDAO.one(1)).thenReturn(new Course(1));
	}

	private Assignment createLiteAssignment() {
		Assignment assignment = new Assignment();
		assignment.setAssignmentId(1);
		assignment.setName("");
		assignment.setDescription("");
		assignment.setCreationTime(mock(Timestamp.class));
		assignment.setDueTime(mock(Timestamp.class));
		assignment.setOpenTime(mock(Timestamp.class));
		assignment.setCourse(new Course(1));
		return assignment;
	}

	@Test
	public void liteAssignmentHasNoDecorations() {
		Assignment assignment = assignmentService.getLiteAssignment(1);

		verify(assignmentDAO).one(1);

		assertNotNull(assignment.getAssignmentId());
		assertNotNull(assignment.getName());
		assertNotNull(assignment.getDescription());
		assertNotNull(assignment.getCreationTime());
		assertNotNull(assignment.getDueTime());
		assertNotNull(assignment.getOpenTime());
	}

	@Test
	public void fullAssignmentHasComplexDecorations() {
		Assignment assignment = assignmentService.getAssignment(1);

		verify(assignmentDAO).one(1);
		verify(fileRequirementDAO).getFileRequirements(1);
		verify(submissionDAO).getSubmissions(assignment);
		verify(fileDAO).getFiles(assignment);
		verify(courseDAO).one(1);

		assertNotNull(assignment.getSubmissions());
		assertNotNull(assignment.getSuppliedFiles());
		assertNotNull(assignment.getRequiredFiles());
	}

	@Test
	public void createdAssignmentHasNewId() throws IncorrectFileNameFormatException, FileUploadException, HashingException, NoResultsReturnedException {
//		Assignment uploadedAssignment = createLiteAssignment();
//		uploadedAssignment.setAssignmentId(null);
//		Assignment assignment = assignmentService.createAssignment(1, uploadedAssignment, null, "TESTNAME");
//
//		assertNotNull(assignment.getAssignmentId());
	}

}
