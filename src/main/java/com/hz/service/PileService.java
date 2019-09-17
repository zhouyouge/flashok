package com.hz.service;

import com.hz.pojo.FoPile;
import java.util.List;

public interface PileService {
    public List<FoPile> getFoPileList() throws Exception;

    public List<FoPile> getPiles() throws Exception;
}
