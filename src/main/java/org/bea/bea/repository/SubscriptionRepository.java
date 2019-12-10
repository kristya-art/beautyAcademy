package org.bea.bea.repository;

import org.bea.bea.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription,Long> {
}
