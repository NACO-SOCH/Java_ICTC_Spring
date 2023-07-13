package gov.naco.soch.service.dto;

import java.io.Serializable;


/**
 * Criteria class for the {@link gov.naco.soch.domain.State} entity. This class is used
 * in {@link gov.naco.soch.web.rest.StateResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /states?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class StateCriteria {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String alternateName;

    private String name;

    public StateCriteria() {
    }

   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlternateName() {
        return alternateName;
    }

    public void setAlternateName(String alternateName) {
        this.alternateName = alternateName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "StateCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (alternateName != null ? "alternateName=" + alternateName + ", " : "") +
                (name != null ? "name=" + name + ", " : "") +
            "}";
    }

}
