package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * Criteria class for the {@link gov.naco.soch.domain.District} entity. This class is used
 * in {@link gov.naco.soch.web.rest.DistrictResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /districts?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class DistrictCriteria{

    private static final long serialVersionUID = 1L;

    private Long id;

    private String alternateName;

    private String name;

    public DistrictCriteria() {
    }

//    public DistrictCriteria(DistrictCriteria other) {
//        this.id = other.id == null ? null : other.id.copy();
//        this.alternateName = other.alternateName == null ? null : other.alternateName.copy();
//        this.name = other.name == null ? null : other.name.copy();
//    }
//
//    @Override
//    public DistrictCriteria copy() {
//        return new DistrictCriteria(this);
//    }

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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final DistrictCriteria that = (DistrictCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(alternateName, that.alternateName) &&
            Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        alternateName,
        name
        );
    }

    @Override
    public String toString() {
        return "DistrictCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (alternateName != null ? "alternateName=" + alternateName + ", " : "") +
                (name != null ? "name=" + name + ", " : "") +
            "}";
    }

}
