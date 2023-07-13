package gov.naco.soch.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.constant.AdminAccessCodes;
import gov.naco.soch.service.TransfersQueryService;
import gov.naco.soch.service.TransfersService;
import gov.naco.soch.service.dto.TransfersCriteria;
import gov.naco.soch.service.dto.TransfersDTO;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;

/**
 * REST controller for managing {@link gov.naco.soch.domain.Transfers}.
 */
@RestController
@PreAuthorize("hasAuthority('" + AdminAccessCodes.ICTC_USERS + "') or hasAuthority('" + AdminAccessCodes.ICTC_FACILITIES + "') "
		+ "or hasAuthority('" + AdminAccessCodes.EIDLAB_ICTC + "') or hasAuthority('" + AdminAccessCodes.EIDLAB_USERS + "')")
@RequestMapping("/api")
public class TransfersResource {

    private final Logger log = LoggerFactory.getLogger(TransfersResource.class);

    private static final String ENTITY_NAME = "sochictcTransfers";
    @Autowired
    TransfersService transfersService;
    @Autowired
    TransfersQueryService transfersQueryService;
    
    @PostMapping("/transfers")
    public ResponseEntity<TransfersDTO> createTransfers(@Valid @RequestBody TransfersDTO transfersDTO) throws URISyntaxException {
        log.debug("REST request to save Transfers : {}", transfersDTO);
        if (transfersDTO.getId() != null) {
            throw new BadRequestAlertException("A new transfers cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TransfersDTO result = transfersService.save(transfersDTO);
        return ResponseEntity.created(new URI("/api/transfers/" + result.getId())).body(result);
    }

    @PutMapping("/transfers")
    public ResponseEntity<TransfersDTO> updateTransfers(@Valid @RequestBody TransfersDTO transfersDTO) throws URISyntaxException {
        log.debug("REST request to update Transfers : {}", transfersDTO);
        if (transfersDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        TransfersDTO result = transfersService.save(transfersDTO);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/transfers")
    public ResponseEntity<List<TransfersDTO>> getAllTransfers(TransfersCriteria criteria, Pageable pageable) {
        log.debug("REST request to get Transfers by criteria: {}", criteria);
        Page<TransfersDTO> page = transfersQueryService.findByCriteria(criteria, pageable);
        return ResponseEntity.ok(page.getContent());
    }

    @GetMapping("/transfers/count")
    public ResponseEntity<Long> countTransfers(TransfersCriteria criteria) {
        log.debug("REST request to count Transfers by criteria: {}", criteria);
        return ResponseEntity.ok().body(transfersQueryService.countByCriteria(criteria));
    }

    @GetMapping("/transfers/{id}")
    public ResponseEntity<TransfersDTO> getTransfers(@PathVariable Long id) {
        log.debug("REST request to get Transfers : {}", id);
        Optional<TransfersDTO> transfersDTO = transfersService.findOne(id);
        return transfersDTO.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/transfers/{id}")
    public ResponseEntity<Void> deleteTransfers(@PathVariable Long id) {
        log.debug("REST request to delete Transfers : {}", id);
        transfersService.delete(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * {@code POST  /transfers} : Create a new transfers.
     *
     * @param transfersDTO the transfersDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new transfersDTO, or with status {@code 400 (Bad Request)} if the transfers has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
//    @PostMapping("/transfers")
//    public ResponseEntity<TransfersDTO> createTransfers(@Valid @RequestBody TransfersDTO transfersDTO) throws URISyntaxException {
//        log.debug("REST request to save Transfers : {}", transfersDTO);
//        if (transfersDTO.getId() != null) {
//            throw new BadRequestAlertException("A new transfers cannot already have an ID", ENTITY_NAME, "idexists");
//        }
//        TransfersDTO result = transfersService.save(transfersDTO);
//        return ResponseEntity.created(new URI("/api/transfers/" + result.getId()))
//            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
//            .body(result);
//    }
//
//    /**
//     * {@code PUT  /transfers} : Updates an existing transfers.
//     *
//     * @param transfersDTO the transfersDTO to update.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated transfersDTO,
//     * or with status {@code 400 (Bad Request)} if the transfersDTO is not valid,
//     * or with status {@code 500 (Internal Server Error)} if the transfersDTO couldn't be updated.
//     * @throws URISyntaxException if the Location URI syntax is incorrect.
//     */
//    @PutMapping("/transfers")
//    public ResponseEntity<TransfersDTO> updateTransfers(@Valid @RequestBody TransfersDTO transfersDTO) throws URISyntaxException {
//        log.debug("REST request to update Transfers : {}", transfersDTO);
//        if (transfersDTO.getId() == null) {
//            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
//        }
//        TransfersDTO result = transfersService.save(transfersDTO);
//        return ResponseEntity.ok()
//            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, transfersDTO.getId().toString()))
//            .body(result);
//    }
//
//    /**
//     * {@code GET  /transfers} : get all the transfers.
//     *
//     * @param pageable the pagination information.
//     * @param criteria the criteria which the requested entities should match.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of transfers in body.
//     */
//    @GetMapping("/transfers")
//    public ResponseEntity<List<TransfersDTO>> getAllTransfers(TransfersCriteria criteria, Pageable pageable) {
//        log.debug("REST request to get Transfers by criteria: {}", criteria);
//        Page<TransfersDTO> page = transfersQueryService.findByCriteria(criteria, pageable);
//        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
//        return ResponseEntity.ok().headers(headers).body(page.getContent());
//    }
//
//    /**
//     * {@code GET  /transfers/count} : count all the transfers.
//     *
//     * @param criteria the criteria which the requested entities should match.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
//     */
//    @GetMapping("/transfers/count")
//    public ResponseEntity<Long> countTransfers(TransfersCriteria criteria) {
//        log.debug("REST request to count Transfers by criteria: {}", criteria);
//        return ResponseEntity.ok().body(transfersQueryService.countByCriteria(criteria));
//    }
//
//    /**
//     * {@code GET  /transfers/:id} : get the "id" transfers.
//     *
//     * @param id the id of the transfersDTO to retrieve.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the transfersDTO, or with status {@code 404 (Not Found)}.
//     */
//    @GetMapping("/transfers/{id}")
//    public ResponseEntity<TransfersDTO> getTransfers(@PathVariable Long id) {
//        log.debug("REST request to get Transfers : {}", id);
//        Optional<TransfersDTO> transfersDTO = transfersService.findOne(id);
//        return ResponseUtil.wrapOrNotFound(transfersDTO);
//    }
//
//    /**
//     * {@code DELETE  /transfers/:id} : delete the "id" transfers.
//     *
//     * @param id the id of the transfersDTO to delete.
//     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
//     */
//    @DeleteMapping("/transfers/{id}")
//    public ResponseEntity<Void> deleteTransfers(@PathVariable Long id) {
//        log.debug("REST request to delete Transfers : {}", id);
//        transfersService.delete(id);
//        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
//    }
}
