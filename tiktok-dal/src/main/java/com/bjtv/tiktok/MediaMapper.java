package com.bjtv.tiktok;

import com.bjtv.tiktok.entity.Media;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/7/18 上午11:52
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
@Mapper
public interface MediaMapper {
    Boolean publicMedia(Media media);
    List<Media> getMediaList();
    Media getMediaById(String mediaId);
}
