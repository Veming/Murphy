package com.cloud.murphy.service.file.impl;

import com.cloud.murphy.dao.ChunkDao;
import com.cloud.murphy.service.file.ChunkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hang.su01
 * @since 2019-05-22 12:13
 */
@Service
public class ChunkServiceImpl implements ChunkService {
    @Resource
    private ChunkDao chunkDao;
}
