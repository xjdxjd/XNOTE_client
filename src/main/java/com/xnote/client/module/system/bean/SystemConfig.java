package com.xnote.client.module.system.bean;

public class SystemConfig {
    private String id;

    private String configCode;

    private String configName;

    private String configValue;

    private Integer configType;

    private String configRemark;

    public SystemConfig() {
    }

    public SystemConfig(String id, String configCode, String configName, String configValue, Integer configType, String configRemark) {
        this.id = id;
        this.configCode = configCode;
        this.configName = configName;
        this.configValue = configValue;
        this.configType = configType;
        this.configRemark = configRemark;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getConfigCode() {
        return configCode;
    }

    public void setConfigCode(String configCode) {
        this.configCode = configCode == null ? null : configCode.trim();
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName == null ? null : configName.trim();
    }

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue == null ? null : configValue.trim();
    }

    public Integer getConfigType() {
        return configType;
    }

    public void setConfigType(Integer configType) {
        this.configType = configType;
    }

    public String getConfigRemark() {
        return configRemark;
    }

    public void setConfigRemark(String configRemark) {
        this.configRemark = configRemark == null ? null : configRemark.trim();
    }
}