package com.idrissbacha.welcomer.repository;

import com.idrissbacha.welcomer.domain.Request;
import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Request entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
    @Query("select request from Request request where request.createdBy.login = ?#{principal.username}")
    List<Request> findByCreatedByIsCurrentUser();

    @Query("select request from Request request where request.validatedBy.login = ?#{principal.username}")
    List<Request> findByValidatedByIsCurrentUser();
}
