package com.bjtv.tiktok.service;

import com.bjtv.tiktok.entity.Media;
import com.bjtv.tiktok.MediaMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/7/18 上午11:51
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
@Service
public class MediaServiceImpl implements MediaService{

    @Resource
    public MediaMapper mediaMapper;

    @Override
    public Boolean publicMedia(Media media) {
        media.setMediaId(UUID.randomUUID().toString().replace("-", ""));
        return mediaMapper.publicMedia(media);
    }

    @Override
    public List<Media> getMediaList() {
        List<Media> mediaList = mediaMapper.getMediaList();

        return mediaMapper.getMediaList();
    }

    @Override
    public Media getMediaById(String mediaId) {
        Media media = mediaMapper.getMediaById(mediaId);
        return media;
    }
}
