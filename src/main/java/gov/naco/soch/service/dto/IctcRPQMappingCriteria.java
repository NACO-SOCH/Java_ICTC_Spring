package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.util.Objects;


/**
 * Criteria class for the {@link gov.naco.soch.domain.IctcRPQMapping} entity. This class is used
 * in {@link gov.naco.soch.web.rest.IctcRPQMappingResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /ictc-rpq-mappings?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link } class are used, we need to use
 * fix type specific filters.
 */
public class IctcRPQMappingCriteria implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long pid;

    private Long visitId;

    private Long rpqId;

    private String answer;

    public IctcRPQMappingCriteria() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getVisitId() {
        return visitId;
    }

    public void setVisitId(Long visitId) {
        this.visitId = visitId;
    }

    public Long getRpqId() {
        return rpqId;
    }

    public void setRpqId(Long rpqId) {
        this.rpqId = rpqId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final IctcRPQMappingCriteria that = (IctcRPQMappingCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(pid, that.pid) &&
            Objects.equals(visitId, that.visitId) &&
            Objects.equals(rpqId, that.rpqId) &&
            Objects.equals(answer, that.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        pid,
        visitId,
        rpqId,
        answer
        );
    }

    @Override
    public String toString() {
        return "IctcRPQMappingCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (pid != null ? "pid=" + pid + ", " : "") +
                (visitId != null ? "visitId=" + visitId + ", " : "") +
                (rpqId != null ? "rpqId=" + rpqId + ", " : "") +
                (answer != null ? "answer=" + answer + ", " : "") +
            "}";
    }

}
