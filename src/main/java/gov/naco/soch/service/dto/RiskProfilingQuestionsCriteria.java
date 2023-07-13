package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.util.Objects;



/**
 * Criteria class for the {@link gov.naco.soch.domain.RiskProfilingQuestions} entity. This class is used
 * in {@link gov.naco.soch.web.rest.RiskProfilingQuestionsResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /risk-profiling-questions?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class RiskProfilingQuestionsCriteria{

    private static final long serialVersionUID = 1L;

    private Long id;

    private String question;

    private String answers;

    public RiskProfilingQuestionsCriteria() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }


    @Override
    public String toString() {
        return "RiskProfilingQuestionsCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (question != null ? "question=" + question + ", " : "") +
                (answers != null ? "answers=" + answers + ", " : "") +
            "}";
    }

}
