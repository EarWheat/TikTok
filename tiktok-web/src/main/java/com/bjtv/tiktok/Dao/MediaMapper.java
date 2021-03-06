package com.bjtv.tiktok.Dao;

import com.bjtv.tiktok.Entity.Media.Media;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/2/25 下午4:36
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
