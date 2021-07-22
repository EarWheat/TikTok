package com.bjtv.tiktok.service;

import com.bjtv.tiktok.entity.Media;

import java.util.List;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/7/18 上午11:45
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public interface MediaService {
    public Boolean publicMedia(Media media);
    public List<Media> getMediaList();
    public Media getMediaById(String id);
}
