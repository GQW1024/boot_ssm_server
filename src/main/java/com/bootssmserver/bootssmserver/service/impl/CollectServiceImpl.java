package com.bootssmserver.bootssmserver.service.impl;

import com.bootssmserver.bootssmserver.dao.CollectMapper;
import com.bootssmserver.bootssmserver.entity.Collect;
import com.bootssmserver.bootssmserver.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional //为这个类开启事务处理，前提：@EnableTransactionManagement
@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    CollectMapper collectMapper;

    @Override
    public int insCollect(Collect collect) {
        return collectMapper.insertCollect(collect);
    }

    @Override
    public int delCollect(int cid,int vid) {
        return collectMapper.DeleteCollect(cid,vid);
    }

    @Override
    public Collect selCollect(int cid, int vid) {
        return collectMapper.SelectCollect(cid,vid);
    }
    @Override
    public int selCollectCount(int cid) {
        return collectMapper.SelectCollectCount(cid);
    }
}
