package com.bjtv.tiktok.Service.MediaServicee;


import com.bjtv.tiktok.Entity.Media.Media;

import java.util.List;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/2/25 下午4:34
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
