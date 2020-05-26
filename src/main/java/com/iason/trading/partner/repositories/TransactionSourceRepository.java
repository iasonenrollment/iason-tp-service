package com.iason.trading.partner.repositories;

import com.iason.trading.partner.domain.TransactionSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: TransactionSourceRepository
 * Inside the package - com.iason.trading.partner.repositories
 * Created Date: 5/22/2020
 * Created Time: 8:05 PM
 **/
@Repository
public interface TransactionSourceRepository extends JpaRepository<TransactionSource, Long> {
}
