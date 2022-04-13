package com.waimou.epidemic_personnel_management_system.pojo;


import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName chinaTotal
 */

@Data
public class Chinatotal implements Serializable {
    /**
     * 
     */
    private Integer nowconfirm;

    /**
     * 
     */
    private Integer heal;

    /**
     * 
     */
    private Integer dead;


    private static final long serialVersionUID = 1L;

//    @Override
//    public boolean equals(Object that) {
//        if (this == that) {
//            return true;
//        }
//        if (that == null) {
//            return false;
//        }
//        if (getClass() != that.getClass()) {
//            return false;
//        }
//        Chinatotal other = (Chinatotal) that;
//        return (this.getNowconfirm() == null ? other.getNowconfirm() == null : this.getNowconfirm().equals(other.getNowconfirm()))
//            && (this.getHeal() == null ? other.getHeal() == null : this.getHeal().equals(other.getHeal()))
//            && (this.getDead() == null ? other.getDead() == null : this.getDead().equals(other.getDead()));
//    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNowconfirm() == null) ? 0 : getNowconfirm().hashCode());
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
        sb.append(", nowconfirm=").append(nowconfirm);
        sb.append(", heal=").append(heal);
        sb.append(", dead=").append(dead);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}