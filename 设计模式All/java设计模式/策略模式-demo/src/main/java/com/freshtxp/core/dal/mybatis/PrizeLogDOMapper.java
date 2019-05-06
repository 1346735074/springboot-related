package com.freshtxp.core.dal.mybatis;

import com.freshtxp.core.dal.domain.PrizeLogDO;
import com.freshtxp.core.dal.domain.PrizeLogDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PrizeLogDOMapper {
    long countByExample(PrizeLogDOExample example);

    int deleteByExample(PrizeLogDOExample example);

    int insert(PrizeLogDO record);

    int insertSelective(PrizeLogDO record);

    List<PrizeLogDO> selectByExampleWithBLOBs(PrizeLogDOExample example);

    List<PrizeLogDO> selectByExample(PrizeLogDOExample example);

    int updateByExampleSelective(@Param("record") PrizeLogDO record, @Param("example") PrizeLogDOExample example);

    int updateByExampleWithBLOBs(@Param("record") PrizeLogDO record, @Param("example") PrizeLogDOExample example);

    int updateByExample(@Param("record") PrizeLogDO record, @Param("example") PrizeLogDOExample example);
}