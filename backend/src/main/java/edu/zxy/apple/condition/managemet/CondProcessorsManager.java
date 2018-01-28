package edu.zxy.apple.condition.managemet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.zxy.apple.condition.process.CondProcessorInf;
import edu.zxy.apple.vo.BaseCondVO;

public class CondProcessorsManager
{
    private static CondProcessorsManager condProcessManage = null;

    private Map<String, CondProcessorInf> condProcessMap = new HashMap<String, CondProcessorInf>();

    private CondProcessorsManager()
    {
    }

    public static CondProcessorsManager getInstance()
    {
        if (null == condProcessManage)
        {
            condProcessManage = new CondProcessorsManager();
        }
        return condProcessManage;
    }

    public void registerCondProcess(String type, CondProcessorInf condProcess)
    {
        condProcessMap.put(type, condProcess);
    }

    public List<Predicate> execute(List<BaseCondVO> condList, CriteriaBuilder crb, Root root)
    {
        List<Predicate> predicateList = new ArrayList<Predicate>();
        Predicate predicateItem = null;
        CondProcessorInf condProcessor = null;
        ObjectMapper INSTANCE = new ObjectMapper();
       

        for (int i=0;i<condList.size();i++)
        {   
            BaseCondVO condVO = INSTANCE.convertValue( condList.get(i), BaseCondVO.class);
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
