package com.bootssmserver.bootssmserver.service;

import com.bootssmserver.bootssmserver.entity.Collect;
import com.bootssmserver.bootssmserver.entity.Useraction;

public interface UseractionService {
    public Useraction SelectsThisUserAction(int uid,int vid);
    public int InsertUseraction(Useraction useraction);
    public int updateUseraction(Useraction useraction);

}
