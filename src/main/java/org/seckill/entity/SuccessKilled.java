package org.seckill.entity;

import java.util.Date;

/**
 * @author: liuwei
 * @Date: 16:12 2018/3/30
 */
public class SuccessKilled {
    private long seckiddId;

    private long userPhone;

    private short state;

    private Date createTime;

    private Seckill seckill;

    public Seckill getSeckill() {
        return seckill;
    }

    public void setSeckill(Seckill seckill) {
        this.seckill = seckill;
    }

    public long getSeckiddId() {
        return seckiddId;
    }

    public void setSeckiddId(long seckiddId) {
        this.seckiddId = seckiddId;
    }

    public long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(long userPhone) {
        this.userPhone = userPhone;
    }

    public short getState() {
        return state;
    }

    public void setState(short state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "SuccessKilled{" +
                "seckiddId=" + seckiddId +
                ", userPhone=" + userPhone +
                ", state=" + state +
                ", createTime=" + createTime +
                '}';
    }
}
