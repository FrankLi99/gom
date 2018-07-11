package com.ghc.dao;

import com.ghc.model.LogInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface ILogInfoDao {
    void addLog(LogInfo logInfo);
}
