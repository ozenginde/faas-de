package com.faas.core.base.model.ws.process.details.content.dto;

import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.ws.process.details.channel.content.dto.ProcessChannelWSDTO;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.ProcessTempWSDTO;
import com.faas.core.base.model.ws.process.details.scenario.dto.ProcessScenarioWSDTO;
import com.faas.core.base.model.ws.process.details.trigger.dto.TriggerWSDTO;

import java.util.List;

public class ProcessDetailsWSDTO {

    private ProcessDBModel process;
    private List<TriggerWSDTO> processTriggers;
    private ProcessTempWSDTO processTemps;
    private ProcessChannelWSDTO processChannels;
    private List<ProcessScenarioWSDTO> processScenarios;
    private List<ProcessAssetWSDTO>processAssets;

    public ProcessDetailsWSDTO() {
    }

    public ProcessDetailsWSDTO(ProcessDBModel process, List<TriggerWSDTO> processTriggers, ProcessTempWSDTO processTemps, ProcessChannelWSDTO processChannels, List<ProcessScenarioWSDTO> processScenarios, List<ProcessAssetWSDTO> processAssets) {
        this.process = process;
        this.processTriggers = processTriggers;
        this.processTemps = processTemps;
        this.processChannels = processChannels;
        this.processScenarios = processScenarios;
        this.processAssets = processAssets;
    }

    public ProcessDBModel getProcess() {
        return process;
    }

    public void setProcess(ProcessDBModel process) {
        this.process = process;
    }

    public List<TriggerWSDTO> getProcessTriggers() {
        return processTriggers;
    }

    public void setProcessTriggers(List<TriggerWSDTO> processTriggers) {
        this.processTriggers = processTriggers;
    }

    public ProcessTempWSDTO getProcessTemps() {
        return processTemps;
    }

    public void setProcessTemps(ProcessTempWSDTO processTemps) {
        this.processTemps = processTemps;
    }

    public ProcessChannelWSDTO getProcessChannels() {
        return processChannels;
    }

    public void setProcessChannels(ProcessChannelWSDTO processChannels) {
        this.processChannels = processChannels;
    }

    public List<ProcessScenarioWSDTO> getProcessScenarios() {
        return processScenarios;
    }

    public void setProcessScenarios(List<ProcessScenarioWSDTO> processScenarios) {
        this.processScenarios = processScenarios;
    }

    public List<ProcessAssetWSDTO> getProcessAssets() {
        return processAssets;
    }

    public void setProcessAssets(List<ProcessAssetWSDTO> processAssets) {
        this.processAssets = processAssets;
    }
}
