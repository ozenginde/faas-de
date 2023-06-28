package com.faas.core.base.repo.inquiry.settings;

import com.faas.core.base.model.db.inquiry.settings.InquiryTypeDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InquiryTypeRepository extends PagingAndSortingRepository<InquiryTypeDBModel, Long> {

    List<InquiryTypeDBModel> findByStatus(int status);

}
