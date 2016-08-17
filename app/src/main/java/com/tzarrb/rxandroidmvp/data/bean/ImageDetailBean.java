package com.tzarrb.rxandroidmvp.data.bean;

import com.tzarrb.rxandroidmvp.data.entity.ImageDetailInfo;

import java.util.List;

/**
 * by y on 2016/4/29.
 */
@SuppressWarnings("ALL")
public class ImageDetailBean {

    private int id;
    private int galleryclass;//          图片分类
    private String title;//          标题
    private String img;//          图库封面
    private int count;//          访问数
    private int rcount;//           回复数
    private int fcount;//          收藏数
    private int size;//      图片多少张
    private List<ImageDetailInfo> list;

    public int getRcount() {
        return rcount;
    }

    public void setRcount(int rcount) {
        this.rcount = rcount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGalleryclass() {
        return galleryclass;
    }

    public void setGalleryclass(int galleryclass) {
        this.galleryclass = galleryclass;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getFcount() {
        return fcount;
    }

    public void setFcount(int fcount) {
        this.fcount = fcount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<ImageDetailInfo> getList() {
        return list;
    }

    public void setList(List<ImageDetailInfo> list) {
        this.list = list;
    }
}
