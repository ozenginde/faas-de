package com.faas.core.base.framework.inquiry.settings;

import com.faas.core.base.model.db.campaign.settings.CampaignTypeDBModel;
import com.faas.core.base.repo.inquiry.content.InquiryRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class InquirySettingsFramework {


    @Autowired
    InquiryRepository inquiryRepository;

    @Autowired
    AppUtils appUtils;



    public CampaignTypeDBModel getAllInquiryTypesService(long typeId) {

        return null;
    }


    public CampaignTypeDBModel getInquiryTypeService(long typeId) {

        return null;
    }


    public CampaignTypeDBModel createInquiryTypeService(long typeId) {

        return null;
    }


    public CampaignTypeDBModel updateInquiryTypeService(long typeId) {

        return null;
    }


    public CampaignTypeDBModel removeInquiryTypeService(long typeId) {

        return null;
    }



}
