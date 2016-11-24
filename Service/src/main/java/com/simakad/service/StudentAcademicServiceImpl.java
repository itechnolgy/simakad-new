package com.simakad.service;

import com.simakad.dao.constant.ScoreType;
import com.simakad.dao.entity.CourseResultSheet;
import com.simakad.dao.entity.Transcript;
import com.simakad.dao.repo.CourseResultSheetDao;
import com.simakad.dao.repo.TranscriptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

/**
 * Created by SRIN on 11/23/2016.
 */
@Component
public class StudentAcademicServiceImpl implements StudentAcademicService {
    private final double ASSIGNMENT_WEIGHT = 0.2;
    private final double MIDEXAM_WEIGHT = 0.3;
    private final double FINALEXAM_WEIGHT = 0.5;

    @Autowired
    CourseResultSheetDao courseResultSheetDao;

    @Autowired
    TranscriptDao transcriptDao;

    @Override
    public void editStudentScore(String studentId, String courseId, ScoreType scoreType, int score) {
        CourseResultSheet resultSheet = courseResultSheetDao.findByStudentIdAndCourseIdAndPeriode(studentId, courseId, true);
        if(Objects.isNull(resultSheet)) throw new RuntimeException("Illegal hit endpoint edit student score");

        if(scoreType == ScoreType.TUGAS)
            resultSheet.setAssignmentScore(score);
        else if(scoreType == ScoreType.UTS)
            resultSheet.setMidExamScore(score);
        else if(scoreType == ScoreType.UAS)
            resultSheet.setFinalExamScore(score);

        boolean isScoresComplete = isScoresCompleted(resultSheet);
        if(isScoresComplete) {
            int finalScore = getFinalScore(resultSheet);
            char letterScore = getLetterScore(finalScore);
            resultSheet.setFinalExamScore(finalScore);
            resultSheet.setFinalGrade(Character.toString(letterScore));
        }

        resultSheet = courseResultSheetDao.save(resultSheet);

        if(isScoresComplete) updateStudentTranscript(resultSheet);
    }

    private void updateStudentTranscript(CourseResultSheet courseResultSheet) {
        Transcript transcript = transcriptDao.findByStudentIdAndCourseId(courseResultSheet.getStudentId(), courseResultSheet.getCourseId());
        if(!Objects.isNull(transcript)) {
            transcript.setFinalScore(courseResultSheet.getFinalScore());
            transcript.setFinalGrade(courseResultSheet.getFinalGrade());
            transcript.setLastUpdateTime(new Date());
        } else {
            transcript = new Transcript();
            transcript.setStudentId(courseResultSheet.getStudentId());
            transcript.setCourseId(courseResultSheet.getCourseId());
            transcript.setFinalScore(courseResultSheet.getFinalScore());
            transcript.setFinalGrade(courseResultSheet.getFinalGrade());
            transcript.setLastUpdateTime(new Date());
            transcript.setCreationTime(new Date());
        }
        transcriptDao.save(transcript);
    }

    private boolean isScoresCompleted(CourseResultSheet courseResultSheet) {
        if(courseResultSheet.getAssignmentScore() != null && courseResultSheet.getMidExamScore() != null && courseResultSheet.getFinalExamScore() != null)
            return true;
        else return false;
    }

    private int getFinalScore(CourseResultSheet courseResultSheet) {
        double totalScore = (courseResultSheet.getAssignmentScore() * ASSIGNMENT_WEIGHT) +
                            (courseResultSheet.getMidExamScore() * MIDEXAM_WEIGHT) +
                            (courseResultSheet.getFinalExamScore() * FINALEXAM_WEIGHT);

        return (int) totalScore;
    }

    private char getLetterScore(int score) {
        if(score >= 85) return 'A';
        else if(score >= 75) return 'B';
        else if(score >= 65) return 'C';
        else if(score >= 55) return 'D';
        else return 'E';
    }
}
