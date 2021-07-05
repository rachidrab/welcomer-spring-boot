package com.idrissbacha.welcomer.service.impl;

import com.idrissbacha.welcomer.domain.Request;
import com.idrissbacha.welcomer.repository.RequestRepository;
import com.idrissbacha.welcomer.service.RequestService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Request}.
 */
@Service
@Transactional
public class RequestServiceImpl implements RequestService {

    private final Logger log = LoggerFactory.getLogger(RequestServiceImpl.class);

    private final RequestRepository requestRepository;

    public RequestServiceImpl(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public Request save(Request request) {
        log.debug("Request to save Request : {}", request);
        return requestRepository.save(request);
    }

    @Override
    public Optional<Request> partialUpdate(Request request) {
        log.debug("Request to partially update Request : {}", request);

        return requestRepository
            .findById(request.getId())
            .map(
                existingRequest -> {
                    if (request.getIsValid() != null) {
                        existingRequest.setIsValid(request.getIsValid());
                    }
                    if (request.getIsDelivered() != null) {
                        existingRequest.setIsDelivered(request.getIsDelivered());
                    }
                    if (request.getDeliveryDate() != null) {
                        existingRequest.setDeliveryDate(request.getDeliveryDate());
                    }
                    if (request.getCreatedDate() != null) {
                        existingRequest.setCreatedDate(request.getCreatedDate());
                    }
                    if (request.getComment() != null) {
                        existingRequest.setComment(request.getComment());
                    }

                    return existingRequest;
                }
            )
            .map(requestRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Request> findAll(Pageable pageable) {
        log.debug("Request to get all Requests");
        return requestRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Request> findOne(Long id) {
        log.debug("Request to get Request : {}", id);
        return requestRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Request : {}", id);
        requestRepository.deleteById(id);
    }
}
