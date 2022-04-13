package com.waimou.epidemic_personnel_management_system.pojo;


import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName province_data
 */

@Data
public class ProvinceData implements Serializable {
    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private Integer value;

    /**
     * 
     */
    private Integer confirm;

    /**
     * 
     */
    private Integer heal;

    /**
     * 
     */
    private Integer dead;

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ProvinceData other = (ProvinceData) that;
        return (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getValue() == null ? other.getValue() == null : this.getValue().equals(other.getValue()))
            && (this.getConfirm() == null ? other.getConfirm() == null : this.getConfirm().equals(other.getConfirm()))
            && (this.getHeal() == null ? other.getHeal() == null : this.getHeal().equals(other.getHeal()))
            && (this.getDead() == null ? other.getDead() == null : this.getDead().equals(other.getDead()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getValue() == null) ? 0 : getValue().hashCode());
        result = prime * result + ((getConfirm() == null) ? 0 : getConfirm().hashCode());
        result = prime * result + ((getHeal() == null) ? 0 : getHeal().hashCode());
        result = prime * result + ((getDead() == null) ? 0 : getDead().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", name=").append(name);
        sb.append(", value=").append(value);
        sb.append(", confirm=").append(confirm);
        sb.append(", heal=").append(heal);
        sb.append(", dead=").append(dead);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}