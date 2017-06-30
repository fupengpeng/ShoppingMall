package com.fupengpeng.shoppingmall.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by fupengpeng on 2017/6/30 0030.
 * 分享咨询列表
 */

public class ShareAttentionList implements Serializable{
    private List<ShareAttentionObject> shareAttentionObjectList;
    public  ShareAttentionList (){}

    public ShareAttentionList(List<ShareAttentionObject> shareAttentionObjectList) {
        this.shareAttentionObjectList = shareAttentionObjectList;
    }

    public List<ShareAttentionObject> getShareAttentionObjectList() {
        return shareAttentionObjectList;
    }

    public void setShareAttentionObjectList(List<ShareAttentionObject> shareAttentionObjectList) {
        this.shareAttentionObjectList = shareAttentionObjectList;
    }
}
