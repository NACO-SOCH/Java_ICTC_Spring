package gov.naco.soch.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.domain.ICTCBeneficiaryCounsellingView;
import gov.naco.soch.domain.ICTCBeneficiaryVisit;
import gov.naco.soch.repository.ICTCBeneficiaryCounsellingViewRepository;

/**
 * Service Implementation for managing {@link ICTCBeneficiaryVisit}.
 */
@Service
@Transactional
public class ICTCBeneficiaryCounsellingViewService {

    private final Logger log = LoggerFactory.getLogger(ICTCBeneficiaryCounsellingViewService.class);

    private final ICTCBeneficiaryCounsellingViewRepository ictcBeneficiaryCounsellingViewRepository;

    public ICTCBeneficiaryCounsellingViewService(ICTCBeneficiaryCounsellingViewRepository ictcBeneficiaryCounsellingViewRepository) {
        this.ictcBeneficiaryCounsellingViewRepository = ictcBeneficiaryCounsellingViewRepository;
    }

    /**
     * Get one iCTCBeneficiaryVisit by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ICTCBeneficiaryCounsellingView> findOne(Long id) {
        log.debug("Request to get ICTCBeneficiaryVisit : {}", id);
        return ictcBeneficiaryCounsellingViewRepository.findById(id);
    }

}