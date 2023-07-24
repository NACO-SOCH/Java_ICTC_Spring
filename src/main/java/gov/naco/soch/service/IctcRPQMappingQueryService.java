package gov.naco.soch.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// for static metamodels
import gov.naco.soch.domain.IctcRPQMapping;
import gov.naco.soch.repository.IctcRPQMappingRepository;
import gov.naco.soch.service.dto.IctcRPQMappingCriteria;
import gov.naco.soch.service.dto.IctcRPQMappingDTO;
import gov.naco.soch.service.mapper.IctcRPQMappingMapper;

/**
 * Service for executing complex queries for {@link IctcRPQMapping} entities in the database.
 * The main input is a {@link IctcRPQMappingCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link IctcRPQMappingDTO} or a {@link Page} of {@link IctcRPQMappingDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class IctcRPQMappingQueryService {

    private final Logger log = LoggerFactory.getLogger(IctcRPQMappingQueryService.class);

    private final IctcRPQMappingRepository ictcRPQMappingRepository;

    private final IctcRPQMappingMapper ictcRPQMappingMapper;

    public IctcRPQMappingQueryService(IctcRPQMappingRepository ictcRPQMappingRepository, IctcRPQMappingMapper ictcRPQMappingMapper) {
        this.ictcRPQMappingRepository = ictcRPQMappingRepository;
        this.ictcRPQMappingMapper = ictcRPQMappingMapper;
    }

    /**
     * Return a {@link List} of {@link IctcRPQMappingDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<IctcRPQMappingDTO> findByCriteria(IctcRPQMappingCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<IctcRPQMapping> specification = createSpecification(criteria);
        return ictcRPQMappingMapper.toDto(ictcRPQMappingRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link IctcRPQMappingDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<IctcRPQMappingDTO> findByCriteria(IctcRPQMappingCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<IctcRPQMapping> specification = createSpecification(criteria);
        return ictcRPQMappingRepository.findAll(specification, page)
            .map(ictcRPQMappingMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(IctcRPQMappingCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<IctcRPQMapping> specification = createSpecification(criteria);
        return ictcRPQMappingRepository.count(specification);
    }

    /**
     * Function to convert {@link IctcRPQMappingCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<IctcRPQMapping> createSpecification(IctcRPQMappingCriteria criteria) {
    	return Specification.<IctcRPQMapping>where((root, query, builder) -> {
            if (criteria != null) {
                if (criteria.getId() != null) {
                    return builder.equal(root.get("id"), criteria.getId());
                }

                if (criteria.getPid() != null) {
                    return builder.equal(root.get("pid"), criteria.getPid());
                }

                if (criteria.getVisitId() != null) {
                    return builder.equal(root.get("visitId"), criteria.getVisitId());
                }

                if (criteria.getRpqId() != null) {
                    return builder.equal(root.get("rpqId"), criteria.getRpqId());
                }

                if (criteria.getAnswer() != null) {
                    return builder.equal(root.get("answer"), criteria.getAnswer());
                }
            }

            return null;
        });
    }
}
