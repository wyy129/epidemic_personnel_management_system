package com.waimou.epidemic_personnel_management_system.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName details
 */

@Data
public class Details implements Serializable {
    /**
     *
     */
    private Integer id;

    /**
     * 数据最后更新时间
     */
    private Date updateTime;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String name;

    /**
     * 累计确诊
     */
    private Integer value;

    /**
     * 新增治愈
     */
    private Integer confirm_add;

    /**
     * 累计治愈
     */
    private Integer heal;

    /**
     * 累计死亡
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
//        Details other = (Details) that;
//        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
//                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
//                && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
//                && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
//                && (this.getConfirm() == null ? other.getConfirm() == null : this.getConfirm().equals(other.getConfirm()))
//                && (this.getConfirmAdd() == null ? other.getConfirmAdd() == null : this.getConfirmAdd().equals(other.getConfirmAdd()))
//                && (this.getHeal() == null ? other.getHeal() == null : this.getHeal().equals(other.getHeal()))
//                && (this.getDead() == null ? other.getDead() == null : this.getDead().equals(other.getDead()));
//    }
//
//    @Override
//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
//        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
//        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
//        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
//        result = prime * result + ((getConfirm() == null) ? 0 : getConfirm().hashCode());
//        result = prime * result + ((getConfirmAdd() == null) ? 0 : getConfirmAdd().hashCode());
//        result = prime * result + ((getHeal() == null) ? 0 : getHeal().hashCode());
//        result = prime * result + ((getDead() == null) ? 0 : getDead().hashCode());
//        return result;
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append(getClass().getSimpleName());
//        sb.append(" [");
//        sb.append("Hash = ").append(hashCode());
//        sb.append(", id=").append(id);
//        sb.append(", updateTime=").append(updateTime);
//        sb.append(", province=").append(province);
//        sb.append(", city=").append(city);
//        sb.append(", confirm=").append(confirm);
//        sb.append(", confirmAdd=").append(confirmAdd);
//        sb.append(", heal=").append(heal);
//        sb.append(", dead=").append(dead);
//        sb.append(", serialVersionUID=").append(serialVersionUID);
//        sb.append("]");
//        return sb.toString();
//    }
}