package edu.zxy.apple.condition.manage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import edu.zxy.apple.condition.process.CondProcessInf;
import edu.zxy.apple.condition.vo.BaseCondVO;

public class CondProcessManage
{
    private static CondProcessManage condProcessManage = null;

    private Map<String, CondProcessInf> condProcessMap = new HashMap<String, CondProcessInf>();

    private CondProcessManage()
    {
    }

    public static CondProcessManage getInstance()
    {
        if (null == condProcessManage)
        {
            condProcessManage = new CondProcessManage();
        }
        return condProcessManage;
    }

    public void registerCondProcess(String type, CondProcessInf condProcess)
    {
        condProcessMap.put(type, condProcess);
    }

    public List<Predicate> execute(List<BaseCondVO> condList, CriteriaBuilder crb, Root root)
    {
        List<Predicate> predicateList = new ArrayList<Predicate>();
        Predicate predicateItem = null;
        CondProcessInf condProcessor = null;
        for (BaseCondVO condVO : condList)
        {
            condProcessor = condProcessMap.get(condVO.getType());
            if (null != condProcessor)
            {
                predicateItem = condProcessor.process(crb, root, condVO);
            }
            if (null != predicateItem)
            {
                predicateList.add(predicateItem);
            }
        }
        return predicateList;
    }

}
