package com.faas.core.base.middleware.utils.variables;

import com.faas.core.base.framework.utils.variables.UtilsVariablesFramework;
import com.faas.core.base.model.db.utils.variables.DataTypeDBModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.utils.variables.DataTypeWSModel;
import com.faas.core.base.model.ws.utils.variables.dto.DataTypeWSDTO;
import com.faas.core.base.repo.utils.variables.DataTypeRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class UtilsVariablesMiddleware {


    @Autowired
    UtilsVariablesFramework utilsVariablesFramework;

    @Autowired
    DataTypeRepository dataTypeRepository;

    @Autowired
    AppUtils appUtils;


    public DataTypeWSModel getAllDataTypes(long userId) {

        DataTypeWSModel response = new DataTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<DataTypeWSDTO> dataTypeWSDTOS = new ArrayList<>();

        List<DataTypeDBModel> dataTypeDBModels = dataTypeRepository.findByStatus(1);
        if (dataTypeDBModels.size() > 0) {
            for (DataTypeDBModel dataTypeDBModel : dataTypeDBModels) {
                dataTypeWSDTOS.add(utilsVariablesFramework.fillDataTypeWSDTO(dataTypeDBModel));
            }
        }

        response.setDataTypes(dataTypeWSDTOS);
        general.setOperation("getAllDataTypes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public DataTypeWSModel getBaseDataTypes(long userId, String baseType) {

        DataTypeWSModel response = new DataTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<DataTypeWSDTO> dataTypeWSDTOS = new ArrayList<>();

        List<DataTypeDBModel> dataTypeDBModels = dataTypeRepository.findByBaseType(baseType);
        if (dataTypeDBModels.size() > 0) {
            for (DataTypeDBModel dataTypeDBModel : dataTypeDBModels) {
                dataTypeWSDTOS.add(utilsVariablesFramework.fillDataTypeWSDTO(dataTypeDBModel));
            }
        }

        response.setDataTypes(dataTypeWSDTOS);
        general.setOperation("getBaseDataTypes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public DataTypeWSModel getDataType(long userId, long typeId) {

        DataTypeWSModel response = new DataTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<DataTypeWSDTO> dataTypeWSDTOS = new ArrayList<>();

        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(typeId);
        if (dataTypeDBModel.isPresent()) {
            dataTypeWSDTOS.add(utilsVariablesFramework.fillDataTypeWSDTO(dataTypeDBModel.get()));
        }

        response.setDataTypes(dataTypeWSDTOS);
        general.setOperation("getDataType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public DataTypeWSModel createDataType(long userId,String dataType,String baseType) {

        DataTypeWSModel response = new DataTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<DataTypeWSDTO> dataTypeWSDTOS = new ArrayList<>();

        DataTypeDBModel dataTypeDBModel = utilsVariablesFramework.createDataTypeService(dataType,baseType);
        if (dataTypeDBModel != null) {
            dataTypeWSDTOS.add(utilsVariablesFramework.fillDataTypeWSDTO(dataTypeDBModel));
        }

        response.setDataTypes(dataTypeWSDTOS);
        general.setOperation("createDataType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public DataTypeWSModel updateDataType(long userId,long typeId,String dataType,String baseType) {

        DataTypeWSModel response = new DataTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<DataTypeWSDTO> dataTypeWSDTOS = new ArrayList<>();

        DataTypeDBModel dataTypeDBModel = utilsVariablesFramework.updateDataTypeService(typeId,dataType,baseType);
        if (dataTypeDBModel != null) {
            dataTypeWSDTOS.add(utilsVariablesFramework.fillDataTypeWSDTO(dataTypeDBModel));
        }

        response.setDataTypes(dataTypeWSDTOS);
        general.setOperation("updateDataType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public DataTypeWSModel removeDataType(long userId,long typeId) {

        DataTypeWSModel response = new DataTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<DataTypeWSDTO> dataTypeWSDTOS = new ArrayList<>();

        DataTypeDBModel dataTypeDBModel = utilsVariablesFramework.removeDataTypeService(typeId);
        if (dataTypeDBModel != null) {
            dataTypeWSDTOS.add(utilsVariablesFramework.fillDataTypeWSDTO(dataTypeDBModel));
        }

        response.setDataTypes(dataTypeWSDTOS);
        general.setOperation("removeDataType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
