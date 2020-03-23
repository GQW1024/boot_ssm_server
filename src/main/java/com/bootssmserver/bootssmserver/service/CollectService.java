package com.bootssmserver.bootssmserver.service;

import com.bootssmserver.bootssmserver.entity.Collect;

public interface CollectService {
    public int insCollect(Collect collect);
    public int delCollect(int cid,int vid);
    public Collect selCollect(int cid,int vid);
    public int selCollectCount(int cid);

}
