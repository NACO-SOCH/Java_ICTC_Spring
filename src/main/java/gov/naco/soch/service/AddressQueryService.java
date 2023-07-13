package gov.naco.soch.service;

import java.util.List;

import javax.persistence.criteria.JoinType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import gov.naco.soch.repository.AddressRepository;
import gov.naco.soch.service.dto.AddressCriteria;
import gov.naco.soch.service.dto.AddressDTO;
import gov.naco.soch.service.mapper.AddressMapper;

import gov.naco.soch.domain.Address;

/**
 * Service for executing complex queries for {@link Address} entities in the database.
 * The main input is a {@link AddressCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link AddressDTO} or a {@link Page} of {@link AddressDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class AddressQueryService {

    private final Logger log = LoggerFactory.getLogger(AddressQueryService.class);

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public AddressQueryService(AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    @Transactional(readOnly = true)
    public List<AddressDTO> findByCriteria(AddressCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Address> specification = createSpecification(criteria);
        return addressMapper.toDto(addressRepository.findAll(specification));
    }

    public Page<AddressDTO> findByCriteria(AddressCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        Specification<Address> specification = createSpecification(criteria);
        return addressRepository.findAll(specification, page).map(addressMapper::toDto);
    }

    public long countByCriteria(AddressCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        Specification<Address> specification = createSpecification(criteria);
        return addressRepository.count(specification);
    }

    protected Specification<Address> createSpecification(AddressCriteria criteria) {
        Specification<Address> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("id"), criteria.getId()));
            }
            if (criteria.getAddress() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("address"), criteria.getAddress()));
            }
            if (criteria.getBlock() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("block"), criteria.getBlock()));
            }
            if (criteria.getCity() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("city"), criteria.getCity()));
            }
            if (criteria.getGeoLatitude() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("geoLatitude"), criteria.getGeoLatitude()));
            }
            if (criteria.getGeoLongitude() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("geoLongitude"), criteria.getGeoLongitude()));
            }
            if (criteria.getHouseNo() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("houseNo"), criteria.getHouseNo()));
            }
            if (criteria.getPincode() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("pincode"), criteria.getPincode()));
            }
            if (criteria.getTaluk() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("taluk"), criteria.getTaluk()));
            }
            if (criteria.getStateId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.join("state", JoinType.LEFT).get("id"), criteria.getStateId()));
            }
            if (criteria.getDistrictId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.join("district", JoinType.LEFT).get("id"), criteria.getDistrictId()));
            }
        }
        return specification;
    }
}
